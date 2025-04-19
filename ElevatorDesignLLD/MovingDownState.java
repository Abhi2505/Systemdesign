package com.SystemDesign.ElevatorDesignLLD;

class MovingDownState implements ElevatorState {
    @Override
    public void move(Elevator elevator) {
        elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
        System.out.println("Elevator " + elevator.getId() + " moving down to floor " + elevator.getCurrentFloor());

        if (elevator.getStops().contains(elevator.getCurrentFloor())) {
            elevator.getStops().remove(elevator.getCurrentFloor());
            System.out.println("Elevator " + elevator.getId() + " stopped at floor " + elevator.getCurrentFloor());
        }

        if (elevator.getStops().isEmpty()) {
            elevator.setState(ElevatorStateFactory.getState(ElevatorStateType.IDLE));
        }
    }

    @Override
    public void handleRequest(Elevator elevator, int floor) {
        elevator.addStop(floor);
    }
}
