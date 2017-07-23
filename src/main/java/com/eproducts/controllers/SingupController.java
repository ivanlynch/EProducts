package com.eproducts.controllers;

import com.eproducts.models.DBConnections;
import com.eproducts.models.User;
import com.eproducts.validations.SingupValidations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/singup")
public class SingupController {
   
    SingupValidations userValidations;
    private JdbcTemplate jdbcTemplate;
    
    public SingupController(){
        this.userValidations = new SingupValidations();
        DBConnections DBConnection = new DBConnections();
        this.jdbcTemplate = new JdbcTemplate(DBConnection.connect());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView singup(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("singup");
        mav.addObject("users", new User());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView singup(@ModelAttribute("users") User u, BindingResult result){
    
        this.userValidations.validate(u, result);
        if(result.hasErrors()){
            ModelAndView mav = new ModelAndView();
            mav.setViewName("singup");
            mav.addObject("users", new User());
            return mav;
            
        }else{
            this.jdbcTemplate.update("insert into Users (nombre, correo, telefono, password) values (?,?,?,?)", u.getUsername(), u.getCorreo(), u.getTelefono(), u.getPassword());
            ModelAndView mav = new ModelAndView();
            mav.setViewName("redirect:index");
            return mav;
            
        }
    
    }
         
}
