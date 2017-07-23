package com.eproducs.services;

import com.mercadopago.MP;
import org.codehaus.jettison.json.JSONObject;



public class mpService {
    
    MP mp = null;

    public mpService() {
        mp = new MP("5258194077733307", "OwuzBDUuVHTfux0expNMm7AZRJwHp4e5");
        mp.sandboxMode(true);
    }

    public JSONObject createPreference(String preferenceData) throws Exception {
        return mp.createPreference(preferenceData);
    }
    
    
    
    
    
}
