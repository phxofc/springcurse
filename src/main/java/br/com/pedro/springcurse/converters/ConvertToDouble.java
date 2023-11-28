package br.com.pedro.springcurse.converters;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ConvertToDouble {
    
    public Double convertToDouble(String strNumber) {

        
        IsNumeric isnumeric = new IsNumeric();


        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if(isnumeric.isNumeric(strNumber)) return Double.parseDouble(number);

        return 0D;
    }


}
