package br.com.pedro.springcurse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class MathController {
    
    @GetMapping("/sum/{n1}/{n2}")
    public Double sum (@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2){

        

        return 1D;
    }

}
