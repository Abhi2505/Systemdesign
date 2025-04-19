package com.SystemDesign.ElevatorDesignLLD;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// ElevatorController Singleton
class ElevatorController {
    private static ElevatorController instance;
    private List<Elevator> elevators;
    private PriorityQueue<ElevatorRequest> requests;

    private ElevatorController() {
        elevators = new ArrayList<>();
        requests = new PriorityQueue<>(Comparator.comparingInt(ElevatorRequest::getFloor));
    }

    public static ElevatorController getInstance() {
        if (instance == null) {
            instance = new ElevatorController();
        }
        return instance;
    }

    public void addElevator(Elevator elevator) {
        elevators.add(elevator);
    }

    public void requestElevator(int floor, Direction direction) {
        requests.add(new ElevatorRequest(floor, direction));
        assignElevators();
    }

    private void assignElevators() {
        while (!requests.isEmpty()) {
            ElevatorRequest request = requests.poll();
            Elevator closestElevator = findClosestElevator(request.getFloor(), request.getDirection());
            if (closestElevator != null) {
                closestElevator.handleRequest(request.getFloor());
            }
        }
    }

    private Elevator findClosestElevator(int floor, Direction direction) {
        Elevator closest = null;
        int minDistance = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - floor);
            if (distance < minDistance) {
                minDistance = distance;
                closest = elevator;
            }
        }
        return closest;
    }

    public List<Elevator> getElevators() {
        return elevators;
    }
}