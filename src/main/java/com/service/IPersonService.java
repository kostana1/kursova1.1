package com.service;

import com.person.Person;

import java.util.Date;

public interface IPersonService {

    Person findPersonByName(String name);
    Person findPersonByDateOfBirth(Date dateOfBirth);
    boolean addNewPerson(Person person);
    boolean removePerson(Person person);
    void showPersons();
}
