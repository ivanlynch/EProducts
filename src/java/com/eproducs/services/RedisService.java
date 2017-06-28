package com.eproducs.services;

import com.eproducts.models.Items;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.redisson.Redisson;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedisService {
    
    RedissonClient client = null;
    
    
    public RedisService() throws UnsupportedEncodingException {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        this.client = Redisson.create(config);
    }
    
    public String setUserCart(String loggedUser, Items item){
        RList<Items> savedCart = client.getList("authenticatedUser");
        boolean exists = false;
        for (Items items : savedCart){
            if(items.getProduct().getId() == item.getProduct().getId()){
                exists = true;
            }
        }
        
        if(!exists){
            savedCart.add(item);
        }
        
        return null;
    }
    
    public List<Items> getUserCart(String loggedUser){
        RList<Items> cart = client.getList("loggedUser");
        return (List<Items>)cart;
    }
       
}
