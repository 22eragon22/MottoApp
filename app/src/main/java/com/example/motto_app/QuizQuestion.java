package com.example.motto_app;

public class QuizQuestion {
    private Integer id;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctAns;

    public QuizQuestion(Integer id, String question, String answerA, String answerB, String answerC, String answerD, String correctAns) {
        this.id = id;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAns = correctAns;
    }

    public Integer getId() {
        return id;
    }
    public String getQuestion() {
        return question;
    }
    public String getAnswerA() {
        return answerA;
    }
    public String getAnswerB() {
        return answerB;
    }
    public String getAnswerC() {
        return answerC;
    }
    public String getAnswerD() {
        return answerD;
    }
    public String getCorrectAns() {
        return correctAns;
    }
}
