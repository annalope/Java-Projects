import java.util.ArrayList;
import java.util.Scanner;

public class RepeatMethods {
    private Scanner s = new Scanner(System.in);
    private Menus menus = new Menus();

    public String repeatHomeApartment() {
        String type;
        print("Would you like to build a home or apartment complex?");
        type = s.nextLine();
        if (!(type.equalsIgnoreCase("home")) && !(type.equalsIgnoreCase("apartment complex"))) {
            print("That is not a valid input. Try again.");
            repeatHomeApartment();
        }
        return type;
    }

    private int numInt() {
        clearLine();
        print("That is not a valid input. Please enter a different integer.");
        int inte;
        try {
            inte = s.nextInt();
            clearLine();
            return inte;
        } catch (Exception e) {
            return numInt();
        }
    }

    public int repeatLoans(Person person) {
        int choice;
        person.dislikeTheMayor(0.1);
        print(person.getName() + " cannot afford to buy any food. They have three options: \n1. Get a loan from the bank" +
                "\n2. Get another job \n3. Starve");
        try {
            choice = s.nextInt();
            clearLine();
        } catch (Exception e) {
            choice = numInt();
        }
        if (choice != 1 && choice != 2 && choice != 3) {
            print("That is not a valid choice. Please try again.");
            return repeatLoans(person);
        } else {
            return choice;
        }
    }

    public void repeatBuyFood(Person person, Home theirResidence, Economy economy) {
        int daysOfFood;
        int answer;
        print("How much food would you like to buy?");
        try {
            daysOfFood = s.nextInt();
            clearLine();
        } catch (Exception e) {
            daysOfFood = numInt();
        }
        if (person.getWalletMoney() - daysOfFood >= 0) {
            economy.makePurchase(daysOfFood, person);
            theirResidence.incrementFood(daysOfFood);
        } else {
            answer = menus.foodMenu(person.getWalletMoney(), person.getName());
            if (answer == 1) {
                repeatBuyFood(person, theirResidence, economy);
            }
        }
    }

    public int repeatCantAfford() {
        print("You cannot afford to build an apartment complex. You have two options:\n1. Build a home\n2. Cancel");
        int choices;
        try {
            choices = s.nextInt();
            clearLine();
        } catch (Exception e) {
            choices = numInt();
        }
        if (choices != 1 && choices != 2) {
            print("That input is not valid. Please try again.");
            repeatCantAfford();
        }
        return choices;
    }

    public void repeatWithdrawMoney(Person person, Economy economy) {
        int withdrawMon;
        print("How much money would you like to withdraw? Enter -1 to cancel.");
        try {
            withdrawMon = s.nextInt();
            clearLine();
        } catch (Exception e) {
            withdrawMon = numInt();
        }
        if (withdrawMon != -1) {
            if (person.getBankValue() - withdrawMon >= 0) {
                economy.withdrawBankMoney(withdrawMon, person);
            } else {
                print("You cannot afford to withdraw that much money because you only have " + person.getBankValue() + " dollars in your bank account.");
            }
        }
    }

    private String capitalizeBuNotInTheEconomicWay(String thingNamed) {
        String firstLetter = (thingNamed.substring(0, 1)).toUpperCase();
        return (firstLetter + thingNamed.substring(1));
    }

    public String capitalizeOtherWords(String thing) {
        String[] array = thing.split(" ");
        String total = "";
        for (int i = 0; i < array.length; i++) {
            if (i + 1 == array.length) {
                total += capitalizeBuNotInTheEconomicWay(array[i]);
            } else {
                total += capitalizeBuNotInTheEconomicWay(array[i]) + " ";
            }
        }
        return total;
    }

    public Job repeatJobChoice(AvailableJobs availableJobs, AvailableBuildings availableBuildings) {
        int jobChoices;
        print("These are the available jobs. Type the number of the job you would like to select:");
        ArrayList<Job> arrayList = availableJobs.printJobsWithRoom(availableBuildings);
        try {
            jobChoices = s.nextInt();
            clearLine();
        } catch (Exception e) {
            jobChoices = numInt();
        }
        return (arrayList.get(jobChoices - 1));
    }

    public int repeatResident(Town ourTown) {
        int numResy;
        print("How many residents would you like the home to hold?");
        try {
            numResy = s.nextInt();
            clearLine();
        } catch (Exception e) {
            numResy = numInt();
        }
        if (numResy != -1) {
            if (numResy * 100 > ourTown.getTownTreasury()) {
                print("Your town cannot afford to build a house of that size. Please try again. Enter -1 to cancel.");
                repeatResident(ourTown);
            }
        }
        return numResy;
    }

    public String repeatHomeName(AvailableHomes availableHomes) {
        print("What would you like to name your home?");
        String homeName = s.nextLine();
        if (availableHomes.checkIfNameExists(homeName)) {
            print("You have already named a home " + capitalizeOtherWords(homeName) + ". Please enter a different name.");
            return repeatHomeName(availableHomes);
        } else {
            return homeName;
        }
    }

    public String repeatResidentName(AvailablePeople availablePeople, String string) {
        print(string);
        String residentName = s.nextLine();
        if (availablePeople.checkIfNameExists(residentName)) {
            print("You have already named a person " + capitalizeOtherWords(residentName) + ". Please enter a different name.");
            return repeatResidentName(availablePeople, string);
        } else {
            return residentName;
        }
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void clearLine() {
        s.nextLine();
    }

}
