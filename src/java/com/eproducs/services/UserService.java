package com.eproducs.services;

import com.eproducts.daos.UserDao;
import com.eproducts.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService{

    private UserDao userDao = null;
    
    public UserService(){
        this.userDao = new UserDao();
    }
    
    public User findUser(int id){
        return userDao.findUserById(id);
    }
    
    public User findUser(String correo){
        return userDao.findUserByCorreo(correo);
    }
    
    public User findUser(String correo, String password){
        return userDao.findUserByCorreoAndPassword(correo, password);
    }
    
    public User loginUser(String correo, String password){
        User user = this.findUser(correo, password);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.loadUserByUsername(username);
    }
    
}
