import java.util.Scanner;

public class SignIn {

    int arrayPosition = 0;
    String userType;

    public void printer(String input) {
        System.out.println(input);
    }

    public void checkUsername() {
        Scanner s = new Scanner(System.in);
        Userbase userbase = new Userbase();
        CreateAccount createAccount = new CreateAccount();
        printer("Username:");
        String username = s.nextLine();

        if (userbase.validateUsernameSignIn(username)) {
            checkPassword(username);
        } else if (username.equalsIgnoreCase("create account")) {
            createAccount.createUsername();
        } else {
            printer("That is not a valid username. To create an account, type in 'Create account'");
            checkUsername();
        }
    }

    private void checkPassword(String username) {
        Scanner s = new Scanner(System.in);
        Interface face = new Interface();
        Userbase userbase = new Userbase();
        printer("Password:");
        String password = s.nextLine();

        if (userbase.validatePasswordSignIn(username, password)) {
            int arraySpot = userbase.getUserInformation(username);
            String userType = userbase.userType(userbase.getUserInformation(username));
            String name = userbase.name(userbase.getUserInformation(username));
            String emailAddress = userbase.emailAddress(userbase.getUserInformation(username));
            User user = new User(username, password, userType, name, emailAddress);
            User currentUser = user.thisIsTheUser(username);
            face.menu(currentUser);
        } else {
            printer("Your password is incorrect. Try again");
            checkPassword(username);
        }
    }
}
