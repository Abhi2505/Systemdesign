package com.SystemDesign.VendingMachine;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Inventory {
    Map<Integer,Product> aisleToProductMap;
    Map<Integer,Integer>productIdtoCountMap;
    Queue<Integer> availableAisle;

    Inventory(int aisleCount){
        availableAisle=new LinkedList<>();
        for(int i=1;i<=aisleCount;i++){
            availableAisle.add(i);
        }
        aisleToProductMap=new HashMap<>();
        productIdtoCountMap=new HashMap<>();

    }
    public void addProduct(Product p) throws Exception {
        int productId=p.getId();
        int productCount=productIdtoCountMap.getOrDefault(productId,0);
        if(productCount==0){
            if(availableAisle.isEmpty()){
                throw new Exception("out of space to add product");
            }
            aisleToProductMap.put(availableAisle.remove(),p);
        }
        productIdtoCountMap.put(productId,productCount+1);
    }
    public Product getProductAt(int aisleNo){
        return aisleToProductMap.get(aisleNo);
    }
    public boolean checkIfProductAvailable(int productID){
        int productCount=productIdtoCountMap.getOrDefault(productID,0);
        return productCount>0;
    }
    public void deductProductCount(int aisleNumber){
        int prodId=aisleToProductMap.get(aisleNumber).getId();
        int updateProductCount=productIdtoCountMap.get(prodId)-1;
        if(updateProductCount==0){
            productIdtoCountMap.remove(prodId);
            aisleToProductMap.remove(aisleNumber);
            availableAisle.add(aisleNumber);
        }
        else{
            productIdtoCountMap.put(prodId,updateProductCount);
        }
    }
}
