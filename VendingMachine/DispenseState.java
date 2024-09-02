package com.SystemDesign.VendingMachine;

public class DispenseState implements State{

    VendingMachine vendingMachine;
    public DispenseState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }

    @Override
    public void insertCoin(double amt) {
        throw new IllegalStateException("Product getting dispensed");
    }

    @Override
    public void pressButton(int aisleNo) {
        throw new IllegalStateException("Product getting dispensed");
    }

    @Override
    public void dispense(int aisleNo) {

       Inventory inventory= vendingMachine.getInventory();
        Product p=inventory.getProductAt(aisleNo);
        inventory.deductProductCount(aisleNo);
        double charge=vendingMachine.getAmount()-p.getPrice();
        vendingMachine.setAmount(0);
        vendingMachine.setCurrentVendingMachineState(vendingMachine.getNoCoinInsertedState());
        System.out.println("product with prod id "+p.getId()+" is dispensed ");
    }
}
