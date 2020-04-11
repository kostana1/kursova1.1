package test.java.com.service;

import java.util.ArrayList;

import main.java.com.person.Person;
import main.java.com.service.CreatePersonService;
import main.java.com.service.IPersonService;

@RunWith(MockitoJUnitRunner.class)
public class CreatePersonServiceTest {

    @Mock
    private IPersonService personService;

    private List<Person> persons;
    @InjectMocks // makes the class to use the mock personService
    private CreatePersonService classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new CreatePersonService(personService);
        persons = new ArrayList<>();
        persons.add(new Person()); // person with dummy data
    }

    @Test
    public void whenAskingInternetPersonQuestions_thenExpectToBeAsked() {
        Mockito.when(personService.readFromPersonsFromInternet()).thenReturn(persons); // this way we ensure that this method will always return
                                                                                       // our list and not try to execute the real implementation
                                                                                       // and depend on whether we have internet or not

        // testing logic

        classUnderTest.askPersonQuestiosFromInternet("dummy");
    }

}
