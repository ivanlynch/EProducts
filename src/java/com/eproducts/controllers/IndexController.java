package com.eproducts.controllers;

import com.eproducs.services.ProductService;
import com.eproducs.services.UserService;
import com.eproducts.models.Products;
import com.eproducts.models.User;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/index")
public class IndexController {
    
    private UserService userService;
    private ProductService productService;
    

    public IndexController(){
        this.userService = new UserService();
        this.productService = new ProductService();
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView login(HttpSession session) throws UnsupportedEncodingException{   
        
        Map<String, Object> model = new HashMap<String, Object>();
        List<Products> products = this.productService.getAllProducts();
        model.put("users", new User());
        model.put("products", products);
        return new ModelAndView("index", "model", model);
        
    }
}
