package com.eproducts.controllers.products;

import com.eproducts.models.DBConnections;
import com.eproducts.models.Products;
import com.mysql.jdbc.PreparedStatement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public ModelAndView get(){
        
        ModelAndView mav = new ModelAndView();
        String query = "SELECT * FROM Products";
        List products = this.jdbcTemplate.queryForList(query);
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
    public ModelAndView addProduct(@ModelAttribute("product") Products product, BindingResult result) throws FileNotFoundException{
        
        FileInputStream fis = null;
        PreparedStatement ps = null;
        fis = new FileInputStream(product.getFile());
        this.jdbcTemplate.update("insert into Products (productName, productDescription, productPrice, productStock, productImage) values (?,?,?,?,?)", product.getProductName(), product.getProductDescription(), product.getProductPrice(), product.getProductStock(), fis);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/products");
        return mav;
        
    }
}
