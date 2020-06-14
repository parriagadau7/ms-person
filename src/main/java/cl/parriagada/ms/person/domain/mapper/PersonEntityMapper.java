package cl.parriagada.ms.person.domain.mapper;

import cl.parriagada.ms.person.domain.model.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonEntityMapper implements Converter<Person, cl.parriagada.ms.person.data.entity.Person> {


    @Override
    public cl.parriagada.ms.person.data.entity.Person convert(Person source) {
        return cl.parriagada.ms.person.data.entity.Person
                .builder()
                .name(source.getName())
                .lastName(source.getLastName())
                .age(source.getAge())
                .build();
    }
}
