package br.com.pedro.springcurse;

import br.com.pedro.springcurse.data.model.Person;
import br.com.pedro.springcurse.data.vo.PersonVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PersonVOTest {

    @Test
    public void testKeyNotZero(){
        PersonVO person = new PersonVO();
        person.setKey(42); // Defina um valor diferente de zero

        assertNotEquals(0, person.getKey());
    }
}
