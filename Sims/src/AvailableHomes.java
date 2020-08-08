import java.util.ArrayList;

public class AvailableHomes {
    private ArrayList<Home> availableHomes = new ArrayList<>(5);

    public void addANewHome(Home home) {
        availableHomes.add(home);
    }

    public ArrayList<Home> getAvailableHomes() {
        return availableHomes;
    }

    public ArrayList<Home> printHomesWithBugs() {
        ArrayList<Home> availableHousesIndex = new ArrayList<>(2);
        String space;
        int counter = 1;
        for (int i = 0; i < availableHomes.size(); i++) {
            if ((availableHomes.get(i)).isBugInfested()) {
                if (counter < 10) {
                    space = ".  ";
                } else {
                    space = ". ";
                }
                System.out.print(counter + space);
                (availableHomes.get(i)).toStringPrint();
                counter++;
                availableHousesIndex.add(availableHomes.get(i));
            }
        }
        return availableHousesIndex;
    }

    public ArrayList<Home> printDamagedHomes() {
        ArrayList<Home> availableHousesIndex = new ArrayList<>(2);
        String space;
        int counter = 1;
        for (int i = 0; i < availableHomes.size(); i++) {
            if ((availableHomes.get(i)).isDamaged()) {
                if (counter < 10) {
                    space = ".  ";
                } else {
                    space = ". ";
                }
                System.out.print(counter + space);
                (availableHomes.get(i)).toStringPrint();
                counter++;
                availableHousesIndex.add(availableHomes.get(i));
            }
        }
        return availableHousesIndex;
    }

    public void unBreak(Home home) {
        for (int i = 0; i < availableHomes.size(); i++) {
            if (availableHomes.get(i).getHomeName().equalsIgnoreCase(home.getHomeName())) {
                home.setDamaged(false);
                System.out.println(home.getHomeName() + " is no longer damaged.");
            }
        }
    }

    public void unBugify(Home home) {
        for (int i = 0; i < availableHomes.size(); i++) {
            if (availableHomes.get(i).getHomeName().equalsIgnoreCase(home.getHomeName())) {
                home.setBugInfested(false);
                System.out.println(home.getHomeName() + " is no longer infested with bugs.");
            }
        }
    }

    public ArrayList<Home> printHomesWithRoom() {
        ArrayList<Home> availableHousesIndex = new ArrayList<>(2);
        String space;
        int counter = 1;
        for (int i = 0; i < availableHomes.size(); i++) {
            if ((availableHomes.get(i)).getCurrentNumOfResidents() + 1 <= (availableHomes.get(i)).getMaxNumOfResidents()) {
                if (!(availableHomes.get(i).isDamaged()) && !(availableHomes.get(i).isBugInfested())) {
                    if (counter < 10) {
                        space = ".  ";
                    } else {
                        space = ". ";
                    }
                    System.out.print(counter + space);
                    (availableHomes.get(i)).toStringPrint();
                    counter++;
                    availableHousesIndex.add(availableHomes.get(i));
                }
            }
        }
        return availableHousesIndex;
    }

    public ArrayList<Home> numHomesWithRoom() {
        ArrayList<Home> availableHousesIndex = new ArrayList<>(1);
        for (int i = 0; i < availableHomes.size(); i++) {
            if ((availableHomes.get(i)).getCurrentNumOfResidents() + 1 <= (availableHomes.get(i)).getMaxNumOfResidents()) {
                if (!(availableHomes.get(i).isDamaged()) && !(availableHomes.get(i).isBugInfested())) {
                    availableHousesIndex.add(availableHomes.get(i));
                }
            }
        }
        return availableHousesIndex;
    }

    public boolean checkIfNameExists(String name) {
        for (int i = 0; i < availableHomes.size(); i++) {
            if (name.equalsIgnoreCase(availableHomes.get(i).getHomeName())) {
                return true;
            }
        }
        return false;
    }
}
