package com.codebind;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.io.PrintWriter;

public class GoogleDocs {
    //main form
    private static JFrame frame = new JFrame("Google Docs");
    private JPanel textPanel = new JPanel();
    private JTextPane defaultt = new JTextPane();
    //menubar
    private MenuBar menuBar = new MenuBar();
    private Menu file = new Menu("File");
    private Menu edit = new Menu("Edit");
    private Menu insert = new Menu("Insert");
    private Menu help = new Menu("Help");
    private MenuItem exit = new MenuItem("Exit");
    private MenuItem save = new MenuItem("Download Text File");
    private MenuItem print = new MenuItem("Print");
    private MenuItem undo = new MenuItem("Undo Typing");
    private MenuItem textFo = new MenuItem("Text Formatting");
    private MenuItem specialCharacters = new MenuItem("Special Characters");
    //text and popup menu
    private JTextArea text = new JTextArea(40, 50);
    private JMenuItem delete = new JMenuItem("Delete Text");
    private JMenuItem copy = new JMenuItem("Copy");
    private JMenuItem paste = new JMenuItem("Paste");
    private JMenuItem reset = new JMenuItem("Reset");
    private JMenuItem textFormat = new JMenuItem("Text Format Menu");

    //variables
    private float currentFontSize = (float) 10.0;
    private boolean isBold = false;
    private boolean boldTemp = false;
    private boolean isItalicized = false;
    private boolean italicsTemp = false;
    private boolean isBulletList = false;
    private boolean bullTemp = false;
    private Color fontColor = text.getForeground();
    private Color tempColor = text.getForeground();
    private String fontName = text.getFont().getFontName();
    private String tempFont = text.getFont().getFontName();
    private String previousText = text.getText();
    private String nowText = text.getText();
    private int counter = 0;
    private int c2 = 0;


    //text formatting form
    private static JFrame textFormatFrame = new JFrame("Text Formatting");
    private JPanel wholeThing = new JPanel();
    private JPanel sizePanel = new JPanel();
    private JLabel size = new JLabel("Size:");
    private JTextField textSize = new JTextField(currentFontSize + "");
    private JButton increase = new JButton("Increase Size");
    private JButton decrease = new JButton("Decrease Size");
    private JPanel colorPane = new JPanel();
    private JLabel color = new JLabel("Color:");
    private JColorChooser colorChooser = new JColorChooser();
    private JPanel fontPanel = new JPanel();
    private JLabel chooseFont = new JLabel("Font:");
    private JComboBox fonts = new JComboBox();
    private JPanel otherFormats = new JPanel();
    private JLabel otherFormatting = new JLabel("Other Formatting Options:");
    private JCheckBox italics = new JCheckBox("Italics");
    private JCheckBox bold = new JCheckBox("Bold");
    private JCheckBox bulletList = new JCheckBox("Bulleted List");
    private JButton textFormatSave = new JButton("Save Changes");
    private JButton cancel = new JButton("Cancel");

    //download frame
    private static JFrame downloadFrame = new JFrame("Download Configuration");
    private JPanel dPanel = new JPanel();
    private JLabel nameLabel = new JLabel("Name of your file:");
    private JTextField nameFile = new JTextField("", 20);
    private JButton downloadIt = new JButton("Download");
    private char c = 247;

    //special characters form
    private static JFrame specialCharactersFrame = new JFrame("Special Characters");
    private JPanel charPanel = new JPanel();
    private JLabel mathSym = new JLabel("  Math & Symbols  ");
    private JLabel uppercase = new JLabel("  Uppercase Letters");
    private JLabel lowercase = new JLabel("   Lowercase Letters");
    private JLabel space = new JLabel("       ");
    private JLabel s2 = new JLabel("       ");
    private JButton divide = new JButton(String.valueOf(c));
    private JButton pound = new JButton(String.valueOf(c = 163));
    private JButton acuteCapitalA = new JButton(String.valueOf(c = 193));
    private JButton diaeresesCapitalA = new JButton(String.valueOf(c = 196));
    private JButton acuteSmallA = new JButton(String.valueOf(c = 225));
    private JButton diaeresesSmallA = new JButton(String.valueOf(c = 228));
    private JButton copyright = new JButton(String.valueOf(c = 169));
    private JButton plusOrMinus = new JButton(String.valueOf(c = 177));
    private JButton circumflexCapitalA = new JButton(String.valueOf(c = 194));
    private JButton ringCapitalA = new JButton(String.valueOf(c = 197));
    private JButton circumflexSmallA = new JButton(String.valueOf(c = 226));
    private JButton ringSmallA = new JButton(String.valueOf(c = 229));
    private JButton centSign = new JButton(String.valueOf(c = 162));
    private JButton paragraphSign = new JButton(String.valueOf(c = 182));
    private JButton cedillaCapital = new JButton(String.valueOf(c = 199));
    private JButton acuteCapitalE = new JButton(String.valueOf(c = 201));
    private JButton cedillaSmall = new JButton(String.valueOf(c = 231));
    private JButton acuteSmallE = new JButton(String.valueOf(c = 233));
    private JButton euroSign = new JButton(String.valueOf(c = 128));
    private JButton upsideDownQuestion = new JButton(String.valueOf(c = 191));
    private JButton diaeresesCapitalE = new JButton(String.valueOf(c = 203));
    private JButton circumflexCapitalE = new JButton(String.valueOf(c = 202));
    private JButton diaeresesSmallE = new JButton(String.valueOf(c = 235));
    private JButton circumflexSmallE = new JButton(String.valueOf(c = 234));
    private JButton yen = new JButton(String.valueOf(c = 165));
    private JButton degree = new JButton(String.valueOf(c = 176));
    private JButton acuteCapitalI = new JButton(String.valueOf(c = 205));
    private JButton diaeresesCapitalI = new JButton(String.valueOf(c = 207));
    private JButton acuteSmallI = new JButton(String.valueOf(c = 237));
    private JButton diaeresesSmallI = new JButton(String.valueOf(c = 239));
    private JButton multiplication = new JButton(String.valueOf(c = 215));
    private JButton leftDoubleAngleQuotes = new JButton(String.valueOf(c = 171));
    private JButton tildeCapitalN = new JButton(String.valueOf(c = 209));
    private JButton diaeresesCapitalO = new JButton(String.valueOf(c = 214));
    private JButton tildeSmallN = new JButton(String.valueOf(c = 241));
    private JButton diaeresesSmallO = new JButton(String.valueOf(c = 246));
    private JButton rightDoubleAngleQuotes = new JButton(String.valueOf(c = 187));
    private JButton notSign = new JButton(String.valueOf(c = 172));
    private JButton tildeCapitalO = new JButton(String.valueOf(c = 213));
    private JButton diaeresesCapitalU = new JButton(String.valueOf(c = 220));
    private JButton tildeSmallO = new JButton(String.valueOf(c = 245));
    private JButton diaeresesSmallU = new JButton(String.valueOf(c = 252));
    private JButton pipe = new JButton(String.valueOf(c = 166));
    private JButton registeredTrademark = new JButton(String.valueOf(c = 174));
    private JButton acuteCapitalU = new JButton(String.valueOf(c = 218));
    private JButton acuteCapitalY = new JButton(String.valueOf(c = 221));
    private JButton acuteSmallU = new JButton(String.valueOf(c = 250));
    private JButton acuteSmallY = new JButton(String.valueOf(c = 253));
    private JButton closeSpecialCharacters = new JButton("Close");



    public GoogleDocs() {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        delete.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                text.setText("");
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        copy.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                StringSelection stringSelection = new StringSelection(text.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        paste.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                try {
                    text.setText(text.getText() + clipboard.getData(DataFlavor.stringFlavor));
                } catch (Exception ef) {
                    JOptionPane.showMessageDialog(null, "There is nothing in your clipboard to paste.");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        reset.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Font font = defaultt.getFont();
                text.setFont(font);
                text.setForeground(Color.BLACK);
                fontColor = Color.BLACK;
                currentFontSize = (float) 10.0;
                isBold = false;
                isBulletList = false;
                isItalicized = false;
                bullTemp = false;
                textSize.setText(currentFontSize + "");
                fontName = defaultt.getFont().getFontName();
                text.setText("");
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        textFormat.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                openTextMenu();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFormatFrame.setVisible(false);
            }
        });
        decrease.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font font = text.getFont();
                if (currentFontSize <= 1) {
                    JOptionPane.showMessageDialog(null, "That is the minimum font size.");
                } else {
                    currentFontSize--;
                }
                textSize.setText(currentFontSize + "");
            }
        });
        increase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentFontSize >= 100) {
                    JOptionPane.showMessageDialog(null, "That is the maximum font size.");
                } else {
                    currentFontSize++;
                }
                textSize.setText(currentFontSize + "");
            }
        });
        textFo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTextMenu();
            }
        });

        textSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Float.parseFloat(textSize.getText()) > 100.0) {
                        JOptionPane.showMessageDialog(null, "That is above the maximum size limit.");
                        textSize.setText(currentFontSize + "");
                    } else if (Float.parseFloat(textSize.getText()) < 1.0) {
                        JOptionPane.showMessageDialog(null, "That is below the minimum size limit.");
                        textSize.setText(currentFontSize + "");
                    } else {
                        currentFontSize = Float.parseFloat((textSize.getText()));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "That is not a valid size input.");
                    textSize.setText(currentFontSize + "");
                }
            }
        });
        italics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                italicsTemp = !italicsTemp;
            }
        });
        bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boldTemp = !boldTemp;
            }
        });
        text.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && isBulletList) {
                    text.setText(text.getText() + "  -");
                }
            }
        });
        bulletList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bullTemp = !bullTemp;
            }
        });
        colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tempColor = colorChooser.getColor();
            }
        });
        textFormatSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font f = text.getFont();
                fontName = tempFont;
                text.setFont(f.deriveFont(currentFontSize));
                text.setForeground(tempColor);
                fontColor = tempColor;
                isItalicized = italicsTemp;
                isBold = boldTemp;
                applyFontChanges();
                isBulletList = bullTemp;
                textFormatFrame.setVisible(false);
            }
        });
        fonts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempFont = String.valueOf(fonts.getSelectedItem());
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downloadFrame.setVisible(true);

            }
        });
        text.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                c2 = 0;
                if (counter == 0) {
                    nowText = text.getText();
                    counter++;
                } else {
                    previousText = nowText;
                    nowText = text.getText();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                c2 = 0;
                if (counter == 0) {
                    nowText = text.getText();
                    counter++;
                } else {
                    previousText = nowText;
                    nowText = text.getText();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                c2 = 0;
                if (counter == 0) {
                    nowText = text.getText();
                    counter++;
                } else {
                    previousText = nowText;
                    nowText = text.getText();
                }
            }
        });
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (c2 == 0) {
                    text.setText(previousText);
                    c2 = 1;
                } else {
                    JOptionPane.showMessageDialog(null, "That is the maximum number of undoes you can do.");
                }
            }
        });
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
                    PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
                    PrintRequestAttributeSet attrib = new HashPrintRequestAttributeSet();
                    PrintService selectedPrintService = ServiceUI.printDialog(null, 150, 150, printServices, defaultPrintService, null, attrib);
                    if (selectedPrintService != null) {
                        DocPrintJob job = selectedPrintService.createPrintJob();
                        job.addPrintJobListener(new PrintJobAdapter() {
                            @Override
                            public void printDataTransferCompleted(PrintJobEvent pje) {
                                super.printDataTransferCompleted(pje);
                            }
                        });
                        Doc doc = new SimpleDoc(text.getText(), DocFlavor.STRING.TEXT_PLAIN, null);
                        PrintRequestAttributeSet printSet = new HashPrintRequestAttributeSet();
                        printSet.add(new Copies(1));
                        job.print(doc, printSet);
                    } else {
                        JOptionPane.showMessageDialog(null, "Print job cancelled.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Could not print at this time.");
                }
            }
        });
        downloadIt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameFile.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Please enter an input for the file name.");
                } else {
                    try {
                        PrintWriter printWriter = new PrintWriter(nameFile.getText());
                        printWriter.println(text.getText());
                        printWriter.close();
                    } catch (Exception ef) {
                        JOptionPane.showMessageDialog(null, "Error: Could not download.");
                    }
                    downloadFrame.setVisible(false);
                }
            }
        });
        specialCharacters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialCharactersFrame.setVisible(true);
            }
        });
        closeSpecialCharacters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialCharactersFrame.setVisible(false);
            }
        });
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(divide.getText());
            }
        });
        pound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(pound.getText());
            }
        });
        acuteCapitalA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(acuteCapitalA.getText());
            }
        });
        diaeresesCapitalA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(diaeresesCapitalA.getText());
            }
        });
        acuteSmallA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(acuteSmallA.getText());
            }
        });
        diaeresesSmallA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(diaeresesSmallA.getText());
            }
        });
        copyright.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(copyright.getText());
            }
        });
        plusOrMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(plusOrMinus.getText());
            }
        });
        circumflexCapitalA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(circumflexCapitalA.getText());
            }
        });
        ringCapitalA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(ringCapitalA.getText());
            }
        });
        circumflexSmallA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(circumflexSmallA.getText());
            }
        });
        ringSmallA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(ringSmallA.getText());
            }
        });
        centSign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(centSign.getText());
            }
        });
        paragraphSign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(paragraphSign.getText());
            }
        });
        cedillaCapital.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(cedillaCapital.getText());
            }
        });
        acuteCapitalE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(acuteCapitalE.getText());
            }
        });
        cedillaSmall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(cedillaSmall.getText());
            }
        });
        acuteSmallE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(acuteSmallE.getText());
            }
        });
        euroSign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(euroSign.getText());
            }
        });
        upsideDownQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(upsideDownQuestion.getText());
            }
        });
        diaeresesCapitalE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(diaeresesCapitalE.getText());
            }
        });
        circumflexCapitalE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(circumflexCapitalE.getText());
            }
        });
        diaeresesSmallE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(diaeresesSmallE.getText());
            }
        });
        circumflexSmallE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(circumflexSmallE.getText());
            }
        });
        yen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(yen.getText());
            }
        });
        degree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(degree.getText());
            }
        });
        acuteCapitalI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(acuteCapitalI.getText());
            }
        });
        diaeresesCapitalI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(diaeresesCapitalI.getText());
            }
        });
        acuteSmallI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(acuteSmallI.getText());
            }
        });
        diaeresesSmallI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(diaeresesSmallI.getText());
            }
        });
        multiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(multiplication.getText());
            }
        });
        leftDoubleAngleQuotes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(leftDoubleAngleQuotes.getText());
            }
        });
        tildeCapitalN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(tildeCapitalN.getText());
            }
        });
        diaeresesCapitalO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(diaeresesCapitalO.getText());
            }
        });
        tildeSmallN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(tildeSmallN.getText());
            }
        });
        diaeresesSmallO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(diaeresesSmallO.getText());
            }
        });
        rightDoubleAngleQuotes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(rightDoubleAngleQuotes.getText());
            }
        });
        notSign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(notSign.getText());
            }
        });
        tildeCapitalO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(tildeCapitalO.getText());
            }
        });
        diaeresesCapitalU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(diaeresesCapitalU.getText());
            }
        });
        tildeSmallO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(tildeSmallO.getText());
            }
        });
        diaeresesSmallU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(diaeresesSmallU.getText());
            }
        });
        pipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(pipe.getText());
            }
        });
        registeredTrademark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(registeredTrademark.getText());
            }
        });
        acuteCapitalU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(acuteCapitalU.getText());
            }
        });
        acuteCapitalY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(acuteCapitalY.getText());
            }
        });
        acuteSmallU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(acuteSmallU.getText());
            }
        });
        acuteSmallY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertASpecialCharacter(acuteSmallY.getText());
            }
        });
    }

    private void insertASpecialCharacter(String character) {
        text.setText(text.getText() + character);
    }

    private void applyFontChanges() {
        Font font;
        int style;
        int temp = Math.round(currentFontSize);
        if(isBold && isItalicized){
            style = Font.BOLD + Font.ITALIC;
        } else if(isBold){
            style = Font.BOLD;
        } else if(isItalicized){
            style = Font.ITALIC;
        } else {
            style = Font.PLAIN;
        }

        font = new Font(fontName, style, temp);
        text.setFont(font);
    }

    public static void main(String[] args) {
        GoogleDocs googleDocs = new GoogleDocs();
        System.out.print(googleDocs.c);
        Font font = googleDocs.text.getFont();
        Dimension dimension = new Dimension(700, 700);
        googleDocs.textPanel.add(new JScrollPane(googleDocs.text));
        googleDocs.setMenuThings();
        googleDocs.initializeFontOptions();
        googleDocs.text.setLineWrap(true);
        googleDocs.text.setFont(font.deriveFont((float) 10.0));
        frame.setContentPane(googleDocs.textPanel);
        frame.setPreferredSize(dimension);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        googleDocs.intializeTextFormat();
        googleDocs.initializeDownloadPanel();
        googleDocs.initializeSpecialCharacters();
    }

    private void initializeDownloadPanel() {
        dPanel.add(nameLabel);
        dPanel.add(nameFile);
        dPanel.add(downloadIt);
        downloadFrame.setContentPane(dPanel);
        downloadFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        downloadFrame.pack();
        downloadFrame.setVisible(false);
    }

    private void openTextMenu() {
        textFormatFrame.setVisible(true);
        italics.setSelected(isItalicized);
        bulletList.setSelected(isBulletList);
        bold.setSelected(isBold);
        colorChooser.setColor(fontColor);
        fonts.setSelectedItem(fontName);
    }


    class PopUp extends JPopupMenu {
        public PopUp() {
            add(delete);
            add(copy);
            add(paste);
            add(reset);
            add(textFormat);
        }
    }

    class PopClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (e.isPopupTrigger())
                doPop(e);
        }

        public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger())
                doPop(e);
        }

        private void doPop(MouseEvent e) {
            PopUp menu = new PopUp();
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    private void setMenuThings() {
        frame.setMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(insert);
        menuBar.add(help);
        file.add(exit);
        file.add(save);
        file.add(print);
        edit.add(undo);
        edit.add(textFo);
        insert.add(specialCharacters);
        textPanel.addMouseListener(new PopClickListener());
    }

    private void initializeSpecialCharacters() {
        Dimension d = new Dimension(500, 350);
        charPanel.add(mathSym);
        charPanel.add(s2);
        uppercase.setForeground(Color.BLUE);
        charPanel.add(uppercase);
        charPanel.add(space);
        charPanel.add(lowercase);
        charPanel.add(divide);
        charPanel.add(pound);
        acuteCapitalA.setForeground(Color.BLUE);
        charPanel.add(acuteCapitalA);
        diaeresesCapitalA.setForeground(Color.BLUE);
        charPanel.add(diaeresesCapitalA);
        charPanel.add(acuteSmallA);
        charPanel.add(diaeresesSmallA);
        charPanel.add(copyright);
        charPanel.add(plusOrMinus);
        circumflexCapitalA.setForeground(Color.BLUE);
        charPanel.add(circumflexCapitalA);
        ringCapitalA.setForeground(Color.BLUE);
        charPanel.add(ringCapitalA);
        charPanel.add(circumflexSmallA);
        charPanel.add(ringSmallA);
        charPanel.add(centSign);
        charPanel.add(paragraphSign);
        cedillaCapital.setForeground(Color.BLUE);
        charPanel.add(cedillaCapital);
        acuteCapitalE.setForeground(Color.BLUE);
        charPanel.add(acuteCapitalE);
        charPanel.add(cedillaSmall);
        charPanel.add(acuteSmallE);
        charPanel.add(euroSign);
        charPanel.add(upsideDownQuestion);
        diaeresesCapitalE.setForeground(Color.BLUE);
        charPanel.add(diaeresesCapitalE);
        circumflexCapitalE.setForeground(Color.BLUE);
        charPanel.add(circumflexCapitalE);
        charPanel.add(diaeresesSmallE);
        charPanel.add(circumflexSmallE);
        charPanel.add(yen);
        charPanel.add(degree);
        acuteCapitalI.setForeground(Color.BLUE);
        charPanel.add(acuteCapitalI);
        diaeresesCapitalI.setForeground(Color.BLUE);
        charPanel.add(diaeresesCapitalI);
        charPanel.add(acuteSmallI);
        charPanel.add(diaeresesSmallI);
        charPanel.add(multiplication);
        charPanel.add(leftDoubleAngleQuotes);
        tildeCapitalN.setForeground(Color.BLUE);
        charPanel.add(tildeCapitalN);
        diaeresesCapitalO.setForeground(Color.BLUE);
        charPanel.add(diaeresesCapitalO);
        charPanel.add(tildeSmallN);
        charPanel.add(diaeresesSmallO);
        charPanel.add(rightDoubleAngleQuotes);
        charPanel.add(notSign);
        tildeCapitalO.setForeground(Color.BLUE);
        charPanel.add(tildeCapitalO);
        diaeresesCapitalU.setForeground(Color.BLUE);
        charPanel.add(diaeresesCapitalU);
        charPanel.add(tildeSmallO);
        charPanel.add(diaeresesSmallU);
        charPanel.add(pipe);
        charPanel.add(registeredTrademark);
        acuteCapitalU.setForeground(Color.BLUE);
        charPanel.add(acuteCapitalU);
        acuteCapitalY.setForeground(Color.BLUE);
        charPanel.add(acuteCapitalY);
        charPanel.add(acuteSmallU);
        charPanel.add(acuteSmallY);
        closeSpecialCharacters.setForeground(Color.RED);
        charPanel.add(closeSpecialCharacters);
        specialCharactersFrame.setPreferredSize(d);
        specialCharactersFrame.setVisible(false);
        specialCharactersFrame.setContentPane(charPanel);
        specialCharactersFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        specialCharactersFrame.pack();
    }

    private void intializeTextFormat() {
        Font f = text.getFont();
        text.setFont(f.deriveFont((float) 10.0));
        color.setSize(50, 5);
        sizePanel.add(size);
        sizePanel.add(textSize);
        sizePanel.add(increase);
        sizePanel.add(decrease);
        colorPane.add(color);
        colorPane.add(colorChooser);
        fontPanel.add(chooseFont);
        fontPanel.add(fonts);
        otherFormats.add(otherFormatting);
        otherFormats.add(italics);
        otherFormats.add(bold);
        otherFormats.add(bulletList);
        wholeThing.add(sizePanel);
        wholeThing.add(colorPane);
        wholeThing.add(fontPanel);
        wholeThing.add(otherFormats);
        wholeThing.add(textFormatSave);
        wholeThing.add(cancel);
        textFormatFrame.setContentPane(wholeThing);
        textFormatFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        textFormatFrame.pack();
        textFormatFrame.setVisible(false);
        textFormatFrame.setSize(750, 550);
    }

    private void initializeFontOptions() {
        fonts.addItem("Arial");
        fonts.addItem("Courier");
        fonts.addItem("Baskerville");
        fonts.addItem("Beirut");
        fonts.addItem("ComicSansMS");
        fonts.addItem("Damascus");
        fonts.addItem("Geneva");
        fonts.addItem("Impact");
        fonts.addItem("Osaka");
        fonts.addItem(text.getFont().getFontName());
        fonts.addItem("Papyrus");
        fonts.addItem("Tahoma");
        fonts.addItem("TimesNewRomanPSMT");
    }
}
