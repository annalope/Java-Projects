import java.util.Scanner;

public class CreateAccount {

    private String username;
    private String password;
    private String userType;
    private String name;
    private String emailaddress;

    public void printer(String input) {
        System.out.println(input);
    }

    public void createUsername() {
        Scanner s = new Scanner(System.in);
        printer("Please enter your new username:");
        username = s.nextLine();

        if (checkIfGoodUsername(username)) {
            createPassword(username);
        } else {
            createUsername();
        }

    }

    private void createPassword(String username) {
        Scanner s = new Scanner(System.in);
        printer("Please enter your new password:");
        password = s.nextLine();

        if (checkIfGoodPassword(username)) {
            userType(username, password);
        } else {
            createPassword(username);
        }
    }

    private void userType(String username, String password) {
        Scanner s = new Scanner(System.in);
        printer("Are you an airline or a passenger?");
        userType = s.nextLine();

        if ((userType.equalsIgnoreCase("airline")) || (userType.equalsIgnoreCase("passenger")) ) {
            getName(username, password, userType);
        } else {
            printer("Please enter either airline or passenger.");
            userType(username, password);
        }
    }

    private void getName(String username, String password, String userType) {
        Scanner s = new Scanner(System.in);
        if (userType.equalsIgnoreCase("airline")) {
            printer("What is the name of your airline?");
            name = s.nextLine();
        } else {
            printer("What is your full name?");
            name = s.nextLine();
        }
        emailAddress(username, password, userType, name);
    }

    private void emailAddress(String username, String password, String userType, String name) {
        Scanner s = new Scanner(System.in);
        if (userType.equalsIgnoreCase("airline")) {
            printer("What is your company's email address?");
            emailaddress = s.nextLine();
        } else {
            printer("What is your email address?");
            emailaddress = s.nextLine();
        }
        createAccount(username, password, userType, name, emailaddress);
    }

    public void createAccount(String username, String password, String userType, String name, String emailaddress) {
        Userbase userbase = new Userbase();
        Interface face = new Interface();
        User user = new User(username, password, userType, name, emailaddress);
        userbase.addUsers(username, password, userType, name, emailaddress);
        User currentUser = user.thisIsTheUser(username);
        face.menu(currentUser);
    }

    private boolean checkIfGoodPassword(String password) {
        boolean hasSpace = false;

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == 32) {
                hasSpace = true;
                printer("Your password cannot have spaces in it.");
            }
        }
        if (hasSpace) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkIfGoodUsername(String username) {
        boolean hasSpace = false;
        boolean existsAlready = false;

        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == 32) {
                hasSpace = true;
                printer("Your username cannot have spaces in it.");
            }
        }

        //check through to see if username already exists
        if (hasSpace || existsAlready) {
            return false;
        } else {
            return true;
        }
    }

}
