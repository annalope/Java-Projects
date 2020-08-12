package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;

public class EbookReader {
    private JTextArea page;
    private JPanel pagePanel;
    private JPanel wholePanel;
    private JPanel buttonPanels;
    private JButton firstPageButton;
    private JButton previousPageButton;
    private JButton nextPageButton;
    private JButton lastPageButton;
    private static JFrame frame = new JFrame();
    private static MenuBar menuBar = new MenuBar();
    private static Menu file = new Menu("File");
    private static Menu bookmark = new Menu("Bookmark");
    private static MenuItem exit = new MenuItem("Exit");
    private static MenuItem bookmarkThisPage = new MenuItem("Bookmark this page");
    private static MenuItem goToBookmarkedPage = new MenuItem("Go to bookmark");
    private int pageNumber = 1;
    private int bookMarkPageNumber = 1;
    //pages
    private String pg1;
    private String pg2;
    private String pg3;
    private String pg4;
    private String pg5;
    private String pg6;
    private String pg7;
    private String pg8;
    private String pg9;
    private String pg10;
    private String pg11;
    private String pg12;
    private String pg13;
    private String pg14;
    private String pg15;
    private String pg16;

    public EbookReader() {
        firstPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pageNumber = 1;
                setPage(pageNumber);
            }
        });
        previousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pageNumber != 1) {
                    pageNumber -= 1;
                    setPage(pageNumber);
                }
            }
        });
        nextPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pageNumber != 16) {
                    pageNumber += 1;
                    setPage(pageNumber);
                }
            }
        });
        lastPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pageNumber = 16;
                setPage(pageNumber);
            }
        });
        goToBookmarkedPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pageNumber = bookMarkPageNumber;
                setPage(pageNumber);
            }
        });
        bookmarkThisPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookMarkPageNumber = pageNumber;
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
        EbookReader ebookReader = new EbookReader();
        JPanel app = new JPanel();
        Dimension preferredSize = new Dimension();
        preferredSize.height = 600;
        preferredSize.width = 775;
        ebookReader.pagePanel.setPreferredSize(preferredSize);
        ebookReader.page.setLineWrap(true);
        ebookReader.page.setWrapStyleWord(true);
        app.add(ebookReader.pagePanel);
        app.add(ebookReader.buttonPanels);
        frame.setContentPane(app);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(900, 700);
        frame.setMenuBar(menuBar);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuBar.add(file);
        menuBar.add(bookmark);
        file.add(exit);
        bookmark.add(bookmarkThisPage);
        bookmark.add(goToBookmarkedPage);
        ebookReader.initializePages();
        ebookReader.page.setText(ebookReader.pg1);
    }

    private void setPage(int pgNum) {
        switch (pgNum) {
            case (1):
                page.setText(pg1);
                break;
            case (2):
                page.setText(pg2);
                break;
            case (3):
                page.setText(pg3);
                break;
            case (4):
                page.setText(pg4);
                break;
            case (5):
                page.setText(pg5);
                break;
            case (6):
                page.setText(pg6);
                break;
            case (7):
                page.setText(pg7);
                break;
            case (8):
                page.setText(pg8);
                break;
            case (9):
                page.setText(pg9);
                break;
            case (10):
                page.setText(pg10);
                break;
            case (11):
                page.setText(pg11);
                break;
            case (12):
                page.setText(pg12);
                break;
            case (13):
                page.setText(pg13);
                break;
            case (14):
                page.setText(pg14);
                break;
            case (15):
                page.setText(pg15);
                break;
            default:
                page.setText(pg16);
                break;
        }
    }

    private void initializePages() {
        Font font = page.getFont();
        page.setFont(font.deriveFont((float) 9.0));
        page.setForeground(Color.BLACK);
        page.setBackground(buttonPanels.getBackground());
        pg1 = readFile("pg1.txt");
        pg2 = readFile("pg2.txt");
        pg3 = readFile("pg3.txt");
        pg4 = readFile("pg4.txt");
        pg5 = readFile("pg5.txt");
        pg6 = readFile("pg6.txt");
        pg7 = readFile("pg7.txt");
        pg8 = readFile("pg8.txt");
        pg9 = readFile("pg9.txt");
        pg10 = readFile("pg10.txt");
        pg11 = readFile("pg11.txt");
        pg12 = readFile("pg12.txt");
        pg13 = readFile("pg13.txt");
        pg14 = readFile("pg14.txt");
        pg15 = readFile("pg15.txt");
        pg16 = readFile("pg16.txt");
    }

    private String readFile(String filename) {
        try {
            String data = "";
            FileReader fr = new FileReader(filename);
            int i;
            while ((i = fr.read()) != -1) {
                data += ((char) i);
            }
            fr.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
