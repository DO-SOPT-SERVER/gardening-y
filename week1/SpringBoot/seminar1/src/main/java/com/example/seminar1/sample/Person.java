package com.example.seminar1.sample;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
public class Person {
    private String LastName;
    private String FirstName;

    @Builder
    public Person(String lastName, String firstName) {
        LastName = lastName;
        FirstName = firstName;
    }
}


