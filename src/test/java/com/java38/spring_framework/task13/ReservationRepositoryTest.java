package com.java38.spring_framework.task13;

import com.java38.spring_framework.exercises.task13.Reservation;
import com.java38.spring_framework.exercises.task13.ReservationRepository;
import com.java38.spring_framework.exercises.task13.Standard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ReservationRepositoryTest {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    TestEntityManager testEntityManager;


    @Test
    void shouldReturn2ReservationWhenSearchForAll() {
        //given
        testEntityManager.persist(new Reservation(1L,
                "res1",
                "hotel1",
                2,
                Standard.NORMAL,
                200.0f,
                LocalDate.now(),
                LocalDate.now().plusDays(1)));
        testEntityManager.persist(new Reservation(2L,
                "res2",
                "hotel1",
                2,
                Standard.EXCLUSIVE,
                200.0f,
                LocalDate.now(),
                LocalDate.now().plusDays(1)));

        //when
        List<Reservation> results = reservationRepository.findAll();

        //then
        assertEquals(2, results.size());
    }

    @Test
    void shouldAdd1ReservationWhenSaveItViaRepository() {
        //given
        Reservation reservation = new Reservation(1L,
                "res1",
                "hotel1",
                2,
                Standard.NORMAL,
                200.0f,
                LocalDate.now(),
                LocalDate.now().plusDays(1));

        //when
        reservationRepository.save(reservation);

        //then
        Reservation result = testEntityManager.find(Reservation.class, 1L);
        assertEquals(reservation, result);
    }

    @ParameterizedTest
    @ArgumentsSource(SearchByStandardAndPriceArgumentsProvider.class)
    void shouldReturn1ReservationWhenSearchByExclusiveStandardWithPrice300(List<Reservation> input,
                                                                           Standard standard,
                                                                           float price,
                                                                           List<Reservation> expected) {
        //given
        input.forEach(testEntityManager::persist);

        //when
        List<Reservation> results = reservationRepository.findAllByStandardAndPrice(standard, price);

        //then
        assertEquals(expected.size(), results.size());
        assertEquals(expected, results);
    }


    @Test
    void shouldReturnReservationWithNameRes1WhenSearchByReservationName() {
        //given
        testEntityManager.persist(new Reservation(1L,
                "res1",
                "hotel1",
                2,
                Standard.NORMAL,
                200.0f,
                LocalDate.now(),
                LocalDate.now().plusDays(1)));
        testEntityManager.persist(new Reservation(2L,
                "res2",
                "hotel1",
                2,
                Standard.EXCLUSIVE,
                200.0f,
                LocalDate.now(),
                LocalDate.now().plusDays(1)));

        //when
        List<Reservation> results = reservationRepository.findAllByName("res1");

        //then
        assertEquals(1, results.size());
        assertEquals("res1", results.get(0).getName());
    }

    @ParameterizedTest
    @ArgumentsSource(SearchByDateArgumentsProvider.class)
    void shouldReturnNReservationWhenLookingForReservationsInSpecifiedData(
            List<Reservation> input,
            LocalDate date,
            List<Reservation> expectedResult) {

        //given
        input.forEach(testEntityManager::persist);

        //when
        List<Reservation> results = reservationRepository.findAllByEndDateGreaterThanEqualAndStartDateLessThanEqual(date, date);

        //then
        assertEquals(expectedResult.size(), results.size());
        assertEquals(expectedResult, results);
    }

}
