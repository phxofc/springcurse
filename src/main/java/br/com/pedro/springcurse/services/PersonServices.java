package br.com.pedro.springcurse.services;

import br.com.pedro.springcurse.controllers.PersonController;
import br.com.pedro.springcurse.data.vo.PersonVO;
import br.com.pedro.springcurse.exceptions.RequiredObjectIsNullException;
import br.com.pedro.springcurse.exceptions.ResourceNotFoundException;
import br.com.pedro.springcurse.data.model.Person;
import br.com.pedro.springcurse.mapper.DozerMapper;
import br.com.pedro.springcurse.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    @Autowired
    PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public PersonVO findById(Long id) throws Exception {
        logger.info("FINDING ONE PERSON");

        var entity = repository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("NO RECORDS FOUND FOR THIS ID!"));
        logger.info("Antes de salvar: ID = " + entity.getId());

        var vo = DozerMapper.parseObject(entity,PersonVO.class);
        logger.info("passado no dozzer = " + vo.getKey());
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        logger.info("passado no hateos = " + vo.getKey());
        return vo;
    }

    public List<PersonVO> findAll(){
        logger.info("FINDING all People");

        var persons =  DozerMapper.parseListObject(repository.findAll(),PersonVO.class);
        persons
                .stream()
                .forEach(p -> {
                    try {
                        p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        return persons;
    }

    public PersonVO create (PersonVO person) throws Exception {
        if (person== null) throw new RequiredObjectIsNullException();
        logger.info("creating one person");

        var entity = DozerMapper.parseObject(person,Person.class);

        var vo = DozerMapper.parseObject(repository.save(entity),PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;

    }
    public PersonVO update (PersonVO person) throws Exception {
        if (person== null) throw new RequiredObjectIsNullException();
        logger.info("update one person");

       var entity =  repository.findById(person.getKey()).orElseThrow(()-> new ResourceNotFoundException("NO RECORDS FOUND FOR THIS ID!"));

       entity.setFirstName(person.getFirstName());
       entity.setLastName(person.getLastName());
       entity.setAddress(person.getAddress());
       entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity),PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }
    public void delete (Long id){
        var entity =  repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("NO RECORDS FOUND FOR THIS ID!"));
        logger.info("deleting one person");
        repository.delete(entity);

    }





}
