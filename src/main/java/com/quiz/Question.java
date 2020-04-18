package com.quiz;

import com.service.QuestionService;

public class Question {

    private String questionDescription;
    private QuestionService questionServiceInstance;

    public Question(String questionDescription) {
        this.questionDescription = questionDescription;
        this.questionServiceInstance = new QuestionService();
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public QuestionService getQuestionServiceInstance() {
        return questionServiceInstance;
    }

    @Override
    public String toString() {
        return this.getQuestionDescription();
    }
}
