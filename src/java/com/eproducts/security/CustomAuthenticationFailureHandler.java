package com.eproducts.security;

import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;


public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        
        if (exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
            

            JsonObject JSONObject = Json.createObjectBuilder().add("login", Json.createObjectBuilder().add("FAILURE", "Usuario o contraseña incorrecto").build()).build();
            response.setContentType("application/json");
            response.getWriter().print(JSONObject);
            response.getWriter().flush();

            
        } else if (exception.getClass().isAssignableFrom(DisabledException.class)) {
                
                throw new DisabledException("Cuenta deshabilitada");
                
        } else if (exception.getClass().isAssignableFrom(SessionAuthenticationException.class)) {
                
                throw new SessionAuthenticationException("Error al intentar logearse");
        }

        super.onAuthenticationFailure(request, response, exception);  

    }
}
