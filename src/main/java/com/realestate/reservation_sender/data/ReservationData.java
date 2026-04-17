package com.realestate.reservation_sender.data;

import lombok.Data;

@Data
public class ReservationData {
    private String customerName;
    private String roomNumber;
    private String areaUnitLayout;
    private Double reservationPrice;
    private String expireDate;
}