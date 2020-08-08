import java.util.ArrayList;

public class AvailableJobs {
    private ArrayList<Job> availableJobs = new ArrayList<>(27);

    public AvailableJobs() {
        availableJobs.add(createNewJob("Firefighter", "Firehouse", 10, 20));
        availableJobs.add(createNewJob("Doctor", "Hospital", 20, 20));
        availableJobs.add(createNewJob("Nurse", "Hospital", 15, 40));
        availableJobs.add(createNewJob("Software Developer", "SpaceX", 18, 25));
        availableJobs.add(createNewJob("Teacher", "School", 10, 30));
        availableJobs.add(createNewJob("Babysitter", "Daycare", 4, 50));
        availableJobs.add(createNewJob("Musical Theatre Actor", "Theatre", 22, 10));
        availableJobs.add(createNewJob("Singer", "Record Label", 24, 5));
        availableJobs.add(createNewJob("Ballet Dancer", "Ballet Studio", 12, 10));
        availableJobs.add(createNewJob("Detective", "Detective Agency", 15, 3));
        availableJobs.add(createNewJob("Writer", "Publishing Company", 22, 10));
        availableJobs.add(createNewJob("Librarian", "Library", 8, 5));
        availableJobs.add(createNewJob("Actor", "Movie Studio", 22, 15));
        availableJobs.add(createNewJob("Video Editor", "Movie Studio", 12, 10));
        availableJobs.add(createNewJob("Astronaut", "SpaceX", 22, 7));
        availableJobs.add(createNewJob("Elon Musk", "SpaceX", 30, 1));
        availableJobs.add(createNewJob("Aerospace Engineer", "SpaceX", 20, 25));
        availableJobs.add(createNewJob("Pilot", "Airport", 15, 20));
        availableJobs.add(createNewJob("Veterinarian", "Pet Hospital", 15, 4));
        availableJobs.add(createNewJob("Lawyer", "Law Practice", 18, 4));
        availableJobs.add(createNewJob("Sailor", "Seaport", 6, 50));
        availableJobs.add(createNewJob("Grocery Store Cashier", "Grocery Store", 6, 10));
        availableJobs.add(createNewJob("Grocery Store Manager", "Grocery Store", 8, 1));
        availableJobs.add(createNewJob("Car Salesman", "Car Dealership", 12, 10));
        availableJobs.add(createNewJob("Publisher", "Publishing Company", 18, 5));
        availableJobs.add(createNewJob("Bank Teller", "Bank", 12, 15));
        availableJobs.add(createNewJob("Accountant", "Bank", 15, 10));
        availableJobs.add(createNewJob("Journalist", "Newspaper", 12, 10));
        availableJobs.add(createNewJob("Flight Attendant", "Airport", 8, 50));
        availableJobs.add(createNewJob("Basketball Player", "Basketball Stadium", 26, 10));
        availableJobs.add(createNewJob("Basketball Coach", "Basketball Stadium", 24, 4));
        availableJobs.add(createNewJob("Groundskeeper", "Park", 6, 10));
        availableJobs.add(createNewJob("Restaurant Chef", "Restaurant", 8, 1));
        availableJobs.add(createNewJob("Restaurant Owner", "Restaurant", 12, 1));
        availableJobs.add(createNewJob("Waiter", "Restaurant", 6, 10));
        availableJobs.add(createNewJob("Astronomer", "Observatory", 15, 10));
        availableJobs.add(createNewJob("Physicist", "Observatory", 20, 10));
        availableJobs.add(createNewJob("Grad Student", "University", 8, 50));
        availableJobs.add(createNewJob("Professor", "University", 20, 20));
        availableJobs.add(createNewJob("Dean", "University", 25, 5));
        availableJobs.add(createNewJob("Researcher", "University", 10, 50));
        availableJobs.add(createNewJob("Museum Curator", "Museum", 10, 5));
        availableJobs.add(createNewJob("Historian", "Museum", 10, 10));
        availableJobs.add(createNewJob("Archaeologist", "Museum", 10, 10));
        availableJobs.add(createNewJob("Barber", "Barbershop", 8, 5));
        availableJobs.add(createNewJob("Baker", "Bakery", 8, 5));
        availableJobs.add(createNewJob("Solar Power Engineer", "Solar Power Plant", 15, 12));
        availableJobs.add(createNewJob("Farmer", "Farm", 7, 5));
        availableJobs.add(createNewJob("Exterminator", "Pest Control Office", 10, 8));
        availableJobs.add(createNewJob("Youtuber", "Basement", 20, 1));
        availableJobs.add(createNewJob("Mail Carrier", "Post Office", 10, 5));
        availableJobs.add(createNewJob("Pirate", "Seaport", 25, 2));
        availableJobs.add(createNewJob("Pastor", "Church", 20, 3));
        availableJobs.add(createNewJob("Therapist", "Hospital", 18, 10));
        availableJobs.add(createNewJob("Weatherman", "Newspaper", 15, 1));
        availableJobs.add(createNewJob("Unemployed", "Unemployed", 0, 1000000000));
        availableJobs.add(createNewJob("Handyman", "Repair Shop", 12, 10));
        availableJobs.add(createNewJob("Animal Shelter Worker", "Animal Shelter", 15, 10));
        availableJobs.add(createNewJob("Zookeeper", "Zoo", 15, 25));
    }

    public String returnPlaceOfWork(String jobTitle) {
        for (int i = 0; i < availableJobs.size(); i++) {
            if ((availableJobs.get(i)).getJobTitle().equalsIgnoreCase(jobTitle)) {
                return (availableJobs.get(i)).getPlaceOfWork();
            }
        }
        return "";
    }

    public Job returnWhichJobThisIs(String jobTitle) {
        for (int i = 0; i < availableJobs.size(); i++) {
            if (jobTitle.equalsIgnoreCase((availableJobs.get(i)).getJobTitle())) {
                return (availableJobs.get(i));
            }
        }
        return null;
    }

    public int returnSalaryADay(String jobTitle) {
        for (int i = 0; i < availableJobs.size(); i++) {
            if (availableJobs.get(i).getJobTitle().equalsIgnoreCase(jobTitle)) {
                return availableJobs.get(i).getSalaryADay();
            }
        }
        return 0;
    }

    public ArrayList<Job> printJobsWithRoom(AvailableBuildings availableBuildings) {
        ArrayList<Job> availableJobsIndex = new ArrayList<>(2);
        String spaceStuff;
        int counter = 1;
        for (int i = 0; i < availableJobs.size(); i++) {
            if (availableJobs.get(i).getNumWhoHoldJob() + 1 <= (availableJobs.get(i).getNumWhoCanHoldJob())) {
                if (availableBuildings.isBuilt(availableJobs.get(i))) {
                    if (!(availableJobs.get(i).getJobTitle().equalsIgnoreCase("unemployed"))) {
                        if (counter < 10) {
                            spaceStuff = ".  ";
                        } else {
                            spaceStuff = ". ";
                        }
                        System.out.print(counter + spaceStuff);
                        (availableJobs.get(i)).toStringPrint();
                        counter++;
                        availableJobsIndex.add(availableJobs.get(i));
                    }
                }
            }
        }
        return availableJobsIndex;
    }

    public ArrayList<Job> numJobs(AvailableBuildings availableBuildings) {
        ArrayList<Job> jobs = new ArrayList<>(2);
        for (int i = 0; i < availableJobs.size(); i++) {
            if (availableJobs.get(i).getNumWhoHoldJob() + 1 <= (availableJobs.get(i).getNumWhoCanHoldJob())) {
                if (availableBuildings.isBuilt(availableJobs.get(i))) {
                    if (!(availableJobs.get(i).getJobTitle().equalsIgnoreCase("unemployed"))) {
                        jobs.add(availableJobs.get(i));
                    }
                }
            }
        }
        return jobs;
    }

    public ArrayList<Job> getAvailableJobs() {
        return availableJobs;
    }

    private Job createNewJob(String jobTitle, String placeOfWork, int salaryADay, int numWhoCanHoldJob) {
        Job job = new Job(jobTitle, placeOfWork, salaryADay, numWhoCanHoldJob);
        return job;
    }
}
