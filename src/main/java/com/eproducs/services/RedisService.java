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
        config.useSingleServer()
                .setAddress("redis://redis-15453.c14.us-east-1-2.ec2.cloud.redislabs.com:15453")
                .setPassword("tSrkjZUq7puIWj9r")
//                .setAddress("redis://127.0.0.1:6379")
                .setTimeout(3000)
                .setConnectionPoolSize(30);
        this.client = Redisson.create(config);
    }
    
    public void setUserCart(String userEmail, Items item){
        RList<Items> savedCart = client.getList("userEmail");
        boolean exists = false;
        for (Items items : savedCart){
            if(items.getProduct().getId() == item.getProduct().getId()){
                exists = true;
            }
        }
        
        if(!exists){
            savedCart.add(item);
        }      
    }
    
    public List<Items> getUserCart(String userEmail){
        RList<Items> cart = client.getList("userEmail");
        return (List<Items>)cart;
    }

    public void deleteProductFromUserCart(String userEmail, Items item) {
        RList<Items> userCart = client.getList("userEmail");
        boolean exists = false;
        for (Items items : userCart){
            if(items.getProduct().getId() == item.getProduct().getId()){
                userCart.remove(item);
            }
        }
        
    }
       
}
