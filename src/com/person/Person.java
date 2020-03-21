package com.person;

import com.enumex.EGender;
import com.enumex.EStatus;

import java.util.Date;
import java.util.UUID;

public class Person {

    private UUID uuid;

    private String name;
    private Date dateOfBirth;
    private String interests;
    private EGender gender;
    private EStatus status;

    public Person(String name, EGender gender, Date dateOfBirth, String interests, EStatus status) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.interests = interests;
        this.status = status;
        this.uuid = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getInterests() {
        return interests;
    }

    public EGender getGender() {
        return gender;
    }

    public EStatus getStatus() {
        return status;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return this.uuid + ", " + this.name + ", " + this.gender + ", " + this.dateOfBirth + ", " + this.interests + ", " + this.status;
    }
}
