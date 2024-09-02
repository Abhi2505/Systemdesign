package com.SystemDesign.VendingMachine;

public class VendingMachine {
    NoCoinInsertedState noCoinInsertedState;
    CoinInsertedState coinInsertedState;
    DispenseState dispenseState;
    State CurrentVendingMachineState;
    Inventory inventory;
    double amount;
    static final int AISLE_COUNT=2;

    public VendingMachine(){
        noCoinInsertedState=new NoCoinInsertedState(this);
        coinInsertedState=new CoinInsertedState(this);
        dispenseState=new DispenseState(this);
        CurrentVendingMachineState=noCoinInsertedState;
        amount=0.0;
        inventory=new Inventory(AISLE_COUNT);
    }

    public NoCoinInsertedState getNoCoinInsertedState() {
        return noCoinInsertedState;
    }

    public void setNoCoinInsertedState(NoCoinInsertedState noCoinInsertedState) {
        this.noCoinInsertedState = noCoinInsertedState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public State getCurrentVendingMachineState() {
        return CurrentVendingMachineState;
    }

    public void setCurrentVendingMachineState(State currentVendingMachineState) {
        CurrentVendingMachineState = currentVendingMachineState;
    }

    public CoinInsertedState getCoinInsertedState() {
        return coinInsertedState;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCoinInsertedState(CoinInsertedState coinInsertedState) {
        this.coinInsertedState = coinInsertedState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(DispenseState dispenseState) {
        this.dispenseState = dispenseState;
    }


    public boolean hasSufficientAmount(double productamt){
        return productamt<=this.amount;
    }
    public void insertCoin(double amt){
        this.CurrentVendingMachineState.insertCoin(amt);
        System.out.println(amt+" coin is inserted");
    }

    public void pressButton(int aisle){
        this.CurrentVendingMachineState.pressButton(aisle);
        this.CurrentVendingMachineState.dispense(aisle);
    }
    public void addProduct(Product p) throws Exception {
        this.getInventory().addProduct(p);

    }



}
