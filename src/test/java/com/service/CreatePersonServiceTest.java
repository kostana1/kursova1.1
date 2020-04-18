package com.service;

import com.enumex.EStatus;
import com.person.Person;
import com.quiz.Answer;
import com.quiz.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.enumex.EGender.FEMALE;
import static org.mockito.Mockito.*;

class CreatePersonServiceTest {

    private List<Person> persons;
    private List<Answer> questions;

    private static String QUESTION = "What's my name ?";

    private CreatePersonService classUnderTest;
    private Question question;

    @BeforeEach
    public void setUp() {
        classUnderTest = new CreatePersonService();
        question = new Question(QUESTION);
        questions = new ArrayList<>();
        questions.add(new Answer("Johny", 10));
        questions.add(new Answer("Peter", 20));
        questions.add(new Answer("Kondio", 30));
        persons = new ArrayList<>();
        persons.add(new Person(UUID.randomUUID(), "Kondio", FEMALE, new Date(), "bla blah blah", EStatus.IN_RELATIONSHIP, question));

    }

    @Test
    public void readFileLines() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn(persons.toString());
        classUnderTest.readFileLines(bufferedReader);
        verify(bufferedReader, times(1)).readLine();
    }
}