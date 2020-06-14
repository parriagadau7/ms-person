package cl.parriagada.ms.person.presentation.controller;

import cl.parriagada.ms.person.domain.model.Person;
import cl.parriagada.ms.person.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/person")
public class PersonController {

    private final PersonUseCase personUseCase;

    @PreAuthorize("#oauth2.hasScope('message.read')")
    @GetMapping("list")
    public ResponseEntity<List<Person>> personList() {
        return ResponseEntity.ok(personUseCase.list());
    }

    @GetMapping("/{idPerson}")
    public ResponseEntity<Person> findPerson(@PathVariable final Long idPerson) {
        return personUseCase.find(idPerson)
                .map(ResponseEntity::ok)          //200 OK
                .orElseGet(() -> ResponseEntity.noContent().build());  //202 No Content
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody final Person person) {
        return new ResponseEntity<>(personUseCase.create(person), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{idPerson}")
    public ResponseEntity<Person> update(@PathVariable final Long idPerson, @RequestBody final Person person) {
        return personUseCase.update(idPerson, person)
                .map(ResponseEntity::ok)          //200 OK
                .orElseGet(() -> ResponseEntity.noContent().build());  //202 No Content
    }

    @DeleteMapping(value = "/{idPerson}")
    public ResponseEntity<Void> delete(@PathVariable Long idPerson) {
        return personUseCase.delete(idPerson)
                .map(person -> new ResponseEntity<Void>(HttpStatus.OK))          //200 OK
                .orElseGet(() -> ResponseEntity.noContent().build());  //202 No Content
    }
}
