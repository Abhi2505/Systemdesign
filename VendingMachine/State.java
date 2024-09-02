package com.SystemDesign.VendingMachine;

public interface State {
    //3 diff state are there
    //No coin inserted state, coinInserted State,DispenseState,NoCoinInserted
    public void insertCoin(double amt);
    public void pressButton(int aisleNo);
    public void dispense(int aisleNo);
}
