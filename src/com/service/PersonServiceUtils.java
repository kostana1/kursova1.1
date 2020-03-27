package com.service;

import com.person.Person;

public class PersonServiceUtils {

    private static final String PERSON_EXIST = "Person existed already";

    private static final PersonService personService = new PersonService();

    protected static boolean isPersonCreated(Person person) {
        for (int i = 0; i < personService.allPersons.size(); i++) {
            Person existedPerson = personService.allPersons.get(i);
            if (existedPerson.equals(person)) {
                System.out.println(PERSON_EXIST);
                return true;
            }
        }
        return false;
    }
}
