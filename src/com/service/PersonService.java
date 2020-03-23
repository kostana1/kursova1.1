package com.service;

import com.person.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonService implements IService{

    private List<Person> allPersons;

    public PersonService() {
        this.allPersons = new ArrayList<>();
    }

    private boolean findPersonByDateOfBirth(Date dateOfBirth) {
        for(int i=0; i<this.allPersons.size(); i++) {
            Person existedPerson = this.allPersons.get(i);
            if(existedPerson.getDateOfBirth() == dateOfBirth) {
                return true;
            }
        }
        return false;
    }

    private boolean isPersonCreated(Person person) {
        if(findPersonByDateOfBirth(person.getDateOfBirth())) {
            System.out.println("Person already in the list");
            return true;
        }else {
            System.out.println("Yet to be made");
            return false;
        }
    }

    @Override
    public boolean addNewPerson(Person person) {
        if(isPersonCreated(person)) {
            System.out.println("Person already exist");
            return false;
        }
        allPersons.add(person);
        System.out.println("Person created");
        return true;
    }

    @Override
    public boolean removePerson(Person person) {
        if(isPersonCreated(person)) {
            this.allPersons.remove(person);
            System.out.println(person.getName() + " deleted");
            return true;
        }else {
            System.out.println(person.getName() + " was not found");
            return false;
        }
    }

    @Override
    public Person findPersonByName(String name) {
        for(int i=0; i<this.allPersons.size(); i++) {
            Person existedPerson = this.allPersons.get(i);
            if (existedPerson.getName().equals(name)) {
                return existedPerson;
            }
        }
        return null;
    }

    @Override
    public void showPersons() {
        System.out.println("Person list");
        for(Person person : allPersons) {
            System.out.println(person.toString());
        }
    }
}
