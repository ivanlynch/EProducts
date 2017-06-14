package com.eproducts.models;

public class Products {
    
    private int id, productPrice, productStock ;
    private String productName, productDescription, productImage;

    public Products() {
        
    }

    public Products(int productPrice, int productStock, String productName, String productDescription, String productImage) {
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
    }
 

    public Products(int id, int productPrice, int productStock, String productName, String productDescription, String productImage) {
        this.id = id;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
     
    
    
}
