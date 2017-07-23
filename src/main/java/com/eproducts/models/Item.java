package com.eproducts.models;

import java.io.Serializable;


public class Item implements Serializable{
    
    private Products product = null;
    private int quantity, productId;
    
    public Item(){
        this.product = new Products();
        this.quantity = 0;
        this.productId = 0;
    }
       
    public Item(Products product, int quantity) {
        
        this.product = product;
        this.quantity = quantity;
        
    }
    
    public Item(int quantity, int productId) {
        this.quantity = quantity;
        this.productId = productId;
    }
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
}
