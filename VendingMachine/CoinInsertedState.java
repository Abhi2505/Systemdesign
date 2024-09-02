package com.SystemDesign.VendingMachine;

public class CoinInsertedState implements State{
    VendingMachine vendingMachine;
    public CoinInsertedState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }
    @Override
    public void insertCoin(double amt) {
        vendingMachine.setAmount(vendingMachine.getAmount()+amt);

    }

    @Override
    public void pressButton(int aisleNo) {
        Inventory inventory=vendingMachine.getInventory();
        Product p=inventory.getProductAt(aisleNo);
        if(!vendingMachine.hasSufficientAmount(p.getPrice())){
           throw new IllegalStateException("Insufficient amt to buy this product");
        }
        if(!inventory.checkIfProductAvailable(p.getId())){
            throw new IllegalStateException("Product not available ");
        }
        vendingMachine.setCurrentVendingMachineState(vendingMachine.getDispenseState());
//        vendingMachine.getCurrentVendingMachineState().dispense(aisleNo);
    }

    @Override
    public void dispense(int aisleNo) {
        throw new IllegalStateException("Product not choosen");
    }
}
