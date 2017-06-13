package com.eproducts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView adminPanel(){
    
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin");
        return mav;
    }
    
}
