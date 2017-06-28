package com.eproducts.controllers;

import com.eproducs.services.ProductService;
import com.eproducs.services.RedisService;
import com.eproducts.models.Items;
import com.eproducts.models.User;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    
    private ProductService productService = null;
    private RedisService redisService = null;
    
    public ShoppingCartController() throws UnsupportedEncodingException{
        this.productService = new ProductService();
        this.redisService = new RedisService();
    }
    
    @RequestMapping(value="/add/{id}", method=RequestMethod.GET)
    public String addToCart(@PathVariable(value="id") int id, HttpSession session){
        User user = (User)session.getAttribute("authenticatedUser");
        redisService.setUserCart(user.getCorreo(), new Items(this.productService.getProductById(id), 1));
        return "redirect:/index";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView indexCart(HttpSession session){
        User user = (User)session.getAttribute("authenticatedUser");
        return new ModelAndView("cart", "cart", redisService.getUserCart(user.getCorreo()));
    }
}
