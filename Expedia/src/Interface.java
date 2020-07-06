import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Interface {
    private Scanner s = new Scanner(System.in);
    Flightbase flightbase = new Flightbase();
    public static File userFile = new File("/Users/annaivansevic/lib/userbase.json");

    public static void main (String[] args) {
        SignIn signIn = new SignIn();
        System.out.println("Please sign into Expedia. To create an account, type in 'Create account'.");
        signIn.checkUsername();
    }

    public File returnUserbase() {
        return userFile;
    }

    public void delete() {
        userFile.delete();
    }

    public void printer(String input) {
        System.out.println(input);
    }

    public void menu(User currentUser) {
        if (currentUser.getUserType().equalsIgnoreCase("airline")) {
            airlineMenu(currentUser);
        } else {
            passengerMenu(currentUser);
        }
    }

    private void airlineMenu(User currentUser) {
        boolean error = false;
        printer("Hello, " + currentUser.getUsername() + ". Choose an action below.");
        printer("1. Schedule a new flight");
        printer("2. Check status of flights");
        printer("3. Check earnings");
        int i;
        do {
            i = s.nextInt();
            if (i == 1 || i == 2 || i == 3) {
                error = true;
            } else {
                s.nextLine();
                System.out.println("Please enter either 1, 2, or 3.");
            }
        } while (!error);

        switch (i) {
            case (1):
                scheduleAFlight(currentUser);
                break;
            case (2):
                airlineCheckFlightStatus(currentUser);
                break;
            case (3):
                checkEarnings(currentUser);
                break;
            default:
        }
    }

    private void checkEarnings(User currentUser) {
        System.out.println("You have made " + currentUser.getMoney() + " dollars.");
        System.out.println("\n \n \n");
        airlineMenu(currentUser);
    }

    private void airlineCheckFlightStatus(User currentUser) {
        System.out.println("These are the flights you are currently offering:");
        flightbase.airlineFlights(currentUser);
        System.out.println("\n \n \n");
        airlineMenu(currentUser);
    }

    private void scheduleAFlight(User currentUser) {
        System.out.println("What is the starting location?");
        String startingLocation = s.nextLine();
        System.out.println("What is the destination?");
        String destination = s.nextLine();
        System.out.println("Which day of the month is it?");
        int day = s.nextInt();
        System.out.println("What month is it in?");
        String month = s.nextLine();
        System.out.println("What year is it in?");
        int year = s.nextInt();
        System.out.println("What does each ticket cost?");
        int price = s.nextInt();
        String airline = currentUser.name;
        System.out.println("How many passengers can your flight hold?");
        int maxNumOfPassengers = s.nextInt();
        flightbase.addFlights(startingLocation, destination, day, month, year, price, airline, maxNumOfPassengers);
        System.out.println("Your flight has been scheduled. \n \n \n");
        airlineMenu(currentUser);
    }

    private void passengerMenu(User currentUser) {
        printer("Hello, " + currentUser.getUsername() + ". Choose an action below.");
        printer("1. Book a flight");
        printer("2. Check status of flights");
        printer("3. Cancel a flight");
        int input = s.nextInt();
        switch (input) {
            case (1):
                chooseAFlight(currentUser);
                break;
            case (2):
                checkBookedFlights(currentUser);
                break;
            case (3):
                cancelAFlight(currentUser);
                break;
            default:
        }
    }

    private void checkBookedFlights(User currentUser) {
        System.out.println("You have booked the following flights:");
        flightbase.whatTheyveBookedToString(flightbase.getWhatTheyveBooked());
        System.out.println("\n \n \n");
        passengerMenu(currentUser);
    }

    private void chooseAFlight(User currentUser) {
        System.out.println("What is your starting location?");
        String startingLoc = s.nextLine();
        ArrayList flights = flightbase.fromYourLocation(startingLoc);
        System.out.println("Which number are you interested in?");
        int choice = s.nextInt();
        Flight flight4 = (Flight) flights.get(choice - 1);
        boolean carriedOut = flightbase.bookAFlight(currentUser, flight4);
        if (carriedOut) {
            System.out.println("\n \n \n");
            passengerMenu(currentUser);
        } else {
            System.out.println("Would you like to select a different flight?");
            String answer = s.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                chooseAFlight(currentUser);
            } else {
                System.out.println("\n \n \n");
                passengerMenu(currentUser);
            }
        }
    }

    private void cancelAFlight(User currentUser) {
        System.out.println("These are the flights you are currently booked for: ");
        int num = 1;
        ArrayList whatTheyBooked = flightbase.getWhatTheyveBooked();
        for (int i = 0; i < whatTheyBooked.size(); i++) {
            Flight fli = (Flight) whatTheyBooked.get(i);
            printer(num + ". " + fli.toString());
            num++;
        }
        printer("Which number would you like to cancel?");
        int canceled = s.nextInt();
        Flight canceledD = (Flight) whatTheyBooked.get(canceled - 1);
        flightbase.cancelAFlight(canceledD, currentUser);
        System.out.println("\n \n \n");
        passengerMenu(currentUser);
    }
}
