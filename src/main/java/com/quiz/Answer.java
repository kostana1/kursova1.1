package com.quiz;

public class Answer {

    private String answerDescription;
    private int points;

    public Answer(String answerDescription, int points) {
        this.answerDescription = answerDescription;
        this.points = points;
    }

    public String getAnswerDescription() {
        return answerDescription;
    }

    public int getPoints() {
        return points;
    }
}
