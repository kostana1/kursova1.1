package com.utils;

import com.service.CreatePersonService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    public static final String PATTERN_DATE_OF_BIRTH = "yyyy-MM-dd";
    public static final String USE_INTEGERS_ONLY = "Use integers as per description";

    private static final CreatePersonService createPersonService = new CreatePersonService();

    public static Date formatDateOfBirth(String dateOfBirthString) {
        Date dateOfBirth = null;
        if(createPersonService.isValidDateOfBirth(dateOfBirthString)) {
            try {
                dateOfBirth = new SimpleDateFormat(PATTERN_DATE_OF_BIRTH).parse(dateOfBirthString);
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println(USE_INTEGERS_ONLY);
            }
        }
        return dateOfBirth;
    }
}
