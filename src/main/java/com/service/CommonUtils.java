package com.service;

import com.enumex.EGender;
import com.enumex.EStatus;
import com.person.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    public static final String PATTERN_DATE_OF_BIRTH = "yyyy-MM-dd";
    public static final String PATTERN_REGEXP_YEAR = "\\d{4}-[01]\\d-[0-3]\\d";
    public static final String USE_INTEGERS_ONLY = "Use integers as per description";

    private static final CreatePersonService createPersonService = new CreatePersonService();
    private static Person person = new Person("", EGender.MALE, new Date(), "sdf", EStatus.IN_RELATIONSHIP);

    public static boolean isValidDateOfBirth(String dateOfBirth) {
        if(dateOfBirth == null || !dateOfBirth.matches(PATTERN_REGEXP_YEAR)) {
            return false;
        }else {
            return true;
        }
    }

    public static Date formatDateOfBirth(String dateOfBirthString) {
        Date dateOfBirth = null;
        if(isValidDateOfBirth(dateOfBirthString)) {
            try {
                dateOfBirth = new SimpleDateFormat(PATTERN_DATE_OF_BIRTH).parse(dateOfBirthString);
                person.setDateOfBirth(dateOfBirth);
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println(USE_INTEGERS_ONLY);
            }
        }
        return dateOfBirth;
    }


}
