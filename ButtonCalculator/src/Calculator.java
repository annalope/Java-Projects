import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator {
    private static JFrame calculatorFrame = new JFrame("Calculator");
    private JPanel calculatorPanel = new JPanel();

    //buttons for the calculator
    private JTextArea calculations = new JTextArea(11, 20);
    private JButton divide = new JButton("÷");
    private JButton multiply = new JButton("x");
    private JButton nine = new JButton("9");
    private JButton add = new JButton("+");
    private JButton six = new JButton("6");
    private JButton seven = new JButton("7");
    private JButton eight = new JButton("8");
    private JButton subtract = new JButton("--");
    private JButton negative = new JButton("(-)");
    private JButton three = new JButton("3");
    private JButton four = new JButton("4");
    private JButton five = new JButton("5");
    private JButton zero = new JButton("0");
    private JButton one = new JButton("1");
    private JButton two = new JButton("2");
    private JButton solve = new JButton("solve");
    private JButton reset = new JButton("reset");
    private JLabel spacer = new JLabel("                                                                   ");
    private JLabel spacer2 = new JLabel("                                                    ");
    private JLabel displayOptionsLabel = new JLabel("Mode:");
    private ButtonGroup displayButtonGroup = new ButtonGroup();
    private JRadioButton historyView = new JRadioButton("Display History");
    private JRadioButton calculateView = new JRadioButton("Calculate");

    private String input = "";
    private String lastAnswer = "";
    private String fullEquation = "";
    private boolean hasOperation = false;
    private ArrayList<String> history = new ArrayList<>(5);
    private boolean calculateEnabled = true;

    public Calculator() {
        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (returnEquationComponents()[input.length() - 1].equalsIgnoreCase("/")) {
                        //makes sure nobody can try to divide by zero
                        JOptionPane.showMessageDialog(null, "You cannot divide by zero.");
                    } else {
                        if (input.equalsIgnoreCase("")) {
                            calculations.setText("0");
                        } else {
                            calculations.setText(calculations.getText() + "0");
                        }
                        input += "0";
                        fullEquation += "0";
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        calculations.setText("1");
                    } else {
                        calculations.setText(calculations.getText() + "1");
                    }
                    input += "1";
                    fullEquation += "1";
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        calculations.setText("2");
                    } else {
                        calculations.setText(calculations.getText() + "2");
                    }
                    input += "2";
                    fullEquation += "2";
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        calculations.setText("3");
                    } else {
                        calculations.setText(calculations.getText() + "3");
                    }
                    input += "3";
                    fullEquation += "3";
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        calculations.setText("4");
                    } else {
                        calculations.setText(calculations.getText() + "4");
                    }
                    input += "4";
                    fullEquation += "4";
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        calculations.setText("5");
                    } else {
                        calculations.setText(calculations.getText() + "5");
                    }
                    input += "5";
                    fullEquation += "5";
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        calculations.setText("6");
                    } else {
                        calculations.setText(calculations.getText() + "6");
                    }
                    input += "6";
                    fullEquation += "6";
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        calculations.setText("7");
                    } else {
                        calculations.setText(calculations.getText() + "7");
                    }
                    input += "7";
                    fullEquation += "7";
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        calculations.setText("8");
                    } else {
                        calculations.setText(calculations.getText() + "8");
                    }
                    input += "8";
                    fullEquation += "8";
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        calculations.setText("9");
                    } else {
                        calculations.setText(calculations.getText() + "9");
                    }
                    input += "9";
                    fullEquation += "9";
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        negative.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        calculations.setText("-");
                        input += "-";
                        fullEquation += "-";
                    } else {
                        if (isDigit(returnEquationComponents()[input.length() - 1])) {
                            JOptionPane.showMessageDialog(null, "You cannot add a negative sign in between digits of a number.");
                        } else if (returnEquationComponents()[input.length() - 1].equalsIgnoreCase("-")) {
                            JOptionPane.showMessageDialog(null, "You cannot add two negative signs in a row.");
                        } else {
                            input += "-";
                            fullEquation += "-";
                            calculations.setText(calculations.getText() + "-");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        input = lastAnswer;
                        fullEquation = input;
                    }

                    if (input.equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "You cannot add an operator without a number first.");
                    } else if (isAnOperation(returnEquationComponents()[input.length() - 1])) {
                        JOptionPane.showMessageDialog(null, "You cannot add two operators in a row.");
                    } else {
                        if (!containsOperation(input)) {
                            input += "/";
                        } else {
                            input = solveEquation() + "/";
                        }
                        hasOperation = true;
                        fullEquation += "/";
                        calculations.setText(calculations.getText() + "/");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        input = lastAnswer;
                        fullEquation = input;
                    }

                    if (input.equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "You cannot add an operator without a number first.");
                    } else if (isAnOperation(returnEquationComponents()[input.length() - 1])) {
                        JOptionPane.showMessageDialog(null, "You cannot add two operators in a row.");
                    } else {
                        if (!containsOperation(input)) {
                            input += "x";
                        } else {
                            input = solveEquation() + "x";
                        }
                        hasOperation = true;
                        fullEquation += "x";
                        calculations.setText(calculations.getText() + "x");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        input = lastAnswer;
                        fullEquation = input;
                    }

                    if (input.equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "You cannot add an operator without a number first.");
                    } else if (isAnOperation(returnEquationComponents()[input.length() - 1])) {
                        JOptionPane.showMessageDialog(null, "You cannot add two operators in a row.");
                    } else {
                        if (!containsOperation(input)) {
                            input += "+";
                        } else {
                            input = solveEquation() + "+";
                        }
                        hasOperation = true;
                        fullEquation += "+";
                        calculations.setText(calculations.getText() + "+");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        input = lastAnswer;
                        fullEquation = input;
                    }

                    if (input.equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "You cannot add an operator without a number first.");
                    } else if (isAnOperation(returnEquationComponents()[input.length() - 1])) {
                        JOptionPane.showMessageDialog(null, "You cannot add two operators in a row.");
                    } else {
                        if (!containsOperation(input)) {
                            input += "~";
                        } else {
                            input = solveEquation() + "~";
                        }
                        hasOperation = true;
                        fullEquation += "-";
                        calculations.setText(calculations.getText() + "-");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        solve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    if (input.equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "You must input some numbers to solve an equation.");
                    } else if (!hasOperation) {
                        JOptionPane.showMessageDialog(null, "You must have an operator in your equation.");
                    } else if (isAnOperation(returnEquationComponents()[input.length() - 1])) {
                        JOptionPane.showMessageDialog(null, "You cannot end an equation with an operation, please enter a number.");
                    } else if (returnEquationComponents()[input.length() - 1].equalsIgnoreCase("-")) {
                        JOptionPane.showMessageDialog(null, "You cannot end an equation with a negative sign, please enter another number.");
                    } else {
                        int solved = solveEquation();
                        lastAnswer = solved + "";
                        calculations.setText(fullEquation + " = " + solved);
                        history.add(calculations.getText());
                        fullEquation = "";
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate mode must be enabled to do calculations.");
                }
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = "";
                fullEquation = "";
                lastAnswer = "";
                hasOperation = false;
                calculations.setText("");
                history.clear();
                calculateEnabled = true;
                calculateView.setSelected(true);
            }
        });
        calculateView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              if (!calculateEnabled) {
                  calculations.setText(input);
                  calculateEnabled = true;
              }
            }
        });
        historyView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateEnabled) {
                    String mem = "";
                    calculateEnabled = false;
                    for (int i = 0; i < history.size(); i++) {
                        mem += "\n" + history.get(i);
                    }
                    calculations.setText("History:" + mem);
                }
            }
        });
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        calculatorFrame.setContentPane(c.calculatorPanel);
        calculatorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        calculatorFrame.setPreferredSize(new Dimension(300, 500));
        calculatorFrame.pack();
        c.initializeCalculatorDisplay();
        calculatorFrame.setVisible(true);
    }

    private void initializeCalculatorDisplay() {
        calculatorFrame.setResizable(false);
        calculations.setEditable(false);
        calculateView.setSelected(true);
        displayOptionsLabel.setForeground(Color.RED);
        solve.setForeground(Color.BLUE);
        reset.setForeground(Color.BLUE);

        eight.setPreferredSize(new Dimension(85, 30));
        nine.setPreferredSize(new Dimension(85, 30));
        divide.setPreferredSize(new Dimension(85, 30));
        six.setPreferredSize(new Dimension(85, 30));
        seven.setPreferredSize(new Dimension(85, 30));
        multiply.setPreferredSize(new Dimension(85, 30));
        four.setPreferredSize(new Dimension(85, 30));
        five.setPreferredSize(new Dimension(85, 30));
        add.setPreferredSize(new Dimension(85, 30));
        two.setPreferredSize(new Dimension(85, 30));
        three.setPreferredSize(new Dimension(85, 30));
        subtract.setPreferredSize(new Dimension(85, 30));
        zero.setPreferredSize(new Dimension(85, 30));
        one.setPreferredSize(new Dimension(85, 30));
        negative.setPreferredSize(new Dimension(85, 30));
        solve.setPreferredSize(new Dimension(175, 30));
        reset.setPreferredSize(new Dimension(85, 30));

        calculatorPanel.add(new JScrollPane(calculations, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        calculatorPanel.add(eight);
        calculatorPanel.add(nine);
        calculatorPanel.add(divide);
        calculatorPanel.add(six);
        calculatorPanel.add(seven);
        calculatorPanel.add(multiply);
        calculatorPanel.add(four);
        calculatorPanel.add(five);
        calculatorPanel.add(add);
        calculatorPanel.add(two);
        calculatorPanel.add(three);
        calculatorPanel.add(subtract);
        calculatorPanel.add(zero);
        calculatorPanel.add(one);
        calculatorPanel.add(negative);
        calculatorPanel.add(solve);
        calculatorPanel.add(reset);
        calculatorPanel.add(spacer);
        calculatorPanel.add(displayOptionsLabel);
        calculatorPanel.add(spacer2);
        displayButtonGroup.add(historyView);
        displayButtonGroup.add(calculateView);
        calculatorPanel.add(historyView);
        calculatorPanel.add(calculateView);
    }

    private int solveEquation() {
        String[] equationComponents = returnEquationComponents();
        String operation = "";
        String partialFirstNum = "";
        String partialSecondNum = "";
        int fullFirstNum = 0;
        int fullSecondNum = 0;

        int answer = 0;
        for (int i = 0; i < equationComponents.length; i++) {
            //this gets the first two numbers of the operation
            if (isDigit(equationComponents[i])) {
                if (i + 1 != equationComponents.length) {
                    if (operation.equalsIgnoreCase("")) {
                        //means this is the first number
                        partialFirstNum += equationComponents[i];
                        if (!isDigit(equationComponents[i + 1])) {
                            //means this is the end of the number, adds it to the final first number tally
                            fullFirstNum = Integer.parseInt(partialFirstNum);
                        }
                    } else {
                        //means this is the second number
                        partialSecondNum += equationComponents[i];
                    }
                } else {
                    //means we're at the last part of the equation
                    partialSecondNum += equationComponents[i];
                    fullSecondNum = Integer.parseInt(partialSecondNum);
                }
            } else if (equationComponents[i].equalsIgnoreCase("-")) {
                //this accounts for the minus sign in front of negative numbers
                if (operation.equalsIgnoreCase("")) {
                    partialFirstNum += "-";
                } else {
                    partialSecondNum += "-";
                }
            } else {
                //gets the operation that is being applied
                operation = equationComponents[i];
            }
        }

        //decides which operation to do
        switch (operation) {
            case "x":
                answer = fullFirstNum * fullSecondNum;
                break;
            case "/":
                answer = fullFirstNum / fullSecondNum;
                break;
            case "+":
                answer = fullFirstNum + fullSecondNum;
                break;
            case "~":
                //subtract needs a different symbol so it doesn't conflict with the negative symbol
                answer = fullFirstNum - fullSecondNum;
                break;
            default:
        }

        input = "";
        hasOperation = false;
        return answer;
    }

    private String[] returnEquationComponents() {
        String[] equationComponents = input.split("");
        return equationComponents;
    }

    private boolean containsOperation(String v) {
        if (v.contains("x") || v.contains("/") || v.contains("+") || v.contains("~")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isAnOperation(String r) {
        if (r.equalsIgnoreCase("x") || r.equalsIgnoreCase("/") || r.equalsIgnoreCase("+") || r.equalsIgnoreCase("~")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isDigit(String h) {
        try {
            int num = Integer.parseInt(h);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
