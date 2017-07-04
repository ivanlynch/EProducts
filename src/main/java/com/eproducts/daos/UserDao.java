package com.eproducts.daos;

import com.eproducts.models.DBConnections;
import com.eproducts.models.Role;
import com.eproducts.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


public class UserDao {
    
    private JdbcTemplate jdbcTemplate;
      
    public UserDao(){
        DBConnections DBConnection = new DBConnections();
        this.jdbcTemplate = new JdbcTemplate(DBConnection.connect());
    }
    
    public User findUserById(int id){
        
        final User usuario = new User();
        String query = "SELECT * FROM Users WHERE id='" + id + "'";
        return (User) jdbcTemplate.query(query, new ResultSetExtractor<User>(){
            public User extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    usuario.setId(rs.getInt("id"));
                    usuario.setUsername((rs.getString("nombre")));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setIsAdmin(rs.getBoolean("isAdmin"));
                    Role r = new Role();
                    List<Role> roles = new ArrayList<Role>();
                    r.setName("ROLE_USER");
                    roles.add(r);
                    if(usuario.isIsAdmin()){
                        r.setName("ROLE_ADMIN");
                        roles.add(r);
                    }
                    usuario.setAuthorities(roles);
                }
                return usuario;
            }
        });
    }
    
    public User findUserByCorreo(String correo){
        
        final User usuario = new User();
        String query = "SELECT * FROM Users WHERE correo='" + correo + "'";
        return (User) jdbcTemplate.query(query, new ResultSetExtractor<User>(){
            public User extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    usuario.setId(rs.getInt("id"));
                    usuario.setUsername((rs.getString("nombre")));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setIsAdmin(rs.getBoolean("isAdmin"));
                    Role r = new Role();
                    List<Role> roles = new ArrayList<Role>();
                    r.setName("ROLE_USER");
                    roles.add(r);
                    if(usuario.isIsAdmin()){
                        r.setName("ROLE_ADMIN");
                        roles.add(r);
                    }
                    usuario.setAuthorities(roles);
                }
                return usuario;
            }
        });
    }
    
    public User findUserByCorreoAndPassword(String correo, String password) {
        
        final User usuario = new User();
        String query = "SELECT * FROM Users WHERE correo='" + correo + "' AND password='" + password + "'";
        return (User) jdbcTemplate.query(query, new ResultSetExtractor<User>(){
            public User extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    usuario.setId(rs.getInt("id"));
                    usuario.setUsername((rs.getString("nombre")));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setIsAdmin(rs.getBoolean("isAdmin"));
                    Role r = new Role();
                    List<Role> roles = new ArrayList<Role>();
                    r.setName("ROLE_USER");
                    roles.add(r);
                    if(usuario.isIsAdmin()){
                        Role a = new Role();
                        a.setName("ROLE_ADMIN");
                        roles.add(a);
                    }
                    usuario.setAuthorities(roles);
                }
                return usuario;
            }
        });
    }
    
    public User loadUserByUsername(final String username) {
        
        final User usuario = new User();
        String query = "SELECT * FROM Users WHERE nombre='" + username + "'";
        return (User) jdbcTemplate.query(query, new ResultSetExtractor<User>(){
            public User extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    usuario.setId(rs.getInt("id"));
                    usuario.setUsername((rs.getString("nombre")));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setIsAdmin(rs.getBoolean("isAdmin"));
                    Role r = new Role();
                    List<Role> roles = new ArrayList<Role>();
                    r.setName("ROLE_USER");
                    roles.add(r);
                    if(usuario.isIsAdmin()){
                        r.setName("ROLE_ADMIN");
                        roles.add(r);
                    }
                    usuario.setAuthorities(roles);
                }
                return usuario;
            }
        });
    }
    
}
