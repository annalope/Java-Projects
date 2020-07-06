public class Flight {

    private String startingLocation;
    private String destination;
    private int day;
    private String month;
    private int year;
    private int price;
    private String airline;
    private int flightNum;
    private int numOfBookings;
    private int maxNumOfPassengers;

    public Flight(String startingLocation, String destination, int day, String month, int year, int price, String airline, int flightNum, int maxNumOfPassengers) {
        this.startingLocation = startingLocation;
        this.destination = destination;
        this.day = day;
        this.month = month;
        this.year = year;
        this.price = price;
        this.airline = airline;
        this.flightNum = flightNum;
        this.maxNumOfPassengers = maxNumOfPassengers;
        this.numOfBookings = 0;
    }

    public void setNumOfBookings(int numOfBookings) {
        this.numOfBookings = numOfBookings;
    }

    public void incrementBookings(int byHowMuch) {
        numOfBookings+= byHowMuch;
    }

    public int getDay() {
        return day;
    }

    public int getPrice() {
        return price;
    }

    public int getMaxNumOfPassengers() {
        return maxNumOfPassengers;
    }

    public int getYear() {
        return year;
    }

    public String getAirline() {
        return airline;
    }

    public String getDestination() {
        return destination;
    }

    public String getMonth() {
        return month;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public int getFlightNum() {
        return flightNum;
    }

    public int getNumOfBookings() {
        return numOfBookings;
    }

    public String toString() {
        Flightbase flightbase = new Flightbase();
        int index = flightbase.arrayPosition(this);
        String string;
        String year = null;
        string = "Flight " + flightbase.flightNum(index) + " out of " + flightbase.startingLocation(index) + " to "
         + flightbase.destination(index) + ". It departs on " + flightbase.month(index) + " " + flightbase.day(index);
        if (!(flightbase.year(index) == 2020)) {
            year = ", " + flightbase.year(index);
        }
        string += year + "." + " It costs ";
        return string;
    }
}

