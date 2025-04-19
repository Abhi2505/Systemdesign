package com.SystemDesign.ElevatorDesignLLD;

// ElevatorRequest class
class ElevatorRequest {
    private int floor;
    private Direction direction;

    public ElevatorRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }
}