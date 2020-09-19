package com.codebind;

public class Question {

    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String chosenAnswer;

    public Question(String question, String choiceA, String choiceB, String choiceC) {
        this.question = question;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
    }

    public void setChosenAnswer(String choice) {
        chosenAnswer = choice;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public String getChosenAnswer() {
        return chosenAnswer;
    }

    public String getQuestion() {
        return question;
    }
}
