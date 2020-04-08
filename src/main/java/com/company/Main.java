package com.company;

import com.person.Person;
import com.quiz.FindPersonByUuidAndAskQuestion;
import com.service.CreatePersonService;
import com.Utils.CommonUtils;
import com.service.PersonService;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static final String QUITTING = "Quitting now";
    public static final String CHOOSE_OPTION = "\nEnter option: (Press 5 to show options)";
    public static final String ENTER_EXISTING_DATE_OF_BIRTH_INPUT = "Enter existing date of birth";
    public static final String ENTER_EXISTING_NAME = "Enter existing name";
    public static final String ENTER_EXISTING_UUID = "Enter existing uuid";
    public static final String UUID_FOUND = "Person uuid found ";
    public static final String CANNOT_PERFORM_ACTION = "Error performing action due to your input";
    public static final String CANNOT_FIND_UUID = "Cannot find uuid";
    public static final String SUCCESSFUL_PERFORM_OF_ACTION = "Successful output";
    public static final String CREATE_PROFILE_MAIN_MENU = "\nCreate your profile";
    public static final String PRINT_OPTIONS_MAIN_MENU = "\t\n 0 to quit \t\n 1 to show persons \t\n 2 to add new person \t\n 3 to remove person \t\n 4 to search person \t\n 5 to quiz \t\n 6 to show options \nChoose your option: ";

    private static PersonService personService = new PersonService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean quit = false;
        printOptions();

        while (!quit) {
            System.out.println(CHOOSE_OPTION);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0: default:
                    System.out.println(QUITTING);
                    quit = true;
                    break;

                case 1:
                    personService.showPersonsFromFile();
                    break;

                case 2:
                    createPersonWithAllAttributesToFile();
                    break;

                case 3:
                    removePerson();
                    break;

                case 4:
                    searchContact();
                    break;

                case 5:
                    FindPersonByUuidAndAskQuestion.readFromFile();
                    break;

                case 6:
                    printOptions();
                    break;
            }
        }
    }

    public static void printOptions() {
        System.out.println(CREATE_PROFILE_MAIN_MENU);
        System.out.println(PRINT_OPTIONS_MAIN_MENU);
    }

    public static void createPersonWithAllAttributesToFile() {

        CreatePersonService createPersonService = new CreatePersonService();
        Person newPerson = new Person(createPersonService.createPersonName(), createPersonService.createPersonGender(), createPersonService.createPersonDateOfBirth(), createPersonService.createPersonInterests(), createPersonService.createPersonStatus());


        try (FileWriter fileWriter = new FileWriter("personsList.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){

            if (personService.addNewPerson(newPerson)) {
                bufferedWriter.newLine();
                bufferedWriter.write(newPerson.toString());
                bufferedWriter.append(System.lineSeparator());
                bufferedWriter.flush();
            } else {
                System.out.println(CANNOT_PERFORM_ACTION);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
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
        Date dateOfBirth = CommonUtils.formatDateOfBirth(dateOfBirthInput);
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
        System.out.println(existingPerson.getName() + existingPerson.getDateOfBirth());
    }

    public static void searchContactByUUID() {
        System.out.println(ENTER_EXISTING_UUID);
        String uuidInput = scanner.nextLine();
        UUID uuid = UUID.fromString(uuidInput);
        Person existingPerson = personService.findPersonByUUID(uuid);
        if(existingPerson != null) {
            System.out.println(existingPerson.getName() + ", " + UUID_FOUND);
        }else {
            System.out.println(CANNOT_FIND_UUID);
        }
    }
}

