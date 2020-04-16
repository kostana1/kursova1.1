package com.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class CreatePropertiesFileTest {

    private final String FILENAME = "application.properties";
    private String propertySource;

    private CreatePropertiesFile classUnderTest;
    private Properties properties;

    @BeforeEach
    void setUp() {
        this.classUnderTest = new CreatePropertiesFile();
        properties = new Properties();
        propertySource = "C:/Петко/udemy/java master class/Martin_Project/testResource/test.txt";
    }

    @Test
    void whenLoadingProperties_thenExpectAllPropertiesToBeFilled() {
        classUnderTest.loadPropertiesFromFile(FILENAME);
    }

    @Test
    void givenRealProperties_whenLoading_thenNotNullExpectToBeReturned() {
        assertNotNull(properties);
    }

    @Test
    void givenRealName_whenGettingProperty_thenRightPropertyFileToBeExecuted() {
        assertEquals(classUnderTest.getPropertyName(), FILENAME);
    }

    @Test
    void givenPropertyKey_whenGettingProperty_thenRightPropertySourceToBeExecuted() {
        assertEquals(classUnderTest.getProperty("testFilePath"), propertySource);
    }

    @Test
    void whenReadingNull_thenExpectToThrowNullPointerException(){

        properties.setProperty(null, null);
        assertThrows(NullPointerException.class, () -> classUnderTest.loadPropertiesFromFile(FILENAME));
    }
}