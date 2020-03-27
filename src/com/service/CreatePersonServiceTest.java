package com.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CreatePersonServiceTest {

    private CreatePersonService classUnderTest;

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @org.junit.jupiter.api.BeforeEach
    void setup() {
//        classUnderTest = new CreatePersonService();
//        testOut = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(testOut));
    }

    @org.junit.jupiter.api.AfterEach
    void restoreSystemInputOutput() {
//        System.setIn(systemIn);
//        System.setOut(systemOut);
    }

//    private String getOutput() {
//        return testOut.toString();
//    }

//    private void provideInput(String data) {
//        testIn = new ByteArrayInputStream(data.getBytes());
//        System.setIn(testIn);
//    }

    @org.junit.jupiter.api.Test
    void createPersonName() {
//        final String testInput = "name";
//        provideInput(testInput);
//        classUnderTest.createPersonName();
//        assertEquals(testInput, testOut.toString());
    }

    @org.junit.jupiter.api.Test
    void createPersonGender() {
    }

    @org.junit.jupiter.api.Test
    void createPersonDateOfBirth() {
    }

    @org.junit.jupiter.api.Test
    void createPersonInterests() {
    }

    @org.junit.jupiter.api.Test
    void createPersonStatus() {
    }
}