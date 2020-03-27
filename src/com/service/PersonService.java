package com.service;

import com.person.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonService implements IPersonService {

    public static final String PERSON_EXIST = "Person existed already";
    public static final String PERSON_DOES_NOT_EXIST = "Person does not exist";
    public static final String PERSON_CREATED = "Person created";
    public static final String PERSON_DELETED = "Person deleted";
    public static final String PERSON_LIST = "Person list";

    protected List<Person> allPersons;

    public PersonService() {
        this.allPersons = new ArrayList<>();
    }

    protected boolean isPersonCreated(Person person) {
        for (int i = 0; i < this.allPersons.size(); i++) {
            Person existedPerson = this.allPersons.get(i);
            if (existedPerson.equals(person)) {
                System.out.println(PERSON_EXIST);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addNewPerson(Person person) {
        if (isPersonCreated(person) || person == null) {
            System.out.println(PERSON_EXIST);
            return false;
        }
        allPersons.add(person);
        System.out.println(PERSON_CREATED);
        return true;
    }

    @Override
    public boolean removePerson(Person person) {
        if (isPersonCreated(person)) {
            this.allPersons.remove(person);
            System.out.println(PERSON_DELETED);
            return true;
        } else {
            System.out.println(PERSON_DOES_NOT_EXIST);
            return false;
        }
    }

    @Override
    public Person findPersonByName(String name) {
        for (int i = 0; i < this.allPersons.size(); i++) {
            Person existedPerson = this.allPersons.get(i);
            if (!name.isEmpty()) {
                if (existedPerson.getName().equals(name)) {
                    return existedPerson;
                }
            }
        }
        return null;
    }

    @Override
    public Person findPersonByDateOfBirth(Date dateOfBirth) {
        for (int i = 0; i < this.allPersons.size(); i++) {
            Person existedPerson = this.allPersons.get(i);
            if (dateOfBirth != null) {
                if (existedPerson.getDateOfBirth() == dateOfBirth) {
                    return existedPerson;
                }
            }
        }
        return null;
    }

    @Override
    public void showPersons() {
        System.out.println(PERSON_LIST);
        for (Person person : allPersons) {
            System.out.println(person.toString());
        }
    }
}
