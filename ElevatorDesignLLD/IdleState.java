package com.SystemDesign.ElevatorDesignLLD;

class IdleState implements ElevatorState {
    @Override
    public void move(Elevator elevator) {
        System.out.println("Elevator " + elevator.getId() + " is idle.");
    }

    @Override
    public void handleRequest(Elevator elevator, int floor) {
        elevator.addStop(floor);
        if (floor > elevator.getCurrentFloor()) {
            elevator.setState(ElevatorStateFactory.getState(ElevatorStateType.MOVING_UP));
        } else if (floor < elevator.getCurrentFloor()) {
            elevator.setState(ElevatorStateFactory.getState(ElevatorStateType.MOVING_DOWN));
        }
    }
}