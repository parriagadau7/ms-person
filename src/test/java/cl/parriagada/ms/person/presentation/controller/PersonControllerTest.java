package cl.parriagada.ms.person.presentation.controller;

import cl.parriagada.ms.person.DummyContent;
import cl.parriagada.ms.person.domain.model.Person;
import cl.parriagada.ms.person.domain.usecase.PersonUseCase;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonUseCase personUseCase;

    @Test
    void personList() {
        when(personUseCase.list()).thenReturn(DummyContent.personList());
        ResponseEntity<List<Person>> response = personController.personList();
        assertNotNull(response);
        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
        assertEquals(3, response.getBody().size());
    }

    @Test
    void findPerson() {
        when(personUseCase.find(anyLong())).thenReturn(Optional.of(DummyContent.person()));
        ResponseEntity<Person> response = personController.findPerson(1l);
        assertNotNull(response);
        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
        assertEquals("Pedro", response.getBody().getName());
        assertEquals("Soto", response.getBody().getLastName());
        assertEquals(32, response.getBody().getAge());
    }

    @Test
    void create() {
        when(personUseCase.create(any())).thenReturn(DummyContent.person());
        ResponseEntity<Person> response = personController.create(DummyContent.person());
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
        assertEquals("Pedro", response.getBody().getName());
        assertEquals("Soto", response.getBody().getLastName());
        assertEquals(32, response.getBody().getAge());
    }

    @Test
    void update() {
        when(personUseCase.update(anyLong(), any())).thenReturn(Optional.of(DummyContent.person()));
        ResponseEntity<Person> response = personController.update(1l, DummyContent.person());
        assertNotNull(response);
        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
        assertEquals("Pedro", response.getBody().getName());
        assertEquals("Soto", response.getBody().getLastName());
        assertEquals(32, response.getBody().getAge());
    }

    @Test
    void delete() {
        when(personUseCase.delete(anyLong())).thenReturn(Optional.of(DummyContent.person()));
        ResponseEntity<Void> response = personController.delete(1l);
        assertNotNull(response);
        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
    }
}