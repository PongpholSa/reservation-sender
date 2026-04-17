package com.realestate.reservation_sender.kafka;

import com.realestate.reservation_sender.data.ReservationData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReservationProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendCreated(ReservationData data) {
        String message = data.getCustomerName() + "|" +
                data.getRoomNumber() + "|" +
                data.getAreaUnitLayout() + "|" +
                data.getReservationPrice() + "|" +
                data.getExpireDate();

        kafkaTemplate.send("reservation.created", message);
        log.info("Sent >> {}", message);
    }
}