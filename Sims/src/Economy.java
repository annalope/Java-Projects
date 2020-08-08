import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Economy {
    private Scanner s = new Scanner(System.in);
    private Random r = new Random();

    public double payTaxes(Person person, AvailableHomes availableHomes, Town town) {
        double taxes = (((double) person.getSalary()) * town.getIncomeTaxRate());
        String owe;
        ArrayList<Home> availableHomes1 = availableHomes.getAvailableHomes();
        for (int i = 0; i < availableHomes1.size(); i++) {
            taxes += (((double) (availableHomes1.get(i).getMaxNumOfResidents() * 100)) * town.getPropertyTaxRate());
        }
        if (person.getWalletMoney() - taxes < 0) {
            if ((taxes - person.getWalletMoney()) == 1) {
                owe = " dollar ";
            } else {
                owe = " dollars ";
            }
            System.out.print(person.getName() + " cannot afford to pay taxes and is now in debt. They owe " + (taxes - person.getWalletMoney()) + owe + " and has to take out a loan.");
            String space;
            System.out.println(" How large of a loan would " + person.getName() + " like to take out?");
            double amount;
            try {
                amount = s.nextInt();
                s.nextLine();
            } catch (Exception e) {
                amount = numsy();
            }
            person.setWalletMoney(amount);
            person.setLoanDebts(amount);
            if (amount == 1) {
                space = " dollar of debt.";
            } else {
                space = " dollars of debt.";
            }
            System.out.println(person.getName() + " now has " + amount + space + "\n");
        }
        person.setWalletMoney(person.getWalletMoney() - taxes);
        return roundIt(taxes);
    }

    private double numsy() {
        s.nextLine();
        System.out.println("That is not a valid input. Please enter another number.");
        double num;
        try {
            num = s.nextDouble();
            s.nextLine();
            return num;
        } catch (Exception e) {
            return numsy();
        }
    }

    private double roundIt(double unroundedNum) {
        return (Math.round(unroundedNum * 100))/(double) 100;
    }

    public boolean townSpendMoney(int amount, Town ourTown) {
        if (ourTown.getTownTreasury() - amount >= 0) {
            ourTown.setTownTreasury(ourTown.getTownTreasury() - amount);
            return true;
        } else {
            return false;
        }
    }

    public void payUtilities(Person person, Home home, Town town, AvailableBuildings availableBuildings) {
        double electricity = 0;
        if (availableBuildings.buildingInExistence("Solar Power Plant")) {
            electricity = 0.5;
        }
        if (home.getHomeOrApartment().equalsIgnoreCase("apartment")) {
            town.collectTaxes(0.5);
            person.setWalletMoney(person.getWalletMoney() - 0.5);
        } else {
            if (person.getWalletMoney() - (0.5 + electricity) < 0) {
                String owe;
                if (((0.5 + electricity) - person.getWalletMoney()) == 1) {
                    owe = " dollar ";
                } else {
                    owe = " dollars ";
                }
                System.out.print(person.getName() + " cannot afford utilities and is now in debt. They owe " + ((0.5 + electricity) - person.getWalletMoney()) + owe + " and has to take out a loan.");
                String space;
                System.out.println(" How large of a loan would " + person.getName() + " like to take out?");
                double amount;
                try {
                    amount = s.nextInt();
                    s.nextLine();
                } catch (Exception e) {
                    amount = numsy();
                }
                person.setWalletMoney(amount);
                person.setLoanDebts(amount);
                if (amount == 1) {
                    space = " dollar of debt.";
                } else {
                    space = " dollars of debt.";
                }
                System.out.println(person.getName() + " now has " + amount + space + "\n");
            }
            town.collectTaxes(0.5 + electricity);
            person.setWalletMoney(person.getWalletMoney() - (0.5 + electricity));
        }
    }

    public void payRent(Home home, Town town, Person person) {
        if (person.getHouse() != null) {
            if (person.getWalletMoney() - (2 / home.getCurrentNumOfResidents()) < 0) {
                String owe;
                if (((2 / home.getCurrentNumOfResidents()) - person.getWalletMoney()) == 1) {
                    owe = " dollar ";
                } else {
                    owe = " dollars ";
                }
                System.out.print(person.getName() + " cannot afford rent and is now in debt. They owe " + ((2 / home.getCurrentNumOfResidents()) - person.getWalletMoney()) + owe + " and has to take out a loan.");
                String space;
                System.out.println("How large of a loan would " + person.getName() + " like to take out?");
                double amount;
                try {
                    amount = s.nextInt();
                    s.nextLine();
                } catch (Exception e) {
                    amount = numsy();
                }
                person.setWalletMoney(amount);
                person.setLoanDebts(amount);
                if (amount == 1) {
                    space = " dollar of debt.";
                } else {
                    space = " dollars of debt.";
                }
                System.out.println(person.getName() + " now has " + amount + space + "\n");
            }
            town.collectTaxes(2 / home.getCurrentNumOfResidents());
            person.setWalletMoney(person.getWalletMoney() - 2 / home.getCurrentNumOfResidents());
        }
    }

    public void withdrawBankMoney(int amount, Person person) {
        String bank;
        String wallet;
        person.addBankMoney(amount * -1);
        person.addWalletMoney(amount);
        if (person.getBankValue() == 1) {
            bank = " dollar in their bank account and ";
        } else {
            bank = " dollars in their bank account and ";
        }
        if (person.getWalletMoney() == 1) {
            wallet = " dollar in their wallet.";
        } else {
            wallet = " dollars in their wallet.";
        }
        System.out.println(person.getName() + " now has " + person.getBankValue() + bank + person.getWalletMoney() + wallet + "\n");
    }

    public boolean makeDeposit(int amount, Person person) {
        String string;
        String string2;
        if (person.getWalletMoney() - amount >= 0) {
            person.addWalletMoney(amount * - 1);
            person.addBankMoney(amount);
            if (person.getBankValue() == 1) {
                string = " dollar in their bank account and ";
            } else {
                string = " dollars in their bank account and ";
            }
            if (person.getWalletMoney() == 1) {
                string2 = " dollar in their wallet.";
            } else {
                string2 = " dollars in their wallet.";
            }
            System.out.println(person.getName() + " now has " + person.getBankValue() + string + person.getWalletMoney() + string2 + "\n");
            return true;
        } else {
            System.out.println("You do not have enough money in your wallet to deposit that much in the bank.");
            return false;
        }
    }

    public void collectInterest(Person person) {
        double interest = roundIt((person.getBankValue() * 0.01));
        person.setBankValue(interest + person.getBankValue());
    }

    public boolean makePurchase(int cost, Person person) {
        if (person.getWalletMoney() - cost >= 0) {
            person.setWalletMoney(person.getWalletMoney() - cost);
            return true;
        } else {
            return false;
        }
    }

    public void receivePaycheck(Person person, int dayNum, Town ourTown) {
        for (int i = 0; i < person.numOfJobsIHold(); i++) {
            if (person.getJobTitle().equalsIgnoreCase("pirate")) {
                if (r.nextInt(25) % 5 == 0) {
                    person.setWalletMoney(person.getWalletMoney() + person.returnThisJobsSalary(i));
                    townSpendMoney(person.returnThisJobsSalary(i), ourTown);
                }
            } else if (person.getJobTitle().equalsIgnoreCase("Unemployed")) {
                //unemployment benefits
                person.setWalletMoney(person.getWalletMoney() + 4);
                townSpendMoney(5, ourTown);
            } else {
                person.setWalletMoney(person.getWalletMoney() + person.returnThisJobsSalary(i));
            }
        }
    }
}
