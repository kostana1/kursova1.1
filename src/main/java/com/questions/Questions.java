package com.questions;

import java.util.Scanner;

public class Questions {

    public static final String FIRST_QUESTION = "Select a number from 1 to 10 to assess your fairness when answering ";
    public static final String SECOND_QUESTION = "How often do you drink? " + "\n1 - I don't drink; 2 - Not very often; 3 - Every other day; 4 - Every day";
    public static final String NEXT_ANSWER = "%d selected. Next question ...";
    public static final String LAST_ANSWER = "%d selected. Thank you for your time";
    public static final String RESULT = "Your result is %d";
    public static final String CANNOT_PERFORM_ACTION = "Error performing action due to your input";
    public static final String USE_INTEGERS_ONLY = "Use integers as per description";

    private static Scanner scanner = new Scanner(System.in);

    int firstAnswer = 0;
    int secondAnswer;
    int result;

    public void questions() {
        System.out.println(FIRST_QUESTION);
        while (true) {
            if (scanner.hasNextInt()) {
                firstAnswer = scanner.nextInt();
                if (firstAnswer >= 1 && firstAnswer <= 10) {
                    System.out.format(NEXT_ANSWER, firstAnswer);
                    System.out.println();
                } else if (firstAnswer > 10) {
                    scanner.nextLine();
                    System.out.println(USE_INTEGERS_ONLY);
                } else {
                    System.out.println(CANNOT_PERFORM_ACTION);
                    return;
                }
                System.out.println(SECOND_QUESTION);
            } else {
                scanner.nextLine();
                System.out.println(USE_INTEGERS_ONLY);
            }

            if (scanner.hasNextInt()) {
                secondAnswer = scanner.nextInt();
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
                    System.out.format(RESULT, result);
                } else if (secondAnswer > 5) {
                    scanner.nextLine();
                    System.out.println(CANNOT_PERFORM_ACTION);
                } else {
                    System.out.println(USE_INTEGERS_ONLY);
                }
                return;
            } else {
                scanner.nextLine();
                System.out.println(USE_INTEGERS_ONLY);
            }
        }
    }
}
