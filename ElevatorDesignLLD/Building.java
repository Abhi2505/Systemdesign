package com.SystemDesign.ElevatorDesignLLD;

class Building {
    private int totalFloors;
    private ElevatorController elevatorController;

    public Building(int totalFloors, int numberOfElevators) {
        this.totalFloors = totalFloors;
        this.elevatorController = ElevatorController.getInstance();
        for (int i = 1; i <= numberOfElevators; i++) {
            elevatorController.addElevator(new Elevator(i, 0));
        }
    }

    public void requestElevator(int floor, Direction direction) {
        if (floor < 0 || floor > totalFloors) {
            throw new IllegalArgumentException("Invalid floor number.");
        }
        elevatorController.requestElevator(floor, direction);
    }

    public ElevatorController getElevatorController() {
        return elevatorController;
    }
}
