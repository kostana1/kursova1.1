package com.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class LoadPropertiesFileTest {

    private final String FILENAME = "application.properties";
    private String propertySource;

    private LoadPropertiesFile classUnderTest;
    private Properties properties;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new LoadPropertiesFile();
        properties = new Properties();
        propertySource = "C:/Петко/udemy/java master class/Martin_Project/testResource/test.txt";
    }

    @Test
    public void whenLoadingProperties_thenExpectAllPropertiesToBeFilled() {
        classUnderTest.fillPropertiesFromFile(FILENAME);
    }

    @Test
    public void givenRealProperties_whenLoading_thenNotNullExpectToBeReturned() {

        assertNotNull(properties);
    }

    @Test
    public void givenPropertyKey_whenGettingProperty_thenRightPropertySourceToBeExecuted() {
        assertEquals(classUnderTest.getProperty("testFilePath"), propertySource);
    }

    @Test
    public void whenReadingNull_thenExpectToThrowNullPointerException(){

        properties.setProperty(null, null);
        assertThrows(NullPointerException.class, () -> classUnderTest.fillPropertiesFromFile(FILENAME));
    }
}