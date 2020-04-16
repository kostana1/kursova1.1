package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CreatePropertiesFile {

    private  final String PROPERTY_NAME = "application.properties";
    private static final CreatePropertiesFile INSTANCE = new CreatePropertiesFile();
    private Properties properties = new Properties();


    public CreatePropertiesFile() {
        loadPropertiesFromFile(PROPERTY_NAME);
    }

    protected Properties loadPropertiesFromFile(String fileName) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = loader.getResourceAsStream(fileName)){
            if(inputStream != null) {
                properties.load(inputStream);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String getPropertyName() {
        return PROPERTY_NAME;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static CreatePropertiesFile getInstance() {
        return INSTANCE;
    }
}
