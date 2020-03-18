package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static PersonInfo personInfo = new PersonInfo();

    public static void main(String[] args) {

        boolean quit = false;
        printActions();
        while (!quit) {
            System.out.println("\nEnter option: (press 5 to show options)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Quitting now");
                    quit = true;
                    break;

                case 1:
                    personInfo.showPersons();
                    break;

                case 2:
                    createPerson();
                    break;

                case 3:
                    removePerson();

                case 4:
                    searchContact();

                case 5:
                    printActions();
                    break;

//                case 6:
//                    questions();
//                    break;
            }
        }

    }

    private static void createPerson() {
        System.out.println("Enter your full name");
        String fullName = scanner.nextLine();
        System.out.println("Enter your gender(0 for male, 1 for female)");
        int gender = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter your date of birth");
        String dob = scanner.nextLine();
        System.out.println("Enter your interest max symbols = 250");
        char limit = 250;
        String interest = scanner.nextLine();

        if(interest.length() > limit) {
            interest = interest.substring(0, limit);
        }
        System.out.println("Enter your status(0 for single; 1 for in relationship; 2 for married)");
        int status = Integer.parseInt(scanner.nextLine());
        Person newPerson = Person.createPerson(fullName, gender, dob, interest, status);
        if(personInfo.addNewPerson(newPerson)) {
            System.out.println("new person added");
        }else {
            System.out.println("cannot add person");
        }
    }

    private static void removePerson() {
        System.out.println("Enter existing full name");
        String fullName = scanner.nextLine();
        Person existingPerson = personInfo.searchPerson(fullName);
        if(existingPerson == null) {
            return;
        }

        if(personInfo.removePerson(existingPerson)) {
            System.out.println("person deleted");
        }else {
            System.out.println("Something wrong happen");
        }
    }

    private static void searchContact() {
        System.out.println("Enter existing full name");
        String fullName = scanner.nextLine();
        Person existingPerson = personInfo.searchPerson(fullName);
        if(existingPerson == null) {
            System.out.println("person not found");
            return;
        }
        System.out.println("Full name = " + existingPerson.getFullName());
    }

    private static void printActions() {
        System.out.println("\nCreate your profile");
        System.out.println("\t 0 to quit");
        System.out.println("\t 1 to show persons");
        System.out.println("\t 2 to add new person");
        System.out.println("\t 3 to remove person");
        System.out.println("\t 4 to search person");
        System.out.println("\t 5 to print actions");
        System.out.println("\t 6 answer our matching questions");
        System.out.println("Choose your option: ");
    }
}
