package com.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationPropertyFileExtractorTest {

    private Properties properties;
    private ApplicationPropertyFileExtractor classUnderTest;

    @BeforeEach
    public void setUp() {
        properties = new Properties();
        classUnderTest = ApplicationPropertyFileExtractor.getInstance();
    }

    @Test
    public void whenFillingProperties_thenExpectAllPropertiesToBeFilled() {
        classUnderTest.fillPropertiesFromFile(properties);
        properties.setProperty("some key", "some value");
        classUnderTest.getProperty("some key");
        assertEquals("some value", properties.getProperty("some key"));
    }

    @Test
    public void testPrivateConstructor() throws Exception{
        Constructor constructor = ApplicationPropertyFileExtractor.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()), "Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }
}