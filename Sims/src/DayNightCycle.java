import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DayNightCycle {
    private Menus menus = new Menus();
    private Scanner s = new Scanner(System.in);
    private Random r = new Random();
    private RepeatMethods repeatMethods = new RepeatMethods();
    private RandomEvents randomEvents = new RandomEvents();
    private int dayNumber = 1;

    public void checkOnEachPerson(AvailablePeople availablePeople, AvailableHomes availableHomes, Town ourTown, AvailableJobs availableJobs, Economy ourEconomy, AvailableBuildings availableBuildings) {
        ArrayList availablePeopleArray = availablePeople.getAvailablePeople();
        boolean taxDay = (dayNumber % 7 == 0);
        boolean electionDay = (dayNumber % 30 == 0);
        print("\nDay " + dayNumber + ":");
        atWarCheckups(availablePeople, ourTown);
        for (int i = 0; i < availablePeople.numOfResidents(); i++) {
            Person thisPerson = (Person) availablePeopleArray.get(i);
            economyStuff(thisPerson, ourEconomy, ourTown, thisPerson.getHouse(), availableBuildings, availablePeople);
            letThemEatCake(thisPerson, ourEconomy, availableJobs, availableBuildings, availablePeople, ourTown);
            if (thisPerson.getDoIApproveOfTheMayor() < 0.05) {
                moveAway(thisPerson, availablePeople, ourTown, availableJobs);
            }
        }
        if (printTheNewsBoard(ourTown, availablePeople, electionDay, availableBuildings, availableJobs, availableHomes)) {
            for (int i = 0; i < availablePeople.numOfResidents(); i++) {
                Person thisPerson = (Person) availablePeopleArray.get(i);
                if (i != 0) {
                    checkTheLoveStatus(thisPerson, availablePeople, availableJobs, ourTown, availableBuildings);
                }
                if (taxDay) {
                    ourTown.collectTaxes(ourEconomy.payTaxes(thisPerson, availableHomes, ourTown));
                }
                if (thisPerson.incrementDays() >= 11) {
                    print(thisPerson.getName() + " has passed away from exposure.");
                    thisPerson.yeetOutOfExistence(availablePeople, ourTown, availableJobs);
                }
            }
            print("\n");
            dayNumber++;
            optionalActions(availableHomes, ourTown, availableJobs, availablePeople, ourEconomy, availableBuildings);
        }
    }

    private void moveAway(Person person, AvailablePeople availablePeople, Town town, AvailableJobs availableJobs) {
        print(person.getName() + " was extremely dissatisfied with your leadership and has moved away.");
        person.yeetOutOfExistence(availablePeople, town, availableJobs);
    }

    private boolean printTheNewsBoard(Town town, AvailablePeople availablePeople, boolean electionDay, AvailableBuildings availableBuildings, AvailableJobs availableJobs, AvailableHomes a) {
        print("\n" + town.getTownName() + " news:");
        if (stillInOffice(availablePeople, electionDay)) {
            town.status(availablePeople);
            print("\nStatus of your residents:");
            for (int i = 0; i < availablePeople.numOfResidents(); i++) {
                Person thisPerson = availablePeople.getAvailablePeople().get(i);
                thisPerson.status();
            }
            announcements(availablePeople, availableJobs, town, availableBuildings, a);
            return true;
        } else {
            return false;
        }
    }

    private boolean stillInOffice(AvailablePeople availablePeople, boolean electionDay) {
        if (electionDay) {
            if (availablePeople.calculateYourApprovalRating() >= 50) {
                print("Congratulations! You were reelected with " + availablePeople.calculateYourApprovalRating() + " percent of the vote.\n");
                return true;
            } else {
                print("Unfortunately, today you lost the election with only " + availablePeople.calculateYourApprovalRating() + " percent fo the vote.");
                return false;
            }
        }
        return true;
    }

    private void announcements(AvailablePeople availablePeople, AvailableJobs availableJobs, Town town, AvailableBuildings availableBuildings, AvailableHomes a) {
        print("\nTown announcements:");
        if (town.getNumResidents() < 5) {
            print("There are no additional announcements today.\n");
        } else {
            randomEvents.randomEvents(availablePeople, availableJobs, availableBuildings, town, this, a);
        }
    }

    private void letThemEatCake(Person person, Economy economy, AvailableJobs availableJobs, AvailableBuildings availableBuildings, AvailablePeople availablePeople, Town town) {
        Home theirResidence = person.getHouse();
        if (theirResidence.getNumOfDaysOfFood() > 0) {
            theirResidence.incrementFood(-1);
        } else {
            if (person.getWalletMoney() <= 0 && person.getWalletMoney() <= 0) {
               starving(person, availableJobs, availableBuildings, availablePeople, town);
            }
            if (!person.getDead()) {
                print("You do not have enough food in the home of " + person.getName() + " to feed them. How many days worth of food would you like to purchase?");
                int daysOfFood;
                try {
                    daysOfFood = s.nextInt();
                    clearLine();
                } catch (Exception e) {
                    daysOfFood = numDiddy();
                }
                if (person.getWalletMoney() - daysOfFood >= 0) {
                    economy.makePurchase(daysOfFood, person);
                    theirResidence.incrementFood(daysOfFood);
                } else {
                    int choice = menus.foodMenu(person.getWalletMoney(), person.getName());
                    if (choice == 1) {
                        repeatMethods.repeatBuyFood(person, theirResidence, economy);
                    } else {
                        repeatMethods.repeatWithdrawMoney(person, economy);
                    }
                }
            }
        }
    }

    private void optionalActions(AvailableHomes availableHomes, Town ourTown, AvailableJobs availableJobs, AvailablePeople availablePeople, Economy ourEconomy, AvailableBuildings availableBuildings) {
        int choice = menus.mainActionsMenu();
        boolean endingTheDay = false;
        switch (choice) {
            case (1):
                availableBuildings.buildABuilding(ourTown, ourEconomy, availableJobs, availablePeople);
                break;
            case (2):
                buildingHomes(availableHomes, ourTown, ourEconomy, availablePeople);
                break;
            case(3):
                createANewResident(availablePeople, availableHomes, availableJobs, ourTown, ourEconomy, availableBuildings);
                break;
            case (4):
                personMenu(availablePeople, availableHomes, ourTown, availableJobs, ourEconomy, availableBuildings);
                break;
            case (5):
                governanceMenu(ourTown, availablePeople);
                break;
            default:
                endingTheDay = true;
                break;
        }
        if (!endingTheDay) {
            optionalActions(availableHomes, ourTown, availableJobs, availablePeople, ourEconomy, availableBuildings);
        } else {
            print("\n----------------------------------------------------------------------");
            checkOnEachPerson(availablePeople, availableHomes, ourTown, availableJobs, ourEconomy, availableBuildings);
        }
    }

    private void atWarCheckups(AvailablePeople availablePeople, Town town) {
        if (town.isAtWar()) {
            town.incrementDaysAtWar();
            for (int i = 0; i < availablePeople.getAvailablePeople().size(); i++) {
                if (availablePeople.getAvailablePeople().get(i).getDoIApproveOfTheMayor() != 0) {
                    availablePeople.getAvailablePeople().get(i).dislikeTheMayor(0.01);
                }
            }
        }
    }

    private void governanceMenu(Town town, AvailablePeople availablePeople) {
        int choice = menus.governanceMenu();
        switch (choice) {
            case (1):
            double taxRate;
            try {
                print("What percent of a person's income would you like to tax?");
               taxRate = s.nextDouble();

            } catch (Exception e) {
                taxRate = percentageCheck();
            }
            if (taxRate > 100 || taxRate < 0) {
                 taxRate = percentageCheck();
            }
            taxRate = (taxRate / (double) 100);
            town.setIncomeTaxRate(taxRate);
            break;
            case (2):
                double proper;
                try {
                    print("What percent of a property's value would you like to tax?");
                    proper = s.nextDouble();
                } catch (Exception e) {
                    proper = percentageCheck();
                }
                if (proper > 100 || proper < 0) {
                    proper = percentageCheck();
                }
                town.setPropertyTaxRate(proper);
                break;
            case (3):
                print("How many posters would you like to buy?");
                int amount;
                try {
                    amount = s.nextInt();
                    clearLine();
                } catch (Exception e) {
                    amount = intCheck(town);
                }

                if (town.getTownTreasury() - (amount * 10) < 0) {
                    print("You cannot afford to buy that many posters. Please enter another number.");
                    amount = intCheck(town);
                }
                town.setTownTreasury(town.getTownTreasury() - amount);
                availablePeople.increasePublicMayorFeelings(amount);
                break;
            case (4):
                if (town.isAtWar()) {
                    print(town.getTownName() + " is already at war.");
                } else {
                    town.setAtWar(true);
                    for (int i = 0; i < availablePeople.getAvailablePeople().size(); i++) {
                        if (availablePeople.getAvailablePeople().get(i).getDoIApproveOfTheMayor() != 0) {
                            availablePeople.getAvailablePeople().get(i).dislikeTheMayor(0.05);
                        }
                    }
                }
                break;
            case (5):
                if (!town.isAtWar()) {
                    print(town.getTownName() + " is not currently at war.");
                } else {
                    double winLose = r.nextDouble();
                    if (winLose >= 0.5) {
                        town.setAtWar(false);
                        town.collectTaxes(town.getDaysAtWar() * 100);
                        for (int i = 0; i < availablePeople.getAvailablePeople().size(); i++) {
                            if (availablePeople.getAvailablePeople().get(i).getDoIApproveOfTheMayor() != 1) {
                                availablePeople.getAvailablePeople().get(i).likeTheMayorMore(0.10);
                            }
                        }
                    } else {
                        town.setAtWar(false);
                        if ((town.getTownTreasury() - (town.getDaysAtWar() * 100)) < 0) {
                            print("Your war has bankrupted the town and caused you to lose the game.");
                            System.exit(0);
                        } else {
                            town.setTownTreasury(town.getTownTreasury() - (town.getDaysAtWar() * 100));
                            for (int i = 0; i < availablePeople.getAvailablePeople().size(); i++) {
                                if (availablePeople.getAvailablePeople().get(i).getDoIApproveOfTheMayor() != 0) {
                                    availablePeople.getAvailablePeople().get(i).dislikeTheMayor(0.10);
                                }
                            }
                        }
                    }
                }
                break;
        }
    }

    private int intCheck(Town town) {
        try {
            int ans = s.nextInt();
            if (town.getTownTreasury() - (ans * 10) < 0) {
                print("You cannot afford to buy that many posters. Please enter a new number.");
                return intCheck(town);
            } else {
                return ans;
            }
        } catch (Exception e) {
            print("That is not a valid integer. Please enter another number.");
            return intCheck(town);
        }
    }

    private double percentageCheck() {
        print("That is not a valid percentage.");
        try {
            double answer = s.nextDouble();
            if (answer > 1 || answer < 0) {
                return percentageCheck();
            } else {
                return answer;
            }
        } catch (Exception e) {
            return percentageCheck();
        }
    }

    private void personMenu(AvailablePeople availablePeople, AvailableHomes availableHomes, Town town, AvailableJobs availableJobs, Economy economy, AvailableBuildings availableBuildings) {
        print("Which person would you like to view the menu of?");
        Person personInQuestion = availablePeople.printThePeople();
        int choice = menus.personMenu(personInQuestion);
        switch (choice) {
            case (1):
                Home home = getTheirHomeChoice(availableHomes, town, availableJobs, availablePeople, economy, availableBuildings);
                personInQuestion.getHouse().removeAResident(personInQuestion);
                home.moveIntoHome(personInQuestion);
                break;
            case (2):
                reassignAJob(availableJobs, personInQuestion, availableBuildings);
                break;
            case (3):
                economicMenu(personInQuestion, economy);
                break;
            case (4):
                String thing = menus.buyThingsMenu(availableBuildings, town);
                if (!thing.equalsIgnoreCase("")) {
                    switch (thing) {
                        case ("boat"):
                            if (personInQuestion.getWalletMoney() - 150 >= 0) {
                                personInQuestion.setWalletMoney(personInQuestion.getWalletMoney() - 150);
                                town.collectTaxes(150);
                                personInQuestion.boughtSomething("Boat");
                                print(personInQuestion.getName() + " now owns a boat.");
                            } else {
                                print(personInQuestion.getName() + " cannot afford a boat.");
                            }
                            break;
                        case ("pet"):
                            getAPet(personInQuestion, town);
                            break;
                        case ("car"):
                            if (personInQuestion.getWalletMoney() - 100 >= 0) {
                                town.collectTaxes(100);
                                personInQuestion.setWalletMoney(personInQuestion.getWalletMoney() - 100);
                                personInQuestion.boughtSomething("Car");
                                print(personInQuestion.getName() + " now owns a car.");
                            } else {
                                print(personInQuestion.getName() + " cannot afford a car.");
                            }
                            break;
                    }
                }
            case (5):
                if (personInQuestion.getWalletMoney() < 1) {
                    print(personInQuestion.getName() + " cannot afford a lottery ticket.");
                } else {
                    double ran = s.nextDouble();
                    if (ran < 0.02) {
                        String print;
                        String dollar;
                        int value = r.nextInt(1000) + 1;
                        print = personInQuestion.getName() + " won the lottery! They won ";
                        if (town.getTownTreasury() < value) {
                            if (town.getTownTreasury() == 1) {
                                dollar = " dollar!";
                            } else {
                                dollar = " dollars!";
                            }
                            print += town.getTownTreasury() + dollar;
                            personInQuestion.setWalletMoney(personInQuestion.getWalletMoney() + town.getTownTreasury());
                            town.collectTaxes((town.getTownTreasury() * -1));
                        } else {
                            if (value == 1) {
                                dollar = " dollar!";
                            } else {
                                dollar = " dollars!";
                            }
                            print += value + dollar;
                            personInQuestion.setWalletMoney(personInQuestion.getWalletMoney() + value);
                            town.collectTaxes((value * -1));
                        }
                        if (personInQuestion.getDoIApproveOfTheMayor() <= 0.8) {
                            personInQuestion.likeTheMayorMore(0.20);
                        } else if (personInQuestion.getDoIApproveOfTheMayor() <= 0.95) {
                            personInQuestion.likeTheMayorMore(0.05);
                        }
                        print(print);
                    } else {
                        print(personInQuestion.getName() + " did not win the lottery this time.");
                        personInQuestion.setWalletMoney(personInQuestion.getWalletMoney() - 1);
                        if (personInQuestion.getDoIApproveOfTheMayor() >= 0.01) {
                            personInQuestion.dislikeTheMayor(0.01);
                        }
                        town.collectTaxes(1);
                    }
                }
                break;
            case (6):
                if (personInQuestion.getJobTitle().equalsIgnoreCase("Exterminator")) {
                    exterminate(availableHomes, personInQuestion);
                } else {
                    repair(availableHomes, availableBuildings, town, personInQuestion);
                }
            default:
        }
    }

    private void repair(AvailableHomes availableHomes, AvailableBuildings availableBuildings, Town town, Person person) {
        int choice;
        print("Choose one of the following homes or buildings to repair:");
        ArrayList<Home> damaged = availableHomes.printDamagedHomes();
        ArrayList<Building> buildings = availableBuildings.printDamagedBuildings(town, damaged.size());
        if (damaged.size() == 0 && buildings.size() == 0) {
            print("There are not currently any damaged homes or buildings.");
        } else {
            try {
                choice = s.nextInt();
                clearLine();
                if (choice > damaged.size()) {
                    choice = homeBugChoice(damaged);
                }
            } catch (Exception e) {
                choice = homeBugChoice(damaged);
            }
            if (choice <= damaged.size()) {
                availableHomes.unBreak(damaged.get(choice - 1));
                person.setWalletMoney(person.getWalletMoney() + 5);
            } else {
                availableBuildings.unBreak(buildings.get((damaged.size() - choice) - 1));
                person.setWalletMoney(person.getWalletMoney() + 10);
            }

        }
    }

    private void exterminate(AvailableHomes availableHomes, Person person) {
        int choice;
        print("Choose one of the following homes to clean up:");
        ArrayList<Home> list = availableHomes.printHomesWithBugs();
        if (list.size() != 0) {
            try {
                choice = s.nextInt();
                clearLine();
                if (choice > list.size()) {
                    choice = homeBugChoice(list);
                }
            } catch (Exception e) {
                choice = homeBugChoice(list);
            }
            availableHomes.unBugify(list.get(choice - 1));
            person.setWalletMoney(person.getWalletMoney() + 5);
        } else {
            print("There are not currently any homes with bug infestations.");
        }
    }

    private int homeBugChoice(ArrayList<Home> list) {
        int choice;
        print("That is not a valid input. Please enter a different integer.");
        try {
            choice = s.nextInt();
            clearLine();
        } catch (Exception e) {
            return homeBugChoice(list);
        }
        if (choice > list.size()) {
            return homeBugChoice(list);
        } else {
            return choice;
        }
    }

    private int numDiddy() {
        clearLine();
        int num;
        print("That is not a valid input. Please enter a different integer.");
        try {
            num = s.nextInt();
            clearLine();
            return num;
        } catch (Exception e) {
            return numDiddy();
        }
    }

    private void economicMenu(Person person, Economy economy) {
        int choice = menus.economicMenu(person);
        switch (choice) {
            case (1):
                System.out.println("How much money would you like to deposit in the bank?");
                int amount;
                try {
                    amount = s.nextInt();
                    clearLine();
                } catch (Exception e) {
                    amount = numDiddy();
                }
                economy.makeDeposit(amount, person);
                break;
            case (2):
                repeatMethods.repeatWithdrawMoney(person, economy);
                break;
            case (3):
                String dollars;
                if (person.getLoanDebts() == 0) {
                    print(person.getName() + " currently does not have any debt.\n");
                } else {
                    if (person.getLoanDebts() == 1) {
                        dollars = " dollar ";
                    } else {
                        dollars = " dollars ";
                    }
                    print(person.getName() + " currently has " + person.getLoanDebts() + dollars + "in debt. How many dollars would you like to pay?");
                    double toPay;
                    try {
                        toPay = s.nextInt();
                    } catch (Exception e) {
                        toPay = numStock();
                    }
                    person.paySomeDebt(toPay);
                }
                break;
            case (4):
                print("How expensive of a stock would you like to buy?");
                double cost;
                try {
                    cost = s.nextDouble();
                } catch (Exception e) {
                    cost = numStock();
                }
                Stock newStock = new Stock(cost);
                person.buyAStock(newStock);
                break;
            case (5):
                print("Choose one of the following stocks to sell:");
                if (person.printStocks()) {
                    int choose;
                    try {
                        choose = s.nextInt();
                    } catch (Exception e) {
                        print("That is not a valid integer. Please enter another one.");
                        choose = getAChoice(person);
                    }
                    ArrayList<Stock> stocks = person.getStockIOwn();
                    Stock stock = stocks.get(choose - 1);
                    person.sellAStock(stock);
                }
                break;
            case (6):
                print("These are the stocks " + person.getName() + " owns:");
                person.printStocks();
             default:
        }
    }

    private double numStock() {
        clearLine();
        double choice;
        print("That is not a valid input. Please enter a different number.");
        try {
            choice = s.nextDouble();
            clearLine();
            return choice;
        } catch (Exception e) {
            return numStock();
        }
    }

    private int getAChoice(Person person) {
        int choice;
        try {
            choice = s.nextInt();
        } catch (Exception e) {
            print("That is not a valid integer. Please enter another one.");
            return getAChoice(person);
        }
        clearLine();
        if (choice > person.getStockIOwn().size()) {
            print(person.getName() + " does not own a stock option corresponding to that number. Please enter a different number.");
            return getAChoice(person);
        } else {
            return choice;
        }
    }

    private void getAPet(Person person, Town town) {
        String pet = menus.petMenu();
        if (person.getWalletMoney() - getPetPrice(pet) >= 0) {
            town.collectTaxes(getPetPrice(pet));
            person.setWalletMoney(person.getWalletMoney() - getPetPrice(pet));
            person.adoptAPet(pet);
        } else {
            print(person.getName() + " cannot afford that pet.");
        }
    }

    private int getPetPrice(String type) {
        if (type.equalsIgnoreCase("horse")) {
            return 50;
        } else if (type.equalsIgnoreCase("cat") || type.equalsIgnoreCase("dog")) {
            return 20;
        } else if (type.equalsIgnoreCase("parrot") || type.equalsIgnoreCase("fish")) {
            return 15;
        } else {
            return 5;
        }
    }

    private void starving(Person person, AvailableJobs availableJobs, AvailableBuildings availableBuildings, AvailablePeople availablePeople, Town town) {
        int choiced = repeatMethods.repeatLoans(person);
        switch (choiced) {
            case (1):
                //loan
                String space;
                print("How large of a loan would " + person.getName() + " like to take out?");
                double amount;
                try {
                    amount = s.nextInt();
                    clearLine();
                } catch (Exception e) {
                    amount = numStock();
                }
                person.setWalletMoney(amount);
                person.setLoanDebts(amount);
                if (amount == 1) {
                    space = " dollar of debt.";
                } else {
                    space = " dollars of debt.";
                }
                print(person.getName() + " now has " + amount + space + "\n");
                break;
            case (2):
                //new job
                ArrayList<Job> arrayList = availableJobs.printJobsWithRoom(availableBuildings);
                print("Enter the number of the job you would like to choose.");
                int choice;
                try {
                    choice = s.nextInt();
                    clearLine();
                } catch (Exception e) {
                    choice = numDiddy();
                }
                Job newJob = arrayList.get(choice - 1);
                person.takeASecondJob(newJob);
                print("\n");
                break;
            case (3):
                //die
                person.yeetOutOfExistence(availablePeople, town, availableJobs);
                print(person.getName() + " has starved to death.");
                person.die();
                break;
            default:
        }
    }

    private void reassignAJob(AvailableJobs availableJobs, Person newEmployee, AvailableBuildings availableBuildings) {
        ArrayList<Job> arrayList = availableJobs.printJobsWithRoom(availableBuildings);
        print("Enter the number of the job you would like to choose.");
        int choice;
        try {
            choice = s.nextInt();
            clearLine();
        } catch (Exception e) {
            choice = numDiddy();
        }
        Job newJob = arrayList.get(choice - 1);
        newEmployee.setJob(newJob.getJobTitle(), availableJobs);
        print("\n");
    }

    private void createANewResident(AvailablePeople availablePeople, AvailableHomes availableHomes, AvailableJobs availableJobs, Town ourTown, Economy economy, AvailableBuildings availableBuildings){
        clearLine();
        String name = repeatMethods.repeatResidentName(availablePeople, "What would you like to name your new resident?");
        print("How old would you like them to be?");
        int age;
        try {
            age = s.nextInt();
            clearLine();
        } catch (Exception e) {
            age = notNeg();
        }
        if (age < 0) {
            age = notNeg();
        }
        Home homeChoice = getTheirHomeChoice(availableHomes, ourTown, availableJobs, availablePeople, economy, availableBuildings);
        Job theirJob = repeatMethods.repeatJobChoice(availableJobs, availableBuildings);
        String jobTitle = theirJob.getJobTitle();
        createRes(name, age, homeChoice, jobTitle, availableJobs, availablePeople, ourTown, availableBuildings);
        print("\n");
    }

    private int notNeg() {
        clearLine();
        print("That is not a valid input. Please enter a different integer.");
        int choice;
        try {
            choice = s.nextInt();
            clearLine();
        } catch (Exception e) {
            return notNeg();
        }

        if (choice < 0) {
            return notNeg();
        } else {
            return choice;
        }
    }

    public Person createRes(String name, int age, Home homeChoice, String jobTitle, AvailableJobs availableJobs, AvailablePeople availablePeople, Town ourTown, AvailableBuildings availableBuildings) {
        Person resident = new Person(name, age, homeChoice, jobTitle, availableJobs, availablePeople, 1);
        homeChoice.moveIntoHome(resident);
        availablePeople.addANewPerson(resident);
        ourTown.addTownResident(resident);
        availableBuildings.updateBuildingNumbers(ourTown);
        return resident;
    }

    private int homesy(ArrayList<Home> list) {
        print("That is not a valid input. Please enter a new one.");
        int choice;
        try {
            choice = s.nextInt();
            clearLine();
        } catch (Exception e) {
            return homesy(list);
        }
        if (choice > list.size()) {
            return homesy(list);
        } else {
            return choice;
        }
    }

    private Home getTheirHomeChoice(AvailableHomes availableHomes, Town ourTown, AvailableJobs availableJobs, AvailablePeople availablePeople, Economy economy, AvailableBuildings availableBuildings) {
        print("Choose from one of the following available residencies:");
        ArrayList<Home> arrayList = availableHomes.printHomesWithRoom();
        if (arrayList.size() == 0) {
            print("There are no available residencies. Please return to the main menu and choose another action.");
            optionalActions(availableHomes, ourTown, availableJobs, availablePeople, economy, availableBuildings);
        } else {
            int choice;
            try {
                choice = s.nextInt();
                clearLine();
            } catch (Exception e) {
                choice = homesy(arrayList);
            }
            Home home = arrayList.get(choice - 1);
            return home;
        }
        return null;
    }

    private boolean buildingHomes(AvailableHomes availableHomes, Town ourTown, Economy economy, AvailablePeople availablePeople) {
        String type = repeatMethods.repeatHomeApartment();
        if (type.equalsIgnoreCase("home")) {
            String homeName = repeatMethods.repeatHomeName(availableHomes);
            int numResidents = repeatMethods.repeatResident(ourTown);
            if (numResidents == -1) {
                return false;
            }
            createAHome(availableHomes, ourTown, "Home", numResidents, homeName);
            economy.townSpendMoney(numResidents * 100, ourTown);
            for (int i = 0; i < availablePeople.getAvailablePeople().size(); i++) {
                if (availablePeople.getAvailablePeople().get(i).getDoIApproveOfTheMayor() <= 0.99) {
                    availablePeople.getAvailablePeople().get(i).likeTheMayorMore(0.01);
                }
            }
            return true;
        } else {
            if (ourTown.getTownTreasury() < 1000) {
                int choice = repeatMethods.repeatCantAfford();
                if (choice == 2) {
                    return false;
                }
                buildingHomes(availableHomes, ourTown, economy, availablePeople);
            } else {
                int counter = 1;
                clearLine();
                print("What would you like to call your apartment complex?");
                String complexName = s.nextLine();
                for (int i = 0; i < 20; i++) {
                    createAnApartment(availableHomes, ourTown, "Apartment", 2, complexName, counter);
                    counter++;
                }
                economy.townSpendMoney(1000, ourTown);
                for (int i = 0; i < availablePeople.getAvailablePeople().size(); i++) {
                    if (availablePeople.getAvailablePeople().get(i).getDoIApproveOfTheMayor() <= 0.95) {
                        availablePeople.getAvailablePeople().get(i).likeTheMayorMore(0.05);
                    }
                }
            }
        }
        return true;
    }


    private Home createAnApartment(AvailableHomes availableHomes, Town ourTown, String homeOrApartment, int maxNumOfResidents, String homeName, int counter) {
        if (counter < 10) {
            homeName += " " + counter + " ";
        } else {
            homeName += " " + counter;
        }
        Home home = new Home(homeName, homeOrApartment, maxNumOfResidents);
        availableHomes.addANewHome(home);
        ourTown.addTownHome(home);
        return home;
    }

    private Home createAHome(AvailableHomes availableHomes, Town ourTown, String homeOrApartment, int maxNumOfResidents, String homeName) {
        Home home = new Home(homeName, homeOrApartment, maxNumOfResidents);
        availableHomes.addANewHome(home);
        ourTown.addTownHome(home);
        print(repeatMethods.capitalizeOtherWords(homeName) + " has been built.\n");
        return home;
    }

    private void economyStuff(Person person, Economy economy, Town town, Home home, AvailableBuildings availableBuildings, AvailablePeople availablePeople) {
        economy.collectInterest(person);
        economy.receivePaycheck(person, dayNumber, town);
        economy.payUtilities(person, home, town, availableBuildings);
        person.incrementLoanInterest();
        person.changeStockPrices(availablePeople);
        if (person.getHouse().getHomeOrApartment().equalsIgnoreCase("Apartment")) {
            economy.payRent(person.getHouse(), town, person);
        }
        if (dayNumber % 7 == 0) {
            person.payForPets();
        }
    }

    private void checkTheLoveStatus(Person person, AvailablePeople availablePeople, AvailableJobs availableJobs, Town town, AvailableBuildings availableBuildings) {
        if (person.married()) {
            Random r = new Random();
            if (r.nextDouble() > 0.6) {
                if (person.getHouse().getCurrentNumOfResidents() + 1 <= person.getHouse().getMaxNumOfResidents()) {
                    System.out.print("Congratulations! " + person.getName() + " and their spouse " + person.getLoveInterest() + " have had a child. ");
                    newBaby(availablePeople, town, availableJobs, availableBuildings, person);
                } else {
                    System.out.print("Congratulations! " + person.getName() + " and their spouse " + person.getLoveInterest() + " have had a child. ");
                    Person baby = newBaby(availablePeople, town, availableJobs, availableBuildings, person);
                    print("There was not enough room in the home of " + person.getName() + " for " + baby.getName() + " to live. Please visit the person menu to give " + baby.getName() + " a home.");
                    baby.setHomeless(true);
                }
            }
        } else {
            if (person.getLoveInterest().getLoveInterest() == person) {
                    person.setMarried(true);
                    person.getLoveInterest().setMarried(true);
            } else {
                if (person.getLoveInterest().married()) {
                    person.setLoveInterest(availablePeople.getNewLoveInterest());
                } else if (person.incrementNumDays() >= 5) {
                    person.setLoveInterest(availablePeople.getNewLoveInterest());
                }
            }
        }
    }

    private Person newBaby(AvailablePeople availablePeople, Town ourTown, AvailableJobs availableJobs, AvailableBuildings availableBuildings, Person parent) {
        clearLine();
        String name = repeatMethods.repeatResidentName(availablePeople, "What would you like to name the new baby?");
        int age = 1;
        Home homeChoice = parent.getHouse();
        Job theirJob = availableJobs.returnWhichJobThisIs("Unemployed");
        String jobTitle = theirJob.getJobTitle();
        Person resident = new Person(name, age, homeChoice, jobTitle, availableJobs, availablePeople, 1);
        homeChoice.moveIntoHome(resident);
        availablePeople.addANewPerson(resident);
        ourTown.addTownResident(resident);
        availableBuildings.updateBuildingNumbers(ourTown);
        print("\n");
        return resident;
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void clearLine() {
        s.nextLine();
    }
}
