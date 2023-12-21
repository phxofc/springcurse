package br.com.pedro.springcurse.controllers;

import br.com.pedro.springcurse.data.vo.PersonVO;
import br.com.pedro.springcurse.services.PersonServices;
import br.com.pedro.springcurse.utils.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    PersonServices personServices;


    @GetMapping(value = "/{id}")
    public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception {
        return personServices.findById(id);
    }

    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML }
            , produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML })
    public List<PersonVO> findByAll() throws Exception {
        return personServices.findAll();
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML }
            , produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML })
    public PersonVO create(@RequestBody PersonVO person) throws Exception {
        return personServices.create(person);
    }

    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML}
            , produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
    public PersonVO update(@RequestBody PersonVO person) throws Exception {
        return personServices.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) throws Exception {
        personServices.delete(id);
    }


}
