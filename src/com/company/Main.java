package com.company;

import com.enumex.Egender;
import com.enumex.Estatus;
import com.person.Person;
import com.service.PersonService;

import java.util.InputMismatchException;
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
                    showPersons();
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
        System.out.println("Enter your gender. ***0 for male <-> 1 for female***");
        int gender = Integer.parseInt(scanner.nextLine());
        try {
            if(gender == 0) {
                Egender male = Egender.MALE;
                System.out.println(male);
            }else if(gender == 1) {
                Egender female = Egender.FEMALE;
                System.out.println(female);
            }
        }catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Please enter a valid number.***0 for male <-> 1 for female***");
        }
        System.out.println("Enter your date of birth");
        //to do later
        System.out.println("Enter your interests *** max symbols = 250 ***");
        char limit = 250;
        String interests = scanner.nextLine();
        if(interests.length() > limit) {
            interests = interests.substring(0, limit);
        }
        System.out.println("Enter your status *** 0 for single <-> 1 for in relationship <-> 2 for married");
        int status = Integer.parseInt(scanner.nextLine());
        try {
            if(status == 0) {
                Estatus single = Estatus.SINGLE;
                System.out.println(single);
            }else if(status == 1) {
                Estatus inRelationship = Estatus.IN_RELATIONSHIP;
                System.out.println(inRelationship);
            }else if(status == 2) {
                Estatus married = Estatus.MARRIED;
                System.out.println(married);
            }
        }catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Please enter a valid status number *** 0 for single <-> 1 for in relationship <-> 2 for married");
            Person newPerson = new Person(name,gender,dateOfBirth,interests,status);
            if(personService.addNewPerson(newPerson)) {
                System.out.println("New person added");
            }else {
                System.out.println("Cannot add person");
            }
        }
    }

    private static void removePerson() {
        System.out.println("Enter existing personal number uuid");
        String uuid = scanner.next();
        UUID uuidInput =
        Person existingPerson = personService.findPerson(uuid);
    }
}
