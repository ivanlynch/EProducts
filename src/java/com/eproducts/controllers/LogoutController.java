package com.eproducts.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/logout")
public class LogoutController {
    
    @RequestMapping(method=RequestMethod.GET)
    public String logout(HttpServletRequest request){
    
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    
    }
    
}
