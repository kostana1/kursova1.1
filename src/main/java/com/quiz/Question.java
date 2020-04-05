package com.quiz;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String questionDescription;
    public List<Answer> questionAnswers;

    public Question(String questionDescription) {
        this.questionDescription = questionDescription;
        this.questionAnswers = new ArrayList<>();
    }

    private Answer findAnswers(String answerDescription) {
        for(int i=0; i < this.questionAnswers.size(); i++) {
            Answer existedAnswer = this.questionAnswers.get(i);
            if(existedAnswer.getAnswerDescription().equals(answerDescription)) {
                return existedAnswer;
            }
        }
        return null;
    }

    public boolean addAnswer(String answerDescription, int points) {
        if(findAnswers(answerDescription) == null) {
            this.questionAnswers.add(new Answer(answerDescription, points));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.questionDescription;
    }
}
