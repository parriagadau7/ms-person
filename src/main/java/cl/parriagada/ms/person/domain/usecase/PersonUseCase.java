package cl.parriagada.ms.person.domain.usecase;

import cl.parriagada.ms.person.domain.mapper.PersonEntityMapper;
import cl.parriagada.ms.person.domain.mapper.PersonMapper;
import cl.parriagada.ms.person.domain.model.Person;
import cl.parriagada.ms.person.domain.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonUseCase {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final PersonEntityMapper personEntityMapper;

    public List<Person> list() {
        return personRepository.findAll()
                .stream()
                .map(personMapper::convert)
                .collect(Collectors.toList());
    }

    public Optional<Person> find(final Long idPerson) {
        return Optional.ofNullable(personMapper.convert(personRepository.findById(idPerson).orElse(null)));
    }

    public Person create(final Person person){
        return personMapper.convert(personRepository.save(personEntityMapper.convert(person)));
    }

    public Optional<Person> update(final Long idPerson, final Person person){
        Optional<cl.parriagada.ms.person.data.entity.Person> optionalPerson = personRepository.findById(idPerson);
        return optionalPerson.map(person1 -> {
            cl.parriagada.ms.person.data.entity.Person person2 = personEntityMapper.convert(person);
            person2.setId(person1.getId());
            return Optional.ofNullable(personMapper.convert(personRepository.save(person2)));
        }).orElseGet(Optional::empty);
    }

    public Optional<Person> delete(final Long idPerson) {
        Optional<cl.parriagada.ms.person.data.entity.Person> optionalPerson = personRepository.findById(idPerson);
        return optionalPerson.map(person -> {
            personRepository.delete(person);
            return Optional.of(Person.builder().build());
        }).orElseGet(Optional::empty);
    }
}
