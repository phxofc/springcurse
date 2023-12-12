package br.com.pedro.springcurse.services;

import br.com.pedro.springcurse.data.vo.PersonVO;
import br.com.pedro.springcurse.exceptions.ResourceNotFoundException;
import br.com.pedro.springcurse.data.model.Person;
import br.com.pedro.springcurse.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    @Autowired
    PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public PersonVO findById(Long id){
        logger.info("FINDING ONE PERSON");


        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("NO RECORDS FOUND FOR THIS ID!"));
    }

    public List<PersonVO> findAll(){
        logger.info("FINDING all People");

        return repository.findAll();
    }

    public PersonVO create (PersonVO person){
        logger.info("creating one person");

        return repository.save(person);
    }
    public PersonVO update (PersonVO person){
        logger.info("update one person");

       var entity =  repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("NO RECORDS FOUND FOR THIS ID!"));

       entity.setFirstName(person.getFirstName());
       entity.setLastName(person.getLastName());
       entity.setAddress(person.getAddress());
       entity.setGender(person.getGender());

        return repository.save(entity);
    }
    public void delete (Long id){
        var entity =  repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("NO RECORDS FOUND FOR THIS ID!"));
        logger.info("deleting one person");
        repository.delete(entity);

    }





}
