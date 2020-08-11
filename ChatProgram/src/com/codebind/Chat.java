package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class Chat {
    private JPanel panel;
    private JButton sendButton;
    private JTextField messageField1;
    private JTextField row1;
    private JTextField row2;
    private JTextField row3;
    private JTextField row4;
    private JTextField row5;
    private JTextField row6;
    private JTextField row7;
    private JTextField row8;
    private JTextField row9;
    private JTextField row10;
    private JTextField crow1;
    private JTextArea crow2;
    private JTextArea crow3;
    private JTextArea crow4;
    private JTextArea crow5;
    private JTextArea crow6;
    private JTextArea crow7;
    private JTextArea crow8;
    private JTextArea crow9;
    private JTextArea crow10;
    private static JFrame frame = new JFrame();
    private static MenuBar menuBar = new MenuBar();
    private static Menu file = new Menu("File");
    private static MenuItem switchSender = new MenuItem("Switch Recipient");
    private static MenuItem exit = new MenuItem("Exit");

    private String messageSent;
    private boolean mode;

    public Chat() {
        messageField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageSent = messageField1.getText();
                if (messageSent.length() > 10) {
                    int x = messageSent.length() / 10;
                    for (int i = 1; i <= x; i++) {
                        messageSent = messageSent.substring(0, i * 10) + "\n" + messageSent.substring(i * 10);
                    }
                }
            }
        });
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    row1.setText(row2.getText());
                    crow1.setText(crow2.getText());
                    row2.setText(row3.getText());
                    crow2.setText(crow3.getText());
                    row3.setText(row4.getText());
                    crow3.setText(crow4.getText());
                    row4.setText(row5.getText());
                    crow4.setText(crow5.getText());
                    row5.setText(row6.getText());
                    crow5.setText(crow6.getText());
                    row6.setText(row7.getText());
                    crow6.setText(crow7.getText());
                    row7.setText(row8.getText());
                    crow7.setText(crow8.getText());
                    row8.setText(row9.getText());
                    crow8.setText(crow9.getText());
                    row9.setText(row10.getText());
                    crow9.setText(crow10.getText());
                    if (mode) {
                        crow10.setText("");
                        row10.setText(messageSent);
                    } else {
                        crow10.setText(messageSent);
                        row10.setText("");
                    }
            }
        });

        switchSender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mode = !mode;
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Chat chat = new Chat();
        chat.mode = true;
        frame.setContentPane(chat.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 410);
        frame.setMenuBar(menuBar);
        menuBar.add(file);
        file.add(exit);
        file.add(switchSender);
        chat.row1.setBorder(BorderFactory.createLineBorder(Color.white));
        chat.row2.setBorder(BorderFactory.createLineBorder(Color.white));
        chat.row3.setBorder(BorderFactory.createLineBorder(Color.white));
        chat.row4.setBorder(BorderFactory.createLineBorder(Color.white));
        chat.row5.setBorder(BorderFactory.createLineBorder(Color.white));
        chat.row6.setBorder(BorderFactory.createLineBorder(Color.white));
        chat.row7.setBorder(BorderFactory.createLineBorder(Color.white));
        chat.row8.setBorder(BorderFactory.createLineBorder(Color.white));
        chat.row9.setBorder(BorderFactory.createLineBorder(Color.white));
        chat.row10.setBorder(BorderFactory.createLineBorder(Color.white));
        chat.crow1.setBorder(BorderFactory.createLineBorder(Color.white));
    }
}
