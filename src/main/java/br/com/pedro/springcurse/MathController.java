package br.com.pedro.springcurse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedro.springcurse.exceptions.UnsupportedMathOperationException;


@RestController
@RequestMapping("/")
public class MathController {
    
    @GetMapping("/sum/{n1}/{n2}")
    public Double sum (@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) throws Exception{

        if(!isNumeric(n1) || !isNumeric(n2)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return convertToDouble(n1) +convertToDouble(n2) ;
    }

    private Double convertToDouble(String strNumber) {

        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);

        return 0D;
    }

    private boolean isNumeric(String strNumber) {

        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        //adicionando regex
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
