import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AvailablePeople {
    private ArrayList<Person> availablePeople = new ArrayList<>(1);
    private Scanner s = new Scanner(System.in);
    private Random r = new Random();

    public void addANewPerson(Person person) {
        availablePeople.add(person);
    }

    public ArrayList<Person> getAvailablePeople() {
        return availablePeople;
    }

    public String getPersonName(String personName) {
        for (int i = 0; i < availablePeople.size(); i++) {
            if (((availablePeople.get(i)).getName()).equals(personName)) {
                return (availablePeople.get(i)).getName();
            }
        }
        return "";
    }

    public void increasePublicMayorFeelings(int howMuchSpent) {
        double rand;
        for (int i = 0; i < availablePeople.size(); i++) {
            if (availablePeople.get(i).getDoIApproveOfTheMayor() <= 0.98) {
                rand = r.nextDouble();
                if (howMuchSpent > 10) {
                    availablePeople.get(i).likeTheMayorMore(0.02);
                } else {
                    if (rand < (howMuchSpent / (double) 10)) {
                        availablePeople.get(i).likeTheMayorMore(0.02);
                    }
                }
            }
        }
    }

    public Person getNewLoveInterest() {
        int random = r.nextInt(availablePeople.size());
        return availablePeople.get(random);
    }

    public double calculateYourApprovalRating() {
        int numWhoApprove = 0;
        for (int i = 0; i < availablePeople.size(); i++) {
            if (availablePeople.get(i).getDoIApproveOfTheMayor() >= 0.5) {
                numWhoApprove++;
            }
        }
        return roundIt(numWhoApprove / (double) availablePeople.size());
    }

    public void deleteAPerson(Person person) {
        availablePeople.remove(person);
    }

    public Person printThePeople() {
       int counter = 1;
       String space;
       for (int i = 0; i < availablePeople.size(); i++) {
           if (counter < 10) {
               space = ".  ";
           } else {
               space = ". ";
           }
           System.out.print(counter + space);
           (availablePeople.get(i)).aToStringMethod();
           counter++;
       }
       print("Enter the number of your choice.");
       int choice;
       try {
           choice = s.nextInt();
           clearLine();
       } catch (Exception e) {
           choice = numDiddy();
       }
       return availablePeople.get(choice - 1);
    }

    private int numDiddy() {
        clearLine();
        print("That is not a valid input. Please enter a different integer.");
        int choi;
        try {
            choi = s.nextInt();
            clearLine();
        } catch (Exception e) {
            return numDiddy();
        }
        if (availablePeople.size() < choi) {
            return numDiddy();
        } else {
            return choi;
        }
    }

    public int numOfResidents() {
        return availablePeople.size();
    }

    public Home getPersonHouse(String personName) {
        for (int i = 0; i < availablePeople.size(); i++) {
            if (((availablePeople.get(i)).getName()).equals(personName)) {
                return (availablePeople.get(i)).getHouse();
            }
        }
        return null;
    }

    public boolean checkIfNameExists(String name) {
        for (int i = 0; i < availablePeople.size(); i++) {
            if (name.equalsIgnoreCase(availablePeople.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    private double roundIt(double unroundedNum) {
        return (Math.round(unroundedNum * 10000))/(double) 100;
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void clearLine() {
        s.nextLine();
    }
}
