import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserAuthenticationSystem {

    private static JFrame frame = new JFrame("User Authentication System");
    private JPanel menuPanel = new JPanel();
    private JPanel signUpPanel = new JPanel();
    private JPanel signInPanel = new JPanel();
    private JPanel passedPanel = new JPanel();
    private JLabel passed = new JLabel("You have successfully logged in.");
    //sign in/sign up menu
    private JButton signInOption = new JButton(new ImageIcon(getClass().getResource("sign in button.png")));
    private JButton signUpOption = new JButton(new ImageIcon(getClass().getResource("sign up button.png")));

    // sign in form
    private JLabel usernamePrompt = new JLabel("Username: ");
    private JTextField usernameField = new JTextField("", 20);
    private JLabel passwordPrompt = new JLabel("Password: ");
    private JPasswordField passwordField = new JPasswordField("", 20);
    private JButton signIn = new JButton("Sign In");
    private JButton returnToMain = new JButton("Return to Main Menu");

    // sign up form
    private JLabel fullNamePrompt = new JLabel("Full Name: ");
    private JTextField firstNameField = new JTextField("", 10);
    private JTextField lastNameField = new JTextField("", 15);
    private JLabel firstNameSubtitle = new JLabel("(First)");
    private JLabel lastNameSubtitle = new JLabel("(Last)");
    private JLabel emailPrompt = new JLabel("Email: ");
    private JTextField emailField = new JTextField("", 15);
    private JLabel dobPrompt = new JLabel("Date of Birth: ");
    private JComboBox<String> monthField = new JComboBox<>();
    private JComboBox<Integer> dayField = new JComboBox<>();
    private JComboBox<Integer> yearField = new JComboBox<>();
    private JLabel usernameEntryPrompt = new JLabel("Username: ");
    private JLabel passwordEntryPrompt = new JLabel("Password: ");
    private JTextField usernameEntry = new JTextField("", 20);
    private JTextField passwordEntry = new JTextField("", 20);
    private JButton createAccount = new JButton("Create Account");
    private JButton mainMenuReturn = new JButton("Return to Main Menu");

    private int mode = 1; // first menu is 1, sign in menu is 2, sign up is 3
    private Dimension size;

    private ArrayList<String[]> userInfo = new ArrayList<>(2);

    /** To do:
     * save data to txt file
     * **/

    public UserAuthenticationSystem() {
        signInOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeSignInDisplay();
                mode = 2;
            }
        });
        signUpOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeSignUpDisplay();
                mode = 3;
            }
        });
        createAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkValidAge()) {
                    if (checkValidEmail()) {
                        if (checkAllBoxesFilled()) {
                            if (usableUsernamePass()) {
                                if (usernameNew(usernameEntry.getText())) {
                                    passed.setText("You have successfully created an account.");
                                    try {
                                        // format: username password
                                        String info = "" + usernameEntry.getText() + " " + passwordEntry.getText();
                                        PrintWriter printWriter = new PrintWriter(new FileWriter("userinfo.txt", true));
                                        printWriter.println("\n" + info);
                                        printWriter.close();

                                        populateUserInfo();
                                    } catch (Exception ef) {
                                        JOptionPane.showMessageDialog(null, "Error: Could not save new account.");
                                    }
                                    initializePassedDisplay();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Sorry, that username already exists.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "There must be no spaces in your username or password.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Sorry, you must fill in every value. Try again.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry, you did not enter a valid email address. Please ensure it contains an @ symbol.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry, you must be at least 18 years of age to register an account.");
                }
            }
        });
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usernamePassValuesEntered()) {
                    if (validUsernamePassword(usernameField.getText(), passwordField.getText())) {
                        passed.setText("You have successfully logged in.");
                        initializePassedDisplay();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry, the username or password is incorrect. Try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please ensure you have filled out both the username and password boxes.");
                }
            }
        });
        returnToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeMenuDisplay();
                mode = 1;
            }
        });
        mainMenuReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeMenuDisplay();
                mode = 1;
            }
        });
    }

    public static void main(String[] args) {
        UserAuthenticationSystem uas = new UserAuthenticationSystem();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 350));
        frame.setResizable(false);
        uas.menuPanel.setLayout(null);
        uas.signInPanel.setLayout(null);
        uas.signUpPanel.setLayout(null);
        uas.initializeMenuDisplay();
        uas.populateUserInfo();
        frame.pack();
        frame.setVisible(true);
    }

    private void populateUserInfo() {
        userInfo.clear();
        String fileData = readInfoFile();
        String[] temp = fileData.split("\n");
        for (int i = 0; i < temp.length; i++) {
            String[] inside = temp[i].split(" ");
            userInfo.add(inside);
        }
    }

    private boolean usernameNew(String entered) {
        boolean notUsed = true;
        // checks if you can create this new username
        for (int i = 0; i < userInfo.size(); i++) {
            if (userInfo.get(i)[0].equalsIgnoreCase(entered)) {
                notUsed = false;
            }
        }
        return notUsed;
    }

    private boolean validUsernamePassword(String username, String password) {
        // checks if the username and password are correct to sign in
        int index = -1;
        boolean valid;
        for (int i = 0; i < userInfo.size(); i++) {
            if (userInfo.get(i)[0].equalsIgnoreCase(username)) {
                index = i;
            }
        }

        if (index == -1) {
            valid = false;
        } else {
            valid = (userInfo.get(index)[1].equalsIgnoreCase(password));
        }

        return valid;
    }

    private boolean usernamePassValuesEntered() {
        boolean filled = true;
        if (usernameField.getText().equalsIgnoreCase("") || passwordField.getText().equalsIgnoreCase("")) {
            filled = false;
        }
        return filled;
    }

    private boolean checkValidAge() {
        boolean rightYear = false;
        if (2021 - (int) yearField.getSelectedItem() > 18) {
            rightYear = true;
        } else if (2021 - (int) yearField.getSelectedItem() == 18) {
            if (3 - monthField.getSelectedIndex() > 0) {
                rightYear = true;
            } else if (3 - (monthField.getSelectedIndex() + 1) == 0) {
                if (14 - (int) dayField.getSelectedItem() >= 0) {
                    rightYear = true;
                } else {
                    rightYear = false;
                }
            } else {
                rightYear = false;
            }
        }
        return rightYear;
    }

    private boolean checkValidEmail() {
        return (emailField.getText().contains("@"));
    }

    private boolean usableUsernamePass() {
        boolean usable = true;
        if (usernameEntry.getText().contains(" ") || passwordEntry.getText().contains(" ")) {
            usable = false;
        }
        return usable;
    }

    private String readInfoFile() {
        String data = "";
        try {
            File file = new File("userinfo.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + "\n";
            }
            myReader.close();
        } catch (Exception e) {
            data = "";
        }
        return data;
    }

    private boolean checkAllBoxesFilled() {
        boolean filled = true;
        if (firstNameField.getText().equalsIgnoreCase("") || lastNameField.getText().equalsIgnoreCase("")
            || usernameEntry.getText().equalsIgnoreCase("") || passwordEntry.getText().equalsIgnoreCase("")) {
            filled = false;
        }
        return filled;
    }

    private void initializeSignUpDisplay() {
        populateDateOptions();
        if (mode != 3) {
            menuPanel.setVisible(false);
            signInPanel.setVisible(false);
            size = fullNamePrompt.getPreferredSize();
            fullNamePrompt.setBounds(50, 39, size.width, size.height);
            signUpPanel.add(fullNamePrompt);
            size = firstNameField.getPreferredSize();
            firstNameField.setText("");
            firstNameField.setBounds(125, 35, size.width, size.height);
            signUpPanel.add(firstNameField);
            size = lastNameField.getPreferredSize();
            lastNameField.setText("");
            lastNameField.setBounds(260, 35, size.width, size.height);
            signUpPanel.add(lastNameField);
            size = firstNameSubtitle.getPreferredSize();
            firstNameSubtitle.setBounds(170, 60, size.width, size.height);
            signUpPanel.add(firstNameSubtitle);
            size = lastNameSubtitle.getPreferredSize();
            lastNameSubtitle.setBounds(335, 60, size.width, size.height);
            signUpPanel.add(lastNameSubtitle);
            size = emailPrompt.getPreferredSize();
            emailPrompt.setBounds(120, 94, size.width, size.height);
            signUpPanel.add(emailPrompt);
            emailField.setText("");
            size = emailField.getPreferredSize();
            emailField.setBounds(170, 89, size.width, size.height);
            signUpPanel.add(emailField);
            size = dobPrompt.getPreferredSize();
            dobPrompt.setBounds(70, 139, size.width, size.height);
            signUpPanel.add(dobPrompt);
            monthField.setSelectedItem("Jan");
            size = monthField.getPreferredSize();
            monthField.setBounds(160, 135, size.width, size.height);
            signUpPanel.add(monthField);
            dayField.setSelectedItem(1);
            size = dayField.getPreferredSize();
            dayField.setBounds(250, 135, size.width, size.height);
            signUpPanel.add(dayField);
            yearField.setSelectedItem(2021);
            size = yearField.getPreferredSize();
            yearField.setBounds(330, 135, size.width, size.height);
            signUpPanel.add(yearField);
            size = usernameEntryPrompt.getPreferredSize();
            usernameEntryPrompt.setBounds(80, 184, size.width, size.height);
            signUpPanel.add(usernameEntryPrompt);
            usernameEntry.setText("");
            size = usernameEntry.getPreferredSize();
            usernameEntry.setBounds(150, 180, size.width, size.height);
            signUpPanel.add(usernameEntry);
            passwordEntry.setText("");
            size = passwordEntryPrompt.getPreferredSize();
            passwordEntryPrompt.setBounds(80, 226, size.width, size.height);
            signUpPanel.add(passwordEntryPrompt);
            size = passwordEntry.getPreferredSize();
            passwordEntry.setBounds(150, 222, size.width, size.height);
            signUpPanel.add(passwordEntry);
            size = createAccount.getPreferredSize();
            createAccount.setBounds(190, 265, size.width, size.height);
            signUpPanel.add(createAccount);
            size = mainMenuReturn.getPreferredSize();
            mainMenuReturn.setBounds(323, 295, size.width, size.height);
            signUpPanel.add(mainMenuReturn);
            signUpPanel.setVisible(true);
            frame.setContentPane(signUpPanel);
            frame.pack();
            frame.setVisible(true);
        }
    }

    private void initializeSignInDisplay() {
        if (mode != 2) {
            menuPanel.setVisible(false);
            signUpPanel.setVisible(false);
            size = usernamePrompt.getPreferredSize();
            usernamePrompt.setBounds(80, 104, size.width, size.height);
            signInPanel.add(usernamePrompt);
            size = passwordPrompt.getPreferredSize();
            passwordPrompt.setBounds(80, 145, size.width, size.height);
            signInPanel.add(passwordPrompt);
            usernameField.setText("");
            size = usernameField.getPreferredSize();
            usernameField.setBounds(150, 100, size.width, size.height);
            signInPanel.add(usernameField);
            passwordField.setText("");
            size = passwordField.getPreferredSize();
            passwordField.setBounds(150, 140, size.width, size.height);
            signInPanel.add(passwordField);
            size = signIn.getPreferredSize();
            signIn.setBounds(190, 190, size.width, size.height);
            signInPanel.add(signIn);
            size = returnToMain.getPreferredSize();
            returnToMain.setBounds(310, 285, size.width, size.height);
            signInPanel.add(returnToMain);
            signInPanel.setVisible(true);
            frame.setContentPane(signInPanel);
            frame.pack();
            frame.setVisible(true);
        }
    }

    private void initializePassedDisplay() {
        menuPanel.setVisible(false);
        signInPanel.setVisible(false);
        signUpPanel.setVisible(false);
        passedPanel.add(passed);
        passedPanel.setVisible(true);
        frame.setContentPane(passedPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void populateDateOptions() {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (String m : months) {
            monthField.addItem(m);
        }
        for (int i = 1; i < 32; i++) {
            dayField.addItem(i);
        }
        for (int i = 2021; i > 1899 ; i--) {
            yearField.addItem(i);
        }
    }

    private void initializeMenuDisplay() {
        signInPanel.setVisible(false);
        signUpPanel.setVisible(false);
        //sets up the sign in/sign up menu
        signInOption.setPreferredSize(new Dimension(380, 100));
        size = signInOption.getPreferredSize();
        signInOption.setBounds(60, 50, size.width, size.height);
        signInOption.setOpaque(false);
        signInOption.setContentAreaFilled(false);
        signInOption.setBorderPainted(false);
        menuPanel.add(signInOption);
        signUpOption.setPreferredSize(new Dimension(380, 100));
        size = signUpOption.getPreferredSize();
        signUpOption.setBounds(60, 180, size.width, size.height);
        signUpOption.setOpaque(false);
        signUpOption.setContentAreaFilled(false);
        signUpOption.setBorderPainted(false);
        menuPanel.add(signUpOption);
        menuPanel.setVisible(true);
        frame.setContentPane(menuPanel);
    }

}
