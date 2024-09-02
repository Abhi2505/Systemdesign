package com.SystemDesign.ParkingLot;

import java.util.Date;

public class Ticket {
    private int slotNumber;
    private String VechileNumber;
    private VehicleSize  vehicleSize;
    private Date date;


    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getVechileNumber() {
        return VechileNumber;
    }

    public void setVechileNumber(String vechileNumber) {
        VechileNumber = vechileNumber;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public Ticket(int slotNumber, String vechileNumber, VehicleSize vehicleSize, Date date) {
        this.slotNumber = slotNumber;
        VechileNumber = vechileNumber;
        this.vehicleSize = vehicleSize;
        this.date = date;
    }

    public void setVehicleSize(VehicleSize vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "slotNumber=" + slotNumber +
                ", VechileNumber='" + VechileNumber + '\'' +
                ", vehicleSize=" + vehicleSize +
                ", date=" + date +
                '}';
    }


}
