package com.eproducts.controllers;

import com.eproducts.models.DBConnections;
import com.eproducts.models.SingupValidations;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductsController {
    
    private JdbcTemplate jdbcTemplate;
    
    public ProductsController(){
        
        DBConnections DBConnection = new DBConnections();
        this.jdbcTemplate = new JdbcTemplate(DBConnection.connect());
        
    }
    
    @RequestMapping(value="/products", method=RequestMethod.GET)
    public ModelAndView products(){
        
        ModelAndView mav = new ModelAndView();
        String query = "SELECT * FROM Products";
        List products = this.jdbcTemplate.queryForList(query);
        mav.addObject("products", products);
        mav.setViewName("products");
        return mav;
        
    }
    
}
