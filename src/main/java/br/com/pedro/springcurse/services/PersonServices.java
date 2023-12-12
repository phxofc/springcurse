package br.com.pedro.springcurse.services;

import br.com.pedro.springcurse.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("FINDING ONE PERSON");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("pedro");
        person.setLastName("rocha");
        person.setAddress("serra caiada RN");
        person.setGender("male");
        return person;
    }

    public List<Person> findAll(){
        logger.info("FINDING all People");
        List<Person> persons = new ArrayList<>();
        for (int i=0; i <8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person create (Person person){
        logger.info("creating one person");

        return person;
    }
    public Person update (Person person){
        logger.info("update one person");

        return person;
    }
    public void delete (String id){
        logger.info("deleting one person");

    }



    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name: "+i);
        person.setLastName("last "+i);
        person.setAddress("Some andress in BRAZIL"+i);
        person.setGender("male");
        return person;
    }

}
