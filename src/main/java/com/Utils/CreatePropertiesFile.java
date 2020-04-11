package com.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CreatePropertiesFile {

    private final String FILENAME = "application.properties";
    private static final CreatePropertiesFile INSTANCE = new CreatePropertiesFile();
    private Properties properties = new Properties();

    private CreatePropertiesFile() {
        fillProperties(properties);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static CreatePropertiesFile getInstance() {
        return INSTANCE;
    }

    protected Properties fillProperties(Properties properties) {
        InputStream inputStream = null;

        try {
            inputStream = this.getClass().getClassLoader().getResourceAsStream(FILENAME);
            properties.load(inputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
