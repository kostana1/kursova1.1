package com.quiz;

import com.Utils.AppProperties;
import com.enumex.EGender;
import com.enumex.EStatus;
import com.person.Person;
import com.Utils.CommonUtils;
import com.service.PersonService;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class FindPersonByUuidAndAskQuestion {

    private static final String VALID_UUID = "Enter a valid uuid";
    private static final String UUID_PATTERN = "^[0-9A-Fa-f]{8}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{12}$";
    private static final String INVALID_UUID = "You have entered wrong or invalid uuid";
    private static final String PERSON_UUID_BELONGS_TO = "This uuid belongs to %s\n";
    public static final String ANSWER_NOW_QUESTION = "Answer now %s's question...\n";
    public static final String LINE_SEPARATOR = "*******************";
    public static final String RESULT = "Your result is %d";

    private static PersonService personService = new PersonService();
    private static Question question = new Question("test");
    private static Scanner scanner = new Scanner(System.in);

    public static void readFromFile() {

        String testFilePath = AppProperties.getInstance().getProperty("testFilePath");

        String readData;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(testFilePath))) {
            while ((readData = bufferedReader.readLine()) != null && !readData.isEmpty()) {
                String[] personData = readData.split(",");
                UUID uuid = UUID.fromString(personData[0]);
                String name = personData[1];
                EGender gender = EGender.valueOf(personData[2]);
                Date date = CommonUtils.formatDateOfBirth(personData[3]);
                String interest = personData[4];
                EStatus status = EStatus.valueOf(personData[5]);

                String questionLine;
                questionLine = bufferedReader.readLine();
                Question question = new Question(questionLine);
                Person personFromFile = new Person(uuid, name, gender, date, interest, status, question);
                personService.allPersons.add(personFromFile);

                int counterAnswerLines = 0;

                while ((readData = bufferedReader.readLine()) != null && !readData.isEmpty()) {
                    String[] answerData = readData.split(",");
                    String answerDescription = answerData[0];
                    int answerPoint = Integer.parseInt(answerData[1]);
                    counterAnswerLines++;

                    question.addAnswer(new Answer(answerDescription, answerPoint));

                    if (counterAnswerLines == 4) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(VALID_UUID);
        String uuidInput = scanner.nextLine();
        if (uuidInput.matches(UUID_PATTERN)) {
            UUID uuid = UUID.fromString(uuidInput);
            for (int i = 0; i < personService.allPersons.size(); i++) {
                if (personService.allPersons.get(i).getUuid().equals(uuid)) {
                    System.out.format(PERSON_UUID_BELONGS_TO, personService.allPersons.get(i).getName());
                    System.out.format(ANSWER_NOW_QUESTION, personService.allPersons.get(i).getName());
                    System.out.println(LINE_SEPARATOR);
                    System.out.println(personService.allPersons.get(i).getQuestion());
                    personService.allPersons.get(i).getQuestion().showAnswers();
                    System.out.println(LINE_SEPARATOR);
                    String replyInput = scanner.nextLine();
                    if (!replyInput.isEmpty()) {
                        System.out.format(RESULT, personService.allPersons.get(i).getQuestion().showPoints(replyInput));
                    }
                }
            }
        } else {
            System.out.println(INVALID_UUID);
        }
    }
}