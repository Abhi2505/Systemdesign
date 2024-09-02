package com.SystemDesign.VendingMachine;

public class NoCoinInsertedState implements State{
    VendingMachine vendingMachine;
    public NoCoinInsertedState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }
    @Override
    public void insertCoin(double amt) {
        vendingMachine.setAmount(amt);
        vendingMachine.setCurrentVendingMachineState(vendingMachine.getCoinInsertedState());
    }

    @Override
    public void pressButton(int aisleNo) {
        throw new IllegalStateException("Mo coin is inserted");
    }

    @Override
    public void dispense(int aisleNo) {
        throw new IllegalStateException("No coin is inserted");
    }
}
