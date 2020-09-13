package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Flashcards {

    private UserSets userSets = new UserSets();
    private Card ca;
    private FlashcardSet fs;
    //mode 0 is selecting a set to study, mode 1 is selecting a set and then a card to edit, mode 2 is selecting a set to delete
    private int mode = 0;

    //main frame
    private static JFrame frame = new JFrame("Flashcards");
    private JPanel mainPanel = new JPanel();
    private MenuBar menuBar = new MenuBar();
    private Menu file = new Menu("File");
    private Menu edit = new Menu("Edit");
    private Menu help = new Menu("Help");
    private MenuItem exit = new MenuItem("Exit");
    private MenuItem editACard = new MenuItem("Edit a card");
    private MenuItem deleteASet = new MenuItem("Delete a Set");
    private JTextArea setsTextArea = new JTextArea("", 12, 17);
    private JTextArea averagesTextArea = new JTextArea("", 12, 17);
    private JButton createNewSet = new JButton("Create");
    private JButton editExistingSet = new JButton("Edit");
    private JButton study = new JButton("Study");
    private JLabel setsHeading = new JLabel("   Sets:                                          ");
    private JLabel averagesHeading = new JLabel(" Averages:                                    ");

    //create set panel
    private static JFrame createFrame = new JFrame("Create a new set");
    private JPanel createPanel = new JPanel();
    private JLabel setNameHeader = new JLabel("Set name:");
    private JTextField flashcardSetName = new JTextField();
    private JLabel spacer = new JLabel("                  ");
    private JLabel createdTermsHeader = new JLabel("Created Terms:                                     ");
    private JLabel createdDefinitionsHeader = new JLabel("Created Definitions:                         ");
    private JTextArea createdTerms = new JTextArea("",8, 20);
    private JTextArea createdDefinitions = new JTextArea("", 8, 20);
    private JLabel termHeader = new JLabel("Term:                                                   ");
    private JLabel definitionHeader = new JLabel("  Definition:                                             ");
    private JTextField newTerm = new JTextField();
    private JTextField newDefinition = new JTextField();
    private JButton addCard = new JButton("Add card");
    private JButton finishSet = new JButton("Finish set");
    private JButton discardChanges = new JButton("Discard Changes");
    private ArrayList<Card> cards = new ArrayList<>();

    //select a set
    private static JFrame selectSetFrame = new JFrame("Choose a set");
    private JPanel choicePanel = new JPanel();
    private JTextArea sets = new JTextArea(10, 25);
    private JLabel choiceLabel = new JLabel("Enter the number of your choice:");
    private JTextField choice = new JTextField(7);

    //study frame
    private static JFrame studyFrame = new JFrame("Study");
    private JPanel studyPanel = new JPanel();
    private JLabel termLabel = new JLabel("Term:                                   ");
    private JLabel definitionLabel = new JLabel("Definition:                                ");
    private JLabel term = new JLabel("");
    private JTextField definition = new JTextField(17);
    private JButton submit = new JButton("Submit answer");
    private JButton end = new JButton("End study session");
    private int counter = 0;
    private int numDone;
    private int numCorrect;
    private double average;

    //edit frame
    private static JFrame editFrame = new JFrame("Edit a set");
    private JPanel editPanel = new JPanel();
    private JLabel cardNameAndDescription = new JLabel();
    private JButton changeTerm = new JButton("Change Term");
    private JButton changeDefinition = new JButton("Change Definition");
    private JButton deleteCard = new JButton("Delete Card");
    private JButton closeMenu = new JButton("Close Menu");

    //select card frame
    private static JFrame selectACard = new JFrame("Select a card: ");
    private JPanel cardPanel = new JPanel();
    private JTextArea cardsPopupPanel = new JTextArea(10, 25);
    private JLabel cardLabel = new JLabel("Enter the number of your choice:");
    private JTextField cardsChoice = new JTextField(7);

    //change feature
    private static JFrame changeFeatureFrame = new JFrame("Change Feature");
    private JPanel changeFeaturePanel = new JPanel();
    private JTextField featureChange = new JTextField(17);
    private JButton featureButton = new JButton("Change");
    private JButton cancelWithNoChange = new JButton("Cancel");
    private String featureChanging;

    public Flashcards() {
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        editACard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editAnExistingSet();
            }
        });
        deleteASet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (userSets.getFlashcardSets().size() > 0) {
                    mode = 2;
                    selectingASet();
                } else {
                    JOptionPane.showMessageDialog(null, "You must create at least one set before you can delete any.");
                }
            }
        });
        createNewSet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cards.clear();
                createFrame.setVisible(true);
                frame.setVisible(false);
            }
        });
        study.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (userSets.getFlashcardSets().size() > 0) {
                    frame.setVisible(false);
                    mode = 0;
                    numDone = 0;
                    numCorrect = 0;
                    selectingASet();
                } else {
                    JOptionPane.showMessageDialog(null, "You must create at least one set before you can study.");
                }
            }
        });
        finishSet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FlashcardSet flashcardSet = new FlashcardSet(flashcardSetName.getText());
                if (userSets.containsFlashcardSet(flashcardSet)) {
                    JOptionPane.showMessageDialog(null, "You already have a flashcard set by that name.");
                } else if (flashcardSet.getFlashcardSetName().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "You must enter a name for your set.");
                } else if (cards.size() == 0) {
                    JOptionPane.showMessageDialog(null, "You must have at least one card.");
                } else {
                    for (Card c : cards) {
                        flashcardSet.addCard(c);
                    }
                    userSets.addSet(flashcardSet);
                    flashcardSet.setFlashcardSetName(flashcardSetName.getText());
                    resetCreatePanel();
                }
            }
        });
        addCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (newDefinition.getText().equalsIgnoreCase("") || newTerm.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "You must enter text in both the term and definition boxes.");
                } else {
                    if (createdTerms.getText().equalsIgnoreCase("")) {
                        Card c = new Card(newTerm.getText(), newDefinition.getText());
                        cards.add(c);
                        createdTerms.setText(newTerm.getText());
                        createdDefinitions.setText(newDefinition.getText());
                    } else {
                        if (checkIfTermExists(newTerm.getText())) {
                            Card c = new Card(newTerm.getText(), newDefinition.getText());
                            cards.add(c);
                            createdTerms.setText(createdTerms.getText() + "\n" + newTerm.getText());
                            createdDefinitions.setText(createdDefinitions.getText() + "\n" + newDefinition.getText());
                        } else {
                            JOptionPane.showMessageDialog(null, "You cannot have duplicate terms. Please enter a different term.");
                        }
                    }
                    newTerm.setText("");
                    newDefinition.setText("");
                }
            }
        });
        choice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = choice.getText();
                choice.setText("");
                try {
                    int c = Integer.parseInt(text);
                    if (c > userSets.getFlashcardSets().size()) {
                        JOptionPane.showMessageDialog(null, "That is not a valid choice.");
                    } else {
                        selectSetFrame.setVisible(false);
                        fs = userSets.getFlashcardSets().get(c - 1);
                        if (mode == 0) {
                            startStudying(fs);
                        } else if (mode == 1) {
                            //card select
                            selectingACard(fs);
                        } else {
                            //selecting a set to delete
                            userSets.removeASet(fs);
                            showAverages();
                            showCreatedSets();
                            selectSetFrame.setVisible(false);
                            frame.setVisible(true);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "That is not a valid choice.");
                }
            }
        });
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numDone++;
                if (fs.getCertainCard(counter).getDefinition().equalsIgnoreCase(definition.getText())) {
                    JOptionPane.showMessageDialog(null, "Correct!");
                    numCorrect++;
                } else {
                    String message = "Incorrect. The correct answer is " + fs.getCertainCard(counter).getDefinition();
                    String s = fs.getCertainCard(counter).getDefinition();
                    if (!(s.substring(s.length() - 1).equalsIgnoreCase("."))) {
                        message += ".";
                    }
                    JOptionPane.showMessageDialog(null, message);
                }
                if (counter == (fs.getNumOfCards() - 1)) {
                    counter = 0;
                } else {
                    counter++;
                }
                nextCard();
                definition.setText("");
            }
        });
        end.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fs.setAverage(average);
                showAverages();
                studyFrame.setVisible(false);
                frame.setVisible(true);
            }
        });
        cardsChoice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = cardsChoice.getText();
                cardsChoice.setText("");
                try {
                    int c = Integer.parseInt(text);
                    if (c > fs.getFlashcardSet().size()) {
                        JOptionPane.showMessageDialog(null, "That is not a valid choice.");
                    } else {
                        ca = fs.getFlashcardSet().get(c - 1);
                        selectACard.setVisible(false);
                        initializeEditWithCard(ca);
                        editFrame.setVisible(true);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "That is not a valid choice.");
                }
            }
        });
        editExistingSet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editAnExistingSet();
            }
        });
        closeMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editFrame.setVisible(false);
                showAverages();
                showCreatedSets();
                frame.setVisible(true);
            }
        });
        changeTerm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                featureChanging = "Term";
                changeFeature();
            }
        });
        changeDefinition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                featureChanging = "Definition";
                changeFeature();
            }
        });
        featureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (featureChange.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "You must enter something in the text field.");
                } else {
                    if (featureChanging.equalsIgnoreCase("Term")) {
                        cards = fs.getFlashcardSet();
                        if (checkIfTermExists(featureChange.getText())) {
                            ca.setTerm(featureChange.getText());
                            initializeEditWithCard(ca);
                            editFrame.setVisible(true);
                            changeFeatureFrame.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "You already have a card with that term.");
                        }
                    } else {
                        ca.setDefinition(featureChange.getText());
                        initializeEditWithCard(ca);
                        editFrame.setVisible(true);
                        changeFeatureFrame.setVisible(false);
                    }
                    featureChange.setText("");
                }
            }
        });
        deleteCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fs.getFlashcardSet().size() == 1) {
                    JOptionPane.showMessageDialog(null, "You must have more than one card in your set to delete one.");
                } else {
                    fs.removeCard(ca);
                    frame.setVisible(true);
                    editFrame.setVisible(false);
                }
            }
        });
        cancelWithNoChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                featureChange.setText("");
                editFrame.setVisible(true);
                changeFeatureFrame.setVisible(false);
            }
        });
        discardChanges.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetCreatePanel();
            }
        });
    }

    public static void main(String[] args) {
        Flashcards userInterface = new Flashcards();
        userInterface.initializeMenu();
        userInterface.initializeMainPanel();
        frame.setContentPane(userInterface.mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 300);
        frame.setVisible(true);
        //create set panel
        userInterface.setTextFieldDimensions();
        userInterface.initializeCreatePanel();
        createFrame.setPreferredSize(new Dimension(600, 330));
        createFrame.setContentPane(userInterface.createPanel);
        createFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createFrame.setVisible(false);
        createFrame.pack();
        //select a set
        userInterface.initializeSelectingASet();
        selectSetFrame.setContentPane(userInterface.choicePanel);
        selectSetFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        selectSetFrame.pack();
        selectSetFrame.setVisible(false);
        //study
        userInterface.initializeStudyPanel();
        studyFrame.setContentPane(userInterface.studyPanel);
        studyFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        studyFrame.pack();
        studyFrame.setVisible(false);
        //edit
        userInterface.initializeEditPanel();
        editFrame.setContentPane(userInterface.editPanel);
        editFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        editFrame.pack();
        editFrame.setVisible(false);
        //pick a card
        userInterface.initializeSelectingACard();
        selectACard.setContentPane(userInterface.cardPanel);
        selectACard.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        selectACard.pack();
        selectACard.setVisible(false);
        //change feature panel
        userInterface.initializeFeaturePanel();
        changeFeatureFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        changeFeatureFrame.pack();
        changeFeatureFrame.setVisible(false);
    }

    private void initializeMainPanel() {
        Font f = setsHeading.getFont();
        setsHeading.setFont(f.deriveFont(Font.BOLD));
        averagesHeading.setFont(f.deriveFont(Font.BOLD));
        setsTextArea.setEditable(false);
        averagesTextArea.setEditable(false);
        mainPanel.add(setsHeading);
        mainPanel.add(averagesHeading);
        mainPanel.add(new JScrollPane(setsTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
        mainPanel.add(new JScrollPane(averagesTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
        mainPanel.add(createNewSet);
        mainPanel.add(editExistingSet);
        mainPanel.add(study);
    }

    private void initializeEditWithCard(Card c) {
        cardNameAndDescription.setText(c.someToStringMethod());
    }

    private void initializeMenu() {
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);
        file.add(exit);
        edit.add(editACard);
        edit.add(deleteASet);
        frame.setMenuBar(menuBar);
    }

    private void initializeSelectingACard() {
        Font f = cardLabel.getFont();
        cardsPopupPanel.setEditable(false);
        selectACard.setPreferredSize(new Dimension(350, 225));
        cardLabel.setFont(f.deriveFont(Font.BOLD));
        cardPanel.add(new JScrollPane(cardsPopupPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        cardPanel.add(cardLabel);
        cardPanel.add(cardsChoice);
    }

    private void initializeSelectingASet() {
        Font f = choiceLabel.getFont();
        sets.setText("");
        choice.setText("");
        sets.setEditable(false);
        selectSetFrame.setPreferredSize(new Dimension(350, 225));
        choiceLabel.setFont(f.deriveFont(Font.BOLD));
        choicePanel.add(new JScrollPane(sets, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        choicePanel.add(choiceLabel);
        choicePanel.add(choice);
    }

    private void initializeCreatePanel() {
        Font f = createdTermsHeader.getFont();
        setTextFieldDimensions();
        createdDefinitionsHeader.setFont(f.deriveFont(Font.BOLD));
        createdTermsHeader.setFont(f.deriveFont(Font.BOLD));
        termHeader.setFont(f.deriveFont(Font.BOLD));
        definitionHeader.setFont(f.deriveFont(Font.BOLD));
        createdTerms.setEditable(false);
        createdDefinitions.setEditable(false);
        createPanel.add(setNameHeader);
        createPanel.add(flashcardSetName);
        createPanel.add(spacer);
        createPanel.add(createdTermsHeader);
        createPanel.add(createdDefinitionsHeader);
        createPanel.add(new JScrollPane(createdTerms, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        createPanel.add(new JScrollPane(createdDefinitions, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        createPanel.add(termHeader);
        createPanel.add(definitionHeader);
        createPanel.add(newTerm);
        createPanel.add(newDefinition);
        createPanel.add(addCard);
        createPanel.add(finishSet);
        createPanel.add(discardChanges);
    }

    private void initializeStudyPanel() {
        Font f = termLabel.getFont();
        studyFrame.setPreferredSize(new Dimension(400, 300));
        termLabel.setFont(f.deriveFont(Font.BOLD));
        definitionLabel.setFont(f.deriveFont(Font.BOLD));
        studyPanel.add(termLabel);
        studyPanel.add(definitionLabel);
        studyPanel.add(term);
        studyPanel.add(definition);
        studyPanel.add(submit);
        studyPanel.add(end);
    }

    private void initializeEditPanel() {
        editPanel.add(cardNameAndDescription);
        editPanel.add(changeTerm);
        editPanel.add(changeDefinition);
        editPanel.add(deleteCard);
        editPanel.add(closeMenu);
        editFrame.setPreferredSize(new Dimension(300, 200));
    }

    private void initializeFeaturePanel() {
        changeFeatureFrame.setPreferredSize(new Dimension(230, 95));
        changeFeaturePanel.add(featureChange);
        changeFeaturePanel.add(featureButton);
        changeFeaturePanel.add(cancelWithNoChange);
        changeFeatureFrame.setContentPane(changeFeaturePanel);
    }

    private void setTextFieldDimensions() {
        flashcardSetName.setPreferredSize(new Dimension(200, 30));
        newTerm.setPreferredSize(new Dimension(255, 30));
        newDefinition.setPreferredSize(new Dimension(255, 30));
    }

    private void changeFeature() {
        changeFeatureFrame.setVisible(true);
        editFrame.setVisible(false);
    }

    private boolean checkIfTermExists(String term) {
        int c3 = 0;
        for (Card c : cards) {
            if (c.getTerm().equals(term)) {
                c3 = 1;
            }
        }
        if (c3 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void showAverages() {
        averagesTextArea.setText("");
        for (FlashcardSet f : userSets.getFlashcardSets()) {
            averagesTextArea.append(f.getAverage() + "%\n");
        }
    }

    private void editAnExistingSet() {
        if (userSets.getFlashcardSets().size() > 0) {
            mode = 1;
            frame.setVisible(false);
            selectingASet();
        } else {
            JOptionPane.showMessageDialog(null, "You must create at least one set before you can edit them.");
        }
    }

    private void selectingASet() {
        int num = 1;
        initializeSelectingASet();
        for (FlashcardSet f : userSets.getFlashcardSets()) {
            sets.append(num + ". " + f.getFlashcardSetName() + "\n");
            num++;
        }
        selectSetFrame.setVisible(true);
    }

    public void selectingACard(FlashcardSet f) {
        int i = 1;
        initializeSelectingACard();
        cardsPopupPanel.setText("");
        for (Card c : f.getFlashcardSet()) {
            cardsPopupPanel.append(i + ". " + c.someToStringMethod() + "\n");
            i++;
        }
        selectACard.setVisible(true);
    }

    private void showCreatedSets() {
        setsTextArea.setText("");
        for (FlashcardSet f : userSets.getFlashcardSets()) {
            setsTextArea.append(f.getFlashcardSetName() + "\n");
        }
    }

    private void nextCard() {
        average = numCorrect/ (float) numDone;
        termLabel.setText(fs.getCertainCard(counter).getTerm());
    }

    private void resetCreatePanel() {
        showCreatedSets();
        showAverages();
        createFrame.setVisible(false);
        createdTerms.setText("");
        createdDefinitions.setText("");
        newTerm.setText("");
        newDefinition.setText("");
        flashcardSetName.setText("");
        frame.setVisible(true);
    }

    private void startStudying(FlashcardSet fs) {
        counter = 0;
        this.fs = fs;
        studyFrame.setVisible(true);
        termLabel.setText(fs.getCertainCard(counter).getTerm());
        definition.setText("");
    }
}
