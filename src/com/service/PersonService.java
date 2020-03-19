package com.service;

import com.person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonService implements IService{

//    public static final String SHOW_PERSONS =

    private List<Person> allPersons;

    public PersonService() {
        this.allPersons = new ArrayList<>();
    }

    @Override
    public Person findPerson(UUID uuid) {
        for(int i=0; i<this.allPersons.size(); i++) {
            Person existedPerson = this.allPersons.get(i);
            if(existedPerson.getUuid() == uuid) {
                return existedPerson;
            }
        }
        return null;
    }

    @Override
    public boolean addNewPerson(Person person) {
        if(findPerson(person.getUuid()) != null) {
            System.out.println("Person already exist");
            return false;
        }
        allPersons.add(person);
        System.out.println("Person created");
        return true;
    }

    @Override
    public boolean removeNewPerson(Person person) {
        if(findPerson(person.getUuid()) != null) {
            System.out.println(person.getName() + " was not found");
            return false;
        }
        this.allPersons.remove(person);
        System.out.println(person.getName() + " deleted");
        return true;
    }


}
