package com.SystemDesign.ParkingLot;

public interface Parking {
    public Ticket park(Vehicle vehicle) throws ParkingFullException;
    public int unpark(Ticket ticker,ParkingChargeStrategy pstrategy) throws InvalidVehicleException;
}
