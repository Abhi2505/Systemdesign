package com.SystemDesign.ParkingLot;

public class TestParking {
    public static void main(String[] args) throws ParkingFullException, InvalidVehicleException {
        ParkingLot pl=ParkingLot.getParkingLot();
        pl.initializeParkingSlots(10,10);
        Vehicle vehicle1=new Vehicle("MH 12",VehicleSize.TWOWHEELER);
        Ticket t1=pl.park(vehicle1);
        System.out.println(t1);
        Vehicle vehicle2=new Vehicle("Rj 13",VehicleSize.TWOWHEELER);
        Ticket t2=pl.park(vehicle2);
        System.out.println(t2);

        int cost1=pl.unpark(t1,new TwoWheelerWeekdayChargeStrategy());
        System.out.println(cost1);
        int cost2=pl.unpark(t2,new TwoWheelerWeekendChargeStrategy());
        System.out.println(cost2);

    }
}
