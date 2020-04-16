package com.quiz;

public interface IAnswerService {

    Answer findAnswers(String answerDescription);
    boolean addAnswer(Answer answer);
    void showAnswers();
    int showPoints(String answerDescription);
}
