package com.SystemDesign.ParkingLot;

public class Vehicle {
    private String vehicleNumber;
    private VehicleSize vehicleSize;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(VehicleSize vehicleSize) {
        this.vehicleSize = vehicleSize;
    }



    public Vehicle(String vehicleNumber, VehicleSize vehicleSize) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleSize = vehicleSize;
    }
}
