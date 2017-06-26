package com.eproducts.controllers;

import com.eproducts.models.DBConnections;
import com.eproducts.models.User;
import com.eproducts.validations.SingupValidations;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UsersController {
    
    SingupValidations userValidations;
    private JdbcTemplate jdbcTemplate;
    
    public UsersController(){
        
        this.userValidations = new SingupValidations();
        DBConnections DBConnection = new DBConnections();
        this.jdbcTemplate = new JdbcTemplate(DBConnection.connect());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView getUsers(){
        ModelAndView mav = new ModelAndView();
        String query = "SELECT * FROM Users";
        List users = this.jdbcTemplate.queryForList(query);
        mav.setViewName("users");
        mav.addObject("users", users);
        return mav;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addUser(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("users/add");
        mav.addObject("users", new User());
        return mav;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("users")User u, BindingResult result){
        
        this.userValidations.validate(u, result);
        if(result.hasErrors()){
            ModelAndView mav = new ModelAndView();
            mav.setViewName("users/add");
            mav.addObject("users", new User());
            return mav;
            
        }else{
            this.jdbcTemplate.update("insert into Users (nombre, correo, telefono, password, isAdmin) values (?,?,?,?,?)", u.getUsername(), u.getCorreo(), u.getTelefono(), u.getPassword(), u.isIsAdmin());
            ModelAndView mav = new ModelAndView();
            mav.setViewName("redirect:/users");
            return mav;
            
        }
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView editUser(HttpServletRequest request){
        User user = getUserById(request.getParameter("id"));
        ModelAndView mav = new ModelAndView();
        mav.setViewName("users/edit");
        mav.addObject("users", user);
        return mav;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("users")User u, HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update("update Users set nombre=?, correo=?, password=?, telefono=?, isAdmin=? where id=? ", u.getUsername(), u.getCorreo(), u.getTelefono(), u.getPassword(), u.isIsAdmin(), id);
        return new ModelAndView("redirect:/users");
    }
    
    @RequestMapping(value="/delete", method=RequestMethod.GET)
    public String deleteUser(HttpServletRequest request){
        
        int id = Integer.parseInt(request.getParameter("id"));
        String query = "DELETE FROM `sys`.`Users` WHERE `id`='"+id+"';";
        this.jdbcTemplate.update(query);
        return "redirect:/users";
    
    }
    
    private User getUserById(String id) {
        
        final User usuario = new User();
        String query = "SELECT * FROM Users WHERE id='" + id + "'";
        return (User) jdbcTemplate.query(query, new ResultSetExtractor<User>(){
            public User extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    usuario.setId(rs.getInt("id"));
                    usuario.setUsername(rs.getString("nombre"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setIsAdmin(rs.getBoolean("isAdmin"));
                }
                return usuario;
            }
        });
    }
    
}
