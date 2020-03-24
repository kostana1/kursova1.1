package com.company;

import com.enumex.EGender;
import com.enumex.EStatus;
import com.person.Person;
import com.service.PersonService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static final String NAME_INPUT = "Enter your name";
    public static final String GENDER_INPUT = "Pick a number.***0 for male <-> 1 for female***";
    public static final String DATE_INPUT = "Enter your date of birth";
    public static final String INTEREST_INPUT = "Enter your interests *** max symbols = 250 ***";
    public static final String STATUS_INPUT = "Enter your status *** 0 for single <-> 1 for in relationship <-> 2 for married";
    public static final String INVALID_INPUT = "Invalid %s input";
    public static final String SUCCESSFUL_INPUT = "%s successfully added";
    public static final String USE_INTEGERS_ONLY = "Use integers as per description";
    public static final String INTEREST_CHAR_LIMIT = "Your interests have been reduced to 250 characters";
    public static final String ENTER_EXISTING_DATE_OF_BIRTH_INPUT = "Enter existing date of birth";
    public static final String ENTER_EXISTING_NAME = "Enter existing name";
    public static final String CANNOT_PERFORM_ACTION = "Error performing action due to your input";
    public static final String SUCCESSFUL_PERFORM_OF_ACTION = "Successful output";
    public static final String CHOOSE_OPTION = "\nEnter option: (Press 6 to show options)";
    public static final String RETURN_TO_MAIN_MENU = "Repeat again your input with the correct values this time";
    public static final String CREATE_PROFILE_MAIN_MENU = "\nCreate your profile";
    public static final String PRINT_OPTIONS_MAIN_MENU = "\t\n 0 to quit \t\n 1 to show persons \t\n 2 to add new person \t\n 3 to remove person \t\n 4 to search person \t\n 5 answer our matching questions \t\n 6 to show options \nChoose your option: ";
    public static final String QUITTING = "Quitting now";
    public static final String FIRST_QUESTION = "Select a number from 1 to 10 to assess your fairness when answering ";
    public static final String SECOND_QUESTION = "How often do you drink? " + "\n1 - I don't drink; 2 - Not very often; 3 - Every other day; 4 - Every day";
    public static final String NEXT_ANSWER = "%d selected. Next question ...";
    public static final String LAST_ANSWER = "%d selected. Thank you for your time";
    public static final String RESULT = "Your result is %d";
    public static final String PATTERN_DATE_OF_BIRTH = "dd/MM/yyyy";
    public static final String NAME_VALIDATION_REGEX = "[a-zA-z]{3,}";

    private static Scanner scanner = new Scanner(System.in);
    private static PersonService personService = new PersonService();

    public static void main(String[] args) {

        boolean quit = false;
        printOptions();

        while (!quit) {
            System.out.println(CHOOSE_OPTION);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    System.out.println(QUITTING);
                    quit = true;
                    break;

                case 1:
                    personService.showPersons();
                    break;

                case 2:
                    createPerson();
                    break;

                case 3:
                    removePerson();

                case 4:
                    searchContact();

                case 5:
                    questions();
                    break;

                case 6:
                    printOptions();
                    break;
            }
        }

    }

    private static void printOptions() {
        System.out.println(CREATE_PROFILE_MAIN_MENU);
        System.out.println(PRINT_OPTIONS_MAIN_MENU);
    }

    private static void createPerson() {

        System.out.println(NAME_INPUT);
        String name = scanner.nextLine();
        if (name.matches(NAME_VALIDATION_REGEX)) {
            System.out.format(SUCCESSFUL_INPUT, name);
            System.out.println();
        } else {
            System.out.format(INVALID_INPUT, name);
            System.out.println(RETURN_TO_MAIN_MENU);
            System.out.println();
            return;
        }

        System.out.println(GENDER_INPUT);
        EGender gender;
        try {
            int genderInput = Integer.parseInt(scanner.nextLine());
            if (genderInput >= 0 && genderInput <= 1) {
                gender = EGender.values()[genderInput];
                System.out.format(SUCCESSFUL_INPUT, gender);
                System.out.println();
            } else {
                System.out.println(USE_INTEGERS_ONLY);
                System.out.println(RETURN_TO_MAIN_MENU);
                return;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(RETURN_TO_MAIN_MENU);
            System.out.println();
            return;
        }

        System.out.println(DATE_INPUT);
        String dateOfBirthInput = scanner.nextLine();
        Date dateOfBirth = formatDateOfBirth(dateOfBirthInput);
        System.out.format(SUCCESSFUL_INPUT, dateOfBirth);
        System.out.println();

        System.out.println(INTEREST_INPUT);
        char limit = 250;
        String interests = scanner.nextLine();
        if (interests.length() > limit) {
            interests = interests.substring(0, limit);
            System.out.println(INTEREST_CHAR_LIMIT);
        }
        System.out.format(SUCCESSFUL_INPUT, interests);
        System.out.println();

        System.out.println(STATUS_INPUT);
        EStatus status;
        try {
            int statusInput = Integer.parseInt(scanner.nextLine());
            if (statusInput >= 0 && statusInput <= 2) {
                status = EStatus.values()[statusInput];
                System.out.format(SUCCESSFUL_INPUT, status);
                System.out.println();
            } else {
                System.out.println(USE_INTEGERS_ONLY);
                System.out.println(RETURN_TO_MAIN_MENU);
                return;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(USE_INTEGERS_ONLY);
            System.out.println(RETURN_TO_MAIN_MENU);
            return;
        }

        Person newPerson = new Person(name, gender, dateOfBirth, interests, status);
        if (personService.addNewPerson(newPerson)) {
            System.out.println(newPerson.toString());
        } else {
            System.out.println(CANNOT_PERFORM_ACTION);
        }
    }

    public static Date formatDateOfBirth(String dateOfBirthString) {
        Date dateOfBirth = null;
        try {
            dateOfBirth = new SimpleDateFormat(PATTERN_DATE_OF_BIRTH).parse(dateOfBirthString);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println(USE_INTEGERS_ONLY);
        }
        return dateOfBirth;
    }

    private static void removePerson() {
        System.out.println(ENTER_EXISTING_DATE_OF_BIRTH_INPUT);
        String dateOfBirthInput = scanner.next();
        Date dateOfBirth = formatDateOfBirth(dateOfBirthInput);
        Person existedPerson = personService.findPersonByDateOfBirth(dateOfBirth);

        if (personService.removePerson(existedPerson)) {
            System.out.println(SUCCESSFUL_PERFORM_OF_ACTION);
        } else {
            System.out.println(CANNOT_PERFORM_ACTION);
        }
    }

    private static void searchContact() {
        System.out.println(ENTER_EXISTING_NAME);
        String name = scanner.nextLine();
        Person existingPerson = personService.findPersonByName(name);
        System.out.println(existingPerson.getName());
    }

    public static void questions() {

        int firstAnswer = 0;
        int secondAnswer;
        int result;

        System.out.println(FIRST_QUESTION);
        while (true) {
            if (scanner.hasNextInt()) {
                firstAnswer = scanner.nextInt();
                if (firstAnswer >= 1 && firstAnswer <= 10) {
                    System.out.format(NEXT_ANSWER, firstAnswer);
                    System.out.println();
                } else {
                    System.out.println(CANNOT_PERFORM_ACTION);
                    return;
                }
                System.out.println(SECOND_QUESTION);
            } else {
                scanner.nextLine();
                System.out.println(USE_INTEGERS_ONLY);
            }

            if(scanner.hasNextInt()) {
                secondAnswer = scanner.nextInt();
                int answerValue = 0;
                switch (secondAnswer) {
                    case 1:
                        answerValue = 10;

                    case 2:
                        answerValue = 20;

                    case 3:
                        answerValue = 30;

                    case 4:
                        answerValue = 40;

                }

                if (secondAnswer >= 1 && secondAnswer <= 4) {
                    System.out.format(LAST_ANSWER, secondAnswer);
                    System.out.println();
                    result = firstAnswer * secondAnswer * answerValue;
                    System.out.format(RESULT, result);
                } else {
                    System.out.println(CANNOT_PERFORM_ACTION);
                }
                return;
            }else {
                scanner.nextLine();
                System.out.println(USE_INTEGERS_ONLY);
            }
        }
    }
}
