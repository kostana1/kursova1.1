package com.company;

import com.person.Person;
import com.service.CreatePersonService;
import com.service.CreatePersonServiceUtils;
import com.service.PersonService;

import java.util.Date;
import java.util.Scanner;

public class MainUtils {

    public static final String ENTER_EXISTING_DATE_OF_BIRTH_INPUT = "Enter existing date of birth";
    public static final String ENTER_EXISTING_NAME = "Enter existing name";
    public static final String CANNOT_PERFORM_ACTION = "Error performing action due to your input";
    public static final String SUCCESSFUL_PERFORM_OF_ACTION = "Successful output";
    public static final String CREATE_PROFILE_MAIN_MENU = "\nCreate your profile";
    public static final String PRINT_OPTIONS_MAIN_MENU = "\t\n 0 to quit \t\n 1 to show persons \t\n 2 to add new person \t\n 3 to remove person \t\n 4 to search person \t\n 5 answer our matching questions \t\n 6 to show options \nChoose your option: ";

    private static PersonService personService = new PersonService();
    private static Scanner scanner = new Scanner(System.in);

    public static void printOptions() {
        System.out.println(CREATE_PROFILE_MAIN_MENU);
        System.out.println(PRINT_OPTIONS_MAIN_MENU);
    }

    public static void createPersonWithAllAttributes() {

        CreatePersonService createPersonService = new CreatePersonService();

        Person newPerson = new Person(createPersonService.createPersonName(), createPersonService.createPersonGender(), createPersonService.createPersonDateOfBirth(), createPersonService.createPersonInterests(), createPersonService.createPersonStatus());
        if (personService.addNewPerson(newPerson)) {
            System.out.println(newPerson.toString());
        } else {
            System.out.println(CANNOT_PERFORM_ACTION);
        }
    }

    public static void removePerson() {
        System.out.println(ENTER_EXISTING_DATE_OF_BIRTH_INPUT);
        String dateOfBirthInput = scanner.nextLine();
        Date dateOfBirth = CreatePersonServiceUtils.formatDateOfBirth(dateOfBirthInput);
        Person existedPerson = personService.findPersonByDateOfBirth(dateOfBirth);

        if (personService.removePerson(existedPerson)) {
            System.out.println(SUCCESSFUL_PERFORM_OF_ACTION);
        } else {
            System.out.println(CANNOT_PERFORM_ACTION);
        }
    }

    public static void searchContact() {
        System.out.println(ENTER_EXISTING_NAME);
        String name = scanner.nextLine();
        Person existingPerson = personService.findPersonByName(name);
        System.out.println(existingPerson.getName());
    }
}
