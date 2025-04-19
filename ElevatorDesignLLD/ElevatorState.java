package com.SystemDesign.ElevatorDesignLLD;

interface ElevatorState {
        void move(Elevator elevator);
        void handleRequest(Elevator elevator, int floor);
}

