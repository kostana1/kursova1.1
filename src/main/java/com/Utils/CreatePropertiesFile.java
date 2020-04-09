package com.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CreatePropertiesFile {

    private  final String FILENAME = "application.properties";
    private static final CreatePropertiesFile PROPERTY_FILE = new CreatePropertiesFile();
    private Properties properties = new Properties();

    private CreatePropertiesFile() {
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(FILENAME);
            properties.load(inputStream);
        }catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static CreatePropertiesFile getInstance() {
        return PROPERTY_FILE;
    }
}
