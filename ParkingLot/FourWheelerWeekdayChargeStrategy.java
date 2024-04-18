package com.SystemDesign.ParkingLot;

public class FourWheelerWeekdayChargeStrategy implements ParkingChargeStrategy{
    @Override
    public int getCharge(int parkHours) {
        if(parkHours<1){
            return 20;
        }
        return 20*parkHours;
    }
}
