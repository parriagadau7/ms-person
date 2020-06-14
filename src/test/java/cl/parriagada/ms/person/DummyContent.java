package cl.parriagada.ms.person;

import cl.parriagada.ms.person.domain.model.Person;

import java.util.ArrayList;
import java.util.List;

public class DummyContent {

    public static Person person() {
        Person person = Person.builder().name("Pedro").lastName("Soto").age(32).build();
        return person;
    }

    public static List<Person> personList() {
        List<Person> personList = new ArrayList<>();
        personList.add(person());
        personList.add(person());
        personList.add(person());
        return personList;
    }

    public static cl.parriagada.ms.person.data.entity.Person personEntity() {
        cl.parriagada.ms.person.data.entity.Person person = cl.parriagada.ms.person.data.entity.Person.
                builder().id(1l).name("Pedro").lastName("Soto").age(32).build();
        return person;
    }

    public static List<cl.parriagada.ms.person.data.entity.Person> personEntityList() {
        List<cl.parriagada.ms.person.data.entity.Person> personList = new ArrayList<>();
        personList.add(personEntity());
        personList.add(personEntity());
        personList.add(personEntity());
        return personList;
    }
}
