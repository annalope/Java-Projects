import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.lang.Math;

public class TypingTest {

    private static JFrame frame = new JFrame("Typing Test");
    private JPanel typingPanel = new JPanel();
    private JLabel instructions1 = new JLabel("To begin the test, press the start button below.");
    private JLabel instructions2 = new JLabel("Hit the reset button to end the test early.");
    private JLabel instructions3 = new JLabel("You have one minute to type the sentence");
    private JLabel instructions4 = new JLabel("as many times as you can. Good luck.");
    private JLabel line = new JLabel("--------------------------------------------------------");
    private JLabel sentenceToType = new JLabel("The quick brown fox jumped over the lazy dog.");
    private JTextArea wordBank = new JTextArea(10, 27);
    private JButton startButton = new JButton("Start");
    private JButton resetButton = new JButton("Reset");
    private JLabel secLeftPrompt = new JLabel("Seconds Left:");
    public static JLabel secondsLeft = new JLabel("60");


    private TimerTask task;
    private TimerTask task2;

    public TypingTest() {
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordBank.setEditable(false);
                wordBank.setText("");
                secondsLeft.setText("60");
                task.cancel();
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickRandomSentence();
                wordBank.setEditable(true);
                wordBank.setText("");
                secondsLeft.setText("60");

                Timer timer = new Timer();
                task = new TimerTask() {
                    @Override
                    public void run() {
                        String words;
                        if (calculateWPM() == 1) {
                            words = " word ";
                        } else {
                            words = " words ";
                        }

                        String finalCount = "You typed " + calculateWPM() + words + "correctly in 60 seconds.";
                        JOptionPane.showMessageDialog(null, finalCount);
                        wordBank.setEditable(false);
                    }
                };

                updateSecondsCountdown();
                timer.schedule(task, 60000);
            }
        });
    }

    public static void main(String[] args) {
        TypingTest ty = new TypingTest();
        ty.initializeDisplay();
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(ty.typingPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateSecondsCountdown() {
        Timer t2 = new Timer();
        task2 = new TimerTask() {
            int secLeft = 59;
            @Override
            public void run() {
                String sec = String.valueOf(secLeft);
                if (secLeft < 10) {
                    sec = "0" + sec;
                }
                secondsLeft.setText(sec);
                secLeft-= 1;

                if (secLeft < 0) {
                    task2.cancel();
                }
            }
        };

        t2.schedule(task2, 1000, 1000);
    }

    private int calculateWPM() {
        String[] correctWords = sentenceToType.getText().split(" ");
        String[] typedWords = wordBank.getText().split(" ");
        double repeats = Math.ceil(typedWords.length / (double) correctWords.length);
        ArrayList<String> repeated = new ArrayList<>(2);
        int correctWordCount = 0;

        for (int j = 0; j < repeats; j++) {
            for (int x = 0; x < correctWords.length; x++) {
                repeated.add(correctWords[x]);
            }
        }

        for (int i = 0; i < typedWords.length; i++) {
            if (repeated.get(i).equals(typedWords[i])) {
                correctWordCount++;
            }
        }

        return correctWordCount;
    }

    private void pickRandomSentence() {
        Random r = new Random();
        String[] sentences = new String[10];
        sentences[0] = "The quick brown fox jumped over the lazy dog.";
        sentences[1] = "The small boy went down to the apple orchard.";
        sentences[2] = "The teacher asked the class if anyone knew the answer.";
        sentences[3] = "The spry owl flew down from the top of the tree.";
        sentences[4] = "The musician jumped off the edge of the stage.";
        sentences[5] = "The math test was extremely hard for most of the students.";
        sentences[6] = "The computer program took too long to finish.";
        sentences[7] = "The car wash was postponed to next weekend instead.";
        sentences[8] = "The backpack was on sale for half its regular price.";
        sentences[9] = "The water spilled all over the student's history report.";
        int num = r.nextInt(9);
        sentenceToType.setText(sentences[num]);
    }

    private void initializeDisplay() {
        instructions1.setForeground(Color.BLUE);
        instructions2.setForeground(Color.BLUE);
        instructions3.setForeground(Color.BLUE);
        instructions4.setForeground(Color.BLUE);
        sentenceToType.setForeground(Color.RED);
        secondsLeft.setForeground(Color.RED);
        pickRandomSentence();
        wordBank.setEditable(false);
        wordBank.setLineWrap(true);
        typingPanel.add(instructions1);
        typingPanel.add(instructions2);
        typingPanel.add(instructions3);
        typingPanel.add(instructions4);
        typingPanel.add(line);
        typingPanel.add(sentenceToType);
        typingPanel.add(new JScrollPane(wordBank, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        typingPanel.add(startButton);
        typingPanel.add(resetButton);
        typingPanel.add(secLeftPrompt);
        typingPanel.add(secondsLeft);
    }
}