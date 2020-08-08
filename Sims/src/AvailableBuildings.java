import java.util.ArrayList;
import java.util.Scanner;

public class AvailableBuildings {
    private ArrayList<Building> availableBuildings = new ArrayList<>(0);
    private Scanner s = new Scanner(System.in);
    private Building build = null;

   public AvailableBuildings(Town ourTown) {
       availableBuildings.add(createNewBuilding("Firehouse", 200, 10, ourTown));
       availableBuildings.add(createNewBuilding("Hospital", 1000, 50, ourTown));
       availableBuildings.add(createNewBuilding("School", 500, 10, ourTown));
       availableBuildings.add(createNewBuilding("Musical Theatre Stage", 7000, 500, ourTown));
       availableBuildings.add(createNewBuilding("Record Label", 2000, 500, ourTown));
       availableBuildings.add(createNewBuilding("Ballet Studio", 200, 40, ourTown));
       availableBuildings.add(createNewBuilding("Detective Agency", 600, 150, ourTown));
       availableBuildings.add(createNewBuilding("Publishing Company", 200, 40, ourTown));
       availableBuildings.add(createNewBuilding("Library", 200, 5, ourTown));
       availableBuildings.add(createNewBuilding("Movie Studio", 5000, 1000, ourTown));
       availableBuildings.add(createNewBuilding("SpaceX", 10000, -1, ourTown));
       availableBuildings.add(createNewBuilding("Airport", 5000, -1, ourTown));
       availableBuildings.add(createNewBuilding("Pet Hospital", 300, 5, ourTown));
       availableBuildings.add(createNewBuilding("Law Practice", 800, 25, ourTown));
       availableBuildings.add(createNewBuilding("Seaport", 1000, -1, ourTown));
       availableBuildings.add(createNewBuilding("Grocery Store", 100, 5, ourTown));
       availableBuildings.add(createNewBuilding("Car Dealership", 200, 5, ourTown));
       availableBuildings.add(createNewBuilding("Bank", 200, 5, ourTown));
       availableBuildings.add(createNewBuilding("Town Hall", 0, -1, ourTown));
       availableBuildings.add(createNewBuilding("Newspaper", 100, -1, ourTown));
       availableBuildings.add(createNewBuilding("Basketball Stadium", 2000, 200, ourTown));
       availableBuildings.add(createNewBuilding("Park", 50, 10, ourTown));
       availableBuildings.add(createNewBuilding("Restaurant", 200, 1, ourTown));
       availableBuildings.add(createNewBuilding("Observatory", 500, 10, ourTown));
       availableBuildings.add(createNewBuilding("University", 2000, 50, ourTown));
       availableBuildings.add(createNewBuilding("Museum", 500, 30, ourTown));
       availableBuildings.add(createNewBuilding("Barbershop", 200, 30, ourTown));
       availableBuildings.add(createNewBuilding("Bakery", 300, 30, ourTown));
       availableBuildings.add(createNewBuilding("Solar Power Plant", 1000, 50, ourTown));
       availableBuildings.add(createNewBuilding("Farm", 100, 5, ourTown));
       availableBuildings.add(createNewBuilding("Pest Control Office", 400, 10, ourTown));
       availableBuildings.add(createNewBuilding("Daycare", 400, 10, ourTown));
       availableBuildings.add(createNewBuilding("Basement", 500, 30, ourTown));
       availableBuildings.add(createNewBuilding("Post office", 200, 500, ourTown));
       availableBuildings.add(createNewBuilding("Church", 200, 10, ourTown));
       availableBuildings.add(createNewBuilding("Unemployed", 0, 1, ourTown));
       availableBuildings.add(createNewBuilding("Repair Shop", 100, 5, ourTown));
       availableBuildings.add(createNewBuilding("Animal Shelter", 100, 1, ourTown));
       availableBuildings.add(createNewBuilding("Zoo", 1000, 300, ourTown));
       buildDefaultBuilding("Firehouse");
       buildDefaultBuilding("School");
       buildDefaultBuilding("Grocery Store");
       buildDefaultBuilding("Bank");
       buildDefaultBuilding("Park");
       buildDefaultBuilding("Town Hall");
       buildDefaultBuilding("Unemployed");
   }

    public ArrayList<Building> getAvailableBuildings() {
        return availableBuildings;
    }

    public boolean buildABuilding(Town ourTown, Economy economy, AvailableJobs availableJobs, AvailablePeople availablePeople) {
       Building buildingInQuestio = null;
       String name = printAllTheBuildingsYouCanBuild(ourTown);
       if (name == null) {
           return false;
       } else {
           for (int i = 0; i < availableBuildings.size(); i++) {
               if (name.equalsIgnoreCase(availableBuildings.get(i).getType())) {
                   buildingInQuestio = availableBuildings.get(i);
               }
           }
           buildingInQuestio.incrementNumWhoExist(1);
           economy.townSpendMoney(buildingInQuestio.getPriceToBuild(), ourTown);
           ourTown.addTownBuilding(buildingInQuestio);

           for (int i = 0; i < availableJobs.getAvailableJobs().size(); i++) {
               if (availableJobs.getAvailableJobs().get(i).getPlaceOfWork().equalsIgnoreCase(buildingInQuestio.getType())) {
                   if (!(availableJobs.getAvailableJobs().get(i).getJobTitle().equalsIgnoreCase("Elon Musk"))) {
                       availableJobs.getAvailableJobs().get(i).setNumWhoCanHoldJob(availableJobs.getAvailableJobs().get(i).getNumWhoCanHoldJob());
                   }
               }
           }

           for (int i = 0; i < availablePeople.getAvailablePeople().size(); i++) {
               if (availablePeople.getAvailablePeople().get(i).getDoIApproveOfTheMayor() <= 0.9) {
                   availablePeople.getAvailablePeople().get(i).likeTheMayorMore(0.1);
               }
           }

           return true;
       }
   }

    public ArrayList printDamagedBuildings(Town town, int weAt) {
        ArrayList availableHousesIndex = new ArrayList<>(2);
        String space;
        int counter = weAt;
        for (int i = 0; i < availableBuildings.size(); i++) {
            if ((availableBuildings.get(i)).isNeedsToBeRepaired()) {
                if (counter < 10) {
                    space = ".  ";
                } else {
                    space = ". ";
                }
                System.out.print(counter + space);
                (availableBuildings.get(i)).anotherToStringMethod(town);
                counter++;
                availableHousesIndex.add(availableBuildings.get(i));
            }
        }
        return availableHousesIndex;
    }

    public void unBreak(Building building) {
       String the;
       if (building.getType().equalsIgnoreCase("SpaceX")) {
           the = "";
       } else {
           the = "The ";
       }
        for (int i = 0; i < availableBuildings.size(); i++) {
            if (availableBuildings.get(i).getType().equalsIgnoreCase(building.getType())) {
                building.setNeedsToBeRepaired(false);
                System.out.println(the + building.getType() + " is no longer damaged.");
            }
        }
    }

   public boolean isBuilt(Job job) {
       String placeOfWork = job.getPlaceOfWork();
       for (int i = 0; i < availableBuildings.size(); i++) {
           if (availableBuildings.get(i).getType().equalsIgnoreCase(placeOfWork)) {
               if (availableBuildings.get(i).getHowManyAreBuilt() > 0) {
                   return true;
               }
           }
       }
       return false;
   }

   public boolean buildingInExistence(String buildingName) {
       for (int i = 0; i < availableBuildings.size(); i++) {
           if (buildingName.equalsIgnoreCase(availableBuildings.get(i).getType())) {
               if (availableBuildings.get(i).getHowManyAreBuilt() > 0) {
                   return true;
               }
           }
       }
       return false;
   }

   public void updateBuildingNumbers(Town ourTown) {
       for (int i = 0; i < availableBuildings.size(); i++) {
           availableBuildings.get(i).setNumThatCanBeBuilt(ourTown);
       }
   }

   private void buildDefaultBuilding(String name) {
       for (int i = 0; i < availableBuildings.size(); i++) {
           if (name.equalsIgnoreCase(availableBuildings.get(i).getType())) {
               build = availableBuildings.get(i);
           }
       }
       build.incrementNumWhoExist(1);
   }

   private String printAllTheBuildingsYouCanBuild(Town ourTown) {
       Building buildingInQuestion;
       ArrayList<Building> tempList = new ArrayList<>(0);
       String spaceStuff;
       int counter = 1;
       System.out.println("Choose the building you'd like to build from the following:");
       for (int i = 0; i < availableBuildings.size(); i++) {
           buildingInQuestion = availableBuildings.get(i);
           double money = ourTown.getTownTreasury();
           if (money >= ((double) buildingInQuestion.getPriceToBuild())) {
               if (buildingInQuestion.canYouBuildIt(this)) {
                   if (!(buildingInQuestion.getType().equalsIgnoreCase("unemployed"))) {
                       if (counter < 10) {
                           spaceStuff = ".  ";
                       } else {
                           spaceStuff = ". ";
                       }
                       System.out.print(counter + spaceStuff);
                       buildingInQuestion.anotherToStringMethod(ourTown);
                       tempList.add(buildingInQuestion);
                       counter++;
                   }
               }
           }
       }
       if (tempList.size() == 0) {
           System.out.println(ourTown.getTownName() + " cannot build any buildings at the moment.\n");
           return null;
       } else {
           int choice;
           try {
               choice = s.nextInt();
               clearLine();
           } catch (Exception e) {
               choice = numy(tempList);
           }
           return tempList.get(choice - 1).getType();
       }
   }

   private int numy(ArrayList<Building> list) {
       clearLine();
       System.out.println("That is not a valid input. Please enter a different integer.");
       int choice;
       try {
           choice = s.nextInt();
           clearLine();
       } catch (Exception e) {
           return numy(list);
       }

       if (choice > list.size()) {
           return numy(list);
       } else {
           return choice;
       }
   }

   private Building createNewBuilding(String type, int priceToBuild, int perPopulation, Town town) {
       Building building = new Building(type, priceToBuild, perPopulation, town);
       return building;
   }


    public int numOfThisBuilding(String name) {
        int count = 0;
        for (int i = 0; i < availableBuildings.size(); i++) {
            if (availableBuildings.get(i).getType().equalsIgnoreCase(name)) {
                count++;
            }
        }
        return count;
    }

    private void clearLine() {
        s.nextLine();
    }

}
