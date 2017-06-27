package com.eproducts.security;

import com.eproducts.models.User;
import com.eproducts.validations.LoginValidations;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(CustomAuthenticationFilter.class);
    private LoginValidations login;
    Errors errors = null;

    protected CustomAuthenticationFilter() {
        super("/login");
    }

    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        User users = new User();
        users.setCorreo(request.getHeader("userName"));
        users.setPassword(request.getHeader("userToken"));
        errors = new BeanPropertyBindingResult(users, "users");
        this.login.validate(users, errors);

        LOG.info("Logeando: [{}] [{}]", users.getCorreo(), users.getPassword());
        return null;
    }
}
