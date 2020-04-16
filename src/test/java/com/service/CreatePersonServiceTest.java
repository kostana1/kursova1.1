package com.service;

import com.enumex.EStatus;
import com.person.Person;
import com.quiz.Answer;
import com.quiz.AnswerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.enumex.EGender.FEMALE;

class CreatePersonServiceTest {

    private List<Person> persons;
    private static String QUESTION = "What's my name ?"

    private CreatePersonService classUnderTest;
    private AnswerService answerService;

    @BeforeEach
    void setUp() {
        classUnderTest = new CreatePersonService();
        answerService = new AnswerService(QUESTION);
        answerService.questionAnswers.add(new Answer("Johny", 10));
        answerService.questionAnswers.add(new Answer("Peter", 20));
        answerService.questionAnswers.add(new Answer("Kondio", 30));
        persons = new ArrayList<>();
        persons.add(new Person(UUID.randomUUID(), "Kondio", FEMALE, new Date(), "bla blah blah", EStatus.IN_RELATIONSHIP, answerService));

    }

    @Test
    void readFileLines() throws IOException {
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.when(bufferedReader.readLine()).thenReturn(persons.toString());
        classUnderTest.readFileLines(bufferedReader);
    }
}