package com.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CreatePersonServiceUtils {

    public static final String PATTERN_DATE_OF_BIRTH = "yyyy-MM-dd";
    public static final String PATTERN_REGEXP_YEAR = "\\d{4}-[01]\\d-[0-3]\\d";
    public static final String USE_INTEGERS_ONLY = "Use integers as per description";

    private static final Scanner scannerIn = new Scanner(System.in);

    public static int getUserInputInteger() {
        return Integer.parseInt(scannerIn.nextLine());
    }

    public static String getUserInputString() {
        return scannerIn.nextLine();
    }

    public static String wrongInputByUserReturnNewLine() {
        return scannerIn.nextLine();
    }

    public static boolean scannerHasNextLine() {
        return scannerIn.hasNextLine();
    }

    public static boolean scannerHasNextInt() {
        return scannerIn.hasNextInt();
    }

    public static Date formatDateOfBirth(String dateOfBirthString) {
        Date dateOfBirth = null;
        if(isValidDateOfBirth(dateOfBirthString)) {
            try {
                dateOfBirth = new SimpleDateFormat(PATTERN_DATE_OF_BIRTH).parse(dateOfBirthString);
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println(USE_INTEGERS_ONLY);
            }
        }
        return dateOfBirth;
    }

    public static boolean isValidDateOfBirth(String dateOfBirth) {
        if(dateOfBirth == null || !dateOfBirth.matches(PATTERN_REGEXP_YEAR)) {
            return false;
        }else {
            return true;
        }
    }
}
