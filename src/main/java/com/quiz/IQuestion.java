package com.quiz;

public interface IQuestion {

    Answer findAnswers(String answerDescription);
    boolean addAnswer(Answer answer);
}
