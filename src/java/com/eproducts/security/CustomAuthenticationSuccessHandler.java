package com.eproducts.security;

import com.eproducts.models.User;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private User user = new User();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        
        user = (User)authentication.getPrincipal();
        request.getSession().setAttribute("authenticatedUser", user);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        handle(request, response, authentication);
        //clearAuthenticationAttributes(request);
    }
    


    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
  
        String targetUrl = determineTargetUrl(authentication);
 
        if (response.isCommitted()) {
            logger.debug( "Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }
        
        redirectStrategy.sendRedirect(request, response, targetUrl);
        
    }
    
    protected String determineTargetUrl(Authentication authentication) {
        boolean isUser = false;
        boolean isAdmin = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
            } else if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                isUser = true;
            }
        }
 
        if (isAdmin) {
            return "/admin";
        } else if (isUser) {
            return "/home";
        } else {
            throw new IllegalStateException();
        }
    }
    
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
    
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }


    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    
}
