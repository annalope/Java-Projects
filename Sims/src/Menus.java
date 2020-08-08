import java.util.Scanner;

public class Menus {
    private Scanner s = new Scanner(System.in);

    //prints the options if someone cannot afford the amount of food they're trying to buy
    public int foodMenu(double amountInWallet, String name) {
        print(name + " cannot afford that many days of food because you only have " + amountInWallet + " dollars in your wallet. " +
                "Your options are:\n1. Buy less food \n2. Withdraw money from the bank");
        int choice;
        try {
            choice = s.nextInt();
            clearLine();
        } catch (Exception e) {
            choice = numDiddy();
        }
        if (choice != 1 && choice != 2) {
            print("That is not a valid option. Try again.");
            return foodMenu(amountInWallet, name);
        } else {
            return choice;
        }
    }

    //extra actions for a resident
    public int personMenu(Person person) {
        int choice;
        String toPrint = "Choose an action for " + person.getName() + ": \n1. Move into a new home \n2. Get a new job \n3. View Economic Menu " +
                "\n4. Buy something\n5. Buy a lottery ticket";
        if (person.getJobTitle().equalsIgnoreCase("Exterminator")) {
            toPrint += "\n6. Clean up a bug infestation";
        } else if (person.getJobTitle().equalsIgnoreCase("Handyman")) {
            toPrint += "\n6. Repair a broken home";
        }
        print(toPrint);
        try {
            choice = s.nextInt();
            clearLine();
        } catch (Exception e) {
            choice = numDiddy();
        }
        if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6) {
            print("That is not a valid input. Try again.");
            return personMenu(person);
        } else {
            if (!(person.getJobTitle().equalsIgnoreCase("Handyman")) && !(person.getJobTitle().equalsIgnoreCase("Exterminator")) && choice == 6) {
                print("That is not a valid input. Try again.");
                return personMenu(person);
            } else {
                return choice;
            }
        }
    }

    //menu of things a resident can do regarding their funds
    public int economicMenu(Person person) {
        print("Choose an economic action for " + person.getName() + ": \n1. Deposit money in the back \n2. Withdraw money from the bank" +
                "\n3. Pay off a loan \n4. Buy Stocks \n5. Sell stocks\n6. Check the status of stocks");
        int choice;
        try {
            choice = s.nextInt();
            clearLine();
        } catch (Exception e) {
            choice = numDiddy();
        }
        if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6) {
            return economicMenu(person);
        } else {
            return choice;
        }
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void clearLine() {
        s.nextLine();
    }

    //lets residents buy things for themselves
    public String buyThingsMenu(AvailableBuildings availableBuildings, Town town) {
        String pet = "";
        boolean pett = false;
        boolean carr = false;
        String print;
        String car = "";
        int counter = 2;
        if (availableBuildings.buildingInExistence("Animal Shelter")) {
            pet = ". A Pet";
        }
        if (availableBuildings.buildingInExistence("Car Dealership")) {
            car = ". A Car";
        }
        print = "The shopping center in " + town.getTownName() + " sells the following: \n1. A Boat";
        if (!(pet.equalsIgnoreCase(""))) {
            print += "\n" + counter + pet;
            pett = true;
            counter++;
        }
        if (!(car.equalsIgnoreCase(""))) {
            print += "\n" + counter + car;
            carr = true;

        }
        print(print);
        int yourChoice;
        try {
            yourChoice = s.nextInt();
            clearLine();
        } catch (Exception e) {
            yourChoice = numDiddy();
        }
        if (yourChoice != 1 && yourChoice != 2 && yourChoice != 3 && yourChoice != -1) {
            print("That is not a valid input try again. Enter -1 to cancel");
            return buyThingsMenu(availableBuildings, town);
        } else {
            if (!pett && yourChoice == 3) {
                print("That is not a valid input try again. Enter -1 to cancel");
                return buyThingsMenu(availableBuildings, town);
            } else if (!carr && yourChoice == 3) {
                print("That is not a valid input try again. Enter -1 to cancel");
                return buyThingsMenu(availableBuildings, town);
            } else if (!pett && !carr && yourChoice == 2) {
                print("That is not a valid input try again. Enter -1 to cancel");
                return buyThingsMenu(availableBuildings, town);
            }

            switch (yourChoice) {
                case (-1):
                    return "";
                case (1):
                    return "boat";
                case (2):
                    if (pett) {
                        return "pet";
                    } else {
                        return "car";
                    }
                case (3):
                    return "car";
            }

        }
        return "";
    }

    //chooses what pet a resident wants to buy
    public String petMenu() {
        print("Choose one of the following pets: \n1. Cat \n2. Dog \n3. Fish \n4. Parrot\n5. Horse \n6. Rock");
        int choice;
        try {
            choice = s.nextInt();
            clearLine();
        } catch (Exception e) {
            choice = numDiddy();
        }
        if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6) {
            print("That is not a valid input. Please try again.");
            return petMenu();
        } else {
            switch (choice) {
                case (1):
                    return "Cat";
                case (2):
                    return "Dog";
                case (3):
                    return "Fish";
                case (4):
                    return "Parrot";
                case (5):
                    return "Horse";
                default:
                    return "Rock";
            }
        }
    }

    //options for the mayor to choose regarding the town government
    public int governanceMenu() {
        print("Choose an action for your town: \n1. Change the income tax rate\n2. Change the property tax rate" +
                " \n3. Campaign for reelection \n4. Declare war\n5. End a war");
        int choice;
        try {
            choice = s.nextInt();
            clearLine();
        } catch (Exception e) {
            choice = numDiddy();
        }
        if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
            return governanceMenu();
        } else {
            return choice;
        }
    }

    //main menu
    public int mainActionsMenu() {
        print("Choose your next action: \n1. Build a new building \n2. Build a new home " +
                "\n3. Create a new resident \n4. View Person Menu \n5. View Governance Menu \n6. End the day");
        int choice;
        try {
            choice = s.nextInt();
            clearLine();
        } catch (Exception e) {
            choice = numDiddy();
        }
        if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6) {
            print("That is not a valid input. Try again.");
            return mainActionsMenu();
        } else {
            return choice;
        }
    }

    //repeats until it gets a valid integer
    private int numDiddy() {
        clearLine();
        print("That is not a valid input. Please enter a different integer.");
        int cho;
        try {
            cho = s.nextInt();
            clearLine();
            return cho;
        } catch (Exception e) {
            return numDiddy();
        }
    }
}
