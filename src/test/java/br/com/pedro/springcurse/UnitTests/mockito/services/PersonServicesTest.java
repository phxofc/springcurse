package br.com.pedro.springcurse.UnitTests.mockito.services;

import br.com.pedro.springcurse.data.model.Person;
import br.com.pedro.springcurse.data.vo.PersonVO;
import br.com.pedro.springcurse.exceptions.RequiredObjectIsNullException;
import br.com.pedro.springcurse.mapper.mocks.MockPerson;
import br.com.pedro.springcurse.repositories.PersonRepository;
import br.com.pedro.springcurse.services.PersonServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServicesTest {

    MockPerson input;


    @InjectMocks
    private PersonServices service;
    @Mock
    PersonRepository repository;

    @BeforeEach
    void setUpMock() throws Exception {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() throws Exception {
        Person entity  = input.mockEntity(1);
        entity.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertEquals(1,result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</person/1>;rel=\"self\"]"));
        assertEquals("Addres Test1",result.getAddress());
        assertEquals("First Name Test1",result.getFirstName());
        assertEquals("Last Name Test1",result.getLastName());
        assertEquals("Female",result.getGender());
    }



    @Test
    void create() throws Exception {
        Person persisted = input.mockEntity(1);
        persisted.setId(1L);


        PersonVO vo = input.mockVO(1);
        vo.setKey(1L);
        when(repository.save(any(Person.class))).thenReturn(persisted);

        var result = service.create(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertEquals(1,result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</person/1>;rel=\"self\"]"));
        assertEquals("Addres Test1",result.getAddress());
        assertEquals("First Name Test1",result.getFirstName());
        assertEquals("Last Name Test1",result.getLastName());
        assertEquals("Female",result.getGender());

    }
    @Test
    void createWithNullPerson() {

        Exception exception = assertThrows(RequiredObjectIsNullException.class, ()->{
            service.create(null);
        });
        String expectMessage = "It is not allowed to persist a null object!";
        String actualMessage  = exception.getMessage();

        assertTrue(actualMessage.contains(expectMessage));


    }

    @Test
    void update() throws Exception {

        Person persisted = input.mockEntity(1);
        persisted.setId(1L);


        PersonVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.save(any(Person.class))).thenReturn(persisted);
        when(repository.findById(1L)).thenReturn(Optional.of(persisted));

        var result = service.update(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertEquals(1,result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</person/1>;rel=\"self\"]"));
        assertEquals("Addres Test1",result.getAddress());
        assertEquals("First Name Test1",result.getFirstName());
        assertEquals("Last Name Test1",result.getLastName());
        assertEquals("Female",result.getGender());

    }

    @Test
    void updateWithNullPerson() {

        Exception exception = assertThrows(RequiredObjectIsNullException.class, ()->{
            service.update(null);
        });
        String expectMessage = "It is not allowed to persist a null object!";
        String actualMessage  = exception.getMessage();

        assertTrue(actualMessage.contains(expectMessage));


    }


    @Test
    void delete() throws Exception {

        Person entity  = input.mockEntity(1);
        entity.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        service.delete(1L);

    }

    @Test
    void findAll() {

        List<Person> list  = input.mockEntityList();
        when(repository.findAll()).thenReturn(list);

        var people = service.findAll();

        assertNotNull(people);
        assertEquals(14,people.size());

        var personOne = people.get(1);

        assertNotNull(personOne);
        assertNotNull(personOne.getKey());
        assertEquals(1,personOne.getKey());
        assertNotNull(personOne.getLinks());
        assertTrue(personOne.toString().contains("links: [</person/1>;rel=\"self\"]"));
        assertEquals("Addres Test1",personOne.getAddress());
        assertEquals("First Name Test1",personOne.getFirstName());
        assertEquals("Last Name Test1",personOne.getLastName());
        assertEquals("Female",personOne.getGender());

        var personFive = people.get(5);

        assertNotNull(personFive);
        assertNotNull(personFive.getKey());
        assertEquals(5,personFive.getKey());
        assertNotNull(personFive.getLinks());
        assertTrue(personFive.toString().contains("links: [</person/5>;rel=\"self\"]"));
        assertEquals("Addres Test5",personFive.getAddress());
        assertEquals("First Name Test5",personFive.getFirstName());
        assertEquals("Last Name Test5",personFive.getLastName());
        assertEquals("Female",personFive.getGender());

        var personSix = people.get(6);

        assertNotNull(personSix);
        assertNotNull(personSix.getKey());
        assertEquals(6,personSix.getKey());
        assertNotNull(personSix.getLinks());
        assertTrue(personSix.toString().contains("links: [</person/6>;rel=\"self\"]"));
        assertEquals("Addres Test6",personSix.getAddress());
        assertEquals("First Name Test6",personSix.getFirstName());
        assertEquals("Last Name Test6",personSix.getLastName());
        assertEquals("Male",personSix.getGender());

    }
}