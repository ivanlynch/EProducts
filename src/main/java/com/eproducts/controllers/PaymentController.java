package com.eproducts.controllers;

import com.eproducs.services.mpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    
    mpService mpService = null;

    public PaymentController() {
        mpService = new mpService();
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public void doPayment(){
        
    }
    
}
