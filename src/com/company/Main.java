package com.company;

import com.enumex.EGender;
import com.enumex.EStatus;
import com.person.Person;
import com.service.PersonService;
import sun.util.calendar.BaseCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static final String NAME_INPUT = "Enter your name";
    public static final String GENDER_INPUT = "Pick a number.***0 for male <-> 1 for female***";
    public static final String DATE_INPUT = "Enter your date of birth";
    public static final String INTEREST_INPUT = "Enter your interests *** max symbols = 250 ***";
    public static final String STATUS_INPUT = "Enter your status *** 0 for single <-> 1 for in relationship <-> 2 for married";
    public static final String INVALID_INPUT = "Invalid %s input";
    public static final String SUCCESSFUL_INPUT = "%s successfully added";
    public static final String USE_INTEGERS_ONLY = "Use integers as per description";

    private static Scanner scanner = new Scanner(System.in);
    private static PersonService personService = new PersonService();

    public static void main(String[] args) {

        boolean quit = false;
        printOptions();

        while (!quit) {
            System.out.println("\nEnter option: (Press 6 to show options)");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    System.out.println("Quitting now");
                    quit = true;
                    break;

                case 1:
                    personService.showPersons();
                    break;

                case 2:
                    createPerson();
                    break;

//                case 3:
//                    removePerson();

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
        System.out.println("\nCreate your profile");
        System.out.println("\t 0 to quit");
        System.out.println("\t 1 to show persons");
        System.out.println("\t 2 to add new person");
        System.out.println("\t 3 to remove person");
        System.out.println("\t 4 to search person");
        System.out.println("\t 5 answer our matching questions");
        System.out.println("\t 6 to show options");
        System.out.println("Choose your option: ");
    }

    private static void createPerson() {

        System.out.println(NAME_INPUT);
        String name = scanner.nextLine();
        if (name.matches("[a-zA-z]{3,}")) {
            System.out.format(SUCCESSFUL_INPUT, name);
            System.out.println();
        } else {
            System.out.format(INVALID_INPUT, name);
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
                return;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println();
            return;
        }

        System.out.println(DATE_INPUT);
        Date dateOfBirth = null;
        String dateOfBirthInput = scanner.nextLine();
        String dateOfBirthPattern = "MM/dd/yyyy";
        SimpleDateFormat formatDateOfBirth = new SimpleDateFormat(dateOfBirthPattern);
        try {
            dateOfBirth = formatDateOfBirth.parse(dateOfBirthInput);
            System.out.format(SUCCESSFUL_INPUT, dateOfBirth);
            System.out.println();
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println(USE_INTEGERS_ONLY);
        }

        System.out.println(INTEREST_INPUT);
        char limit = 250;
        String interests = scanner.nextLine();
        if (interests.length() > limit) {
            interests = interests.substring(0, limit);
        }

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
                return;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(USE_INTEGERS_ONLY);
            return;
        }

        Person newPerson = new Person(name, gender, dateOfBirth, interests, status);
        if (personService.addNewPerson(newPerson)) {
            System.out.println("New person added");
            System.out.println(newPerson.toString());
        } else {
            System.out.println("Cannot add person");
        }
    }

    // Revision needed
//    private static void removePerson() {
//        System.out.println("Enter existing personal number uuid");
//        String dateOfBirthInput = scanner.next();
//        SimpleDateFormat dateOfBirth = SimpleDateFormat.
//
//        if (personService.removePerson(?????)) {
//            System.out.println("Successfully deleted");
//        } else {
//            System.out.println("Error deleting contact");
//        }
//    }

    private static void searchContact() {
        System.out.println("Enter existing name");
        String name = scanner.nextLine();
        Person existingPerson = personService.findPersonByName(name);
        System.out.println(existingPerson.getName());
    }

    public static void questions() {

        int firstAnswer = 0;
        int secondAnswer;
        int result;

        System.out.println("Select a number from 1 to 10 to assess your fairness when answering ");
        while (true) {
            if (scanner.hasNextInt()) {
                firstAnswer = scanner.nextInt();
                if (firstAnswer >= 1 && firstAnswer <= 10) {
                    System.out.println(firstAnswer + " selected. Next question...");
                } else {
                    System.out.println("You cheeky bastard");
                    return;
                }
                System.out.println("Answer the question: How often do you drink?");
                System.out.println("1 - I don't drink; 2 - Not very often; 3 - Every other day; 4 - Every day");
            } else {
                scanner.nextLine();
                System.out.println("Use digits only!");
            }

            if(scanner.hasNextInt()) {
                secondAnswer = scanner.nextInt();
                if (secondAnswer >= 1 && secondAnswer <= 4) {
                    System.out.println(secondAnswer + " selected. Thank you for your time");
                    result = firstAnswer * secondAnswer;
                    System.out.println("Your result is " + result);
                } else {
                    System.out.println("you lie me again");
                }
                return;
            }else {
                scanner.nextLine();
                System.out.println("Use digits only!");
            }
        }
    }
}
