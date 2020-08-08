public class Building {

    private String type;
    private int priceToBuild;
    private int perPopulation;
    private int numThatCanBeBuilt;
    private int howManyAreBuilt;
    private boolean needsToBeRepaired;

    public Building(String name, int priceToBuild, int perPopulation, Town ourTown) {
        this.type = name;
        this.priceToBuild = priceToBuild;
        this.perPopulation = perPopulation;
        setNumThatCanBeBuilt(ourTown);
        this.howManyAreBuilt = 0;
        this.needsToBeRepaired = false;
    }

    public boolean isNeedsToBeRepaired() {
        return needsToBeRepaired;
    }

    public void setNeedsToBeRepaired(boolean needsToBeRepaired) {
        this.needsToBeRepaired = needsToBeRepaired;
    }

    public String getType() {
        return type;
    }

    public int getHowManyAreBuilt() {
        return howManyAreBuilt;
    }

    public void setNumThatCanBeBuilt(Town ourTown) {
        int residents = ourTown.numResidents();
        if (perPopulation == -1) {
            numThatCanBeBuilt = 1;
        } else if (residents / perPopulation == 0) {
            numThatCanBeBuilt = 1;
        } else {
            numThatCanBeBuilt = ((residents / perPopulation) / 2);
        }
    }

    public void incrementNumWhoExist(int amount) {
        howManyAreBuilt += amount;
    }

    public boolean canYouBuildIt(AvailableBuildings availableBuildings) {
        boolean answer = (numThatCanBeBuilt < availableBuildings.numOfThisBuilding(type) + 1);
        if (answer) {
            return false;
        } else {
            return true;
        }
    }

    public void anotherToStringMethod(Town town) {
        String aOrAn;
        String isAre;
        if (type.substring(0, 1).equalsIgnoreCase("A") ||type.substring(0, 1).equalsIgnoreCase("E")
                || type.substring(0, 1).equalsIgnoreCase("O") || type.substring(0, 1).equalsIgnoreCase("I") ||
                type.substring(0, 1).equalsIgnoreCase("U") ) {
            aOrAn = "An ";
        } else {
            aOrAn = "A ";
        }
        if (howManyAreBuilt == 1) {
            isAre = " is currently ";
        } else {
            isAre = " are currently ";
        }

        print(aOrAn + type + " costs " + priceToBuild + " dollars to build. There" + isAre + howManyAreBuilt + " in " + town.getTownName() + ".");
    }

    public int getPriceToBuild() {
        return priceToBuild;
    }

    private void print(String message) {
        System.out.println(message);
    }
}
