package com.eproducts.controllers;

import com.eproducts.models.DBConnections;
import com.eproducts.models.LoginValidations;
import com.eproducts.models.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    
        LoginValidations userValidations;
        private JdbcTemplate jdbcTemplate;

        public HomeController() {
            this.userValidations = new LoginValidations();
            DBConnections DBConnection = new DBConnections();
            this.jdbcTemplate = new JdbcTemplate(DBConnection.connect());

        }
        
        @RequestMapping(method=RequestMethod.GET)
        public ModelAndView home(HttpServletRequest request){
            ModelAndView mav = new ModelAndView();
            int id= Integer.parseInt(request.getParameter("id"));
            Users user = this.findUserById(id);
            mav.setViewName("home");
            mav.addObject("users", new Users(id, user.getNombre(), user.getCorreo(), user.getTelefono(), user.getPassword()));
            return mav;
        }
        
        @RequestMapping(value="/logout" , method=RequestMethod.POST)
        public String logout(){
            return "redirect:index";
        }
        
        private Users findUserById(int id) {
        
            final Users usuario = new Users();
            String query = "SELECT * FROM Users WHERE id='" + id + "'";
            return (Users) jdbcTemplate.query(query, new ResultSetExtractor<Users>(){
                public Users extractData(ResultSet rs) throws SQLException, DataAccessException{
                        if(rs.next()){
                            usuario.setId(rs.getInt("id"));
                            usuario.setNombre(rs.getString("nombre"));
                            usuario.setCorreo(rs.getString("correo"));
                            usuario.setTelefono(rs.getString("telefono"));
                            usuario.setPassword(rs.getString("password"));
                        }
                        return usuario;
                    }
                }
            );
            
        }
        
}
