package com.SystemDesign.ParkingLot;
import java.util.*;
public class ParkingLot implements Parking{
    //parking lot entity is a singleton class
    private static ParkingLot parkingLot;
    private final List<Slot>twoWheelerSlot;
    private final List<Slot>fourWheelerSlot;

    private ParkingLot(){
        this.fourWheelerSlot=new ArrayList<>();
        this.twoWheelerSlot=new ArrayList<>();
    }
//here we have used singleton design pattern
    public static ParkingLot getParkingLot(){
        if(parkingLot==null)
            parkingLot=new ParkingLot();
        return parkingLot;
    }
    public boolean initializeParkingSlots(int Totaltwowheelerslots,int Totalfourwheelerslots){
        for(int i=1;i<Totalfourwheelerslots;i++)fourWheelerSlot.add(new Slot(i));
        System.out.println("create fourwheeler slots "+ Totalfourwheelerslots );
        for(int i=1;i<Totaltwowheelerslots;i++)twoWheelerSlot.add(new Slot(i));
        System.out.println("create threewheeler slots "+ Totalfourwheelerslots );
        return true;
    }

    private Slot getFourWheelerAvailableSlot() throws ParkingFullException{
            for(Slot slot:fourWheelerSlot){
                if(slot.isEmpty()){
                    return slot;
                }
            }
            throw new ParkingFullException("parking full no slot available for Fourwheeler");
    }
    private Slot getTwoWheelerAvailableSlot() throws ParkingFullException{
        for(Slot slot:twoWheelerSlot){
            if(slot.isEmpty()){
                return slot;
            }
        }
        throw new ParkingFullException("parking full no slot available for TwoWheeler");
    }

    @Override
    public Ticket park(Vehicle vehicle) throws ParkingFullException {
        Slot availableSlot;
        if(vehicle.getVehicleSize().equals(VehicleSize.FOURWHEELER)){
            availableSlot=getFourWheelerAvailableSlot();
        }
        else{
            availableSlot=getTwoWheelerAvailableSlot();
        }
        availableSlot.occupySlot(vehicle);
        System.out.println("Occupied slot "+ availableSlot.getSlotNumber());
        Ticket ticket=new Ticket(availableSlot.getSlotNumber(),vehicle.getVehicleNumber(),vehicle.getVehicleSize(),new Date());
        return ticket;
    }

    @Override
    public int unpark(Ticket ticket, ParkingChargeStrategy pstrategy) throws InvalidVehicleException {
        int costByHours=0;
        Slot slot;
        if(ticket.getVehicleSize().equals(VehicleSize.FOURWHEELER)){
              slot=findSlotByFourWheelerVehicleNumber(ticket.getVechileNumber());
        }
        else{
            slot=findSlotByTwoVehicleNumber((ticket.getVechileNumber()));
        }
        slot.vacateSlot();
        int hours=getHoursParked(ticket.getDate(),new Date());
        costByHours=pstrategy.getCharge(hours);
        System.out.println("vehicle with registration "+ticket.getVechileNumber()+" at slot "+slot.getSlotNumber()+" parked for "+hours+" hours and total charge is "+costByHours);
        return costByHours;
    }

    private int getHoursParked(Date startdate, Date enddate) {
        long sec=(enddate.getTime()+100000000-startdate.getTime())/1000;
        int hr=(int)(sec/3600);
        return hr;
    }

    private Slot findSlotByTwoVehicleNumber(String vehicleNumber) throws InvalidVehicleException {
        for(Slot slot:twoWheelerSlot){
            Vehicle v=slot.getParkVehicle();
            {
                if (v != null && v.getVehicleNumber().equals(vehicleNumber)){
                    return slot;
                }
            }
        }
            throw new InvalidVehicleException("Two wheeler vehicle with reg no "+vehicleNumber +" not found ");
    }

    private Slot findSlotByFourWheelerVehicleNumber(String vehicleNumber) throws InvalidVehicleException {
        for(Slot slot:fourWheelerSlot){
            Vehicle v=slot.getParkVehicle();
            {
                if (v != null && v.getVehicleNumber().equals(vehicleNumber)){
                    return slot;
                }
            }
        }
        throw new InvalidVehicleException("Two wheeler vehicle with reg no "+vehicleNumber +" not found ");
    }
}
