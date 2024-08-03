package com.java38.spring_framework.exercises.task13;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByName(String name);
    List<Reservation> findAllByStandardAndPrice(Standard standard, Float price);
    List<Reservation> findAllByEndDateGreaterThanEqualAndStartDateLessThanEqual(LocalDate start, LocalDate end);
}
