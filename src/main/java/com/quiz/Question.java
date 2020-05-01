package com.quiz;

import java.util.ArrayList;
import java.util.List;

public class Question implements IQuestion{

    private String questionDescription;
    protected List<Answer> questionAnswers;


    public Question(String questionDescription) {
        this.questionDescription = questionDescription;
        this.questionAnswers = new ArrayList<>();
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public List<Answer> getQuestionAnswers() {
        return questionAnswers;
    }

    @Override
    public Answer findAnswers(String answerDescription) {
        for (int i = 0; i < this.questionAnswers.size(); i++) {
            Answer existedAnswer = this.questionAnswers.get(i);
            if (existedAnswer.getAnswerDescription().equals(answerDescription)) {
                return existedAnswer;
            }
        }
        return null;
    }

    @Override
    public boolean addAnswer(Answer answer) {
        if (findAnswers(answer.getAnswerDescription()) == null) {
            this.questionAnswers.add(answer);
            return true;
        }
        return false;
    }

    @Override
    public void showAnswers() {
        for (int i = 0; i < this.questionAnswers.size(); i++) {
            Answer existingAnswer = this.questionAnswers.get(i);
            System.out.println(existingAnswer.getAnswerDescription());
        }
    }

    @Override
    public int showPoints(String answerDescription) {
        int points = 0;
        for (int i = 0; i < this.questionAnswers.size(); i++) {
            Answer existingAnswer = this.questionAnswers.get(i);
            if (answerDescription.equals(existingAnswer.getAnswerDescription())) {
                points = existingAnswer.getPoints();
            }
        }
        return points;
    }

    @Override
    public String toString() {
        return this.getQuestionDescription();
    }
}
