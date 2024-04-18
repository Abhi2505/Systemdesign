package com.SystemDesign.ParkingLot;

public class ParkingFullException extends Exception{
    public ParkingFullException(String message){
         super(message);
    }
}
