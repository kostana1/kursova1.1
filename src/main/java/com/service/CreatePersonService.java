package com.service;

import com.enumex.EGender;
import com.enumex.EStatus;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreatePersonService {

    public static final String NAME_INPUT = "Enter your name";
    public static final String GENDER_INPUT = "Pick a number.***0 for male <-> 1 for female***";
    public static final String DATE_INPUT = "Enter your date of birth";
    public static final String INTEREST_INPUT = "Enter your interests *** max symbols = 250 ***";
    public static final String STATUS_INPUT = "Enter your status *** 0 for single <-> 1 for in relationship <-> 2 for married";
    public static final String INVALID_INPUT = "Invalid %s input";
    public static final String SUCCESSFUL_INPUT = "%s successfully added";
    public static final String INTEREST_CHAR_LIMIT = "Your interests have been reduced to 250 characters";
    public static final String NAME_VALIDATION_REGEX = "[a-zA-z]{3,}";
    public static final String PATTERN_REGEXP_YEAR = "\\d{4}-[01]\\d-[0-3]\\d";
    public static final String USE_INTEGERS_ONLY = "Use integers as per description";

    public static final String FIRST_QUESTION = "Select a number from 1 to 10 to assess your fairness when answering ";
    public static final String SECOND_QUESTION = "How often do you drink? " + "\n1 - I don't drink; 2 - Not very often; 3 - Every other day; 4 - Every day";
    public static final String NEXT_ANSWER = "%d selected. Next question ...";
    public static final String LAST_ANSWER = "%d selected. Thank you for your time";
    public static final String RESULT = "Your result is %d";

    private static final Scanner scannerIn = new Scanner(System.in);

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
                    System.out.println();
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
                        System.out.println();
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
        if(dateOfBirth == null || !dateOfBirth.matches(PATTERN_REGEXP_YEAR)) {
            return false;
        }else {
            return true;
        }
    }

    public Date createPersonDateOfBirth() {
        System.out.println(DATE_INPUT);
        while (true) {
            if (scannerHasNextLine()) {
                String dateOfBirthInput = getUserInputString();
                if(isValidDateOfBirth(dateOfBirthInput)) {
                    Date dateOfBirth = CommonUtils.formatDateOfBirth(dateOfBirthInput);
                    System.out.format(SUCCESSFUL_INPUT, dateOfBirth);
                    System.out.println();
                    return dateOfBirth;
                }else {
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
        System.out.println();
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
                        System.out.println();
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

    public int questions() {

        int firstAnswer;
        int secondAnswer;
        int result = 0;
        boolean quit = false;

        System.out.println(FIRST_QUESTION);
        while (!quit) {
            if (scannerHasNextInt()) {
                try {
                    firstAnswer = getUserInputInt();
                    if (firstAnswer >= 1 && firstAnswer <= 10) {
                        System.out.format(NEXT_ANSWER, firstAnswer);
                        System.out.println();
                        System.out.println(SECOND_QUESTION);
                        try {
                            secondAnswer = getUserInputInt();
                            int answerValue = 0;
                            switch (secondAnswer) {
                                case 1:
                                    answerValue = 10;
                                    break;

                                case 2:
                                    answerValue = 20;
                                    break;

                                case 3:
                                    answerValue = 30;
                                    break;

                                case 4:
                                    answerValue = 40;
                                    break;
                            }

                            if (secondAnswer >= 1 && secondAnswer <= 4) {
                                System.out.format(LAST_ANSWER, secondAnswer);
                                System.out.println();
                                result = firstAnswer * answerValue;
                                quit = true;
                            } else if (secondAnswer > 5) {
                                getUserInputInt();
                                System.out.println(USE_INTEGERS_ONLY);
                            }

                        } catch (InputMismatchException e) {
                            getUserInputString();
                            System.out.println(USE_INTEGERS_ONLY);
                        }
                    } else if (firstAnswer > 10) {
                        getUserInputString();
                        System.out.println(USE_INTEGERS_ONLY);
                    }
                } catch (InputMismatchException e) {
                    getUserInputString();
                    System.out.println(USE_INTEGERS_ONLY);
                }
            }else {
                getUserInputInt();
                System.out.println(USE_INTEGERS_ONLY);
            }
        }
        System.out.format(RESULT, result);
        System.out.println();
        return result;
    }
}
