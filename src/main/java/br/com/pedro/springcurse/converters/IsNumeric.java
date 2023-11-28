package br.com.pedro.springcurse.converters;

import org.springframework.context.annotation.Configuration;

@Configuration
public class IsNumeric {

    public boolean isNumeric(String strNumber) {

        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        //adicionando regex
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
    
}
