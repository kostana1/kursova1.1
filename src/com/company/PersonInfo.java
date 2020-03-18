package com.company;

import java.util.ArrayList;

public class PersonInfo {

    private ArrayList<Person> allPersons;


    public PersonInfo() {
        this.allPersons = new ArrayList<>();
    }

    private int findPerson(String fullName) {
        for(int i=0; i < this.allPersons.size(); i++) {
            Person checkedPerson = this.allPersons.get(i);
            if(checkedPerson.getFullName().equals(fullName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addNewPerson(Person person) {
        if(findPerson(person.getFullName()) >= 0) {
            System.out.println("Person already exist");
            return false;
        }
        allPersons.add(person);
        return true;
    }

    public Person searchPerson(String fullName) {
        int position = findPerson(fullName);
        if(position > 0) {
            return this.allPersons.get(position);
        }
        return null;
    }

    public boolean removePerson(Person person) {
        if(findPerson(person.getFullName()) < 0) {
            System.out.println(person.getFullName() + " was not found");
            return false;
        }
        this.allPersons.remove(person);
        System.out.println(person.getFullName() + " was deleted");
        return true;
    }

    public void showPersons() {
        System.out.println("Persons' list");
        for(int i=0; i < this.allPersons.size(); i++) {
            System.out.println((i+1) + ". Personal Number = " + this.allPersons.get(i).getId() + " *** full name = " + this.allPersons.get(i).getFullName() +
                    " *** gender = " + this.allPersons.get(i).getGender() + " *** dateOfBirth = " + this.allPersons.get(i).getDateOfBirth() + " *** interests = " +
                    this.allPersons.get(i).getInterests() + " *** status = " + this.allPersons.get(i).getStatus());
        }
    }

}
