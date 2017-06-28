package com.eproducts.controllers;

import com.eproducts.models.User;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccessDeniedController {
    
    @RequestMapping(value="/403", method = RequestMethod.GET)
    public ModelAndView accessDenied(HttpServletRequest request){
        
        ModelAndView mav = new ModelAndView();
        User user = new User();
        user = (User)request.getSession().getAttribute("authenticatedUser");
        
        if(user.getUsername() != null){
            mav.addObject("msg", "Hola " + user.getUsername() + ", tu cuenta no tiene permisos para acceder a esta sección");
        }else{
            mav.addObject("msg", "Hola, tu cuenta no tiene permisos para acceder a esta sección");
        }
        
        mav.setViewName("403");
        return mav;
    };
}
