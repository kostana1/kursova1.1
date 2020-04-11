package com.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import main.java.com.person.Person;

public interface IPersonService {

    Person findPersonByName(String name);

    Person findPersonByDateOfBirth(Date dateOfBirth);

    Person findPersonByUUID(UUID uuid);

    List<Person> getAllPersons();

    boolean addNewPerson(Person person);

    boolean removePerson(Person person);

    void showPersons();

    void showPersonsFromFile();

    List<Person> readFromPersonsFile();

    List<Person> readFromPersonsFromInternet();

    void showPersonsFromInternet();
}
