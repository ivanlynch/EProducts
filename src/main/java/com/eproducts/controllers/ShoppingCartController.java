package com.eproducts.controllers;

import com.eproducs.services.ProductService;
import com.eproducs.services.RedisService;
import com.eproducts.models.Item;
import com.eproducts.models.Products;
import com.eproducts.models.User;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    
    private ProductService productService = null;
    private RedisService redisService = null;
    private List<Item> cart = null;
    
    public ShoppingCartController() throws UnsupportedEncodingException{
        this.productService = new ProductService();
        this.redisService = new RedisService();
        this.cart = new ArrayList<>();
    }
    
    @RequestMapping(value="/add/{id}/{qty}", method=RequestMethod.GET)
    public String addToCart(@PathVariable(value="id") int id,@PathVariable(value="qty") int qty, HttpSession session){
        Products product = this.productService.getProductByIdWithoutImage(id);
        User user = (User)session.getAttribute("authenticatedUser");
        redisService.setUserCart(user.getCorreo(), new Item(product, qty));
        return "redirect:/index";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView indexCart(HttpSession session){
        User user = (User)session.getAttribute("authenticatedUser");
        cart = redisService.getUserCart(user.getCorreo());
        return new ModelAndView("cart", "cart", cart);
    }
    
    @RequestMapping(value={"/delete/{id}"}, method=RequestMethod.GET)
    public String deleteFromCart(@PathVariable(value="id") int id, HttpSession session){
        User user = (User)session.getAttribute("authenticatedUser");
        redisService.deleteProductFromUserCart(user.getCorreo(), id);
        return "redirect:/cart";
    }
   
}
