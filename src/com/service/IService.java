package com.service;

import com.person.Person;

import java.util.UUID;

public interface IService {

    Person findPersonByName(String name);
    boolean addNewPerson(Person person);
    boolean removePerson(Person person);
    void showPersons();
}