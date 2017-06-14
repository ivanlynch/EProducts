package com.eproducts.controllers.products;

import com.eproducts.models.Products;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddProductController {
    
    @RequestMapping(value="/addProducts", method=RequestMethod.GET)
    public ModelAndView addProduct(){
    
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addProducts");
        mav.addObject("products", new Products());
        return mav;
        
    }
    
}
