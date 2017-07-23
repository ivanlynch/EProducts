package com.eproducts.controllers;

import com.eproducs.services.mpService;
import com.eproducts.models.Item;
import com.eproducts.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    
    mpService mpService = null;
    private List<Item> cart;
    String mpSandBox = "";
    
    public PaymentController() {
        mpService = new mpService();
        this.cart = new ArrayList<>();
    }
    
    
    
    @RequestMapping(method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void setPayment(@RequestParam(value="ItemList", required=false)String ItemList, HttpSession session) throws Exception{
        
        ObjectMapper mapper = new ObjectMapper();
        this.cart = mapper.readValue(ItemList, mapper.getTypeFactory().constructCollectionType(List.class, Item.class)); 
        
        JSONObject jsonItems = new JSONObject();
        
        JSONArray arrayItems = new JSONArray(); 
        
        User user = (User) session.getAttribute("authenticatedUser");
        
        for(Item item : cart){
            JSONObject JSONItem = new JSONObject();
            JSONItem.put("title", "Carrito de " + user.getUsername());
            JSONItem.put("quantity", 1);
            JSONItem.put("currency_id", "ARS");
            JSONItem.put("unit_price", item.getProduct().getProductPrice());
            arrayItems.put(JSONItem);
        }
                
        jsonItems.put("items", arrayItems);       
        
        String preferenceItemsData = jsonItems.toString();
	JSONObject preference = mpService.createPreference(preferenceItemsData);
        this.mpSandBox = preference.getJSONObject("response").getString("sandbox_init_point");
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String returnPayment() throws Exception{
                
        
        return "redirect:" + mpSandBox;
        
    }
    
}
