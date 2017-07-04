package com.eproducts.controllers;

import com.eproducts.models.User;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/account")
public class AccountController {

    private User user;
    
    public AccountController() {
        this.user = new User();
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView getAccount(HttpServletRequest request){
    
        this.user = (User)request.getSession().getAttribute("authenticatedUser");
        return new ModelAndView("account", "user", user);
    
    };
    
}
