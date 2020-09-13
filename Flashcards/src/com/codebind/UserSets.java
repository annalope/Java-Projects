package com.codebind;

import java.util.ArrayList;

public class UserSets {

    private ArrayList<FlashcardSet> flashcardSets = new ArrayList<>();

    public boolean containsFlashcardSet(FlashcardSet f) {
        boolean b = false;
        for (int i = 0; i < flashcardSets.size(); i++) {
            if (flashcardSets.get(i).getFlashcardSetName().equals(f.getFlashcardSetName())) {
                b = true;
            }
        }
        return b;
    }

    public ArrayList<FlashcardSet> getFlashcardSets() {
        return flashcardSets;
    }

    public void addSet(FlashcardSet f) {
        flashcardSets.add(f);
    }

    public void removeASet(FlashcardSet fs) {
        flashcardSets.remove(fs);
    }
}
