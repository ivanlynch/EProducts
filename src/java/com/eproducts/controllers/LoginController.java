package com.eproducts.controllers;

import com.eproducts.models.DBConnections;
import com.eproducts.models.UserValidations;
import com.eproducts.models.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("index.htm")
public class LoginController {
    
    UserValidations userValidations;
    private JdbcTemplate jdbcTemplate;

    public LoginController(){
        this.userValidations = new UserValidations();
        DBConnections DBConnection = new DBConnections();
        this.jdbcTemplate = new JdbcTemplate(DBConnection.connect());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView login(){
    
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("users", new Users());
        return mav;
    }
    
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("users") Users u, BindingResult result, SessionStatus status){
    
        this.userValidations.validate(u, result);
        if(result.hasErrors()){
        
            ModelAndView mav = new ModelAndView();
            mav.setViewName("index");
            mav.addObject("users", new Users());
            return mav;
            
        }else{
            
            
            Users user = checkUser(u.getCorreo(), u.getPassword());
            if((u.getCorreo().equals(user.getCorreo())) && (u.getPassword().equals(user.getPassword()))){
                
                return new ModelAndView("redirect:/home.htm");
                
            }else{
                
                return new ModelAndView("redirect:/index.htm");
                
            }
            
        }
    
    }
    
    @RequestMapping(value="/index.htm", method=RequestMethod.POST)
    public @ResponseBody String login(@ModelAttribute("users") Users u, BindingResult result){
        
        String returnText;
        this.userValidations.validate(u, result);
        Users user = checkUser(u.getCorreo(), u.getPassword());
        if((u.getCorreo().equals(user.getCorreo())) && (u.getPassword().equals(user.getPassword()))){
            returnText = "¡Bienvenid@ " + user.getNombre() + "!";
           
        }else{
            returnText = "Usuario incorrecto";
        }
        
        return returnText;
    
    }
    
    private Users checkUser(String correo, String password) {
        
        final Users usuario = new Users();
        String query = "SELECT * FROM Users WHERE correo='" + correo + "' AND password='" + password + "'";
        return (Users) jdbcTemplate.query(query, new ResultSetExtractor<Users>(){
            public Users extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setPassword(rs.getString("password"));
                }
                return usuario;
            }
        });
    }
}
