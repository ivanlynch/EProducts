package com.eproducts.controllers;

import com.eproducts.models.DBConnections;
import com.eproducts.models.UserValidations;
import com.eproducts.models.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    @RequestMapping(method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute("users") Users user, BindingResult result) {
        Users usr = checkUser(user.getCorreo(), user.getPassword());
        this.userValidations.validate(user, result);
        //String message = result.getFieldError().getDefaultMessage();
        if (!result.hasErrors()){
            if ((user.getCorreo().equals(usr.getCorreo())) && (user.getPassword().equals(usr.getPassword()))) {
                model.addAttribute("msg", usr.getNombre());
                return "home";
            } else {
                model.addAttribute("error", "El correo o contraseña son incorrectos");
                return "index";
            } 
        } else {
            model.addAttribute("error", result.getFieldError().getDefaultMessage());
            return "index";
        }
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