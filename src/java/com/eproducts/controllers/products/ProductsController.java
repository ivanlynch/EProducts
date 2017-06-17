package com.eproducts.controllers.products;

import com.eproducts.models.DBConnections;
import com.eproducts.models.Products;
import com.eproducts.models.Users;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.Base64;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductsController {
    
    private JdbcTemplate jdbcTemplate;
    
    public ProductsController(){
        
        DBConnections DBConnection = new DBConnections();
        this.jdbcTemplate = new JdbcTemplate(DBConnection.connect());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView get() throws IOException{
        
        ModelAndView mav = new ModelAndView();
        String query = "SELECT * FROM Products";
        List<Products> products = new ArrayList<Products>();
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
        
       
        mav.addObject("products", products);
        mav.setViewName("products");
        return mav;
        
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addProduct(){
    
        ModelAndView mav = new ModelAndView();
        mav.setViewName("products/add");
        mav.addObject("products", new Products());
        return mav;
        
    }
    
      
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("products") Products products, BindingResult result) throws FileNotFoundException, IOException{
        
        InputStream inputStream = null;
        byte[] byteArr = products.getFile().getBytes();
        inputStream = new ByteArrayInputStream(byteArr);
        this.jdbcTemplate.update("insert into Products (productName, productDescription, productPrice, productStock, productImage) values (?,?,?,?,?)", products.getProductName(), products.getProductDescription(), products.getProductPrice(), products.getProductStock(), inputStream);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/products");
        return mav;
        
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView editProduct(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        Products product = getProductById(request.getParameter("id"));        
        mav.setViewName("products/edit");
        mav.addObject("products", new Products(product.getProductName(), product.getProductDescription(), product.getProductPrice(), product.getProductStock(), product.getProductImage()));
        return mav;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public ModelAndView editPostProduct(@ModelAttribute("products") Products products, HttpServletRequest request) throws IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        InputStream inputStream = null;
        byte[] byteArr = products.getFile().getBytes();
        inputStream = new ByteArrayInputStream(byteArr);        
        this.jdbcTemplate.update("update Products set productName=?, productDescription=?, productPrice=?, productStock=?, productImage=? where id=? ", products.getProductName(), products.getProductDescription(), products.getProductPrice(), products.getProductStock(), inputStream, id);
        return new ModelAndView("redirect:/products");
    }
    
    @RequestMapping(value="/delete", method=RequestMethod.GET)
    public String deleteProduct(HttpServletRequest request){
        
        int id = Integer.parseInt(request.getParameter("id"));
        String query = "DELETE FROM `sys`.`Products` WHERE `id`='"+id+"';";
        this.jdbcTemplate.update(query);
        return "redirect:/products";
    
    }

    private Products getProductById(String id) {
        
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
    
}
