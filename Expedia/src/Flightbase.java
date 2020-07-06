import java.util.ArrayList;
import java.util.Scanner;

public class Flightbase {

    public ArrayList flightbase = new ArrayList(100);
    public ArrayList flightNumberList = new ArrayList(100);
    private ArrayList whatTheyveBooked = new ArrayList(5);
    int currentFlightNum = 100;

    public void addFlights(String startingLocation, String destination, int day, String month, int year, int price, String airline, int maxNumOfPassengers) {
        Flight flight = new Flight(startingLocation, destination, day, month, year, price, airline, currentFlightNum, maxNumOfPassengers);
        flightbase.add(flight);
        flightNumberList.add(currentFlightNum);
        currentFlightNum++;
    }

    public void airlineFlights(User airline) {
        for (int i = 0; i < flightbase.size(); i++) {
            if (airline(i).equalsIgnoreCase(airline.toString())) {
                Flight flight = (Flight) flightbase.get(i);
                System.out.println(flight.toString());
            }
        }
    }

    public void cancelAFlight(Flight flight, User currentUser) {
        flight.incrementBookings(-1);
        giveTheCorporationsTheirMoney(flight, (-1 * flight.getPrice()));
        currentUser.addMoney(flight.getPrice());
        whatTheyveBooked.remove(flight);
        System.out.println("You are no longer a passenger on Flight " + flight.getFlightNum() + ".");
    }

    public ArrayList fromYourLocation(String startingLoc) {
        int num = 1;
        ArrayList flightsFromYourLocation = new ArrayList(10);

        for (int i = 0; i < flightbase.size(); i++) {
            Flight flight2 = (Flight) flightbase.get(i);
            if (startingLoc.equalsIgnoreCase(flight2.getStartingLocation())) {
                System.out.println(num + ". " + flight2.toString());
                flightsFromYourLocation.add(flight2);
                num++;
            }
        }
        return flightsFromYourLocation;
    }

    public boolean bookAFlight(User passenger, Flight flight) {
        Scanner s = new Scanner(System.in);
        if (flight.getNumOfBookings() < flight.getMaxNumOfPassengers()) {
            if (flight.getNumOfBookings()> flight.getMaxNumOfPassengers()) {
                System.out.println("Sorry, this flight can only accommodate " + (flight.getMaxNumOfPassengers() - flight.getNumOfBookings()) + " of tickets.");
                return false;
            } else {
                System.out.println("You are now a passenger on Flight " + flight.getFlightNum() + ".");
                flight.incrementBookings(1);
                passenger.subtractMoney(flight.getPrice());
                giveTheCorporationsTheirMoney(flight, flight.getPrice());
                whatTheyveBooked.add(flight);
                return true;
            }
        } else {
            System.out.println("Sorry, this flight is fully booked. Please select another one.");
            return false;
        }
    }

    public ArrayList getWhatTheyveBooked() {
        return whatTheyveBooked;
    }

    public void whatTheyveBookedToString(ArrayList whatTheyBook) {
        for (int i = 0; i < whatTheyBook.size(); i++) {
            Flight fligh = (Flight) whatTheyBook.get(i);
            fligh.toString();
        }
    }

    public User findTheAccountDetails(Flight flight) {
        Userbase userbase = new Userbase();
        String airline = flight.getAirline();
        return userbase.thisUser(airline);
    }

    private void giveTheCorporationsTheirMoney(Flight flight, int price) {
        User airline = findTheAccountDetails(flight);
        airline.addMoney(price);
    }

    public int arrayPosition(Flight flight) {
        return flightbase.indexOf(flight);
    }

    public String startingLocation(int index) {
        Flight flight = (Flight) flightbase.get(index);
        return flight.getStartingLocation();
    }

    public String destination(int index) {
        Flight flight = (Flight) flightbase.get(index);
        return flight.getDestination();
    }

    public int day(int index) {
        Flight flight = (Flight) flightbase.get(index);
        return flight.getDay();
    }

    public String month(int index) {
        Flight flight = (Flight) flightbase.get(index);
        return flight.getMonth();
    }

    public int year(int index) {
        Flight flight = (Flight) flightbase.get(index);
        return flight.getYear();
    }

    public int price(int index) {
        Flight flight = (Flight) flightbase.get(index);
        return flight.getPrice();
    }

    public String airline(int index) {
        Flight flight = (Flight) flightbase.get(index);
        return flight.getAirline();
    }

    public int flightNum(int index) {
        Flight flight = (Flight) flightbase.get(index);
        return flight.getFlightNum();
    }
}
