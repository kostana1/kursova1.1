package com.company;

import java.util.UUID;

public class Person {

    private UUID id = UUID.randomUUID();

    private String fullName;
    private int gender;
    private String dateOfBirth;
    private String interests;
    private int status;

    public Person(String fullName, int gender, String dateOfBirth, String interests, int status) {
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.interests = interests;
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public int getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getInterests() {
        return interests;
    }

    public int getStatus() {
        return status;
    }

    public UUID getId() {
        return id;
    }

    public static Person createPerson(String fullName, int gender, String dateOfBirth, String interests, int status) {
        return new Person(fullName, gender, dateOfBirth, interests, status);
    }
}
