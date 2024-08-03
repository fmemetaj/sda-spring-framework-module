package com.java38.spring_framework.exercises.task13;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation getById(long id) {
        return reservationRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No reservation with provided id found!"));
    }

    public Reservation addReservation(Reservation reservation) {
        reservationRepository.findById(reservation.getId())
                .ifPresent(r -> {
                    throw new IllegalArgumentException("can't add reservation with the same id");
                });
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.findById(reservation.getId())
                .map(foundReservation -> {
                    foundReservation.setName(reservation.getName());
                    foundReservation.setHotelName(reservation.getHotelName());
                    foundReservation.setNumberOfPeople(reservation.getNumberOfPeople());
                    foundReservation.setStandard(reservation.getStandard());
                    foundReservation.setPrice(reservation.getPrice());
                    foundReservation.setStartDate(reservation.getStartDate());
                    foundReservation.setEndDate(reservation.getEndDate());

                    return reservationRepository.save(foundReservation);
                })
                .orElseThrow(()-> new NoSuchElementException("No reservation with provided id found!"));
    }

    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> findAllReservationsByName(String name) {
        return reservationRepository.findAllByName(name);
    }

    public Reservation deleteById(Long id) {
        Reservation reservationToDelete = getById(id);
        reservationRepository.delete(reservationToDelete);
        return reservationToDelete;
    }
}
