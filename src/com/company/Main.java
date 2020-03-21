package com.company;

import com.enumex.EGender;
import com.enumex.EStatus;
import com.person.Person;
import com.service.PersonService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Main {

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

        System.out.println("Enter your name");
        String name = scanner.nextLine();
        if (name.matches("[a-zA-z]{3,}")) {
            System.out.println("Name added successfully");
        } else {
            System.out.println("Invalid name input");
            return;
        }

        System.out.println("Pick a number.***0 for male <-> 1 for female***");
        EGender gender;
        try {
            int genderInput = Integer.parseInt(scanner.nextLine());
            if (genderInput >= 0 && genderInput <= 1) {
                gender = EGender.values()[genderInput];
                System.out.println("Gender added successfully");
            } else {
                System.out.println("Enter from 0 to 1");
                return;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Invalid gender input use digits only next time");
            return;
        }

        System.out.println("Enter your date of birth");
        Date dateOfBirth = null;
        String dateOfBirthInput = scanner.nextLine();
        String dateOfBirthPattern = "dd/MM/yyyy";
        SimpleDateFormat formatDateOfBirth = new SimpleDateFormat(dateOfBirthPattern);
        try {
            dateOfBirth = formatDateOfBirth.parse(dateOfBirthInput);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Enter integers only");
        }

        System.out.println("Enter your interests *** max symbols = 250 ***");
        char limit = 250;
        String interests = scanner.nextLine();
        if (interests.length() > limit) {
            interests = interests.substring(0, limit);
        }

        System.out.println("Enter your status *** 0 for single <-> 1 for in relationship <-> 2 for married");
        EStatus status;
        try {
            int statusInput = Integer.parseInt(scanner.nextLine());
            if (statusInput >= 0 && statusInput <= 2) {
                status = EStatus.values()[statusInput];
            } else {
                System.out.println("Enter from 0 to 2");
                return;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Enter digits only");
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

    private static void removePerson() {
        System.out.println("Enter existing personal number uuid");
        String uuid = scanner.next();
        UUID uuidInput = UUID.fromString(uuid);
        Person existingPerson = personService.isPersonCreated(uuidInput);

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

        int firstAnswer = 0;
        int secondAnswer = 0;
        int result = 0;

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
