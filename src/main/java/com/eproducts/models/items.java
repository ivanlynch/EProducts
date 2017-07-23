package com.eproducts.models;

import java.math.BigDecimal;

public class items {
    
    private String title;
    private int quantity;
    private String currency_id;
    private BigDecimal unit_price;

    public items() {
        
    }
    
    public items(String title, int quantity, String currency_id, BigDecimal unit_price) {
        this.title = title;
        this.quantity = quantity;
        this.currency_id = currency_id;
        this.unit_price = unit_price;
    }

    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }
    
    
}
