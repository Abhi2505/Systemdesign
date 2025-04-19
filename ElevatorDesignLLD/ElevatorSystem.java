package com.SystemDesign.ElevatorDesignLLD;

public class ElevatorSystem {
    public static void main(String[] args) {
        Building building = new Building(20, 3);

        building.requestElevator(5, Direction.UP);
        building.requestElevator(2, Direction.DOWN);
        building.requestElevator(7,Direction.DOWN);
        // Simulate elevator movements
        ElevatorController controller = building.getElevatorController();
        for (int i = 0; i < 10; i++) {
            for (Elevator elevator : controller.getElevators()) {
                elevator.move();
            }
        }
    }
}
