package com.SystemDesign.ParkingLot;

public class TwoWheelerWeekendChargeStrategy implements ParkingChargeStrategy{
    @Override
    public int getCharge(int parkHours) {
        return parkHours<1?15:15*parkHours;
    }
}
