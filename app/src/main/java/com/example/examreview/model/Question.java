package com.example.examreview.model;

public class Question {
    private String Qtext;
    private Boolean AnswerTrue;

    public String getQtext() {
        return Qtext;
    }

    public void setQtext(String qtext) {
        Qtext = qtext;
    }

    public Boolean getAnswerTrue() {
        return AnswerTrue;
    }

    public void setAnswerTrue(Boolean answerTrue) {
        AnswerTrue = answerTrue;
    }
}
