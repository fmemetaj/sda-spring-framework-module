package com.java38.spring_framework.exercises.task13;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("add")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.addReservation(reservation));
    }

    @PutMapping("update")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.updateReservation(reservation));
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.findAllReservations();
    }

    @GetMapping("{name}")
    public List<Reservation> getAllReservationsByName(@RequestParam String name) {
        return reservationService.findAllReservationsByName(name);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable Long id) {
        /*
        return reservationService.deleteById(id)
                ? ResponseEntity.ok("Reservation deleted successfully!")
                : ResponseEntity.badRequest().build();
         */
        return ResponseEntity.ok(reservationService.deleteById(id));
    }

}
