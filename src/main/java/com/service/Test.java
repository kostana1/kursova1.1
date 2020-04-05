package com.service;

import com.enumex.EGender;
import com.enumex.EStatus;
import com.person.Person;
import com.quiz.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class Test {
    private static PersonService personService = new PersonService();

    public static void main(String[] args) {
        askQuestion();
    }

    public static void askQuestion() {

        String questionLoc = "C:\\Петко\\udemy\\java master class\\Martin_Project\\test.txt";
        String fileData;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(questionLoc))) {
            while ((fileData = bufferedReader.readLine()) != null && !fileData.isEmpty()) {
                String[] personData = fileData.split(",");
                UUID uuid = UUID.fromString(personData[0]);
                String name = personData[1];
                EGender gender = EGender.valueOf(personData[2]);
                Date date = CommonUtils.formatDateOfBirth(personData[3]);
                String interest = personData[4];
                EStatus status = EStatus.valueOf(personData[5]);
                int questions = Integer.parseInt(personData[6]);
                Person personFromFile = new Person(name, gender, date, interest, status, questions);
                personService.allPersons.add(personFromFile);

                String questionLine;
                questionLine = bufferedReader.readLine();
                Question question = new Question(questionLine);
                System.out.println(question);

                int counterAnswerLines = 0;

                while ((fileData = bufferedReader.readLine()) != null && !fileData.isEmpty()) {
                    String[] answerData = fileData.split(",");
                    String answerDescription = answerData[0];
                    int answerPoint = Integer.parseInt(answerData[1]);
                    counterAnswerLines++;

                    if(counterAnswerLines == 4) {
                        break;
                    }
                    question.addAnswer(answerDescription, answerPoint);
                }

                for(int j=0; j < question.questionAnswers.size(); j++) {
                }

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
