package com.codebind;

import java.util.ArrayList;

public class FlashcardSet {

    private ArrayList<Card> cardsInSet = new ArrayList<>();
    private String flashcardSetName;
    private double average;

    //getter/setter methods
    public FlashcardSet(String flashcardSetName) {
        this.flashcardSetName = flashcardSetName;
        this.average = 0.00;
    }

    public int getNumOfCards() {
        return cardsInSet.size();
    }

    public String getFlashcardSetName() {
        return flashcardSetName;
    }

    public void setFlashcardSetName(String flashcardSetName) {
        this.flashcardSetName = flashcardSetName;
    }

    public Card getCertainCard(int index) {
        return cardsInSet.get(index);
    }

    public void removeCard(Card card) {
        cardsInSet.remove(card);
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = round(average);
    }

    public void addCard(Card card) {
        cardsInSet.add(card);
    }

    private double round(double average) {
        return (Math.round(average * 10000) / (double) 100);
    }

    public ArrayList<Card> getFlashcardSet() {
        return cardsInSet;
    }
}
