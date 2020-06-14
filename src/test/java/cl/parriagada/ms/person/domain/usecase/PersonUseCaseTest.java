package cl.parriagada.ms.person.domain.usecase;

import cl.parriagada.ms.person.DummyContent;
import cl.parriagada.ms.person.domain.mapper.PersonEntityMapper;
import cl.parriagada.ms.person.domain.mapper.PersonMapper;
import cl.parriagada.ms.person.domain.model.Person;
import cl.parriagada.ms.person.domain.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonUseCaseTest {

    @InjectMocks
    private PersonUseCase personUseCase;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @Mock
    private PersonEntityMapper personEntityMapper;


    @Test
    void list() {
        when(personRepository.findAll()).thenReturn(DummyContent.personEntityList());
        when(personMapper.convert(any())).thenReturn(DummyContent.person());
        List<Person> response = personUseCase.list();
        assertNotNull(response);
        assertEquals(3, response.size());
    }

    @Test
    void find() {
        when(personRepository.findById(anyLong())).thenReturn(Optional.of(DummyContent.personEntity()));
        when(personMapper.convert(any())).thenReturn(DummyContent.person());
        Optional<Person> response = personUseCase.find(1l);
        assertNotNull(response);
        assertTrue(response.isPresent());
        Person person = response.get();
        assertEquals("Pedro", person.getName());
        assertEquals("Soto", person.getLastName());
        assertEquals(32, person.getAge());
    }

    @Test
    void create() {
        when(personRepository.save(any())).thenReturn(DummyContent.personEntity());
        when(personMapper.convert(any())).thenReturn(DummyContent.person());
        when(personEntityMapper.convert(any())).thenReturn(DummyContent.personEntity());
        Person response = personUseCase.create(DummyContent.person());
        assertNotNull(response);
        assertEquals("Pedro", response.getName());
        assertEquals("Soto", response.getLastName());
        assertEquals(32, response.getAge());
    }

    @Test
    void update() {
        when(personRepository.findById(anyLong())).thenReturn(Optional.of(DummyContent.personEntity()));
        when(personMapper.convert(any())).thenReturn(DummyContent.person());
        when(personEntityMapper.convert(any())).thenReturn(DummyContent.personEntity());
        Optional<Person> response = personUseCase.update(1l, DummyContent.person());
        assertNotNull(response);
        assertTrue(response.isPresent());
        Person person = response.get();
        assertEquals("Pedro", person.getName());
        assertEquals("Soto", person.getLastName());
        assertEquals(32, person.getAge());
    }

    @Test
    void delete() {
        when(personRepository.findById(anyLong())).thenReturn(Optional.of(DummyContent.personEntity()));
        Optional<Person> response = personUseCase.delete(1l);
        assertNotNull(response);
        assertTrue(response.isPresent());
    }
}