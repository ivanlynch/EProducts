package com.eproducs.services;

import com.eproducts.daos.ProductDao;
import com.eproducts.models.Products;
import java.io.UnsupportedEncodingException;
import java.util.List;


public class ProductService {
    
    private ProductDao productDao = null;

    public ProductService() {
        this.productDao = new ProductDao();
    }
    
    public Products getProductById(int id){
        return productDao.getProductById(id);
    }
    
    public List getAllProducts() throws UnsupportedEncodingException{
        return productDao.getAllProducts();
    }

    public Products getProductByIdWithoutImage(int id) {
        return productDao.getProductByIdWithoutImage(id);
    }
    
    
    
}
