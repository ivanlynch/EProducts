package com.eproducts.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.springframework.web.multipart.MultipartFile;

public class Products {
 
    private int id, productStock ;
    private BigDecimal productPrice;
    private String productName, productDescription, productImage;
    private MultipartFile file;

    public Products() {
        this.id = 0;
        this.productStock = 0;
        this.productPrice = new BigDecimal(BigInteger.ONE);
        this.productName = "";
        this.productDescription = "";
        this.productImage = "";
    }

    public Products(BigDecimal productPrice, int productStock, String productName, String productDescription, MultipartFile file, String productImage) {
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productName = productName;
        this.productDescription = productDescription;
        this.file = file;
        this.productImage = productImage;
    }

    public Products(int id, BigDecimal productPrice, int productStock, String productName, String productDescription, MultipartFile file, String productImage) {
        this.id = id;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productName = productName;
        this.productDescription = productDescription;
        this.file = file;
        this.productImage = productImage;
    }

    public Products(String productName, String productDescription, BigDecimal productPrice, int productStock, String productImage) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productImage = productImage;
    }

    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
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


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
     
    
}
