package com.eproducts.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class UserValidations implements Validator{
    
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean supports(Class<?> type) {
        return Users.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        Users usuarios = (Users) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo", "required.correo", "El campo Correo es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "El Campo Contraseña es obligatorio");
        
        if(!(usuarios.getCorreo() != null && usuarios.getCorreo().isEmpty())){
        
            this.pattern = Pattern.compile(EMAIL_PATTERN);
            this.matcher = pattern.matcher(usuarios.getCorreo());
                if(!matcher.matches()){
                    errors.rejectValue("correo", "correo.incorrect", "El Correo electronico" + usuarios.getCorreo() + "no es valido");
                }
        
        }
    }
    
}