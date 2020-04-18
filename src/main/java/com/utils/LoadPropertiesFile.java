package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadPropertiesFile {

    private  final String FILENAME = "application.properties";
    private static final LoadPropertiesFile INSTANCE = new LoadPropertiesFile();
    private Properties properties = new Properties();


    public LoadPropertiesFile() {
        fillPropertiesFromFile(FILENAME);
    }

    protected Properties fillPropertiesFromFile(String fileName) {

        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName)){
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

    public static LoadPropertiesFile getInstance() {
        return INSTANCE;
    }
}
