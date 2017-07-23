package com.eproducts.controllers;

import com.eproducts.models.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/checkout")
public class CheckOutController {
    
    private List<Item> cart = new ArrayList<>();
       
    @RequestMapping(method=RequestMethod.POST)
    public void checkout(@RequestParam(value="ItemList", required=false)String ItemList) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        this.cart = mapper.readValue(ItemList, mapper.getTypeFactory().constructCollectionType(List.class, Item.class));
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView getCheckout(){
        return new ModelAndView("checkout", "cart", this.cart);
    }

}
