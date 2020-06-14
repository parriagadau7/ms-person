package cl.parriagada.ms.person.domain.mapper;

import cl.parriagada.ms.person.data.entity.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements Converter<Person, cl.parriagada.ms.person.domain.model.Person> {

    @Override
    public cl.parriagada.ms.person.domain.model.Person convert(Person source) {
        if(source !=null) {
            return cl.parriagada.ms.person.domain.model.Person
                    .builder()
                    .name(source.getName())
                    .lastName(source.getLastName())
                    .age(source.getAge())
                    .build();
        }
        return null;
    }
}
