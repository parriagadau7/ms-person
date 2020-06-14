package cl.parriagada.ms.person.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private String name;
    private String lastName;
    private int age;
}
