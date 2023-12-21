package br.com.pedro.springcurse.services;

import br.com.pedro.springcurse.controllers.PersonController;
import br.com.pedro.springcurse.data.vo.PersonVO;
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

        PersonVO vo = DozerMapper.parseObject(entity,PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

    public List<PersonVO> findAll(){
        logger.info("FINDING all People");

        return DozerMapper.parseListObject(repository.findAll(),PersonVO.class);
    }

    public PersonVO create (PersonVO person){
        logger.info("creating one person");

        var entity = DozerMapper.parseObject(person,Person.class);

        var vo = DozerMapper.parseObject(repository.save(entity),PersonVO.class);
        return vo;

    }
    public PersonVO update (PersonVO person){
        logger.info("update one person");

       var entity =  repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("NO RECORDS FOUND FOR THIS ID!"));

       entity.setFirstName(person.getFirstName());
       entity.setLastName(person.getLastName());
       entity.setAddress(person.getAddress());
       entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity),PersonVO.class);
        return vo;
    }
    public void delete (Long id){
        var entity =  repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("NO RECORDS FOUND FOR THIS ID!"));
        logger.info("deleting one person");
        repository.delete(entity);

    }





}
