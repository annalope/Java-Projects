import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineLibraryCatalog {

    // log in frame
    private static JFrame logInFrame = new JFrame("Log In");
    private JPanel logInPanel = new JPanel();
    private JLabel usernamePrompt = new JLabel("Username:");
    private JTextField usernameField = new JTextField(16);
    private JLabel passwordPrompt = new JLabel("Password:");
    private JPasswordField passwordField = new JPasswordField(15);
    private JButton logIn = new JButton("Log in");
    private JButton forgotPassword = new JButton("Forgot Password?");
    private JButton createAnAccount = new JButton("Create an Account");
    private JLabel secuQuesPrompt = new JLabel("_______(Security Question)______________");
    private JTextField securAns = new JTextField(18);
    private JButton logInWithQuestion = new JButton("Log In");

    // create an account
    private static JFrame createAccountFrame = new JFrame("Create an Account");
    private JPanel createPanel = new JPanel();
    private JLabel firstNamePrompt = new JLabel("First Name:");
    private JLabel lastNamePrompt = new JLabel("Last Name:");
    private JTextField firstName = new JTextField(12);
    private JTextField lastName = new JTextField(15);
    private JLabel userPrompt = new JLabel("Username:");
    private JLabel passPrompt = new JLabel("Password:");
    private JTextField userField = new JTextField(15);
    private JPasswordField passFieldOriginal = new JPasswordField(15);
    private JLabel retypePassPrompt = new JLabel("Retype Password:");
    private JPasswordField retypePass = new JPasswordField(15);
    private JLabel securityQuestionPrompt = new JLabel("Security Question:");
    private JComboBox<String> securityQuestions = new JComboBox<>();
    private JTextField securityAnswer = new JTextField(18);
    private JLabel accountTypePrompt = new JLabel("Account Type:");
    private JComboBox<String> accountTypes = new JComboBox<>();
    private JButton createAcc = new JButton("Create Account");
    private JLabel logInPrompt = new JLabel("Already have an account?");
    private JButton logInInstead = new JButton("Log in");

    // the add book
    private static JFrame addBookFrame = new JFrame("Add a Book");
    private JPanel addBookPanel = new JPanel();
    private JLabel titlePrompt = new JLabel("Title:");
    private JTextField title = new JTextField(15);
    private JLabel authorPrompt = new JLabel("Author:");
    private JTextField author = new JTextField(15);
    private JLabel genrePrompt = new JLabel("Genre:");
    private JComboBox<String> genres = new JComboBox<>();
    private JLabel datePublishedPrompt = new JLabel("Date Published:");
    private JComboBox<String> months = new JComboBox<>();
    private JLabel firstSlash = new JLabel("/");
    private JComboBox<Integer> days = new JComboBox<>();
    private JLabel secondSlash = new JLabel("/");
    private JComboBox<Integer> years = new JComboBox<>();
    private JLabel publishingCompPrompt = new JLabel("Publishing Company:");
    private JTextField publishingCompany = new JTextField(15);
    private JLabel inLibraryPrompt = new JLabel("In Library:");
    private JRadioButton yesLibrary = new JRadioButton("Yes");
    private JRadioButton noLibrary = new JRadioButton("No");
    private ButtonGroup yesNoGroup = new ButtonGroup();
    private JLabel locationPrompt = new JLabel("Library Location:");
    private JTextField location = new JTextField(15);
    private JButton addBook = new JButton("Add");
    private JButton cancelBook = new JButton("Cancel");

    // librarian view
    private static JFrame librarianViewFrame = new JFrame("Librarian Menu");
    private JPanel librarianPanel = new JPanel();
    private JButton addBooksToCatalog = new JButton("Add Book to Catalog");
    private JButton chooseFeatured = new JButton("Choose Featured Item");
    private JButton addLibraryEvent = new JButton("Add Library Event");
    private JButton logOut = new JButton("Log Out");

    // add library events
    private static JFrame eventFrame = new JFrame("Add Library Event");
    private JPanel eventPanel = new JPanel();
    private JLabel eventNamePrompt = new JLabel("Event Name:");
    private JTextField eventName = new JTextField(15);
    private JLabel detailsPrompt = new JLabel("Event Details:");
    private JTextArea eventDetails = new JTextArea(7, 15);
    private JButton createEvent = new JButton("Create Event");
    private JButton cancelEvent = new JButton("Cancel");

    // search results view
    private static JFrame searchFrame = new JFrame("Search Results");
    private JPanel searchPanel = new JPanel();
    private JLabel resultsPrompt = new JLabel("Results:");
    private JList<String> searchList;
    private JButton viewSelected = new JButton("View Selected");
    private JButton returnToMain = new JButton("Return to Main Page");

    // choose featured items
    private static JFrame featuredFrame = new JFrame("Select Featured Items");
    private JPanel featuredPanel = new JPanel();
    private JLabel featAuthorPrompt = new JLabel("Featured Author:");
    private JLabel featBookPrompt = new JLabel("Featured Book:");
    private JList<String> authorList;
    private JList<String> bookList;
    private JButton submitChoices = new JButton("Submit Choices");
    private JButton cancelChoice = new JButton("Cancel");

    // book overview page
    private static JFrame bookOverviewFrame = new JFrame(" Overview");
    private JPanel bookOverviewPanel = new JPanel();
    private JLabel bookTitle = new JLabel("Title,");
    private JLabel bookAuthor = new JLabel("Author");
    private JLabel bookGenre = new JLabel("genre");
    private JLabel bookPublishingDate = new JLabel("Date Published");
    private JLabel bookPublishingCompany = new JLabel("Publishing Company");
    private JLabel ifInLibrary = new JLabel("In Library: Yes");
    private JButton checkInOrOut = new JButton("Check In");
    private JButton backToMain = new JButton("Back To Main");
    private JButton backToSearch = new JButton("Back To Search");

    // reader view
    private static JFrame readerFrame = new JFrame("Reader View");
    private JPanel readerPanel = new JPanel();
    private JLabel featuredBookPrompt = new JLabel("Featured Book:");
    private JLabel featuredBookDetails = new JLabel("Title by Author");
    private JLabel featuredBookGenre = new JLabel("genre");
    private JLabel searchCatalogPrompt = new JLabel("Search Catalog:");
    private JLabel byPrompt = new JLabel("by:");
    private JComboBox<String> searchBy = new JComboBox<>();
    private JTextField searchQuery = new JTextField(15);
    private JButton searchCatalog = new JButton("go");
    private JLabel featuredAuthorPrompt = new JLabel("Featured Author:");
    private JLabel authorName = new JLabel("None.");
    private JLabel upcomingEventPrompt = new JLabel("Upcoming Event:");
    private JList<String> eventList;
    private JLabel libraryStatsPrompt = new JLabel("Library Statistics:");
    private JLabel booksInCatalog = new JLabel("Books in Catalog: 0");
    private JLabel authorsInCatalog = new JLabel("Authors in Catalog: 0");
    private JLabel booksInLibrary = new JLabel("Books in Library: 0");
    private JLabel genresInCatalog = new JLabel("Genres in Catalog: 0");
    private JButton readerLogOut = new JButton("Log Out");

    // stored data
    private ArrayList<String[]> userInfo = new ArrayList<>();
    private ArrayList<String[]> bookCatalog = new ArrayList<>();
    private ArrayList<String[]> libEvents = new ArrayList<>();
    private String[] featItems = {"", "", ""};

    // temporary data
    private ArrayList<String[]> searchResults = new ArrayList<>();
    private String searchQuestion = "";
    private boolean searchResExist = true;
    private boolean featsExist = true;

    public OnlineLibraryCatalog() {
        //log in frame
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usernameField.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Please ensure you have entered your username.");
                } else {
                    if (passwordField.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Please ensure you have entered your password.");
                    } else {
                        if (verifyLogin(usernameField.getText(), passwordField.getText())) {
                            if (accountType(usernameField.getText()).equalsIgnoreCase("Reader")) {
                                setUpReaderDashboard();
                                readerFrame.setVisible(true);
                                usernameField.setText("");
                                passwordField.setText("");
                                logInFrame.setVisible(false);
                            } else {
                                librarianViewFrame.setVisible(true);
                                usernameField.setText("");
                                passwordField.setText("");
                                logInFrame.setVisible(false);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please double check your username and password.");
                        }
                    }

                }
            }
        });
        forgotPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usernameField.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Please ensure you have entered your username.");
                } else {
                    String question = getSecurityQuestion(usernameField.getText());
                    if (question.equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Pleas ensure your username is a valid, existing username.");
                    } else {
                        secuQuesPrompt.setText(question);
                        secuQuesPrompt.setVisible(true);
                        securAns.setVisible(true);
                        logInWithQuestion.setVisible(true);
                    }
                }
            }
        });
        logInWithQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usernameField.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Please ensure you have entered an existing username.");
                } else {
                    if (securAns.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Please ensure you have answered the security question.");
                    } else {
                        if (verifySecurityAnswer(usernameField.getText(), securAns.getText())) {
                            secuQuesPrompt.setVisible(false);
                            securAns.setVisible(false);
                            logInWithQuestion.setVisible(false);
                            logInFrame.setVisible(false);
                            if (accountType(usernameField.getText()).equalsIgnoreCase("Reader")) {
                                setUpReaderDashboard();
                                readerFrame.setVisible(true);
                                usernameField.setText("");
                                passwordField.setText("");
                                securAns.setText("");
                            } else {
                                librarianViewFrame.setVisible(true);
                                usernameField.setText("");
                                passwordField.setText("");
                                securAns.setText("");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please recheck your security answer.");
                        }
                    }
                }
            }
        });
        createAnAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
                securAns.setText("");
                secuQuesPrompt.setVisible(false);
                securAns.setVisible(false);
                logInWithQuestion.setVisible(false);
                logInFrame.setVisible(false);
                createAccountFrame.setVisible(true);
            }
        });
        // create an account frame
        logInInstead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstName.setText("");
                lastName.setText("");
                userField.setText("");
                passFieldOriginal.setText("");
                retypePass.setText("");
                securityAnswer.setText("");
                securityQuestions.setSelectedIndex(0);
                accountTypes.setSelectedIndex(0);
                createAccountFrame.setVisible(false);
                logInFrame.setVisible(true);
            }
        });
        createAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstName.getText().equalsIgnoreCase("") || lastName.getText().equalsIgnoreCase("")
                || userField.getText().equalsIgnoreCase("") || passFieldOriginal.getText().equalsIgnoreCase("") ||
                retypePass.getText().equalsIgnoreCase("") || securityAnswer.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Please ensure you have filled out every field to create an account.");
                } else {

                    if (userField.getText().contains("/") || passFieldOriginal.getText().contains("/") || securityAnswer.getText().contains("/")) {
                        JOptionPane.showMessageDialog(null, "None of your answers may contain a '/' in them.");
                    } else {
                        if (usernameNew(userField.getText())) {
                            if (passFieldOriginal.getText().equalsIgnoreCase(retypePass.getText())) {
                                try {
                                    // format: username password securityQ securityAns accountType
                                    String info = userField.getText() + "/" + passFieldOriginal.getText() + "/" + securityQuestions.getSelectedItem() + "/" + securityAnswer.getText() + "/" + accountTypes.getSelectedItem();
                                    PrintWriter printWriter = new PrintWriter(new FileWriter("userinfo.txt", true));
                                    printWriter.println(info);
                                    printWriter.close();

                                    populateUserInfo();
                                    firstName.setText("");
                                    lastName.setText("");
                                    userField.setText("");
                                    passFieldOriginal.setText("");
                                    retypePass.setText("");
                                    securityAnswer.setText("");
                                    securityQuestions.setSelectedIndex(0);
                                    if (accountTypes.getSelectedIndex() == 0) {
                                        setUpReaderDashboard();
                                        readerFrame.setVisible(true);
                                    } else {
                                        librarianViewFrame.setVisible(true);
                                    }
                                    accountTypes.setSelectedIndex(0);
                                    createAccountFrame.setVisible(false);
                                } catch (Exception ef) {
                                    JOptionPane.showMessageDialog(null, "Error: Could not save new account.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Please ensure the password matches the retyped password.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "That username is already taken, please select a different one.");
                        }
                    }
                }
            }
        });
        // reader view frame
        readerLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readerFrame.setVisible(false);
                logInFrame.setVisible(true);
            }
        });
        searchCatalog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchQuery.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a search query.");
                } else {
                    searchResults = calculateSearchResults(searchQuery.getText(), (String) searchBy.getSelectedItem());
                    searchQuestion = searchQuery.getText();
                    searchQuery.setText("");
                    readerFrame.setVisible(false);
                    displaySearchResults();
                    searchFrame.setVisible(true);
                }
            }
        });
        // search frame
        viewSelected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchResExist) {
                    String authorAndTitle = searchList.getSelectedValue();
                    if (authorAndTitle == null) {
                        JOptionPane.showMessageDialog(null, "Please ensure you have selected a book.");
                    } else {
                        String[] bookDet = authorAndTitle.split(" by ");
                        String[] ourBook = new String[7];
                        for (String[] i : bookCatalog) {
                            if (i[0].equalsIgnoreCase(bookDet[0]) && i[1].equalsIgnoreCase(bookDet[1])) {
                                ourBook = i;
                                break;
                            }
                        }
                        setUpBookDisplay(ourBook);
                        searchFrame.setVisible(false);
                        bookOverviewFrame.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "There were no results for your query.");
                }
            }
        });
        returnToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFrame.setVisible(false);
                setUpReaderDashboard();
                readerFrame.setVisible(true);
            }
        });
        // book overview frame
        checkInOrOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ourBook = 0;
                for (int i = 0; i < bookCatalog.size(); i++) {
                    if (bookCatalog.get(i)[0].equalsIgnoreCase(bookTitle.getText()) && bookCatalog.get(i)[1].equalsIgnoreCase(bookAuthor.getText())) {
                        ourBook = i;
                        break;
                    }
                }
                String[] bookDe = bookCatalog.get(ourBook);
                if (checkInOrOut.getText().equalsIgnoreCase("Check In")) {
                    bookDe[5] = "Yes";
                    bookDe[6] = "Check-In Desk";
                } else {
                    bookDe[5] = "No";
                    bookDe[6] = "Sorry!";
                }
                bookCatalog.set(ourBook, bookDe);
                setUpBookDisplay(bookDe);
            }
        });
        backToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookOverviewFrame.setVisible(false);
                setUpReaderDashboard();
                readerFrame.setVisible(true);
            }
        });
        backToSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookOverviewFrame.setVisible(false);
                searchFrame.setVisible(true);
            }
        });
        // librarian view frame
        addBooksToCatalog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                librarianViewFrame.setVisible(false);
                addBookFrame.setVisible(true);
            }
        });
        chooseFeatured.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                librarianViewFrame.setVisible(false);
                setUpFeaturedChoices();
                featuredFrame.setVisible(true);
            }
        });
        addLibraryEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                librarianViewFrame.setVisible(false);
                eventFrame.setVisible(true);
            }
        });
        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                librarianViewFrame.setVisible(false);
                logInFrame.setVisible(true);
            }
        });
        // featured panel
        cancelChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                featuredFrame.setVisible(false);
                librarianViewFrame.setVisible(true);
            }
        });
        submitChoices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (featsExist) {
                    try {
                        File file = new File("featureditems.txt");
                        file.delete();
                        String book = bookList.getSelectedValue();
                        String[] bookTemp = book.split(" by ");
                        String[] ourBook = new String[7];
                        for (int i = 0; i < bookCatalog.size(); i++) {
                            if (bookTemp[0].equalsIgnoreCase(bookCatalog.get(i)[0]) && bookTemp[1].equalsIgnoreCase(bookCatalog.get(i)[1])) {
                                ourBook = bookCatalog.get(i);
                                break;
                            }
                        }
                        String info = bookList.getSelectedValue() + "/" + authorList.getSelectedValue() + "/" + ourBook[2];
                        PrintWriter printWriter = new PrintWriter(new FileWriter("featureditems.txt", true));
                        printWriter.println(info);
                        printWriter.close();
                        populateFeatItems();
                        featuredFrame.setVisible(false);
                        librarianViewFrame.setVisible(true);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Sorry, featured selections could not be saved.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "There are no featured items to select.");
                }
            }
        });

        // add book to catalog
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (title.getText().equalsIgnoreCase("") || author.getText().equalsIgnoreCase("") || publishingCompany.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Please ensure you have filled out every blank.");
                } else {
                    if (yesLibrary.isSelected() && location.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Please enter the book's location in the library.");
                    } else {
                        if (validBook(title.getText(), author.getText())) {
                            try {
                                // format: title ^ author ^ genre ^ date published ^ publishing company ^ in library ^ location, Sorry if none
                                String datePublished = months.getSelectedItem() + "/" + days.getSelectedItem() + "/" + years.getSelectedItem();
                                String inLib;
                                String loc;
                                if (yesLibrary.isSelected()) {
                                    inLib = "Yes";
                                    loc = location.getText();
                                } else {
                                    inLib = "No";
                                    loc = "Sorry!";
                                }
                                String info = title.getText() + "#" + author.getText() + "#" + genres.getSelectedItem() + "#" + datePublished + "#" + publishingCompany.getText() + "#" + inLib + "#" + loc;
                                PrintWriter printWriter = new PrintWriter(new FileWriter("bookcatalog.txt", true));
                                printWriter.println(info);
                                printWriter.close();
                                populateBookCatalog();
                                resetAddBookDisplay();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Error: Could not add new book.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "This book already exists in the catalog, sorry.");
                        }
                    }
                }
            }
        });
        cancelBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAddBookDisplay();
            }
        });
        // add event
        cancelEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventName.setText("");
                eventDetails.setText("");
                eventFrame.setVisible(false);
                librarianViewFrame.setVisible(true);
            }
        });
        createEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (eventName.getText().equalsIgnoreCase("") || eventDetails.getText().equalsIgnoreCase("")) {
                   JOptionPane.showMessageDialog(null, "Please ensure you have filled out every blank.");
               } else {
                   if (eventDetails.getText().contains("\n")) {
                       JOptionPane.showMessageDialog(null, "There cannot be any line breaks in the event details.");
                   } else {
                       // format : event name / details
                       try {
                           String info = eventName.getText() + "/" + eventDetails.getText();
                           PrintWriter printWriter = new PrintWriter(new FileWriter("eventschedule.txt", true));
                           printWriter.println(info);
                           printWriter.close();
                           populateLibEvents();
                           setUpReaderDashboard();
                           eventDetails.setText("");
                           eventName.setText("");
                           eventFrame.setVisible(false);
                           librarianViewFrame.setVisible(true);
                       } catch (Exception ex) {
                           JOptionPane.showMessageDialog(null, "Sorry, event could not be saved.");
                       }
                   }
               }
            }
        });
        yesLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                locationPrompt.setVisible(true);
                location.setVisible(true);
            }
        });
        noLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                locationPrompt.setVisible(false);
                location.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        OnlineLibraryCatalog olc = new OnlineLibraryCatalog();
        olc.populateUserInfo();
        logInFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        logInFrame.setPreferredSize(new Dimension(500, 500));
        logInFrame.setResizable(false);
        olc.initializeLogInDisplay();
        logInFrame.setContentPane(olc.logInPanel);
        logInFrame.pack();
        logInFrame.setVisible(true);

        createAccountFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createAccountFrame.setPreferredSize(new Dimension(600, 400));
        createAccountFrame.setResizable(false);
        olc.initializeCreateAccount();
        createAccountFrame.setContentPane(olc.createPanel);
        createAccountFrame.pack();
        createAccountFrame.setVisible(false);

        addBookFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addBookFrame.setPreferredSize(new Dimension(650, 500));
        addBookFrame.setResizable(false);
        olc.initializeAddBook();
        addBookFrame.setContentPane(olc.addBookPanel);
        addBookFrame.pack();
        addBookFrame.setVisible(false);

        librarianViewFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        librarianViewFrame.setPreferredSize(new Dimension(500, 350));
        librarianViewFrame.setResizable(false);
        olc.initializeLibrarianView();
        librarianViewFrame.setContentPane(olc.librarianPanel);
        librarianViewFrame.pack();
        librarianViewFrame.setVisible(false);

        eventFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        eventFrame.setPreferredSize(new Dimension(400, 380));
        eventFrame.setResizable(false);
        olc.initializeEventsView();
        eventFrame.setContentPane(olc.eventPanel);
        eventFrame.pack();
        eventFrame.setVisible(false);

        searchFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        searchFrame.setPreferredSize(new Dimension(400, 400));
        searchFrame.setResizable(false);
        olc.initializeSearchView();
        searchFrame.setContentPane(olc.searchPanel);
        searchFrame.pack();
        searchFrame.setVisible(false);

        featuredFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        featuredFrame.setPreferredSize(new Dimension(500, 400));
        featuredFrame.setResizable(false);
        olc.initializeFeaturedView();
        featuredFrame.setContentPane(olc.featuredPanel);
        featuredFrame.pack();
        featuredFrame.setVisible(false);

        bookOverviewFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        bookOverviewFrame.setPreferredSize(new Dimension(400, 400));
        bookOverviewFrame.setResizable(false);
        olc.initializeBookOverview();
        bookOverviewFrame.setContentPane(olc.bookOverviewPanel);
        bookOverviewFrame.pack();
        bookOverviewFrame.setVisible(false);

        readerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        readerFrame.setPreferredSize(new Dimension(650, 400));
        readerFrame.setResizable(false);
        olc.initializeReaderView();
        readerFrame.setContentPane(olc.readerPanel);
        readerFrame.pack();
        readerFrame.setVisible(false);
    }

    private void setUpBookDisplay(String[] bookDetails) {
        // format of array: title ^ author ^ genre ^ date published ^ publishing company ^ in library ^ location, sorry if none
         bookTitle.setText(bookDetails[0]);
         bookAuthor.setText(bookDetails[1]);
         bookGenre.setText(bookDetails[2]);
         bookPublishingDate.setText("Published On: " + bookDetails[3]);
         bookPublishingCompany.setText("by " + bookDetails[4]);
         String inLib = bookDetails[5];
         if (inLib.equalsIgnoreCase("Yes")) {
             ifInLibrary.setText("In Library: Yes, " + bookDetails[6]);
             checkInOrOut.setText("Check Out");
         } else {
             ifInLibrary.setText("In Library: No, " + bookDetails[6]);
             checkInOrOut.setText("Check In");
         }
         bookOverviewFrame.setTitle(bookDetails[0] + " Details");
    }

    private void setUpReaderDashboard() {
        populateUserInfo();
        populateBookCatalog();
        populateLibEvents();
        populateFeatItems();
        // set up featured author/book
        boolean empty = (featItems[0].equalsIgnoreCase(""));
        if (empty) {
            authorName.setText("None.");
            featuredBookDetails.setText("None.");
            featuredBookGenre.setText("");
        } else {
            featuredBookDetails.setText(featItems[0]);
            authorName.setText(featItems[1]);
            featuredBookGenre.setText(featItems[2]);
        }

        // show event schedule
        if (libEvents.isEmpty()) {
            JTextArea noResults = new JTextArea(5, 12);
            noResults.setFont(new Font("Serif", Font.PLAIN, 14));
            noResults.setLineWrap(true);
            noResults.setForeground(Color.GRAY);
            noResults.setEditable(false);
            noResults.setText("There are currently no events scheduled at the library.");
            Dimension dim = noResults.getPreferredSize();
            // upcomingEventDetails.setBounds(220, 230, dim.width, dim.height);
            noResults.setBounds(220, 230, dim.width, dim.height);
            readerPanel.add(noResults);
        } else {
            String[] eventsTemp = new String[libEvents.size()];
            for (int i = 0; i < libEvents.size(); i++) {
                eventsTemp[i] = libEvents.get(i)[0] + " - " + libEvents.get(i)[1];
            }
            eventList = new JList(eventsTemp);
            eventList.setFont(new Font("Serif", Font.PLAIN, 14));
            eventList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            eventList.setLayoutOrientation(JList.VERTICAL);
            eventList.setVisibleRowCount(-1);
            eventList.setSelectionMode(0);
            JScrollPane listScroller = new JScrollPane(eventList);
            listScroller.setPreferredSize(new Dimension(125, 133));
            Dimension dim = listScroller.getPreferredSize();
            listScroller.setBounds(220, 230, dim.width, dim.height);
            readerPanel.add(listScroller);
        }
        // library stats
        int[] stats = calculateLibraryStats();
        booksInCatalog.setText("Books in Catalog: " + stats[0]);
        authorsInCatalog.setText("Authors in Catalog: " + stats[1]);
        booksInLibrary.setText("Books in Library: " + stats[2]);
        genresInCatalog.setText("Genres in Catalog: " + stats[3]);
    }

    private int[] calculateLibraryStats() {
        // format: # books in catalog, # authors, # books in library, # genres in catalog
        int numBooks = bookCatalog.size();
        int numAuthors = 0;
        int numInLibrary = 0;
        int numGenres = 0;
        ArrayList<String> authorsTemp = new ArrayList<>();
        ArrayList<String> genresTemp = new ArrayList<>();
        for (int i = 0; i < bookCatalog.size(); i++) {
            if (!authorsTemp.contains(bookCatalog.get(i)[1])) {
                authorsTemp.add(bookCatalog.get(i)[1]);
                numAuthors++;
            }
            if (bookCatalog.get(i)[5].equalsIgnoreCase("Yes")) {
                numInLibrary++;
            }
            if (!genresTemp.contains(bookCatalog.get(i)[2])) {
                genresTemp.add(bookCatalog.get(i)[2]);
                numGenres++;
            }
        }
        int[] stats = {numBooks, numAuthors, numInLibrary, numGenres};
        return stats;
    }

    private void setUpFeaturedChoices() {
        populateBookCatalog();
        JTextArea noAuthors = new JTextArea(10, 18);
        JTextArea noBooks = new JTextArea(10, 18);
        ArrayList<String> authorsTemp = new ArrayList<>(1);
        String[] booksTemp = new String[bookCatalog.size()];
        for (int i = 0; i < bookCatalog.size(); i++) {
            String tempAuth = "";
            String tempZero = "";
            String tempOne = "";
            for (int j = 0; j < bookCatalog.get(i).length; j++) {
                if (j == 1) {
                    tempAuth = bookCatalog.get(i)[j];
                    break;
                }
            }
            if (!authorsTemp.contains(tempAuth)) {
                authorsTemp.add(tempAuth);
            }
            for (int j = 0; j < bookCatalog.get(i).length; j++) {
                if (j == 0) {
                    tempZero = bookCatalog.get(i)[j];
                }
                if (j == 1) {
                    tempOne = bookCatalog.get(i)[j];
                    break;
                }
            }
            booksTemp[i] = tempZero + " by " + tempOne;
        }
        String[] authorsInCatalog = new String[authorsTemp.size()];
        for (int i = 0; i < authorsTemp.size(); i++) {
            authorsInCatalog[i] = authorsTemp.get(i);
        }

        if (authorsInCatalog.length == 0) {
            noAuthors.setFont(new Font("Serif", Font.PLAIN, 14));
            noAuthors.setLineWrap(true);
            noAuthors.setForeground(Color.GRAY);
            noAuthors.setEditable(false);
            noAuthors.setText("There are no authors currently in the catalog.");
            noBooks.setFont(new Font("Serif", Font.PLAIN, 14));
            noBooks.setLineWrap(true);
            noBooks.setForeground(Color.GRAY);
            noBooks.setEditable(false);
            noBooks.setText("There are no books currently in the catalog.");
            Dimension dim = noAuthors.getPreferredSize();
            noAuthors.setBounds(30, 50, dim.width, dim.height);
            featuredPanel.add(noAuthors);
            dim = noBooks.getPreferredSize();
            noBooks.setBounds(260, 50, dim.width, dim.height);
            featuredPanel.add(noBooks);
            featsExist = false;
        } else {
            featuredPanel.remove(noAuthors);
            featuredPanel.remove(noBooks);
            featsExist = true;
            authorList = new JList(authorsInCatalog);
            authorList.setFont(new Font("Serif", Font.PLAIN, 14));
            authorList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            authorList.setLayoutOrientation(JList.VERTICAL);
            authorList.setPreferredSize(new Dimension(200, 200));
            authorList.setVisibleRowCount(-1);
            JScrollPane authorScroller = new JScrollPane(authorList);
            authorScroller.setPreferredSize(new Dimension(200, 200));
            Dimension dim = authorScroller.getPreferredSize();
            authorScroller.setBounds(30, 50, dim.width, dim.height);
            featuredPanel.add(authorScroller);

            bookList = new JList(booksTemp);
            bookList.setFont(new Font("Serif", Font.PLAIN, 14));
            bookList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            bookList.setLayoutOrientation(JList.VERTICAL);
            bookList.setPreferredSize(new Dimension(200, 200));
            bookList.setVisibleRowCount(-1);
            JScrollPane bookScroller = new JScrollPane(bookList);
            bookScroller.setPreferredSize(new Dimension(200, 200));
            dim = bookScroller.getPreferredSize();
            bookScroller.setBounds(260, 50, dim.width, dim.height);
            featuredPanel.add(bookScroller);
        }

    }

    private boolean validBook(String title, String author) {
        boolean valid = true;
        for (String[] i : bookCatalog) {
            if (title.equalsIgnoreCase(i[0]) && author.equalsIgnoreCase(i[1])) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    private ArrayList<String[]> calculateSearchResults(String query, String typeOfSearch) {
        ArrayList<String[]> results = new ArrayList<>();
        for (String[] i : bookCatalog) {
            if (typeOfSearch.equalsIgnoreCase("Author")) {
                if (i[1].equalsIgnoreCase(query)) {
                    results.add(i);
                }
            } else {
                if (i[0].equalsIgnoreCase(query)) {
                    results.add(i);
                }
            }
        }
        return results;
    }

    private void displaySearchResults() {
        if (searchResults.isEmpty()) {
            searchResExist = false;
            JTextArea noResults = new JTextArea(10, 18);
            noResults.setFont(new Font("Serif", Font.PLAIN, 14));
            noResults.setLineWrap(true);
            noResults.setForeground(Color.GRAY);
            noResults.setEditable(false);
            noResults.setText("There are no results for '" + searchQuestion + "' in the catalog.");
            Dimension dim = noResults.getPreferredSize();
            noResults.setBounds(100, 30, dim.width, dim.height);
            searchPanel.add(noResults);
        } else {
            String[] resultsTemp = new String[searchResults.size()];
            // gets results as a string[]
            for (int i = 0; i < searchResults.size(); i++) {
                String searchRes = searchResults.get(i)[0] + " by " + searchResults.get(i)[1];
                resultsTemp[i] = searchRes;
            }
            // creates JList with data and proper alignment
            searchList = new JList(resultsTemp);
            searchList.setFont(new Font("Serif", Font.PLAIN, 14));
            searchList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            searchList.setLayoutOrientation(JList.VERTICAL);
            searchList.setVisibleRowCount(-1);
            // creates scroll bar
            JScrollPane listScroller = new JScrollPane(searchList);
            listScroller.setPreferredSize(new Dimension(250, 200));
            // adds to panel
            Dimension dim = listScroller.getPreferredSize();
            listScroller.setBounds(100, 30, dim.width, dim.height);
            searchPanel.add(listScroller);
        }
    }

    private void resetAddBookDisplay() {
        title.setText("");
        author.setText("");
        genres.setSelectedIndex(0);
        months.setSelectedIndex(0);
        days.setSelectedIndex(0);
        years.setSelectedIndex(0);
        publishingCompany.setText("");
        location.setText("");
        location.setVisible(false);
        locationPrompt.setVisible(false);
        yesLibrary.setSelected(false);
        noLibrary.setSelected(false);
        addBookFrame.setVisible(false);
        librarianViewFrame.setVisible(true);
    }

    private boolean verifySecurityAnswer(String username, String answer) {
        // checks if security answer is right
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
            valid = (userInfo.get(index)[3].equalsIgnoreCase(answer));
        }

        return valid;
    }

    private boolean verifyLogin(String username, String password) {
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

    private String readEventFile() {
        String data = "";
        try {
            File file = new File("eventschedule.txt");
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

    private String readFeaturedFile() {
        String data = "";
        try {
            File file = new File("featureditems.txt");
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

    private String readBookFile() {
        String data = "";
        try {
            File file = new File("bookcatalog.txt");
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

    private void populateLibEvents() {
        libEvents.clear();
        String fileData = readEventFile();
        String[] temp = fileData.split("\n");
        for (int i = 0; i < temp.length; i++) {
            String[] inside = temp[i].split("/");
            libEvents.add(inside);
        }
    }

    private void populateFeatItems() {
        String fileData = readFeaturedFile();
        featItems = fileData.split("/");
    }


    private void populateBookCatalog() {
        bookCatalog.clear();
        String fileData = readBookFile();
        String[] temp = fileData.split("\n");
        for (int i = 0; i < temp.length; i++) {
            String[] inside = temp[i].split("#");
            bookCatalog.add(inside);
        }
    }

    private void populateUserInfo() {
        userInfo.clear();
        String fileData = readInfoFile();
        String[] temp = fileData.split("\n");
        for (int i = 0; i < temp.length; i++) {
            String[] inside = temp[i].split("/");
            userInfo.add(inside);
        }
    }

    private String accountType(String username) {
        populateUserInfo();
        int index = -1;
        String type = "";
        for (int i = 0; i < userInfo.size(); i++) {
            if (userInfo.get(i)[0].equalsIgnoreCase(username)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return type;
        } else {
            for (int j = 0; j < userInfo.get(index).length; j++) {
                type = userInfo.get(index)[j];
            }
        }
        return type;
        // return "Librarian" or "Reader";
    }

    private String getSecurityQuestion(String username) {
        String[] userDetails = new String[5];
        for (int i = 0; i < userInfo.size(); i++) {
            if (username.equalsIgnoreCase(userInfo.get(i)[0])) {
                userDetails = userInfo.get(i);
                break;
            }
        }
        return userDetails[2];
    }

    private void initializeAccOptions() {
        accountTypes.addItem("Reader");
        accountTypes.addItem("Librarian");
    }

    private void initializeGenreOptions() {
        genres.addItem("Action and Adventure");
        genres.addItem("Biographies");
        genres.addItem("Cookbooks");
        genres.addItem("Fantasy");
        genres.addItem("Graphic Novel");
        genres.addItem("History");
        genres.addItem("Historical Fiction");
        genres.addItem("Horror");
        genres.addItem("Literary Fiction");
        genres.addItem("Mystery");
        genres.addItem("Poetry");
        genres.addItem("Romance");
        genres.addItem("Science Fiction");
        genres.addItem("Self Help");
        genres.addItem("Short Stories");
        genres.addItem("Other");
    }

    private void initializeDateOptions() {
        String[] monthOptions = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
        for (int i = 0; i < monthOptions.length; i++) {
            months.addItem(monthOptions[i]);
        }
        for (int i = 1; i <= 31; i++) {
            days.addItem(i);
        }
        for (int i = 1200; i <= 2022; i++) {
            years.addItem(i);
        }
    }

    private void initializeSecurityQs() {
        securityQuestions.addItem("What was the name of your first pet?");
        securityQuestions.addItem("What is your mother's maiden name?");
        securityQuestions.addItem("What city were you born in?");
        securityQuestions.addItem("What was the name of your elementary school?");
        securityQuestions.addItem("What is your favorite food?");
        securityQuestions.addItem("What is the name of your favorite restaurant?");
        securityQuestions.addItem("What is your oldest cousin's name?");
    }

    private void initializeReaderView() {
        readerPanel.setLayout(null);
        featuredBookPrompt.setFont(new Font("Serif", Font.BOLD, 18));
        Dimension dim = featuredBookPrompt.getPreferredSize();
        featuredBookPrompt.setBounds(25, 45, dim.width, dim.height);
        readerPanel.add(featuredBookPrompt);
        featuredBookDetails.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = featuredBookDetails.getPreferredSize();
        featuredBookDetails.setPreferredSize(new Dimension(500, dim.height));
        dim = featuredBookDetails.getPreferredSize();
        featuredBookDetails.setBounds(25, 85, dim.width, dim.height);
        readerPanel.add(featuredBookDetails);
        featuredBookGenre.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = featuredBookGenre.getPreferredSize();
        featuredBookGenre.setPreferredSize(new Dimension(500, dim.height));
        dim = featuredBookGenre.getPreferredSize();
        featuredBookGenre.setBounds(25, 110, dim.width, dim.height);
        readerPanel.add(featuredBookGenre);
        searchCatalogPrompt.setFont(new Font("Serif", Font.BOLD, 18));
        dim = searchCatalogPrompt.getPreferredSize();
        searchCatalogPrompt.setBounds(220, 45, dim.width, dim.height);
        readerPanel.add(searchCatalogPrompt);
        byPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = byPrompt.getPreferredSize();
        byPrompt.setBounds(220, 85, dim.width, dim.height);
        readerPanel.add(byPrompt);
        searchBy.addItem("author");
        searchBy.addItem("title");
        dim = searchBy.getPreferredSize();
        searchBy.setBounds(240, 81, dim.width, dim.height);
        readerPanel.add(searchBy);
        searchQuery.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = searchQuery.getPreferredSize();
        searchQuery.setBounds(340, 81, dim.width, dim.height);
        readerPanel.add(searchQuery);
        dim = searchCatalog.getPreferredSize();
        searchCatalog.setBounds(530, 81, dim.width, dim.height);
        readerPanel.add(searchCatalog);
        featuredAuthorPrompt.setFont(new Font("Serif", Font.BOLD, 18));
        dim = featuredAuthorPrompt.getPreferredSize();
        featuredAuthorPrompt.setBounds(25, 200, dim.width, dim.height);
        readerPanel.add(featuredAuthorPrompt);
        authorName.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = authorName.getPreferredSize();
        authorName.setPreferredSize(new Dimension(500, dim.height));
        dim = authorName.getPreferredSize();
        authorName.setBounds(25, 230, dim.width, dim.height);
        readerPanel.add(authorName);
        upcomingEventPrompt.setFont(new Font("Serif", Font.BOLD, 18));
        dim = upcomingEventPrompt.getPreferredSize();
        upcomingEventPrompt.setBounds(220, 200, dim.width, dim.height);
        readerPanel.add(upcomingEventPrompt);
        libraryStatsPrompt.setFont(new Font("Serif", Font.BOLD, 18));
        dim = libraryStatsPrompt.getPreferredSize();
        libraryStatsPrompt.setBounds(400, 200, dim.width, dim.height);
        readerPanel.add(libraryStatsPrompt);
        booksInCatalog.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = booksInCatalog.getPreferredSize();
        booksInCatalog.setBounds(400, 230, dim.width, dim.height);
        readerPanel.add(booksInCatalog);
        authorsInCatalog.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = authorsInCatalog.getPreferredSize();
        authorsInCatalog.setBounds(400, 250, dim.width, dim.height);
        readerPanel.add(authorsInCatalog);
        genresInCatalog.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = genresInCatalog.getPreferredSize();
        genresInCatalog.setBounds(400, 270, dim.width, dim.height);
        readerPanel.add(genresInCatalog);
        booksInLibrary.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = booksInLibrary.getPreferredSize();
        booksInLibrary.setBounds(400, 290, dim.width, dim.height);
        readerPanel.add(booksInLibrary);
        readerLogOut.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = readerLogOut.getPreferredSize();
        readerLogOut.setBounds(545, 340, dim.width, dim.height);
        readerPanel.add(readerLogOut);
    }

    private void initializeBookOverview() {
        bookOverviewPanel.setLayout(null);
        bookTitle.setFont(new Font("Serif", Font.BOLD, 30));
        bookAuthor.setFont(new Font("Serif", Font.BOLD, 30));
        Dimension dim = bookTitle.getPreferredSize();
        bookTitle.setPreferredSize(new Dimension(500, dim.height));
        dim = bookTitle.getPreferredSize();
        bookTitle.setBounds(30, 30, dim.width, dim.height);
        bookOverviewPanel.add(bookTitle);
        dim = bookAuthor.getPreferredSize();
        bookAuthor.setPreferredSize(new Dimension(500, dim.height));
        dim = bookAuthor.getPreferredSize();
        bookAuthor.setBounds(30, 90, dim.width, dim.height);
        bookOverviewPanel.add(bookAuthor);
        bookGenre.setFont(new Font("Serif", Font.BOLD, 18));
        dim = bookGenre.getPreferredSize();
        bookGenre.setPreferredSize(new Dimension(500, dim.height));
        dim = bookGenre.getPreferredSize();
        bookGenre.setBounds(30, 150, dim.width, dim.height);
        bookOverviewPanel.add(bookGenre);
        bookPublishingDate.setFont(new Font("Serif", Font.PLAIN, 18));
        dim = bookPublishingDate.getPreferredSize();
        bookPublishingDate.setPreferredSize(new Dimension(500, dim.height));
        dim = bookPublishingDate.getPreferredSize();
        bookPublishingDate.setBounds(30, 190, dim.width, dim.height);
        bookOverviewPanel.add(bookPublishingDate);
        bookPublishingCompany.setFont(new Font("Serif", Font.PLAIN, 18));
        dim = bookPublishingCompany.getPreferredSize();
        bookPublishingCompany.setPreferredSize(new Dimension(500, dim.height));
        dim = bookPublishingCompany.getPreferredSize();
        bookPublishingCompany.setBounds(235, 190, dim.width, dim.height);
        bookOverviewPanel.add(bookPublishingCompany);
        ifInLibrary.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = ifInLibrary.getPreferredSize();
        ifInLibrary.setPreferredSize(new Dimension(500, dim.height));
        dim = ifInLibrary.getPreferredSize();
        ifInLibrary.setBounds(30, 230, dim.width, dim.height);
        bookOverviewPanel.add(ifInLibrary);
        checkInOrOut.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = checkInOrOut.getPreferredSize();
        checkInOrOut.setBounds(155, 290, dim.width, dim.height);
        bookOverviewPanel.add(checkInOrOut);
        backToSearch.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = backToSearch.getPreferredSize();
        backToSearch.setBounds(20, 290, dim.width, dim.height);
        bookOverviewPanel.add(backToSearch);
        backToMain.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = backToMain.getPreferredSize();
        backToMain.setBounds(250, 290, dim.width, dim.height);
        bookOverviewPanel.add(backToMain);
    }

    private void initializeFeaturedView() {
        featuredPanel.setLayout(null);
        featAuthorPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        Dimension dim = featAuthorPrompt.getPreferredSize();
        featAuthorPrompt.setBounds(30, 30, dim.width, dim.height);
        featuredPanel.add(featAuthorPrompt);
        featBookPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = featBookPrompt.getPreferredSize();
        featBookPrompt.setBounds(260, 30, dim.width, dim.height);
        featuredPanel.add(featBookPrompt);
        submitChoices.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = submitChoices.getPreferredSize();
        submitChoices.setBounds(250, 280, dim.width, dim.height);
        featuredPanel.add(submitChoices);
        cancelChoice.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = cancelChoice.getPreferredSize();
        cancelChoice.setBounds(80, 280, dim.width, dim.height);
        featuredPanel.add(cancelChoice);
    }

    private void initializeSearchView() {
        searchPanel.setLayout(null);
        resultsPrompt.setFont(new Font("Serif", Font.BOLD, 14));
        Dimension dim = resultsPrompt.getPreferredSize();
        resultsPrompt.setBounds(40, 33, dim.width, dim.height);
        searchPanel.add(resultsPrompt);
        viewSelected.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = viewSelected.getPreferredSize();
        viewSelected.setBounds(135, 265, dim.width, dim.height);
        searchPanel.add(viewSelected);
        returnToMain.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = returnToMain.getPreferredSize();
        returnToMain.setBounds(215, 335, dim.width, dim.height);
        searchPanel.add(returnToMain);
    }

    private void initializeEventsView() {
        eventPanel.setLayout(null);
        eventNamePrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        Dimension dim = eventNamePrompt.getPreferredSize();
        eventNamePrompt.setBounds(50, 33, dim.width, dim.height);
        eventPanel.add(eventNamePrompt);
        eventName.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = eventName.getPreferredSize();
        eventName.setBounds(150, 30, dim.width, dim.height);
        eventPanel.add(eventName);
        detailsPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = detailsPrompt.getPreferredSize();
        detailsPrompt.setBounds(50, 113, dim.width, dim.height);
        eventPanel.add(detailsPrompt);
        eventDetails.setLineWrap(true);
        eventDetails.setFont(new Font("Serif", Font.PLAIN, 14));
        eventDetails.setForeground(Color.GRAY);
        dim = eventDetails.getPreferredSize();
        eventDetails.setBounds(150, 110, dim.width, dim.height);
        eventPanel.add(eventDetails);
        createEvent.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = createEvent.getPreferredSize();
        createEvent.setBounds(140, 260, dim.width, dim.height);
        eventPanel.add(createEvent);
        cancelEvent.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = cancelEvent.getPreferredSize();
        cancelEvent.setBounds(300, 320, dim.width, dim.height);
        eventPanel.add(cancelEvent);
    }

    private void initializeLibrarianView() {
        librarianPanel.setLayout(null);
        addBooksToCatalog.setFont(new Font("Serif", Font.PLAIN, 14));
        Dimension dim = addBooksToCatalog.getPreferredSize();
        addBooksToCatalog.setBounds(50, 70, dim.width, dim.height);
        librarianPanel.add(addBooksToCatalog);
        chooseFeatured.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = chooseFeatured.getPreferredSize();
        chooseFeatured.setBounds(275, 70, dim.width, dim.height);
        librarianPanel.add(chooseFeatured);
        addLibraryEvent.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = addLibraryEvent.getPreferredSize();
        addLibraryEvent.setBounds(165, 170, dim.width, dim.height);
        librarianPanel.add(addLibraryEvent);
        logOut.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = logOut.getPreferredSize();
        logOut.setBounds(390, 290, dim.width, dim.height);
        librarianPanel.add(logOut);
    }

    private void initializeAddBook() {
        addBookPanel.setLayout(null);
        titlePrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        Dimension dim = titlePrompt.getPreferredSize();
        titlePrompt.setBounds(75, 43, dim.width, dim.height);
        addBookPanel.add(titlePrompt);
        title.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = title.getPreferredSize();
        title.setBounds(110, 40, dim.width, dim.height);
        addBookPanel.add(title);
        authorPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = authorPrompt.getPreferredSize();
        authorPrompt.setBounds(330, 43, dim.width, dim.height);
        addBookPanel.add(authorPrompt);
        author.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = author.getPreferredSize();
        author.setBounds(380, 40, dim.width, dim.height);
        addBookPanel.add(author);
        genrePrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = genrePrompt.getPreferredSize();
        genrePrompt.setBounds(25, 133, dim.width, dim.height);
        addBookPanel.add(genrePrompt);
        initializeGenreOptions();
        genres.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = genres.getPreferredSize();
        genres.setBounds(65, 130, dim.width, dim.height);
        addBookPanel.add(genres);
        datePublishedPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = datePublishedPrompt.getPreferredSize();
        datePublishedPrompt.setBounds(260, 133, dim.width, dim.height);
        addBookPanel.add(datePublishedPrompt);
        initializeDateOptions();
        months.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = months.getPreferredSize();
        months.setBounds(360, 130, dim.width, dim.height);
        addBookPanel.add(months);
        firstSlash.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = firstSlash.getPreferredSize();
        firstSlash.setBounds(445, 133, dim.width, dim.height);
        addBookPanel.add(firstSlash);
        days.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = days.getPreferredSize();
        days.setBounds(455, 130, dim.width, dim.height);
        addBookPanel.add(days);
        secondSlash.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = secondSlash.getPreferredSize();
        secondSlash.setBounds(530, 133, dim.width, dim.height);
        addBookPanel.add(secondSlash);
        years.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = years.getPreferredSize();
        years.setBounds(540, 130, dim.width, dim.height);
        addBookPanel.add(years);
        publishingCompPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = publishingCompPrompt.getPreferredSize();
        publishingCompPrompt.setBounds(50, 223, dim.width, dim.height);
        addBookPanel.add(publishingCompPrompt);
        publishingCompany.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = publishingCompany.getPreferredSize();
        publishingCompany.setBounds(190, 220, dim.width, dim.height);
        addBookPanel.add(publishingCompany);
        inLibraryPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = inLibraryPrompt.getPreferredSize();
        inLibraryPrompt.setBounds(405, 223, dim.width, dim.height);
        addBookPanel.add(inLibraryPrompt);
        yesNoGroup.add(yesLibrary);
        yesNoGroup.add(noLibrary);
        yesLibrary.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = yesLibrary.getPreferredSize();
        yesLibrary.setBounds(470, 220, dim.width, dim.height);
        noLibrary.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = noLibrary.getPreferredSize();
        noLibrary.setBounds(530, 220, dim.width, dim.height);
        addBookPanel.add(yesLibrary);
        addBookPanel.add(noLibrary);
        locationPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = locationPrompt.getPreferredSize();
        locationPrompt.setBounds(170, 313, dim.width, dim.height);
        addBookPanel.add(locationPrompt);
        locationPrompt.setVisible(false);
        location.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = location.getPreferredSize();
        location.setBounds(280, 310, dim.width, dim.height);
        addBookPanel.add(location);
        location.setVisible(false);
        addBook.setFont(new Font("Serif", Font.PLAIN, 14));
        addBook.setPreferredSize(new Dimension(150, 45));
        dim = addBook.getPreferredSize();
        addBook.setBounds(400, 400, dim.width, dim.height);
        addBookPanel.add(addBook);
        cancelBook.setPreferredSize(new Dimension(150, 45));
        cancelBook.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = cancelBook.getPreferredSize();
        cancelBook.setBounds(85, 400, dim.width, dim.height);
        addBookPanel.add(cancelBook);
    }

    private void initializeCreateAccount() {
        createPanel.setLayout(null);
        firstNamePrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        Dimension dim = firstNamePrompt.getPreferredSize();
        firstNamePrompt.setBounds(30, 33, dim.width, dim.height);
        createPanel.add(firstNamePrompt);
        firstName.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = firstName.getPreferredSize();
        firstName.setBounds(105, 30, dim.width, dim.height);
        createPanel.add(firstName);
        lastNamePrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = lastNamePrompt.getPreferredSize();
        lastNamePrompt.setBounds(265 ,33, dim.width, dim.height);
        createPanel.add(lastNamePrompt);
        lastName.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = lastName.getPreferredSize();
        lastName.setBounds(335, 30, dim.width, dim.height);
        createPanel.add(lastName);
        initializeAccOptions();
        accountTypePrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = accountTypePrompt.getPreferredSize();
        accountTypePrompt.setBounds(30, 93, dim.width, dim.height);
        createPanel.add(accountTypePrompt);
        accountTypes.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = accountTypes.getPreferredSize();
        accountTypes.setBounds(125, 90, dim.width, dim.height);
        createPanel.add(accountTypes);
        userPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = userPrompt.getPreferredSize();
        userPrompt.setBounds(255, 93, dim.width, dim.height);
        createPanel.add(userPrompt);
        userField.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = userField.getPreferredSize();
        userField.setBounds(330, 90, dim.width, dim.height);
        createPanel.add(userField);
        passPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = passPrompt.getPreferredSize();
        passPrompt.setBounds(20, 153, dim.width, dim.height);
        createPanel.add(passPrompt);
        passFieldOriginal.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = passFieldOriginal.getPreferredSize();
        passFieldOriginal.setBounds(85, 150, dim.width, dim.height);
        createPanel.add(passFieldOriginal);
        retypePassPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = retypePassPrompt.getPreferredSize();
        retypePassPrompt.setBounds(280, 153, dim.width, dim.height);
        createPanel.add(retypePassPrompt);
        retypePass.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = retypePass.getPreferredSize();
        retypePass.setBounds(390, 150, dim.width, dim.height);
        createPanel.add(retypePass);
        securityQuestionPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = securityQuestionPrompt.getPreferredSize();
        securityQuestionPrompt.setBounds(15, 210, dim.width, dim.height);
        createPanel.add(securityQuestionPrompt);
        initializeSecurityQs();
        securityQuestions.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = securityQuestions.getPreferredSize();
        securityQuestions.setBounds(10, 230, dim.width, dim.height);
        createPanel.add(securityQuestions);
        securityAnswer.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = securityAnswer.getPreferredSize();
        securityAnswer.setBounds(360, 230, dim.width, dim.height);
        createPanel.add(securityAnswer);
        createAcc.setPreferredSize(new Dimension(150, 45));
        createAcc.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = createAcc.getPreferredSize();
        createAcc.setBounds(220, 280, dim.width, dim.height);
        createPanel.add(createAcc);
        logInPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = logInPrompt.getPreferredSize();
        logInPrompt.setBounds(350, 350, dim.width, dim.height);
        createPanel.add(logInPrompt);
        logInInstead.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = logInInstead.getPreferredSize();
        logInInstead.setBounds(510,345, dim.width, dim.height);
        createPanel.add(logInInstead);
    }

    private void initializeLogInDisplay() {
        logInPanel.setLayout(null);
        usernamePrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        Dimension dim = usernamePrompt.getPreferredSize();
        usernamePrompt.setBounds(110, 73, dim.width, dim.height);
        logInPanel.add(usernamePrompt);
        usernameField.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = usernameField.getPreferredSize();
        usernameField.setBounds(180, 70, dim.width, dim.height);
        logInPanel.add(usernameField);
        passwordPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = passwordPrompt.getPreferredSize();
        passwordPrompt.setBounds(110, 143, dim.width, dim.height);
        logInPanel.add(passwordPrompt);
        dim = passwordField.getPreferredSize();
        passwordField.setBounds(180, 140, dim.width, dim.height);
        logInPanel.add(passwordField);
        logIn.setFont(new Font("Serif", Font.PLAIN, 14));
        logIn.setPreferredSize(new Dimension(150, 45));
        dim = logIn.getPreferredSize();
        logIn.setBounds(190, 200, dim.width, dim.height);
        logInPanel.add(logIn);
        forgotPassword.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = forgotPassword.getPreferredSize();
        forgotPassword.setBounds(90, 280, dim.width, dim.height);
        logInPanel.add(forgotPassword);
        createAnAccount.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = createAnAccount.getPreferredSize();
        createAnAccount.setBounds(265, 280, dim.width, dim.height);
        logInPanel.add(createAnAccount);
        secuQuesPrompt.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = secuQuesPrompt.getPreferredSize();
        secuQuesPrompt.setBounds(10, 363, dim.width, dim.height);
        logInPanel.add(secuQuesPrompt);
        securAns.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = securAns.getPreferredSize();
        securAns.setBounds(280, 360, dim.width, dim.height);
        logInPanel.add(securAns);
        logInWithQuestion.setFont(new Font("Serif", Font.PLAIN, 14));
        dim = logInWithQuestion.getPreferredSize();
        logInWithQuestion.setBounds(408, 400, dim.width, dim.height);
        logInPanel.add(logInWithQuestion);
        secuQuesPrompt.setVisible(false);
        securAns.setVisible(false);
        logInWithQuestion.setVisible(false);
    }
}
