package test.java.com.service;

import com.person.Person;

import main.java.com.service.CreatePersonService;
import main.java.com.service.IPersonService;
import main.java.com.service.PersonService;

public class CreatePersonServiceTest {

    private CreatePersonService classUnderTest;

    private IPersonService personService;

    private Person person;

    @Before
    public void setUp() {
        personService = new PersonService();
        classUnderTest = new CreatePersonService(personService);
    }

    @Test
    public void whenLoadingPersonsFromFile_thenExpectRightPersonsToBeLoaded() {
        
        classUnderTest.readDataFromFileAndCreatePerson();
        
        assertTrue(personService.getAllPersons().contains(new Persons))
    }
}
