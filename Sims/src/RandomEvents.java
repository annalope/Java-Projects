import java.util.ArrayList;
import java.util.Random;

public class RandomEvents {
    private Random r = new Random();
    private boolean pandemic = false;
    private int daysOfDisease = 0;

    public void randomEvents(AvailablePeople availablePeople, AvailableJobs availableJobs, AvailableBuildings availableBuildings, Town town, DayNightCycle dayNightCycle, AvailableHomes availableHomes) {
        boolean hadAnEvent = false;
        double odds;
        if (pandemic) {
            if (daysOfDisease > 10) {
                pandemic = false;
                daysOfDisease = 0;
            } else {
                daysOfDisease++;
            }
        }
        odds = r.nextDouble();
        if (odds > 0.4) {
            disagreementAmongResidents(availablePeople);
            hadAnEvent = true;
        }
        odds = r.nextDouble();
        if (odds > 0.3) {
            competitionAmongBusinesses(availableBuildings, availablePeople, availableJobs);
            hadAnEvent = true;
        }
        odds = r.nextDouble();
        if (odds > 0.6) {
            breakABuilding(availablePeople, availableBuildings, availableJobs);
            hadAnEvent = true;
        }
        odds = r.nextDouble();
        if (odds > 0.95) {
            scienceExplosion(availableBuildings, availablePeople);
            hadAnEvent = true;
        }
        odds = r.nextDouble();
        if (odds > 0.95) {
            bearAttack(availablePeople, town, availableJobs);
            hadAnEvent = true;
        }
        odds = r.nextDouble();
        if (pandemic) {
            if (odds > 0.2) {
                disease(availablePeople, availableBuildings, town, availableJobs);
                hadAnEvent = true;
            }
        } else {
            if (odds > 0.8) {
                disease(availablePeople, availableBuildings, town, availableJobs);
                hadAnEvent = true;
            }
        }
        odds = r.nextDouble();
        if (odds > 0.9) {
            alienAbduction(availablePeople, town, availableJobs);
            hadAnEvent = true;
        }
        odds = r.nextDouble();
        if (odds > 0.7) {
            naturalDisaster(availablePeople, town);
            hadAnEvent = true;
        }
        odds = r.nextDouble();
        if (odds > availablePeople.calculateYourApprovalRating()) {
            unemployment(availablePeople, availableJobs);
            hadAnEvent = true;
        }
        odds = r.nextDouble();
        if (odds > (1 - availablePeople.calculateYourApprovalRating())) {
            newRes(dayNightCycle, availableHomes, availableJobs, availableBuildings, town, availablePeople);
            hadAnEvent = true;
        }
        odds = r.nextDouble();
        if (odds > 0.90) {
            timeTravel(availablePeople, town, availableJobs);
            hadAnEvent = true;
        }
        odds = r.nextDouble();
        if (odds > 0.6) {
            lawsuit(availablePeople);
            hadAnEvent = true;
        }
        if (!hadAnEvent) {
            print("There are no additional announcements today.\n");
        } else {
            print("\n");
        }
    }

    private void newRes(DayNightCycle dayNightCycle, AvailableHomes availableHomes, AvailableJobs availableJobs, AvailableBuildings availableBuildings, Town town, AvailablePeople availablePeople) {
        String name = getRandomName(availablePeople);
        int age = r.nextInt(101);
        Home house = getHome(availableHomes);
        String jobTitle = getAJob(availableJobs, availableBuildings).getJobTitle();
        if (house != null && jobTitle != null) {
            Person newRes = dayNightCycle.createRes(name, age, house, jobTitle, availableJobs, availablePeople, town, availableBuildings);
            print(newRes.getName() + " has moved to " + town.getTownName() + ".");
        }
    }

    private Job getAJob(AvailableJobs availableJobs, AvailableBuildings availableBuildings) {
        ArrayList<Job> job = availableJobs.numJobs(availableBuildings);
        if (job.size() != 0) {
            int num = r.nextInt(job.size());
            return job.get(num);
        } else {
            return null;
        }
    }

    private Home getHome(AvailableHomes availableHomes) {
        ArrayList<Home> homes = availableHomes.numHomesWithRoom();
        if (homes.size() != 0) {
            int num = r.nextInt(homes.size());
            return homes.get(num);
        } else {
            return null;
        }
    }

    private String getRandomName(AvailablePeople availablePeople) {
        //34
        int s1 = r.nextInt(34);
        int s2 = r.nextInt(34);
        int s3 = r.nextInt(34);
        int s4 = r.nextInt(34);
        int numSyl = r.nextInt(3);
        String name;
        if (numSyl == 0) {
           name = (getSyllables(s1) + getSyllables(s2));
        } else if (numSyl == 1) {
            name = (getSyllables(s1) + getSyllables(s2) + getSyllables(s3));
        } else {
            name = (getSyllables(s1) + getSyllables(s2) + getSyllables(s3) + getSyllables(s4));
        }

        if (availablePeople.checkIfNameExists(name)) {
            getRandomName(availablePeople);
        }
        return name;
    }

    private String getSyllables(int num) {
        ArrayList<String> syllables = new ArrayList<>(10);
        syllables.add("cha");
        syllables.add("fah");
        syllables.add("ohe");
        syllables.add("zad");
        syllables.add("kol");
        syllables.add("por");
        syllables.add("saw");
        syllables.add("upo");
        syllables.add("goj");
        syllables.add("ghu");
        syllables.add("wer");
        syllables.add("jee");
        syllables.add("buv");
        syllables.add("go");
        syllables.add("quo");
        syllables.add("cas");
        syllables.add("le");
        syllables.add("mu");
        syllables.add("yit");
        syllables.add("as");
        syllables.add("xe");
        syllables.add("se");
        syllables.add("ur");
        syllables.add("o");
        syllables.add("e");
        syllables.add("ik");
        syllables.add("te");
        syllables.add("no");
        syllables.add("tho");
        syllables.add("ra");
        syllables.add("vi");
        syllables.add("yu");
        syllables.add("zap");
        syllables.add("ku");
        syllables.add("goo");
        syllables.add("hui");
        return syllables.get(num);
    }

    private void disagreementAmongResidents(AvailablePeople availablePeople) {
        int p1 = r.nextInt(availablePeople.getAvailablePeople().size());
        int p2 = r.nextInt(availablePeople.getAvailablePeople().size());
        if (p1 == p2) {
            if (p2 == availablePeople.getAvailablePeople().size() - 1) {
                p2 -= 1;
            } else {
                p2 += 1;
            }
        }
        availablePeople.getAvailablePeople().get(p1).dislikeTheMayor(0.01);
        availablePeople.getAvailablePeople().get(p2).dislikeTheMayor(0.01);
        print(availablePeople.getAvailablePeople().get(p2).getName() + " had an argument with " + availablePeople.getAvailablePeople().get(p1).getName() + ".");
    }

    private void timeTravel(AvailablePeople availablePeople, Town town, AvailableJobs availableJobs) {
        int p1 = r.nextInt(availablePeople.getAvailablePeople().size());
        print(availablePeople.getAvailablePeople().get(p1).getName() + " has passed away in a time traveling accident.");
        availablePeople.getAvailablePeople().get(p1).yeetOutOfExistence(availablePeople, town, availableJobs);

    }

    private void lawsuit(AvailablePeople availablePeople) {
        int p1 = r.nextInt(availablePeople.getAvailablePeople().size());
        int p2 = r.nextInt(availablePeople.getAvailablePeople().size());
        if (p1 == p2) {
            if (p2 == availablePeople.getAvailablePeople().size() - 1) {
                p2 -= 1;
            } else {
                p2 += 1;
            }
        }
        availablePeople.getAvailablePeople().get(p1).dislikeTheMayor(0.05);
        availablePeople.getAvailablePeople().get(p2).likeTheMayorMore(0.05);
        print(availablePeople.getAvailablePeople().get(p2).getName() + " sued " + availablePeople.getAvailablePeople().get(p1).getName() + ".");
    }

    private void competitionAmongBusinesses(AvailableBuildings availableBuildings, AvailablePeople availablePeople, AvailableJobs availableJobs) {
        int business = r.nextInt(availableBuildings.getAvailableBuildings().size());
        int num = 0;
        ArrayList<Person> peeps = new ArrayList<>(1);
        String type = availableBuildings.getAvailableBuildings().get(business).getType();
        if (availableBuildings.numOfThisBuilding(type) > 1) {
            for (int i = 0; i < availablePeople.getAvailablePeople().size(); i++) {
                if (availablePeople.getAvailablePeople().get(i).getPlaceOfWork().equalsIgnoreCase(type)) {
                    peeps.add(availablePeople.getAvailablePeople().get(i));
                }
            }

            for (int i = 0; i < availableJobs.getAvailableJobs().size(); i++) {
                if (availableJobs.getAvailableJobs().get(i).getPlaceOfWork().equalsIgnoreCase(type)) {
                    num += availableJobs.getAvailableJobs().get(i).getNumWhoCanHoldJob();
                }
            }
            if (peeps.size() > num) {
                for (int i = 0; i < (peeps.size() - num); i++) {
                    peeps.get(i).setJob("Unemployed", availableJobs);
                }
                print("One of your " + type.toLowerCase() + "s has been driven out of business by a competing " + type.toLowerCase() + " and all of its employees have been laid off.");
            }
        }
    }

    private void breakABuilding(AvailablePeople availablePeople, AvailableBuildings availableBuildings, AvailableJobs availableJobs) {
        int building = r.nextInt(availableBuildings.getAvailableBuildings().size());
        String string;
        Building buildin = availableBuildings.getAvailableBuildings().get(building);
        availableBuildings.getAvailableBuildings().get(building).setNeedsToBeRepaired(true);
        for (int i = 0; i < availablePeople.getAvailablePeople().size(); i++) {
            if (availablePeople.getAvailablePeople().get(i).getPlaceOfWork().equalsIgnoreCase(buildin.getType())) {
                availablePeople.getAvailablePeople().get(i).setJob("Unemployed", availableJobs);
            }
        }
        if (buildin.getType().equalsIgnoreCase("SpaceX")) {
            string = "";
        } else {
            string = "The ";
        }
        print(string + buildin.getType() + " has been damaged and everyone who worked there has lost their job.");
    }

    private void scienceExplosion(AvailableBuildings availableBuildings, AvailablePeople availablePeople) {
        Person scientist = getUnluckyPerson(availablePeople);
        double survival = r.nextDouble();
        if (availableBuildings.buildingInExistence("Museum")) {
            if (survival >= 0.5) {
                print("There has been an explosion at the museum and " + scientist.getName() + " has passed away.");
            } else {
                print("There has been an explosion at the museum and " + scientist.getName() + " has been injured.");
            }
        }
    }

    private void bearAttack(AvailablePeople availablePeople, Town town, AvailableJobs availableJobs) {
        Person bearVictim = getUnluckyPerson(availablePeople);
        double odds = r.nextDouble();
        if (odds > 0.7) {
            print(bearVictim.getName() + " was attacked by a bear and passed away.");
            bearVictim.yeetOutOfExistence(availablePeople, town, availableJobs);
        } else {
            print(bearVictim.getName() + " was attacked by a bear but miraculously survived!");
        }
    }

    private void disease(AvailablePeople availablePeople, AvailableBuildings availableBuildings, Town town, AvailableJobs availableJobs) {
        Person person = getUnluckyPerson(availablePeople);
        double odds = r.nextDouble();
        if (availableBuildings.buildingInExistence("Hospital")) {
            if (odds > 0.3) {
                print(person.getName() + " got sick, but they went to the hospital in time and have recovered.");
            } else {
                print(person.getName() + " got sick and passed away.");
                person.yeetOutOfExistence(availablePeople, town, availableJobs);
            }
        } else {
            if (odds > 0.8) {
                print(person.getName() + " got sick, but they miraculously recovered.");
            } else {
                print(person.getName() + " got sick and passed away because they couldn't get to a hospital.");
                person.yeetOutOfExistence(availablePeople, town, availableJobs);
            }
        }
    }

    private Person check(AvailablePeople availablePeople) {
        Person person = getUnluckyPerson(availablePeople);
        if (person.getJobTitle().equalsIgnoreCase("Unemployed")) {
            return check(availablePeople);
        } else {
            return person;
        }
    }

    private void alienAbduction(AvailablePeople availablePeople, Town town, AvailableJobs availableJobs) {
        Person abducted = getUnluckyPerson(availablePeople);
        print(abducted.getName() + " has been abducted by aliens.");
        abducted.yeetOutOfExistence(availablePeople, town, availableJobs);
    }

    private void unemployment(AvailablePeople availablePeople, AvailableJobs availableJobs) {
        Person person = check(availablePeople);
        person.setJob("Unemployed", availableJobs);
        print(person.getName() + " is now unemployed.");
    }

    private Person choock(AvailablePeople availablePeople) {
        Person person = getUnluckyPerson(availablePeople);
        if (person.isHomeless()) {
            return check(availablePeople);
        } else {
            return person;
        }
    }

    private void naturalDisaster(AvailablePeople availablePeople, Town town) {
        String disaster = getDisaster();
        String aOrAn;
        if (disaster.equalsIgnoreCase("earthquake")) {
            aOrAn = "an";
        } else {
            aOrAn = "a";
        }

        Person person = choock(availablePeople);
        if (disaster.equalsIgnoreCase("bugs")) {
            person.getHouse().setBugInfested(true);
            ArrayList<Person> unluckyPeople = person.getHouse().getHomeResidents();
            for (int i = 0; i < unluckyPeople.size(); i++) {
                unluckyPeople.get(i).setHomeless(true);
                if (i + 1 != unluckyPeople.size()) {
                    System.out.print(person.getName() + ", ");
                } else {
                    System.out.println("and " + person.getName() + " are now homeless because their house has become infested with bugs.");
                }
            }
        } else if (disaster.equalsIgnoreCase("pandemic")) {
            pandemic = true;
            print("A pandemic has hit " + town.getTownName() + ".");
        } else {
            person.getHouse().setDamaged(true);
            ArrayList<Person> unluckyPeople = person.getHouse().getHomeResidents();
            for (int i = 0; i < unluckyPeople.size(); i++) {
                unluckyPeople.get(i).setHomeless(true);
                if (i + 1 != unluckyPeople.size()) {
                    System.out.print(person.getName() + ", ");
                } else {
                    System.out.println("and " + person.getName() + " are now homeless because their house was damaged in " + aOrAn + " " + disaster.toLowerCase() + ".");
                }
            }
        }
    }

    private Person getUnluckyPerson(AvailablePeople availablePeople) {
        int inte = r.nextInt(availablePeople.getAvailablePeople().size());
        Person person = availablePeople.getAvailablePeople().get(inte);
        return person;
    }

    private String getDisaster() {
        int rand = r.nextInt(7);
        switch (rand) {
            case (0):
                return "Hurricane";
            case (1):
                return "Flood";
            case (2):
                return "Fire";
            case (3):
                return "Bugs";
            case (4):
                return "Blizzard";
            case (5):
                return "Earthquake";
            case (6):
                return "Pandemic";
            default:
                return "Volcanic eruption";
        }
    }

    private void print(String message) {
        System.out.println(message);
    }

}
