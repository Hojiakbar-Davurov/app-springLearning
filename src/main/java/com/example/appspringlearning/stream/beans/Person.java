package com.example.appspringlearning.stream.beans;

import lombok.Data;

@Data
public class Person {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String gender;
    private final Integer age;

    public static PersonDTO toDTO(Person person) {
        return new PersonDTO(
                person.getId(),
                person.getFirstName(),
                person.getAge());
    }
}
