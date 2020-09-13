package com.codebind;

public class Card {

    private String term;
    private String definition;

    public Card(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    //getter/setter methods
    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String someToStringMethod() {
        return term + " - " + definition;
    }
}
