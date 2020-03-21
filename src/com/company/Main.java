package com.company;

import com.enumex.EGender;
import com.enumex.EStatus;
import com.person.Person;
import com.service.PersonService;

import java.io.BufferedInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    private static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
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

        EGender gender = null;
        EStatus status = null;
        Date dateOfBirth = null;

        System.out.println("Enter your name");
        String name = scanner.nextLine();
        int genderInput = Integer.parseInt(scanner.nextLine());
        try {
            gender = EGender.values()[genderInput];
        } catch (InputMismatchException e) {
            e.printStackTrace();
            scanner.nextLine();
            System.out.println("Please enter a valid number.***0 for male <-> 1 for female***");
        }
        System.out.println("Enter your date of birth");
        String dateOfBirthInput = scanner.nextLine();
        String dateOfBirthPattern = "dd/MM/yyyy";
        SimpleDateFormat formatDateOfBirth = new SimpleDateFormat(dateOfBirthPattern);
        try {
            dateOfBirth = formatDateOfBirth.parse(dateOfBirthInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Enter your interests *** max symbols = 250 ***");
        char limit = 250;
        String interests = scanner.nextLine();
        if (interests.length() > limit) {
            interests = interests.substring(0, limit);
        }
        System.out.println("Enter your status *** 0 for single <-> 1 for in relationship <-> 2 for married");
        int statusInput = Integer.parseInt(scanner.nextLine());
        try {
            status = EStatus.values()[statusInput];
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Please enter a valid status number *** 0 for single <-> 1 for in relationship <-> 2 for married");
        }
        Person newPerson = new Person(name, gender, dateOfBirth, interests, status);
        if (personService.addNewPerson(newPerson)) {
            System.out.println("New person added");
            System.out.println(newPerson.toString());
        } else {
            System.out.println("Cannot add person");
        }
    }

    private static void removePerson() {
        System.out.println("Enter existing personal number uuid");
        String uuid = scanner.next();
        UUID uuidInput = UUID.fromString(uuid);
        Person existingPerson = personService.findPersonByUuid(uuidInput);

        if (personService.removePerson(existingPerson)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    private static void searchContact() {
        System.out.println("Enter existing name");
        String name = scanner.nextLine();
        Person existingPerson = personService.findPersonByName(name);
        System.out.println(existingPerson.toString());
    }

    public static void questions() {

        int pickNumber = 0;
        int answer = 0;

        System.out.println("Pick a number from 1 to 10 as 1 does mean not interested in this survey and 10 does mean very interested");
        while (true) {

            try {
                pickNumber = scanner.nextInt();
                System.out.println("Answer the question: How often do you drink?");
                try {
                    System.out.println("1 - I don't drink; 2 - Not very often; 3 - Every other day; 4 - Every day");
                    answer = scanner.nextInt();
                } catch (InputMismatchException e) {
//                    e.printStackTrace();
                    scanner.nextLine();
                    System.out.println("Please pick a number from 1 to 4");
                }

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Please pick a number from 1 to 10");
//                e.printStackTrace();
            }
        }
//        int result = pickNumber * answer;
//        System.out.println(result);

    }

}
