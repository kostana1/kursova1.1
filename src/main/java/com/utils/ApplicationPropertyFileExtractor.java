package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertyFileExtractor {

    private  final String FILENAME = "application.properties";
    private static final ApplicationPropertyFileExtractor INSTANCE = new ApplicationPropertyFileExtractor();
    private Properties properties = new Properties();


    private ApplicationPropertyFileExtractor() {
        fillPropertiesFromFile(properties);
    }

    protected Properties fillPropertiesFromFile(Properties properties) {

        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(FILENAME)){
            if(inputStream != null) {
                properties.load(inputStream);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static ApplicationPropertyFileExtractor getInstance() {
        return INSTANCE;
    }
}