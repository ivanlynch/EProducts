package com.eproducts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

        public HomeController() {

        }
        
        @RequestMapping(method=RequestMethod.GET)
        public ModelAndView home(){
            return new ModelAndView("home");
        }           
}
