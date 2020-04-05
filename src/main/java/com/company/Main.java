package com.company;

<<<<<<< HEAD
import com.person.Person;
import com.service.CreatePersonService;
import com.service.CommonUtils;
import com.service.PersonService;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;
=======
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import main.java.com.person.Person;
import main.java.com.service.CommonUtils;
import main.java.com.service.CreatePersonService;
import main.java.com.service.PersonService;
>>>>>>> e5f5ea862462fd2b712f9f32b2da26da78942281

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
<<<<<<< HEAD
    public static final String PRINT_OPTIONS_MAIN_MENU = "\t\n 0 to quit \t\n 1 to show persons \t\n 2 to add new person \t\n 3 to remove person \t\n 4 to search person \t\n 5 to show options \nChoose your option: ";
=======
    public static final String PRINT_OPTIONS_MAIN_MENU = "\t\n 0 to quit \t\n 1 to show persons \t\n 2 to add new person \t\n 3 to remove person \t\n 4 to search person \t\n 5 to show options \t\n 6 to find your partner \nChoose your option: ";
>>>>>>> e5f5ea862462fd2b712f9f32b2da26da78942281

    private static PersonService personService = new PersonService();
    private static Scanner scanner = new Scanner(System.in);

    private static List<Person> persons;

    public static void main(String[] args) {
        persons = readPersons();

        boolean quit = false;
        printOptions();

        while (!quit) {
            System.out.println(CHOOSE_OPTION);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
<<<<<<< HEAD
                case 0: default:
                    System.out.println(QUITTING);
                    quit = true;
                    break;

//                case 1:
//                    personService.showPersons();
//                    break;

                case 1:
                    personService.showPersonsFromFile();
                    break;

                case 2:
                    createPersonWithAllAttributes();
                    break;

                case 3:
                    removePerson();
                    break;

                case 4:
                    searchContact();
                    break;

                case 5:
                    printOptions();
                    break;
=======
            case 0:
            default:
                System.out.println(QUITTING);
                quit = true;
                break;

            // case 1:
            // personService.showPersons();
            // break;

            case 1:
                personService.showPersonsFromFile();
                break;

            case 2:
                createPersonWithAllAttributes();
                break;

            case 3:
                removePerson();
                break;

            case 4:
                searchContact();
                break;

            case 5:
                printOptions();
                break;

            case 6:
                personService.findYourPartner();
                break;

            case 7:
                askQuestion();
                break;
>>>>>>> e5f5ea862462fd2b712f9f32b2da26da78942281
            }
        }
    }

    public static void printOptions() {
        System.out.println(CREATE_PROFILE_MAIN_MENU);
        System.out.println(PRINT_OPTIONS_MAIN_MENU);
    }

    public static void createPersonWithAllAttributes() {

        CreatePersonService createPersonService = new CreatePersonService();
<<<<<<< HEAD
        Person newPerson = new Person(createPersonService.createPersonName(), createPersonService.createPersonGender(), createPersonService.createPersonDateOfBirth(), createPersonService.createPersonInterests(), createPersonService.createPersonStatus(), createPersonService.questions());

=======
        Person newPerson = new Person(createPersonService.createPersonName(), createPersonService.createPersonGender(),
                createPersonService.createPersonDateOfBirth(), createPersonService.createPersonInterests(),
                createPersonService.createPersonStatus(), createPersonService.questions());
>>>>>>> e5f5ea862462fd2b712f9f32b2da26da78942281

        try (FileWriter fileWriter = new FileWriter("personsList.txt", true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            if (personService.addNewPerson(newPerson)) {
                bufferedWriter.newLine();
                bufferedWriter.write(newPerson.toString());
                bufferedWriter.append(System.lineSeparator());
                bufferedWriter.flush();
            } else {
                System.out.println(CANNOT_PERFORM_ACTION);
            }
<<<<<<< HEAD
        }catch (IOException e) {
=======
        } catch (IOException e) {
>>>>>>> e5f5ea862462fd2b712f9f32b2da26da78942281
            e.printStackTrace();
        }
    }

    // public static void createPersonWithAllAttributes() {
    //
    // CreatePersonService createPersonService = new CreatePersonService();
    //
    // Person newPerson = new Person(createPersonService.createPersonName(),
    // createPersonService.createPersonGender(),
    // createPersonService.createPersonDateOfBirth(),
    // createPersonService.createPersonInterests(),
    // createPersonService.createPersonStatus());
    // if (personService.addNewPerson(newPerson)) {
    // System.out.println(newPerson.toString());
    // } else {
    // System.out.println(CANNOT_PERFORM_ACTION);
    // }
    // }

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
<<<<<<< HEAD

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
=======
>>>>>>> e5f5ea862462fd2b712f9f32b2da26da78942281

    public static void searchContactByUUID() {
        System.out.println(ENTER_EXISTING_UUID);
        String uuidInput = scanner.nextLine();
        UUID uuid = UUID.fromString(uuidInput);
        Person existingPerson = personService.findPersonByUUID(uuid);
        if (existingPerson != null) {
            System.out.println(existingPerson.getName() + ", " + UUID_FOUND);
        } else {
            System.out.println("something wrong happen");
        }
    }

    public static List<Person> readPersons() {
        List<Person> persons = new ArrayList<>();
        String questionLoc = "C:\\Петко\\udemy\\java master class\\Martin_Project\\test.txt";
        String questionData;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(questionLoc))) {
            if ((questionData = bufferedReader.readLine()) != null && !questionData.isEmpty()) {
                String data[] = questionData.split(",");
                UUID uuid = UUID.fromString(data[0]);
                // first line
                Person person = new Person();
                person.setUuid(data[0]);
                person.setNames(data[1]);
                person.setDateOfBirth(data[2]);
                // 2nd line
                Question question = new Question(readLine);

                // line 3 4 5 6 -> answers
                String data[] = questionData.split(",");
                String answer = data[0];
                double points = Double.parseDouble(data[1]);
                Answer answer = new Answer(answer, points);
                question.addAnswer(answer);

                person.setQuestion(question);
                persons.add(person);
                for (int i = 0; i < personService.allPersons.size(); i++) {
                    searchContactByUUID();
                    if (uuid.equals(personService.allPersons.get(i).getUuid())) {
                        System.out.println(bufferedReader.readLine());
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
