package com.SystemDesign.ParkingLot;

public interface ParkingChargeStrategy {

    //depending on type of vehicle along with the whether parking is done on a weekday or a weekend
    int getCharge(int parkHours);
}
