package com.java38.spring_framework.task13;

import com.java38.spring_framework.exercises.task13.Reservation;
import com.java38.spring_framework.exercises.task13.ReservationRepository;
import com.java38.spring_framework.exercises.task13.ReservationService;
import com.java38.spring_framework.exercises.task13.Standard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class ReservationServiceTest {

    @MockBean
    ReservationRepository reservationRepository;
    @Autowired
    ReservationService reservationService;

    @Test
    void whenFetchByExistingReservationByIdThenReservationShouldBeReturned() {
        //given
        Long id = 1L;
        Reservation reservation = new Reservation(id, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3));
        Mockito.when(reservationRepository.findById(id)).thenReturn(Optional.of(reservation));

        //when
        Reservation result = reservationService.getById(id);

        //then
        Mockito.verify(reservationRepository, Mockito.times(1)).findById(Mockito.any());
        assertEquals(reservation, result);
    }

    @Test
    void whenFetchByNonExistingReservationByIdThenExceptionShouldBeThrown() {
        //given
        Long id = 1L;
        Mockito.when(reservationRepository.findById(id)).thenReturn(Optional.empty());

        //when
        //then
        assertThrows(NoSuchElementException.class, () -> {
            reservationService.getById(id);
        });
        Mockito.verify(reservationRepository, Mockito.times(1)).findById(Mockito.any());
    }

    @Test
    void whenFetchByNameAndReservationWithThatNameExistsThenReturnListOfThem() {
        //given
        String name = "res1";
        List<Reservation> reservations = Arrays.asList(
                new Reservation(1L, name, "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3)),
                new Reservation(3L, name, "hotel1", 2, Standard.NORMAL, 300.0f, LocalDate.of(2022, 3, 20), LocalDate.of(2022, 1, 25))
        );
        Mockito.when(reservationRepository.findAllByName(name)).thenReturn(reservations);

        //when
        List<Reservation> results = reservationService.findAllReservationsByName(name);

        //then
        assertEquals(Arrays.asList(
                new Reservation(1L, name, "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3)),
                new Reservation(3L, name, "hotel1", 2, Standard.NORMAL, 300.0f, LocalDate.of(2022, 3, 20), LocalDate.of(2022, 1, 25))
        ), results);
    }

    @Test
    void whenFetchByNameAndReservationWithNonExistingNameThenReturnEmptyList() {
        //given
        String name = "reservation1";
        List<Reservation> reservations = Arrays.asList(
                new Reservation(1L, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3)),
                new Reservation(3L, "res1", "hotel1", 2, Standard.NORMAL, 300.0f, LocalDate.of(2022, 3, 20), LocalDate.of(2022, 1, 25))
        );
        Mockito.when(reservationRepository.findAllByName(name)).thenReturn(Collections.emptyList());
        Mockito.when(reservationRepository.findAllByName("res1")).thenReturn(reservations);

        //when
        List<Reservation> results = reservationService.findAllReservationsByName(name);

        //then
        assertTrue(results.isEmpty());
    }

    @Test
    void whenAddUniqueReservationThenReservationShouldBeAddedToTheRepo() {
        //given
        Long id = 1L;
        Reservation reservation = new Reservation(id, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3));
        Mockito.when(reservationRepository.findById(id)).thenReturn(Optional.empty());
        Mockito.when(reservationRepository.save(reservation)).thenReturn(reservation);

        //when
        Reservation result = reservationService.addReservation(reservation);

        //then
        assertEquals(reservation, result);
        Mockito.verify(reservationRepository, Mockito.times(1)).save(reservation);
    }

    @Test
    void whenAddDuplicatedReservationThenExceptionShouldBeThrown() {
        //given
        Long id = 1L;
        Reservation reservation = new Reservation(id, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3));
        Mockito.when(reservationRepository.findById(id)).thenReturn(Optional.of(reservation));

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            reservationService.addReservation(reservation);
        });
        Mockito.verify(reservationRepository, Mockito.never()).save(Mockito.any());
    }

    @Test
    void whenDeleteReservationWhichNotExistInRepoThenExceptionShouldBeThrown() {
        //given
        Long id = 1L;
        Mockito.when(reservationRepository.findById(id)).thenReturn(Optional.empty());

        //when
        //then
        assertThrows(NoSuchElementException.class, () -> {
            reservationService.deleteById(id);
        });
        Mockito.verify(reservationRepository, Mockito.never()).delete(Mockito.any());
    }

    @Test
    void whenDeleteReservationWhichExistInRepoThenDeleteOnRepoShouldBeCalled() {
        //given
        Long id = 1L;
        Reservation reservation = new Reservation(id, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3));
        Mockito.when(reservationRepository.findById(id)).thenReturn(Optional.of(reservation));

        //when
        Reservation result = reservationService.deleteById(id);

        //then
        Mockito.verify(reservationRepository).delete(reservation);
        assertEquals(reservation, result);
    }

    @Test
    void whenUpdateNonExistingReservationThenExceptionShouldBeThrown() {
        //given
        Reservation reservation = new Reservation(1L, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3));
        Mockito.when(reservationRepository.findById(1L)).thenReturn(Optional.empty());

        //when
        //then
        assertThrows(NoSuchElementException.class, () -> {
            reservationService.updateReservation(reservation);
        });
        Mockito.verify(reservationRepository, Mockito.never()).save(Mockito.any());
    }

    @Test
    void whenUpdateExistingReservationThenNameShouldBeUpdated() {
        //given
        Reservation reservation = new Reservation(1L, "xxx", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3));
        Reservation reservationToUpdate = new Reservation(1L, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3));
        Mockito.when(reservationRepository.findById(1L)).thenReturn(Optional.of(reservation));
        Mockito.when(reservationRepository.save(reservationToUpdate)).thenReturn(reservationToUpdate);

        //when
        Reservation result = reservationService.updateReservation(reservationToUpdate);

        //then
        assertEquals(reservationToUpdate, result);
        Mockito.verify(reservationRepository).save(reservationToUpdate);
    }

    @TestConfiguration
    static class ReservationTestConfig {

        @Bean
        ReservationService reservationService(ReservationRepository reservationRepository) {
            return new ReservationService(reservationRepository);
        }
    }
}
