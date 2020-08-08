import java.util.ArrayList;

public class Home {

    private String homeName;
    private String homeOrApartment;
    private int maxNumOfResidents;
    private int currentNumOfResidents;
    private ArrayList<Person> homeResidents = new ArrayList<>(0);
    private int numOfDaysOfFood;
    private boolean damaged;
    private boolean bugInfested;

    public Home(String homeName, String homeOrApartment, int maxNumOfResidents) {
        RepeatMethods repeatMethods = new RepeatMethods();
        this.homeName = repeatMethods.capitalizeOtherWords(homeName);
        this.homeOrApartment = homeOrApartment;
        this.maxNumOfResidents = maxNumOfResidents;
        this.currentNumOfResidents = 0;
        this.numOfDaysOfFood = 0;
        this.damaged = false;
        this.bugInfested = false;
    }

    //getter/setter stuff
    public String getHomeOrApartment() {
        return homeOrApartment;
    }

    public ArrayList<Person> getHomeResidents() {
        return homeResidents;
    }

    public boolean isBugInfested() {
        return bugInfested;
    }

    public void setBugInfested(boolean bugInfested) {
        this.bugInfested = bugInfested;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void removeAResident(Person person) {
        currentNumOfResidents -= 1;
        homeResidents.remove(person);
    }

    public int getNumOfDaysOfFood() {
        return numOfDaysOfFood;
    }

    public void incrementFood(int amount) {
        numOfDaysOfFood += amount;
    }

    public void moveIntoHome(Person mover) {
            currentNumOfResidents++;
            homeResidents.add(mover);
    }

    public String getHomeName() {
        return homeName;
    }

    public int getCurrentNumOfResidents() {
        return currentNumOfResidents;
    }

    public int getMaxNumOfResidents() {
        return maxNumOfResidents;
    }

    public void toStringPrint() {
        String preposition;
        String occup;
        String occ;
        if (homeOrApartment.equalsIgnoreCase("Home")) {
            preposition = " a ";
        } else {
            preposition = " an ";
        }
        if (maxNumOfResidents == 1) {
            occup = " occupant.";
        } else {
            occup = " occupants.";
        }
        if (currentNumOfResidents == 1) {
            occ = " occupant.";
        } else {
            occ = " occupants.";
        }
        String toPrint = homeName + " is" + preposition + homeOrApartment.toLowerCase() + " that can support " + maxNumOfResidents + occup +
                " It currently has " + currentNumOfResidents + occ;
        if (homeResidents.size() == 0) {
            System.out.println(toPrint);
        } else {
            if (homeResidents.size() == 1) {
                toPrint += " The person living in this " + homeOrApartment.toLowerCase() + " is " + homeResidents.get(0).getName() + ".";
            } else {
                toPrint += " The people living in this " + homeOrApartment.toLowerCase() + " are";
                for (int i = 0; i < homeResidents.size(); i++) {
                    if (i == homeResidents.size() - 1) {
                        toPrint += " and " + (homeResidents.get(i)).getName() + ".";
                    } else if (homeResidents.size() == 2) {
                        toPrint += " " + (homeResidents.get(i)).getName();
                    } else {
                        toPrint += " " + (homeResidents.get(i)).getName() + ",";
                    }
                }
            }
            System.out.println(toPrint);
        }
    }
}
