package com.company;

import com.questions.Questions;
import com.service.PersonService;

import java.util.Scanner;

public class Main {

    public static final String QUITTING = "Quitting now";
    public static final String CHOOSE_OPTION = "\nEnter option: (Press 6 to show options)";

    private static Scanner scanner = new Scanner(System.in);
    private static PersonService personService = new PersonService();
    private static Questions questions = new Questions();

    public static void main(String[] args) {

        boolean quit = false;
        MainUtils.printOptions();

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
                    MainUtils.createPersonWithAllAttributes();
                    break;

                case 3:
                    MainUtils.removePerson();
                    break;

                case 4:
                    MainUtils.searchContact();
                    break;

                case 5:
                    questions.questions();
                    break;

                case 6:
                    MainUtils.printOptions();
                    break;
            }
        }
    }

}

