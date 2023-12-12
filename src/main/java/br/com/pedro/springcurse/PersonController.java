package br.com.pedro.springcurse;

import br.com.pedro.springcurse.model.Person;
import br.com.pedro.springcurse.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    PersonServices personServices;


     @GetMapping("/{id}")
    public Person findById(@PathVariable(value = "id") Long id) throws Exception{
        return  personServices.findById(id);
    }

    @GetMapping
    public List<Person> findByAll() throws Exception{
        return  personServices.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person) throws Exception{
        return  personServices.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person) throws Exception{
        return  personServices.update(person);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) throws Exception{
        personServices.delete(id);
    }


}
