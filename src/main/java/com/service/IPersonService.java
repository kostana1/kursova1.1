package com.service;

import com.person.Person;

import java.util.Date;
import java.util.UUID;

public interface IPersonService {

    Person findPersonByName(String name);
    Person findPersonByDateOfBirth(Date dateOfBirth);
    Person findPersonByUUID(UUID uuid);
    boolean addNewPerson(Person person);
    boolean removePerson(Person person);
    void showPersons();
    void showPersonsFromFile();
    void findYourPartner();
}
