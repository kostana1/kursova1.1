package com.service;

import com.quiz.Question;
import com.utils.ApplicationPropertyFileExtractor;
import com.utils.CommonUtils;
import com.enumex.EGender;
import com.enumex.EStatus;
import com.person.Person;
import com.quiz.Answer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class CreatePersonService {

    public static final String NAME_INPUT = "Enter your name";
    public static final String GENDER_INPUT = "Pick a number.***0 for male <-> 1 for female***";
    public static final String DATE_INPUT = "Enter your date of birth";
    public static final String INTEREST_INPUT = "Enter your interests *** max symbols = 250 ***";
    public static final String STATUS_INPUT = "Enter your status *** 0 for single <-> 1 for in relationship <-> 2 for married";
    public static final String INVALID_INPUT = "Invalid %s input";
    public static final String SUCCESSFUL_INPUT = "%s successfully added\n";
    public static final String INTEREST_CHAR_LIMIT = "Your interests have been reduced to 250 characters";
    public static final String NAME_VALIDATION_REGEX = "[a-zA-z]{3,}";
    public static final String PATTERN_REGEXP_YEAR = "\\d{4}-[01]\\d-[0-3]\\d";
    public static final String USE_INTEGERS_ONLY = "Use integers as per description";

    private static final String VALID_UUID = "Enter a valid uuid";
    private static final String UUID_PATTERN = "^[0-9A-Fa-f]{8}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{12}$";
    private static final String INVALID_UUID = "You have entered wrong or invalid uuid";
    private static final String PERSON_UUID_BELONGS_TO = "This uuid belongs to %s\n";
    public static final String ANSWER_NOW_QUESTION = "Answer now %s's question...\n";
    public static final String LINE_SEPARATOR = "*******************";
    public static final String RESULT = "Your result is %d";

    private static PersonService personService = new PersonService();
    private static Question question = new Question("question");
// dependency inversion, liskov substitution principle
//    private IPersonService ipersonService;

    private static final Scanner scannerIn = new Scanner(System.in);

//    public CreatePersonService(IPersonService ipersonService) {
//        this.ipersonService = ipersonService;
//    }

//    public void asdPersonQuestionFromInternet(String uuid) {
//        List<Person> personsFromInternet = this.ipersonService.readFromPersonsFromInternet();
//
//        Person personFromInternet = personsFromInternet.stream().filter(person -> person.getUuid().equals(UUID.fromString(uuid)))
//                .findFirst().orElse(null);
//
//        //asking questions
//    }

    public int getUserInputParseInteger() {
        return Integer.parseInt(scannerIn.nextLine());
    }

    public String getUserInputString() {
        return scannerIn.nextLine();
    }

    public int getUserInputInt() {
        return scannerIn.nextInt();
    }

    public String wrongInputByUserReturnNewLine() {
        return scannerIn.nextLine();
    }

    public boolean scannerHasNextLine() {
        return scannerIn.hasNextLine();
    }

    public boolean scannerHasNextInt() {
        return scannerIn.hasNextInt();
    }

    public String createPersonName() {
        while (true) {
            System.out.println(NAME_INPUT);
            if (scannerHasNextLine()) {
                String name = getUserInputString();
                if (name != null && name.matches(NAME_VALIDATION_REGEX)) {
                    System.out.format(SUCCESSFUL_INPUT, name);
                    return name;
                }
            } else {
                wrongInputByUserReturnNewLine();
                System.out.println(INVALID_INPUT);
            }
        }
    }

    public EGender createPersonGender() {
        System.out.println(GENDER_INPUT);
        EGender gender;
        while (true) {
            if (scannerHasNextInt()) {
                try {
                    int genderInput = getUserInputParseInteger();
                    if (genderInput >= 0 && genderInput <= 1) {
                        gender = EGender.values()[genderInput];
                        System.out.format(SUCCESSFUL_INPUT, gender);
                        return gender;
                    } else if (genderInput > 1) {
                        wrongInputByUserReturnNewLine();
                        System.out.println(USE_INTEGERS_ONLY);
                    }
                } catch (NumberFormatException e) {
                    wrongInputByUserReturnNewLine();
                    System.out.println(USE_INTEGERS_ONLY + e.getMessage());
                }
            } else {
                wrongInputByUserReturnNewLine();
                System.out.println(USE_INTEGERS_ONLY);
            }
        }
    }

    public boolean isValidDateOfBirth(String dateOfBirth) {
        if (dateOfBirth == null || !dateOfBirth.matches(PATTERN_REGEXP_YEAR)) {
            return false;
        } else {
            return true;
        }
    }

    public Date createPersonDateOfBirth() {
        System.out.println(DATE_INPUT);
        while (true) {
            if (scannerHasNextLine()) {
                String dateOfBirthInput = getUserInputString();
                if (isValidDateOfBirth(dateOfBirthInput)) {
                    Date dateOfBirth = CommonUtils.formatDateOfBirth(dateOfBirthInput);
                    System.out.format(SUCCESSFUL_INPUT, dateOfBirth);
                    return dateOfBirth;
                } else {
                    wrongInputByUserReturnNewLine();
                    System.out.println(USE_INTEGERS_ONLY);
                }
            } else {
                wrongInputByUserReturnNewLine();
                System.out.println(USE_INTEGERS_ONLY);
            }
        }
    }

    public String createPersonInterests() {
        char limit = 250;
        System.out.println(INTEREST_INPUT);
        String interests = getUserInputString();
        if (interests.length() > limit) {
            interests = interests.substring(0, limit);
            System.out.println(INTEREST_CHAR_LIMIT);
        }
        System.out.format(SUCCESSFUL_INPUT, interests);
        return interests;
    }

    public EStatus createPersonStatus() {
        System.out.println(STATUS_INPUT);
        EStatus status;
        while (true) {
            if (scannerHasNextLine()) {
                try {
                    int statusInput = getUserInputParseInteger();
                    if (statusInput >= 0 && statusInput <= 2) {
                        status = EStatus.values()[statusInput];
                        System.out.format(SUCCESSFUL_INPUT, status);
                        return status;
                    } else if (statusInput > 2) {
                        wrongInputByUserReturnNewLine();
                        System.out.println(USE_INTEGERS_ONLY);
                    }
                } catch (NumberFormatException e) {
                    wrongInputByUserReturnNewLine();
                    System.out.println(USE_INTEGERS_ONLY + e.getMessage());
                }
            } else {
                wrongInputByUserReturnNewLine();
                System.out.println(USE_INTEGERS_ONLY);
            }
        }
    }

    public void readPropertyFileAndExecuteReadFileLinesMethod() {
        String testFilePath = ApplicationPropertyFileExtractor.getInstance().getProperty("testFilePath");


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(testFilePath))) {
            readFileLines(bufferedReader);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void readFileLines(BufferedReader bufferedReader) {

        String readPersonData;
        String readAnswerData;

        try {
            while ((readPersonData = bufferedReader.readLine()) != null && !readPersonData.isEmpty()) {
                String[] personData = readPersonData.split(",");
                UUID uuid = UUID.fromString(personData[0]);
                if(uuid.toString().matches(UUID_PATTERN)) {
                    String name = personData[1];
                    EGender gender = EGender.valueOf(personData[2]);
                    Date date = CommonUtils.formatDateOfBirth(personData[3]);
                    String interest = personData[4];
                    EStatus status = EStatus.valueOf(personData[5]);

                    String questionLine;
                    questionLine = bufferedReader.readLine();
                    Question question = new Question(questionLine);
                    Person personFromFile = new Person(uuid, name, gender, date, interest, status, question);
                    personService.addNewPerson(personFromFile);
                }

                int counterAnswerLines = 0;

                while ((readAnswerData = bufferedReader.readLine()) != null && !readAnswerData.isEmpty()) {
                    String[] answerData = readAnswerData.split(",");
                    String answerDescription = answerData[0];
                    int answerPoint = Integer.parseInt(answerData[1]);
                    counterAnswerLines++;

                    question.addAnswer(new Answer(answerDescription, answerPoint));

                    if (counterAnswerLines == 4) {
                        break;
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void askPersonQuestionFromFile() {

        System.out.println(VALID_UUID);
        String uuidInput = getUserInputString();
        if (uuidInput.matches(UUID_PATTERN)) {
            UUID uuid = UUID.fromString(uuidInput);
            Person existingPerson = personService.findPersonByUUID(uuid);
            if (existingPerson != null) {
                System.out.format(PERSON_UUID_BELONGS_TO, existingPerson.getName());
                System.out.format(ANSWER_NOW_QUESTION, existingPerson.getName());
                System.out.println(LINE_SEPARATOR);
                System.out.println(existingPerson.getQuestion());
                existingPerson.getQuestion().showAnswers();

                System.out.println(LINE_SEPARATOR);
                String replyInput = getUserInputString();
                if (!replyInput.isEmpty()) {
                    System.out.format(RESULT, existingPerson.getQuestion().showPoints(replyInput));
                }
            }
        } else {
            System.out.println(INVALID_UUID);
        }
    }
}
