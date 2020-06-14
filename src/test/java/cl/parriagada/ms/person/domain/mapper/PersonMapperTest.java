package cl.parriagada.ms.person.domain.mapper;

import cl.parriagada.ms.person.DummyContent;
import cl.parriagada.ms.person.domain.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonMapperTest {

    private PersonMapper personMapper;

    @BeforeEach
    void setUp() {
        personMapper = new PersonMapper();
    }

    @Test
    void convert() {
        Person response = personMapper.convert(DummyContent.personEntity());
        assertNotNull(response);
        assertEquals("Pedro", response.getName());
        assertEquals("Soto", response.getLastName());
        assertEquals(32, response.getAge());
    }
}