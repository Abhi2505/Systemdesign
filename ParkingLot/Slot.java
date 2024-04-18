package com.SystemDesign.ParkingLot;

public class Slot {
    private int slotNumber;
    private boolean isEmpty;
    private Vehicle parkVehicle;

    public int getSlotNumber() {
        return slotNumber;
    }

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isEmpty=true;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getParkVehicle() {
        return parkVehicle;
    }

    public void setParkVehicle(Vehicle parkVehicle) {
        this.parkVehicle = parkVehicle;
    }

    public void vacateSlot(){
        parkVehicle=null;
        isEmpty=true;
    }
    public void occupySlot(Vehicle parkVehicle){
        this.parkVehicle=parkVehicle;
        isEmpty=false;
    }
}
