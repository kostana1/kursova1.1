package com.service;

import com.person.Person;

import java.util.UUID;

public interface IService {

    Person findPerson(UUID uuid);
    boolean addNewPerson(Person person);
    boolean removeNewPerson(Person person);
}
