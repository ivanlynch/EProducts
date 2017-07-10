/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eproducts.daos;

import com.eproducts.models.DBConnections;
import com.eproducts.models.Products;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author root
 */
public class ProductDao {
    
    private JdbcTemplate jdbcTemplate;
      
    public ProductDao(){
        DBConnections DBConnection = new DBConnections();
        this.jdbcTemplate = new JdbcTemplate(DBConnection.connect());
    }
    
    
    public Products getProductById(int id) {
        
        final Products product = new Products();
        String query = "SELECT * FROM Products WHERE id='" + id + "'";
        return (Products) jdbcTemplate.query(query, new ResultSetExtractor<Products>(){
            public Products extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    try{
                        product.setId(rs.getInt("id"));
                        product.setProductName(rs.getString("productName"));
                        product.setProductDescription(rs.getString("productDescription"));
                        product.setProductPrice(rs.getBigDecimal("productPrice"));
                        product.setProductStock(rs.getInt("productStock"));
                        byte[] imageAsBytes = (byte[]) rs.getBytes("productImage");
                        byte[] encodeBase64 = Base64.encodeBase64(imageAsBytes);
                        String base64Encoded = new String(encodeBase64, "UTF-8");
                        product.setProductImage(base64Encoded);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
                return product;
            }
        });
    }
    
    public List getAllProducts() throws UnsupportedEncodingException{
        
        String query = "SELECT * FROM Products";
        List<Products> products = new ArrayList<>();
        List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);
        
        for(Map row : rows){
            Products product = new Products();
            product.setId((int)(row.get("id")));
            product.setProductName((String)(row.get("productName")));
            product.setProductDescription((String)(row.get("productDescription")));
            product.setProductPrice((BigDecimal)(row.get("productPrice")));
            
            byte[] imageAsBytes = (byte[]) row.get("productImage");
            byte[] encodeBase64 = Base64.encodeBase64(imageAsBytes);
            String base64Encoded = new String(encodeBase64, "UTF-8");
            
            product.setProductStock((int)(row.get("productStock")));
            product.setProductImage(base64Encoded);
            products.add(product);
        }
        
        return products;
    };

    public Products getProductByIdWithoutImage(int id) {
        final Products product = new Products();
        String query = "SELECT * FROM Products WHERE id='" + id + "'";
        return (Products) jdbcTemplate.query(query, new ResultSetExtractor<Products>(){
            public Products extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    try{
                        product.setId(rs.getInt("id"));
                        product.setProductName(rs.getString("productName"));
                        product.setProductDescription(rs.getString("productDescription"));
                        product.setProductPrice(rs.getBigDecimal("productPrice"));
                        product.setProductStock(rs.getInt("productStock"));
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
                return product;
            }
        });
    }
    
}
