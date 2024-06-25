package com.locococo.backend.controller;

import com.locococo.backend.model.Reservation;
import com.locococo.backend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
        return ResponseEntity.ok(reservation);
    }
}
