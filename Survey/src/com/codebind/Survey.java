package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Survey {

    private static JFrame surveyFrame = new JFrame("Create Survey");
    private JPanel createSurveyPanel = new JPanel();
    private JPanel takeSurveyPanel = new JPanel();
    private JPanel displayResultsPanel = new JPanel();
    //menu
    private MenuBar menuBar = new MenuBar();
    private Menu file = new Menu("File");
    private Menu options = new Menu("Options");
    private Menu help = new Menu("Help");
    private Menu createSurveyOptions = new Menu("Creating Survey");
    private Menu takeSurveyOptions = new Menu("Taking Survey");
    private MenuItem exit = new MenuItem("Exit");
    private MenuItem reset = new MenuItem("Reset Survey");
    private MenuItem takeSurvey = new MenuItem("Take Survey");
    private MenuItem endSurvey = new MenuItem("End Survey");
    private MenuItem createAnotherSurvey = new MenuItem("Create Another Survey");
    //create survey
    private JTextArea createdQuestions = new JTextArea(10, 40);
    private JLabel questionLabel = new JLabel("Question:                                   ");
    private JLabel choiceALabel = new JLabel("    Choice A:                                    ");
    private JLabel choiceBLabel = new JLabel("Choice B:                                        ");
    private JLabel choiceCLabel = new JLabel("Choice C:                                   ");
    private JTextField question = new JTextField(17);
    private JTextField choiceA = new JTextField(17);
    private JTextField choiceB = new JTextField(17);
    private JTextField choiceC = new JTextField(17);
    private JButton addQuestion = new JButton("Add Question");
    //take survey
    private JLabel questionAsking = new JLabel("", SwingConstants.CENTER);
    private JButton choiceAButton = new JButton();
    private JButton choiceBButton = new JButton();
    private JButton choiceCButton = new JButton();
    private JButton skip = new JButton("Skip Question");
    //display results
    private JLabel answeredA = new JLabel("", SwingConstants.CENTER);
    private JLabel answeredB = new JLabel("", SwingConstants.CENTER);
    private JLabel answeredC = new JLabel("", SwingConstants.CENTER);
    private JLabel unanswered = new JLabel("", SwingConstants.CENTER);

    private int questionNum = -1;
    private int aCount = 0;
    private int bCount = 0;
    private int cCount = 0;
    //1 is create survey, 2 is take survey, 3 is display results
    private int mode = 1;
    private ArrayList<Question> surveyQuestions = new ArrayList<>();

    public Survey() {
        //menu items
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mode == 1) {
                    surveyQuestions.clear();
                    createdQuestions.setText("");
                    resetQuestionCreater();
                }
            }
        });
        takeSurvey.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (surveyQuestions.size() < 1) {
                    JOptionPane.showMessageDialog(null, "You must create at least one question before you can take the survey.");
                } else {
                    if (mode == 1) {
                        initializeTakeSurvey();
                    }
                }
            }
        });
        createAnotherSurvey.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                beginAgain();
            }
        });
        endSurvey.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mode == 2) {
                    displayResults();
                }
            }
        });
        //create survey
        addQuestion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (question.getText().equalsIgnoreCase("") || choiceA.getText().equalsIgnoreCase("") ||
                choiceB.getText().equalsIgnoreCase("") || choiceC.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "You must enter a question and three answer choices. Make sure all blanks are filled.");
                } else if (choiceA.getText().equalsIgnoreCase(choiceB.getText()) || choiceA.getText().equalsIgnoreCase(choiceC.getText()) ||
                        choiceB.getText().equalsIgnoreCase(choiceC.getText())) {
                    JOptionPane.showMessageDialog(null, "Each answer must be unique.");
                } else if (checkIfQuestionExists(question.getText())) {
                    JOptionPane.showMessageDialog(null, "You have already asked that question.");
                    resetQuestionCreater();
                } else {
                    surveyQuestions.add(new Question(question.getText(), choiceA.getText(), choiceB.getText(), choiceC.getText()));
                    createdQuestions.append(question.getText() + "\n");
                    resetQuestionCreater();
                }
            }
        });
        //take survey
        choiceAButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                surveyQuestions.get(questionNum).setChosenAnswer("A");
                aCount++;
                nextQuestionOrEndSurvey();
            }
        });
        choiceBButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                surveyQuestions.get(questionNum).setChosenAnswer("B");
                bCount++;
                nextQuestionOrEndSurvey();
            }
        });
        choiceCButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                surveyQuestions.get(questionNum).setChosenAnswer("C");
                cCount++;
                nextQuestionOrEndSurvey();
            }
        });
        skip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextQuestionOrEndSurvey();
            }
        });
    }

    public static void main(String[] args) {
        Survey survey = new Survey();
        surveyFrame.setContentPane(survey.createSurveyPanel);
        surveyFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        surveyFrame.setPreferredSize(new Dimension(500, 400));
        surveyFrame.pack();
        survey.initializeMenu();
        survey.initializeCreateSurvey();
        surveyFrame.setVisible(true);
    }

    private boolean checkIfQuestionExists(String question) {
        for (Question q : surveyQuestions) {
            if (q.getQuestion().equalsIgnoreCase(question)) {
                return true;
            }
        }
        return false;
    }

    //resets everything to start from the beginning
    private void beginAgain() {
        mode = 1;
        questionNum = -1;
        aCount = 0;
        bCount = 0;
        cCount = 0;
        surveyQuestions.clear();
        createdQuestions.setText("");
        resetQuestionCreater();
        surveyFrame.setTitle("Create Survey");
        setUpOrCleanupCreatePanel(true);
        surveyFrame.setContentPane(createSurveyPanel);
    }

    private void setUpOrCleanupCreatePanel(Boolean b) {
        createdQuestions.setVisible(b);
        questionLabel.setVisible(b);
        choiceALabel.setVisible(b);
        choiceA.setVisible(b);
        question.setVisible(b);
        choiceBLabel.setVisible(b);
        choiceCLabel.setVisible(b);
        choiceB.setVisible(b);
        choiceC.setVisible(b);
        addQuestion.setVisible(b);
    }

    //displaying the results
    private void displayResults() {
        mode = 3;
        surveyFrame.setTitle("Survey Results");
        questionAsking.setVisible(false);
        choiceAButton.setVisible(false);
        choiceBButton.setVisible(false);
        choiceCButton.setVisible(false);
        skip.setVisible(false);
        initializeDisplayResults();
        showResults();
        surveyFrame.setContentPane(displayResultsPanel);
    }

    private void showResults() {
        int unansweredQuestions = surveyQuestions.size() - (aCount + bCount + cCount) ;
        answeredA.setText("You answered A " + aCount + " " + plurality("time", aCount) + ".");
        answeredB.setText("You answered B " + bCount + " " + plurality("time", bCount) + ".");
        answeredC.setText("You answered C " + cCount + " " + plurality("time", cCount) + ".");
        unanswered.setText("You left " + unansweredQuestions + " " + plurality("question", unansweredQuestions) + " unanswered.");
    }

    private String plurality(String notPlural, int count) {
        if (count == 1) {
            return notPlural;
        } else {
            return notPlural + "s";
        }
    }

    //taking the survey
    private void nextQuestionOrEndSurvey() {
        if (questionNum + 1 == surveyQuestions.size()) {
            displayResults();
        } else {
            nextQuestion();
        }
    }

    private void nextQuestion() {
        questionNum++;
        questionAsking.setText(surveyQuestions.get(questionNum).getQuestion());
        choiceAButton.setText(surveyQuestions.get(questionNum).getChoiceA());
        choiceBButton.setText(surveyQuestions.get(questionNum).getChoiceB());
        choiceCButton.setText(surveyQuestions.get(questionNum).getChoiceC());
    }

    //creating the survey
    private void resetQuestionCreater() {
        question.setText("");
        choiceA.setText("");
        choiceB.setText("");
        choiceC.setText("");
    }

    //initializing displays
    private void initializeDisplayResults() {
        answeredA.setPreferredSize(new Dimension(surveyFrame.getPreferredSize().width, 15));
        answeredB.setPreferredSize(new Dimension(surveyFrame.getPreferredSize().width, 15));
        answeredC.setPreferredSize(new Dimension(surveyFrame.getPreferredSize().width, 15));
        unanswered.setPreferredSize(new Dimension(surveyFrame.getPreferredSize().width, 15));
        answeredA.setVisible(true);
        answeredB.setVisible(true);
        answeredC.setVisible(true);
        unanswered.setVisible(true);
        displayResultsPanel.add(answeredA);
        displayResultsPanel.add(answeredB);
        displayResultsPanel.add(answeredC);
        displayResultsPanel.add(unanswered);
    }

    private void initializeTakeSurvey() {
        mode = 2;
        setUpOrCleanupCreatePanel(false);
        surveyFrame.setTitle("Take Survey");
        questionAsking.setVisible(true);
        choiceAButton.setVisible(true);
        choiceBButton.setVisible(true);
        choiceCButton.setVisible(true);
        skip.setVisible(true);
        questionAsking.setPreferredSize(new Dimension(surveyFrame.getPreferredSize().width, 15));
        takeSurveyPanel.add(questionAsking);
        takeSurveyPanel.add(choiceAButton);
        takeSurveyPanel.add(choiceBButton);
        takeSurveyPanel.add(choiceCButton);
        takeSurveyPanel.add(skip);
        nextQuestion();
        surveyFrame.setContentPane(takeSurveyPanel);
    }

    private void initializeCreateSurvey() {
        createdQuestions.setEditable(false);
        createSurveyPanel.add(new JScrollPane(createdQuestions, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        createSurveyPanel.add(questionLabel);
        createSurveyPanel.add(choiceALabel);
        createSurveyPanel.add(question);
        createSurveyPanel.add(choiceA);
        createSurveyPanel.add(choiceBLabel);
        createSurveyPanel.add(choiceCLabel);
        createSurveyPanel.add(choiceB);
        createSurveyPanel.add(choiceC);
        createSurveyPanel.add(addQuestion);
    }

    private void initializeMenu() {
        menuBar.add(file);
        menuBar.add(options);
        menuBar.add(help);
        file.add(exit);
        options.add(createSurveyOptions);
        options.add(takeSurveyOptions);
        options.add(createAnotherSurvey);
        createSurveyOptions.add(reset);
        createSurveyOptions.add(takeSurvey);
        takeSurveyOptions.add(endSurvey);
        surveyFrame.setMenuBar(menuBar);
    }

}
