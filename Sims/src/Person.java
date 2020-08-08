import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Person {

    private String name;
    private int age;
    private Home house;
    private String placeOfWork;
    private String jobTitle;
    private int salary;
    private double walletMoney = 10.0;
    private double bankValue;
    private double loanDebts = 0;
    private double doIApproveOfTheMayor = 1.0;
    private Person loveInterest;
    private boolean married = false;
    private boolean homeless = false;
    private int daysHomeless = 0;
    private int numDaysInterested = 0;
    private boolean dead = false;
    private ArrayList<Pet> pets = new ArrayList<>(1);
    private ArrayList<String> possessions = new ArrayList<>(1);
    private ArrayList<Job> jobsIHold = new ArrayList<>(1);
    private ArrayList<Stock> stockIOwn = new ArrayList<>(1);

    private Scanner s = new Scanner(System.in);
    private Random r = new Random();

    public Person(String name, int age, Home house, String jobTitle, AvailableJobs availableJobs, AvailablePeople availablePeople, int num) {
        RepeatMethods repeatMethods = new RepeatMethods();
        this.name = repeatMethods.capitalizeOtherWords(name);
        this.age = age;
        this.house = house;
        this.jobTitle = jobTitle;
        this.placeOfWork = availableJobs.returnPlaceOfWork(jobTitle);
        this.salary = availableJobs.returnSalaryADay(jobTitle);
        if (num != -1) {
            this.loveInterest = availablePeople.getNewLoveInterest();
        }
    }

    //getter/setter stuff
    public boolean isHomeless() {
        return homeless;
    }

    public boolean getDead() {
        return dead;
    }

    public void die() {
        dead = true;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void boughtSomething(String nameOfThing) {
        possessions.add(nameOfThing);
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public ArrayList<Stock> getStockIOwn() {
        return stockIOwn;
    }

    public double getDoIApproveOfTheMayor() {
        return doIApproveOfTheMayor;
    }

    public Person getLoveInterest() {
        return loveInterest;
    }

    public int incrementDays() {
        daysHomeless++;
        return daysHomeless;
    }

    public void setLoveInterest(Person loveInterest) {
        this.loveInterest = loveInterest;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public boolean married() {
        return married;
    }

    public void changeStockPrices(AvailablePeople availablePeople) {
        double percent;
        for (int i = 0; i < stockIOwn.size(); i++) {
            percent = roundIt(r.nextDouble() + availablePeople.calculateYourApprovalRating());
            stockIOwn.get(i).changeCurrentPrice(percent);
        }
    }

    public boolean printStocks() {
        int counter = 1;
        if (stockIOwn.size() == 0) {
            print(name + " does not own any stocks.\n");
            return false;
        } else {
            for (int i = 0; i < stockIOwn.size(); i++) {
                System.out.print("Stock " + counter + " costs ");
                stockIOwn.get(i).stockToString();
                counter++;
            }
            print("\n");
            return true;
        }
    }

    public void buyAStock(Stock stock) {
        String dollar;
        if (totalStock() == 1) {
            dollar = " dollar";
        } else {
            dollar = " dollars";
        }
        if (walletMoney - stock.getInitialPrice() < 0) {
            print(name + " cannot afford to buy this stock.");
        } else {
            walletMoney = (walletMoney - stock.getInitialPrice());
            stockIOwn.add(stock);
            print(name + " now owns " + totalStock() + dollar + " worth of stock.\n");
        }
    }

    private double totalStock() {
        double total = 0;
        for (int i = 0; i < stockIOwn.size(); i++) {
            total += stockIOwn.get(i).getCurrentPrice();
        }
        return total;
    }

    public void sellAStock(Stock stock) {
        String dollar;
        if (stock.getCurrentPrice() == 1) {
            dollar = " dollar";
        } else {
            dollar = " dollars";
        }
        walletMoney += stock.getCurrentPrice();
        stockIOwn.remove(stock);
        print(name + " no longer owns that stock. They made " + stock.getCurrentPrice() + dollar + ".\n");
    }

    //here in case of an update that requires its use
    public void printPossessions() {
        int boatCount = 0;
        int carCount = 0;
        if (possessions.size() == 0) {
            print(name + " currently has no possessions.");
        } else {
            String car;
            String boat;
            String toPrint = name + " has ";
            for (int i = 0; i < possessions.size(); i++) {
                if (possessions.get(i).equalsIgnoreCase("Car")) {
                    carCount++;
                } else {
                    boatCount++;
                }
            }
            if (carCount == 1) {
                car = " car ";
            } else {
                car = " cars ";
            }
            if (boatCount == 1) {
                boat = " boat ";
            } else {
                boat = " boats ";
            }
            toPrint += carCount + car + " and " + boatCount + boat + ".";
            print(toPrint);
        }
    }

    //adopts a pet for a resident
    public void adoptAPet(String type) {
        print("What would you like to name your " + type + "?");
        String name = s.nextLine();
        Pet pet = new Pet(name, type, this);
        pets.add(pet);
    }

    //returns a valid double
    private double numDoub() {
        s.nextLine();
        print("That is not a valid input. Please enter another number.");
        double doub;
        try {
            doub = s.nextDouble();
            s.nextLine();
            return doub;
        } catch (Exception e) {
            return numDoub();
        }
    }

    public void payForPets() {
        double sum = 0;
        for (int i = 0; i < pets.size(); i++) {
            sum += pets.get(i).getDailyMaintenance();
        }
        if (walletMoney - sum < 0) {
            String owe;
            if ((sum - walletMoney) == 1) {
                owe = " dollar ";
            } else {
                owe = " dollars ";
            }
            System.out.print(name + " cannot afford to pay taxes and is now in debt. They owe " + (sum - walletMoney) + owe + " and has to take out a loan.");
            String space;
            System.out.println(" How large of a loan would " + name + " like to take out?");
            double amount;
            try {
                amount = s.nextInt();
                s.nextLine();
            } catch (Exception e) {
                amount = numDoub();
            }
            walletMoney = amount;
            loanDebts = amount;
            if (amount == 1) {
                space = " dollar of debt.";
            } else {
                space = " dollars of debt.";
            }
            System.out.println(name + " now has " + amount + space + "\n");
        }

        walletMoney -= sum;
    }


    public int incrementNumDays() {
        if (homeless) {
            numDaysInterested++;
        }
        return numDaysInterested;
    }

    public void setHomeless(boolean homeless) {
        this.homeless = homeless;
        if (homeless) {
            house.removeAResident(this);
            house = null;
        }
    }

    public void dislikeTheMayor(double amount) {
        doIApproveOfTheMayor -= amount;
    }

    public void likeTheMayorMore(double amount) {
        doIApproveOfTheMayor += amount;
    }

    public int returnThisJobsSalary(int i) {
        return jobsIHold.get(i).getSalaryADay();
    }

    public int numOfJobsIHold() {
        return jobsIHold.size();
    }

    public void status() {
        String walletSingular;
        String bankSingular;
        String foodSingular;

        if (walletMoney == 1) {
            walletSingular = " dollar in their wallet and ";
        } else {
            walletSingular = " dollars in their wallet and ";
        }

        if (bankValue == 1) {
            bankSingular = " dollar in their bank account. They have ";
        } else {
            bankSingular = " dollars in their bank account. They have ";
        }

        if (house.getNumOfDaysOfFood() == 1) {
            foodSingular = " day worth of food ";
        } else {
            foodSingular = " days worth of food ";
        }

        print(name + " currently has " + roundIt(walletMoney) + walletSingular + roundIt(bankValue) + bankSingular + house.getNumOfDaysOfFood() + foodSingular +
                "in their home.");
    }

    //delete from the game essentially
    public void yeetOutOfExistence(AvailablePeople availablePeople, Town town, AvailableJobs availableJobs) {
        house.removeAResident(this);
        availablePeople.deleteAPerson(this);
        town.deleteAResident(this);
        availableJobs.returnWhichJobThisIs(jobTitle).fireSomebody(this);
    }

    public void paySomeDebt(double amount) {
        if (walletMoney - amount < 0) {
            print(name + " cannot afford to pay off that much debt. Please enter a new amount. Enter -1 to cancel.");
            double newAmount;
            try {
                newAmount = s.nextInt();
                s.nextLine();
            } catch (Exception e) {
                newAmount = numDoub();
            }
            if (newAmount != -1) {
                paySomeDebt(newAmount);
            }
        } else {
            loanDebts -= amount;
            walletMoney -= amount;
        }
    }

    public void incrementLoanInterest() {
        double interest = roundIt(loanDebts * 0.01);
        loanDebts += interest;
    }

    //getter/setter stuff
    public Home getHouse() {
        return house;
    }

    public double getWalletMoney() {
        return walletMoney;
    }

    public double getBankValue() {
        return bankValue;
    }

    private double roundIt(double unroundedNum) {
        return (Math.round(unroundedNum * 100))/(double) 100;
    }

    public int getSalary() {
        return salary;
    }

    public void setBankValue(double bankValue) {
        this.bankValue = bankValue;
    }

    public void addBankMoney(double amount) {
        bankValue += amount;
    }

    public void setLoanDebts(double loanDebts) {
        this.loanDebts = loanDebts;
    }

    public double getLoanDebts() {
        return loanDebts;
    }

    public void addWalletMoney(double money) {
        walletMoney += money;
    }

    public void setWalletMoney(double walletMoney) {
        this.walletMoney = walletMoney;
    }

    public void takeASecondJob(Job job) {
        this.jobsIHold.add(job);
    }

    public void setJob(String jobTitle, AvailableJobs availableJobs) {
        this.jobTitle = jobTitle;
        this.placeOfWork = availableJobs.returnPlaceOfWork(jobTitle);
        this.salary = availableJobs.returnSalaryADay(jobTitle);
        this.jobsIHold.add(availableJobs.returnWhichJobThisIs(jobTitle));
        if (jobTitle.equalsIgnoreCase("Unemployed")) {
            doIApproveOfTheMayor -= 0.1;
        }
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getName() {
        return name;
    }

    //toString method
    public void aToStringMethod() {
        System.out.println(name + ", " + age + ", " + jobTitle);
    }

    public void print(String message) {
        System.out.println(message);
    }
}
