package com.service;

import com.quiz.Answer;

public interface IQuestionService {

    Answer findAnswers(String answerDescription);
    boolean addAnswer(Answer answer);
    void showAnswers();
    int showPoints(String answerDescription);
}
