package br.com.pedro.springcurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedro.springcurse.converters.ConvertToDouble;
import br.com.pedro.springcurse.converters.IsNumeric;
import br.com.pedro.springcurse.exceptions.UnsupportedMathOperationException;



@RestController
@RequestMapping("/")
public class MathController {

    @Autowired
    IsNumeric isNumeric;
    @Autowired
    ConvertToDouble convertToDouble;
    
    @GetMapping("/sum/{n1}/{n2}")
    public Double sum (@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) throws Exception{

        if(!isNumeric.isNumeric(n1) || !isNumeric.isNumeric(n2)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return convertToDouble.convertToDouble(n1) +convertToDouble.convertToDouble(n2) ;
    }


    @GetMapping("/sub/{n1}/{n2}")
    public Double sub(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) throws Exception{

        if(!isNumeric.isNumeric(n1) || !isNumeric.isNumeric(n2)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return convertToDouble.convertToDouble(n1) - convertToDouble.convertToDouble(n2) ;
    }

    @GetMapping("/mult/{n1}/{n2}")
    public Double mult(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) throws Exception{

        if(!isNumeric.isNumeric(n1) || !isNumeric.isNumeric(n2)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return convertToDouble.convertToDouble(n1) *convertToDouble.convertToDouble(n2) ;
    }

    @GetMapping("/div/{n1}/{n2}")
    public Double div (@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) throws Exception{

        if(!isNumeric.isNumeric(n1) || !isNumeric.isNumeric(n2)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return convertToDouble.convertToDouble(n1) / convertToDouble.convertToDouble(n2) ;
    }


     @GetMapping("/med/{n1}/{n2}")
    public Double med(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) throws Exception{

        if(!isNumeric.isNumeric(n1) || !isNumeric.isNumeric(n2)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return (convertToDouble.convertToDouble(n1) + convertToDouble.convertToDouble(n2))/2 ;
    }

     @GetMapping("/raiz/{n1}")
    public Double raiz(@PathVariable(value = "n1") String n1) throws Exception{

        if(!isNumeric.isNumeric(n1)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        

        return  Math.sqrt(convertToDouble.convertToDouble(n1));
    }










    

    

}
