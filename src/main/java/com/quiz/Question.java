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

        public boolean addAnswer(Answer answer) {
        if(findAnswers(answer.getAnswerDescription()) == null) {
            this.questionAnswers.add(answer);
            return true;
        }
        return false;
    }

    public void showAnswers() {
        for(int i=0; i < this.questionAnswers.size(); i++) {
            System.out.println(this.questionAnswers.get(i).getAnswerDescription());
        }
    }

    public int showPoints(String answerDescription) {
        int points = 0;
        for(int i=0; i < this.questionAnswers.size(); i++) {
            if(answerDescription.equals(this.questionAnswers.get(i).getAnswerDescription())) {
                points = this.questionAnswers.get(i).getPoints();
            }
        }
        return points;
    }

    @Override
    public String toString() {
        return this.questionDescription;
    }
}
