package com.service;

import com.person.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PersonService implements IPersonService {

    private static final String PERSON_EXIST = "Person existed already";
    private static final String NULL_PERSON = "Cannot add null person";
    private static final String PERSON_DOES_NOT_EXIST = "Person does not exist";
    private static final String PERSON_CREATED = "Person created";
    private static final String PERSON_DELETED = "Person deleted";
    private static final String PERSON_LIST = "Person list";
    private static final String MATCHING_FEMALE_RESULT = "You've been matched to drink with the following ladies ";
    public static final String NO_MATCHING = "No luck this time, keep drinking alone ";

//    private static final PersonService personService = new PersonService();
    private static Scanner scanner = new Scanner(System.in);

    public List<Person> allPersons;

    public PersonService() {
        this.allPersons = new ArrayList<>();
    }

    protected boolean isPersonCreated(Person person) {
        for (int i = 0; i < allPersons.size(); i++) {
            Person existedPerson = allPersons.get(i);
            if (existedPerson.equals(person)) {
                System.out.println(PERSON_EXIST);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addNewPerson(Person person) {
        if (isPersonCreated(person)) {
            System.out.println(PERSON_EXIST);
            return false;
        }else if(person == null) {
            System.out.println(NULL_PERSON);
            return false;
        }
        allPersons.add(person);
        System.out.println(PERSON_CREATED);
        return true;
    }

    @Override
    public boolean removePerson(Person person) {
        if (person != null) {
            this.allPersons.remove(person);
            System.out.println(PERSON_DELETED);
            return true;
        } else {
            System.out.println(PERSON_DOES_NOT_EXIST);
            return false;
        }
    }

    @Override
    public Person findPersonByName(String name) {
        for (int i = 0; i < this.allPersons.size(); i++) {
            Person existedPerson = this.allPersons.get(i);
            if (!name.isEmpty()) {
                if (existedPerson.getName().equals(name)) {
                    return existedPerson;
                }
            }
        }
        return null;
    }

    @Override
    public Person findPersonByDateOfBirth(Date dateOfBirth) {
        for (int i = 0; i < this.allPersons.size(); i++) {
            Person existedPerson = this.allPersons.get(i);
            if (existedPerson != null) {
                if (existedPerson.getDateOfBirth().equals(dateOfBirth)) {
                    return existedPerson;
                }
            }
        }
        return null;
    }

    @Override
    public Person findPersonByUUID(UUID uuid) {
        for(int i=0; i < this.allPersons.size(); i++) {
            Person existedPerson = this.allPersons.get(i);
            if(existedPerson != null) {
                if(existedPerson.getUuid().equals(uuid)) {
                    return existedPerson;
                }
            }
        }
        return null;
    }

    @Override
    public void showPersons() {
        System.out.println(PERSON_LIST);
        for (Person person : allPersons) {
            System.out.println(person.toString());
        }
    }

    @Override
    public void showPersonsFromFile() {
        String fileLoc = "C:\\Петко\\udemy\\java master class\\Martin_Project\\personsList.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLoc))) {
            String readData;
            while ((readData = bufferedReader.readLine()) != null && !readData.isEmpty()) {
                System.out.println(readData);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findYourPartner() {
        List<String> allPersons = new ArrayList<>();
        String fileLoc = "C:\\Петко\\udemy\\java master class\\Martin_Project\\personsList.txt";
        String fileData;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLoc))){
            while((fileData = bufferedReader.readLine()) != null && !fileData.isEmpty()) {
                allPersons.add(fileData);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        String questionLoc = "C:\\Петко\\udemy\\java master class\\Martin_Project\\matchingQuestions.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(questionLoc))){
            System.out.println(bufferedReader.readLine());
            String genderInput = scanner.nextLine();
            System.out.println(bufferedReader.readLine());
            int myScore = Integer.parseInt(scanner.nextLine());


            if(myScore == 300 && genderInput.equals("FEMALE")) {
                for(int i=0; i < allPersons.size(); i++) {
                    if(allPersons.get(i).contains("FEMALE") && allPersons.get(i).contains("300")) {
                        System.out.println(MATCHING_FEMALE_RESULT);
                        System.out.println(allPersons.get(i));
                    }
                }
            }else {
                System.out.println(NO_MATCHING);
            }

            //to be created for MALE as well

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}