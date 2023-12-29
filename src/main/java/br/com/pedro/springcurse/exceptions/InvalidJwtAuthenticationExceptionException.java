package br.com.pedro.springcurse.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJwtAuthenticationExceptionException extends AuthenticationException {

    private static final long serialVersionUID = 1L;
    public InvalidJwtAuthenticationExceptionException(String ex){
        super(ex);
    }
   
   
   

}
