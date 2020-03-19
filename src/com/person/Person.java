package com.person;

import com.enumex.Egender;
import com.enumex.Estatus;

import java.util.Date;
import java.util.UUID;

public class Person {

    private UUID uuid;

    private String name;
    private Date dateOfBirth;
    private String interests;

    public Person(String name, Egender egender, Date dateOfBirth, String interests, Estatus estatus) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.interests = interests;
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

    public UUID getUuid() {
        return uuid;
    }

}
