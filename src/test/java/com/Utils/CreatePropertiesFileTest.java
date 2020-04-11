package test.java.com.Utils;

import java.util.Properties;

import main.java.com.Utils.CreatePropertiesFile;

public class CreatePropertiesFileTest {

    private CreatePropertiesFile classUnderTest;

    private Properties properties;

    @Before
    public void setUp() {
        this.classUnderTest = new CreatePropertiesFile();
        properties = new Properties();
    }

    @Test
    public void whenFillingProperties_thenExpectAllPropertiesToBeFilled() {
        classUnderTest.fillProperties(properties);
        
        assertTrue(properties.contains(value))
    }
}
