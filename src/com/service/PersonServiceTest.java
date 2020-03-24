package com.service;

import java.util.Date;

import com.enumex.EGender;
import com.enumex.EStatus;
import com.person.Person;

class PersonServiceTest {

    private PersonService classUnderTest;

    @org.junit.jupiter.api.BeforeEach
    void setup() {
        classUnderTest = new PersonService();
    }

    @org.junit.jupiter.api.Test
    public void givenPersonWithRealData_whenCreatingPerson_thenExpectToBeAddedInList() {
        Person person = new Person("", EGender.FEMALE, new Date(), "slqdl", EStatus.IN_RELATIONSHIP);

        classUnderTest.addNewPerson(person);

        assertTrue(classUnderTest.allPersons.contains(person));
    }

    @org.junit.jupiter.api.Test
    public void givenNullablePerson_whenCreatingPerson_thenExpectNotToBeAddedInList() {

        assertFalse(classUnderTest.addNewPerson(null));
    }

    @org.junit.jupiter.api.Test
    public void givenPersonWithRealData_whenDeletingPerson_thenExpectToBeDeletedFromList_andReturnTrue() {
        Person person = new Person("", EGender.FEMALE, new Date(), "slqdl", EStatus.IN_RELATIONSHIP);

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

}