package com.person;

import com.enumex.EGender;
import com.enumex.EStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.quiz.Question;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@JsonIgnoreProperties()
public class Person {

    public static final String TO_STRING = "%s,%s,%s,%s,%s,%s,%s";

    private UUID uuid;
    private String name;
    private Date dateOfBirth;
    private String interests;
    private EGender gender;
    private EStatus status;
    private Question question;

    public Person(String name, EGender gender, Date dateOfBirth, String interests, EStatus status) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.interests = interests;
        this.status = status;
    }

    public Person(UUID uuid, String name, EGender gender, Date dateOfBirth, String interests, EStatus status, Question question) {
        this.uuid = uuid;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.interests = interests;
        this.gender = gender;
        this.status = status;
        this.question = question;
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

    public Question getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING, uuid, name, gender, dateOfBirth, interests, status, question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.dateOfBirth, this.gender, this.interests, this.status, this.question);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Person) {
            Person objectPerson = (Person) obj;
            return this.name.equals(objectPerson.getName()) && this.gender == objectPerson.getGender() && this.dateOfBirth == objectPerson.getDateOfBirth() && this.status == objectPerson.getStatus() && this.interests.equals(objectPerson.getInterests()) && this.question.equals(objectPerson.getQuestion());
        }
        return false;
    }
}
