package com.service;

import com.enumex.EGender;
import com.enumex.EStatus;
import com.person.Person;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    private Person person;
    private PersonService classUnderTest;

    @org.junit.jupiter.api.BeforeEach
    void setup() {
        person = new Person("name", EGender.MALE, new Date(), "sdfdsfdsfds", EStatus.IN_RELATIONSHIP);
        classUnderTest = new PersonService();
    }

    @org.junit.jupiter.api.Test
    void givenPersonWithRealData_whenCreatingPerson_thenAddedInList() {
        assertTrue(classUnderTest.addNewPerson(person));
    }

    @org.junit.jupiter.api.Test
    public void givenPersonWithRealData_whenCreatingPerson_thenExpectToBeAddedInList() {
        Person person = new Person("", EGender.MALE, new Date(), "dsfsd", EStatus.IN_RELATIONSHIP);
    }

    @org.junit.jupiter.api.Test
    public void givenNullablePerson_whenCreatingPerson_thenExpectNotToBeAddedInList() {
        assertFalse(classUnderTest.addNewPerson(null));
    }

    @org.junit.jupiter.api.Test
    void givenPersonWithRealData_whenRemovingPerson_thenExpectToBeRemovedFromList() {
        classUnderTest.addNewPerson(person);
        assertTrue(classUnderTest.removePerson(person));
        assertFalse(classUnderTest.allPersons.contains(person));
    }

    @org.junit.jupiter.api.Test
    public void givenPersonWithRealData_whenCreatingPerson_thenExpectToBeDeletedFromList_andThenReturnTrue(){
        Person person = new Person("",EGender.MALE, new Date(), "dsfsd", EStatus.IN_RELATIONSHIP);
        classUnderTest.allPersons.add(person);
        assertTrue(classUnderTest.removePerson(person));
        assertFalse(classUnderTest.allPersons.contains(person));
    }

    @org.junit.jupiter.api.Test
    public void givenNullablePerson_whenDeletingPerson_thenExpectNothingToBeDeletedFromList_andReturnFalse() {
        int sizeBeforeRemoveMethod = classUnderTest.allPersons.size();
        assertFalse(classUnderTest.removePerson(null));
        int sizeAfterRemoveMethod = classUnderTest.allPersons.size();
        assertEquals(sizeBeforeRemoveMethod, sizeAfterRemoveMethod);
    }

    @org.junit.jupiter.api.Test
    public void givenNullableName_whenFindingByName_thenExpectToReturnNull() {
        Person person = new Person(null, EGender.MALE, new Date(), "dsfsd", EStatus.IN_RELATIONSHIP);
        assertNull(classUnderTest.findPersonByName(person.getName()), "null was not found");
    }

    @org.junit.jupiter.api.Test
    void givenPersonWithRealName_whenFindingByName_thenExpectToBeFound() {
        classUnderTest.addNewPerson(person);
        assertEquals(person, classUnderTest.findPersonByName(person.getName()));
    }

    @org.junit.jupiter.api.Test
    public void givenNullableDateOfBirth_whenFindingByDateOfBirth_thenExpectToReturnNull() {
        Person person = new Person("",EGender.MALE, null, "dsfsd", EStatus.IN_RELATIONSHIP);
        assertNull(classUnderTest.findPersonByDateOfBirth(person.getDateOfBirth()));
    }

    @org.junit.jupiter.api.Test
    void givenPersonWithRealDateOfBirth_whenFindingByDateOfBirth_thenExpectToBeFound() {
        classUnderTest.addNewPerson(person);
        assertNotNull(classUnderTest.findPersonByDateOfBirth(person.getDateOfBirth()));
        assertSame(person, classUnderTest.findPersonByDateOfBirth(person.getDateOfBirth()));
    }

    @org.junit.jupiter.api.Test
    void showPersons() {
    }
}