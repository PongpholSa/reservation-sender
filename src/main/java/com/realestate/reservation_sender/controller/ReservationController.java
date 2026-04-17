package com.realestate.reservation_sender.controller;

import com.realestate.reservation_sender.data.ReservationData;
import com.realestate.reservation_sender.kafka.ReservationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationProducer producer;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ReservationData data) {
        producer.sendCreated(data);
        return ResponseEntity.ok("Reservation created event sent!");
    }
}