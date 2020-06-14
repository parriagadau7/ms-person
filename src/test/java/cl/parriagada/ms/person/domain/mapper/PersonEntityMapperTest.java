package cl.parriagada.ms.person.domain.mapper;

import cl.parriagada.ms.person.DummyContent;
import cl.parriagada.ms.person.data.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonEntityMapperTest {

    private PersonEntityMapper personEntityMapper;

    @BeforeEach
    void setUp() {
        personEntityMapper = new PersonEntityMapper();
    }

    @Test
    void convert() {
        Person response = personEntityMapper.convert(DummyContent.person());
        assertNotNull(response);
        assertEquals("Pedro", response.getName());
        assertEquals("Soto", response.getLastName());
        assertEquals(32, response.getAge());
    }
}