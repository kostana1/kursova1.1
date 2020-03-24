package com.service;

import com.enumex.EGender;
import com.enumex.EStatus;
import com.person.Person;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    private static Person person;
    private static PersonService personService;
    private static String name;
    private static EGender gender;
    private static Date dateOfBirth;
    private String interest;
    private static EStatus status;

    @org.junit.jupiter.api.BeforeEach
    void setup() {
        person = new Person(name, gender, dateOfBirth, interest, status);
    }

    @org.junit.jupiter.api.Test
    void addNewPerson() {
        fail("Yet to be implemented");
    }

    @org.junit.jupiter.api.Test
    void removePerson() {
        fail("Yet to be implemented");
    }

    @org.junit.jupiter.api.Test
    void findPersonByName() {
//        assertEquals("Petko", personService.findPersonByName(name));
//        fail("Yet to be implemented");
    }

    @org.junit.jupiter.api.Test
    void findPersonByDateOfBirth() {
        fail("Yet to be implemented");
    }

    @org.junit.jupiter.api.Test
    void showPersons() {
        fail("Yet to be implemented");
    }
}