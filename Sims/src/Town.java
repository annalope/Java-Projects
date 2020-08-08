import java.util.ArrayList;

public class Town {
    private String townName;
    private ArrayList<Person> townResidents = new ArrayList<>(1);
    private ArrayList<Building> townBuildings = new ArrayList<>(0);
    private ArrayList<Home> townHomes = new ArrayList<>(0);
    private double townTreasury;
    private RepeatMethods repeatMethods = new RepeatMethods();
    private int homeCount;
    private int apartmentCount;
    private double incomeTaxRate;
    private double propertyTaxRate;
    private boolean atWar;
    private int daysAtWar;

    public Town(String townName) {
        this.townName = repeatMethods.capitalizeOtherWords(townName);
        this.townTreasury = 1000;
        this.incomeTaxRate = 0.1;
        this.propertyTaxRate = 0.1;
        this.atWar = false;
        this.daysAtWar = 0;
    }

    //getter/setter stuff
    public int getNumResidents() {
        return townResidents.size();
    }

    public void incrementDaysAtWar() {
        daysAtWar++;
    }

    public int getDaysAtWar() {
        return daysAtWar;
    }

    public void setAtWar(boolean atWar) {
        this.atWar = atWar;
    }

    public boolean isAtWar() {
        return atWar;
    }

    public double getIncomeTaxRate() {
        return incomeTaxRate;
    }

    public double getPropertyTaxRate() {
        return propertyTaxRate;
    }

    public void setPropertyTaxRate(double propertyTaxRate) {
        this.propertyTaxRate = propertyTaxRate;
    }

    public void setIncomeTaxRate(double taxRate) {
        this.incomeTaxRate = taxRate;
    }

    public void deleteAResident(Person person) {
        townResidents.remove(person);
    }

    public int numResidents() {
        return townResidents.size();
    }

    public void collectTaxes(double amount) {
        townTreasury += amount;
    }

    public void addTownResident(Person resident) {
        townResidents.add(resident);
    }

    public void addTownBuilding(Building building) {
        townBuildings.add(building);
    }

    public void addTownHome(Home home) {
        townHomes.add(home);
    }

    public String getTownName() {
        return townName;
    }

    public double getTownTreasury() {
        return townTreasury;
    }

    public void setTownTreasury(double townTreasury) {
        this.townTreasury = townTreasury;
    }

    private void print(String message) {
        System.out.println(message);
    }

    //toString method basically
    public void status(AvailablePeople availablePeople) {
        String singularOrNo;
        String moneySingular;
        if (townResidents.size() == 1) {
            singularOrNo = " resident. It has ";
        } else {
            singularOrNo = " residents. It has ";
        }
        if (townTreasury == 1) {
            moneySingular = " dollar in it.";
        } else {
            moneySingular = " dollars in it.";
        }
        String toPrint = townName + " currently has " + townResidents.size() + singularOrNo;
        homeApartmentDifferentiation();
        if (homeCount != 0) {
            if (homeCount == 1) {
                toPrint += "1 home";
            } else {
                toPrint += homeCount + " homes";
            }

            if (apartmentCount != 0) {
                if (apartmentCount == 1) {
                    if (townBuildings.size() == 0) {
                        toPrint += " and 1 apartment complex.";
                    } else if (townBuildings.size() == 1){
                        toPrint += ", 1 apartment complex, and 1 building.";
                    } else {
                        toPrint += ", 1 apartment complex, and " + townBuildings.size() + " buildings.";
                    }
                } else {
                    if (townBuildings.size() == 0) {
                        toPrint += " and " + apartmentCount + " apartment complexes.";
                    } else if (townBuildings.size() == 1){
                        toPrint +=  ", " + apartmentCount + " apartment complexes, and 1 building.";
                    } else {
                        toPrint += ", " + apartmentCount + " apartment complexes, and " + townBuildings.size() + " buildings.";
                    }
                }
            } else {
                if (townBuildings.size() == 0) {
                    toPrint += ".";
                } else if (townBuildings.size() == 1){
                    toPrint += " and 1 building.";
                } else {
                    toPrint += " and " + townBuildings.size() + " buildings.";
                }
            }
        } else {
            if (apartmentCount != 0) {
                if (apartmentCount == 1) {
                    if (townBuildings.size() != 0) {
                        toPrint += "1 apartment complex.";
                    } else if (townBuildings.size() == 1){
                        toPrint += "1 apartment complex and 1 building.";
                    } else {
                        toPrint += "1 apartment complex and " + townBuildings.size() + " buildings.";
                    }
                } else {
                    if (townBuildings.size() != 0) {
                        toPrint += apartmentCount + " apartment complexes.";
                    } else if (townBuildings.size() == 1){
                        toPrint += apartmentCount + " apartment complexes and 1 building.";
                    } else {
                        toPrint += apartmentCount + " apartment complexes and " + townBuildings.size() + " buildings.";
                    }
                }
            } else {
                if (townBuildings.size() != 0) {
                    toPrint += "no homes, apartment complexes, or buildings.";
                } else if (townBuildings.size() == 1){
                    toPrint += "1 building.";
                } else {
                    toPrint += townBuildings.size() + " buildings.";
                }
            }
        }
        toPrint += " The treasury has " + townTreasury + moneySingular + " Your approval rating as mayor is " + availablePeople.calculateYourApprovalRating() + " percent.";
        print(toPrint);
    }

    //counts how many homes and how many apartments there are
    private void homeApartmentDifferentiation() {
        homeCount = 0;
        apartmentCount = 0;
        for (int i = 0; i < townHomes.size(); i++) {
            if ((townHomes.get(i).getHomeOrApartment()).equalsIgnoreCase("home")) {
                homeCount++;
            } else {
                apartmentCount++;
            }
        }
        apartmentCount = apartmentCount / 20;
    }
}
