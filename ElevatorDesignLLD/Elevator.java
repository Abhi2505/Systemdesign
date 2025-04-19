package com.SystemDesign.ElevatorDesignLLD;// Elevator class

import java.util.TreeSet;

class Elevator {
    private int id;
    private int currentFloor;
    private ElevatorState state;
    private TreeSet<Integer> stops;

    public Elevator(int id, int initialFloor) {
        this.id = id;
        this.currentFloor = initialFloor;
        this.state = ElevatorStateFactory.getState(ElevatorStateType.IDLE);
        this.stops = new TreeSet<>();
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int floor) {
        this.currentFloor = floor;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public TreeSet<Integer> getStops() {
        return stops;
    }

    public void addStop(int floor) {
        stops.add(floor);
    }

    public void move() {
        state.move(this);
    }

    public void handleRequest(int floor) {
        state.handleRequest(this, floor);
    }
}