package com.service;

import com.Utils.CreatePropertiesFile;
import com.person.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PersonService implements IPersonService {

    private static final String PERSON_EXIST = "Person existed already";
    private static final String NULL_PERSON = "Cannot add null person";
    private static final String PERSON_DOES_NOT_EXIST = "Person does not exist";
    private static final String PERSON_CREATED = "Person created";
    private static final String PERSON_DELETED = "Person deleted";
    private static final String PERSON_LIST = "Person list";

    protected List<Person> allPersons;

    public PersonService() {
        this.allPersons = new ArrayList<>();
    }

    protected boolean isPersonCreated(Person person) {
        for (int i = 0; i < allPersons.size(); i++) {
            Person existedPerson = allPersons.get(i);
            if (existedPerson.equals(person)) {
                System.out.println(PERSON_EXIST);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addNewPerson(Person person) {
        if (isPersonCreated(person)) {
            System.out.println(PERSON_EXIST);
            return false;
        }else if(person == null) {
            System.out.println(NULL_PERSON);
            return false;
        }
        allPersons.add(person);
        System.out.println(PERSON_CREATED);
        return true;
    }

    @Override
    public boolean removePerson(Person person) {
        if (person != null) {
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
            if (existedPerson != null) {
                if (existedPerson.getDateOfBirth().equals(dateOfBirth)) {
                    return existedPerson;
                }
            }
        }
        return null;
    }

    @Override
    public Person findPersonByUUID(UUID uuid) {
        for(int i=0; i < this.allPersons.size(); i++) {
            Person existedPerson = this.allPersons.get(i);
            if(existedPerson != null) {
                if(existedPerson.getUuid().equals(uuid)) {
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

    @Override
    public void showPersonsFromFile() {
        String personListFilePath = CreatePropertiesFile.getInstance().getProperty("personListFilePath");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(personListFilePath))) {
            String readData;
            while ((readData = bufferedReader.readLine()) != null && !readData.isEmpty()) {
                System.out.println(readData);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}