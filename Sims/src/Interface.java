import java.util.Scanner;

public class Interface {
    private Scanner s = new Scanner(System.in);
    private AvailableJobs availableJobs = new AvailableJobs();
    private AvailableHomes availableHomes = new AvailableHomes();
    private AvailablePeople availablePeople = new AvailablePeople();
    private DayNightCycle dayNightCycle = new DayNightCycle();
    private Town ourTown;
    private Economy townEconomy = new Economy();

    public static void main (String[] args) {
        Interface inter = new Interface();
        inter.tutorial();
    }

    //gets the name of the first resident and builds the first home. Sets up the town.
    public void tutorial() {
        System.out.println("Welcome to the Sims. What would you like to name your town?");
        String townName = s.nextLine();
        ourTown = new Town(townName);
        print("Welcome, mayor of " + ourTown.getTownName() + ". Now it's time to create your first resident. What would you like to name your resident?");
        String personName = s.nextLine();
        personName = capitalizeOtherWords(personName);
        print("How old would you like your resident to be?");
        int age;
        try {
            age = s.nextInt();
            clearLine();
        } catch (Exception e) {
            age = numInt();
        }
        print("What would you like to name their home?");
        String homeName = s.nextLine();
        Home res1Home = createAHome(homeName, "Home", 1);
        String jobTitle = pickJob1(personName);
        createAResident(personName, age, res1Home, jobTitle, availableJobs);
        print("It is time to cycle through your daily activities. You begin the day by taking care of every resident's needs and collecting their" +
                " paycheck. \nFrom there, there are more options to continue to grow and develop " + ourTown.getTownName() + ".");
        AvailableBuildings availableBuildings = new AvailableBuildings(ourTown);
        dayNightCycle.checkOnEachPerson(availablePeople, availableHomes, ourTown, availableJobs, townEconomy, availableBuildings);
    }

    //gets a valid integer input
    private int numInt() {
        clearLine();
        print("That is not a valid input. Please enter a different integer.");
        int in;
        try {
            in = s.nextInt();
            clearLine();
        } catch (Exception e) {
            return numInt();
        }
        if (in < 0) {
            return numInt();
        } else {
            return in;
        }
     }

     //creates the first home
    private Home createAHome(String homeName, String homeOrApartment, int maxNumOfResidents) {
        Home home = new Home(homeName, homeOrApartment, maxNumOfResidents);
        availableHomes.addANewHome(home);
        ourTown.addTownHome(home);
        return home;
    }

    //creates the first resident
    private void createAResident(String personName, int age, Home residentHome, String jobTitle, AvailableJobs availableJobs) {
        Person resident = new Person(personName, age, residentHome, jobTitle, availableJobs, availablePeople, -1);
        residentHome.moveIntoHome(resident);
        availablePeople.addANewPerson(resident);
        ourTown.addTownResident(resident);
        Job theirJob = availableJobs.returnWhichJobThisIs(jobTitle);
        resident.setJob(jobTitle, availableJobs);
        theirJob.addANewEmployee(resident);
    }

    //gets the first job from the defaults
    private String pickJob1(String name) {
        print("Choose one of the following jobs for " + name + ". \n1. Firefighter \n2. Teacher\n3. Groundskeeper");
        int choiced;
        try {
            choiced = s.nextInt();
            clearLine();
        } catch (Exception e) {
            choiced = numInt();
        }
        switch (choiced) {
            case (1):
              return "Firefighter";
            case (2):
                return "Teacher";
            case (3):
                return "Groundskeeper";
            default:
                 print("That is not a valid input.");
                 return pickJob1(name);
        }
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void clearLine() {
        s.nextLine();
    }

    //capitalizes the first letter of the names
    private String capitalizeName(String thingNamed) {
        String firstLetter = (thingNamed.substring(0, 1)).toUpperCase();
        return (firstLetter + thingNamed.substring(1));
    }

    private String capitalizeOtherWords(String thing) {
        String[] array = thing.split(" ");
        String total = "";
        for (int i = 0; i < array.length; i++) {
            if (i + 1 == array.length) {
                total += capitalizeName(array[i]);
            } else {
                total += capitalizeName(array[i]) + " ";
            }
        }
        return total;
    }
}
