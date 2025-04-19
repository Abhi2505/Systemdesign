package com.SystemDesign.ElevatorDesignLLD;

class ElevatorStateFactory {
    public static ElevatorState getState(ElevatorStateType type) {
        switch (type) {
            case MOVING_UP:
                return new MovingUpState();
            case MOVING_DOWN:
                return new MovingDownState();
            case IDLE:
            default:
                return new IdleState();
        }
    }
}