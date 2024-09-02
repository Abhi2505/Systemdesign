package com.SystemDesign.VendingMachine;

public class Main {
    public static void main(String[] args) throws Exception {
        VendingMachine vendingMachine=new VendingMachine();
        Product herseys=new Product("hersys",1,5.0);
        for(int i=1;i<=3;i++){
            vendingMachine.addProduct(herseys);
        }
        Product biskfarm=new Product("biskfarm",2,2.0);
        for(int i=1;i<=3;i++){
            vendingMachine.addProduct(biskfarm);
        }

        vendingMachine.insertCoin(5.0);
        vendingMachine.insertCoin(3.0);
        vendingMachine.pressButton(1);
        vendingMachine.insertCoin(5.0);
        vendingMachine.pressButton(1);
        vendingMachine.insertCoin(7.0);
        vendingMachine.pressButton(2);
        
    }
}
