package com.eproducts.models;

import java.io.Serializable;


public class Items implements Serializable{
    
    private Products product = new Products();
    private int quantity, productId;
    
    public Items(){
    
    }
    
    public Items(Products product, int quantity) {
        
        this.product = product;
        this.quantity = quantity;
        
    }
    
    public Items(int quantity, int productId) {
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
