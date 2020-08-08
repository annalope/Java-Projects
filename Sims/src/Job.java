import java.util.ArrayList;

public class Job {

    private String jobTitle;
    private String placeOfWork;
    private int salaryADay;
    private int numWhoCanHoldJob;
    private int numWhoHoldJob = 0;
    private ArrayList<Person> whoWorksThisJob = new ArrayList<>(1);

    public Job(String jobTitle, String placeOfWork, int salaryADay, int numWhoCanHoldJob) {
        this.jobTitle = jobTitle;
        this.placeOfWork = placeOfWork;
        this.salaryADay = salaryADay;
        this.numWhoCanHoldJob = numWhoCanHoldJob;
    }

    public void setNumWhoCanHoldJob(int newAmount) {
        this.numWhoCanHoldJob += newAmount;
    }

    public void fireSomebody(Person person) {
        whoWorksThisJob.remove(person);
    }

    public int getSalaryADay() {
        return salaryADay;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void addANewEmployee(Person person) {
        numWhoHoldJob++;
        whoWorksThisJob.add(person);
    }

    public int getNumWhoCanHoldJob() {
        return numWhoCanHoldJob;
    }

    public int getNumWhoHoldJob() {
        return numWhoHoldJob;
    }

    private void print(String message) {
        System.out.println(message);
    }

    //toString
    public void toStringPrint() {
        String firstLetterVowel;
        String more;
        if (jobTitle.charAt(0) == 'A') {
            firstLetterVowel = "An ";
        } else if (jobTitle.substring(0, 1).equalsIgnoreCase("El")) {
            firstLetterVowel = "";
        } else if (jobTitle.charAt(0) == 'E' && jobTitle.charAt(1) != 'l'){
            firstLetterVowel = "An ";
        } else {
            firstLetterVowel = "A ";
        }
        if (placeOfWork.equalsIgnoreCase("SpaceX")) {
            more = "SpaceX";
        } else {
            more = "the " + placeOfWork.toLowerCase();
        }
        print(firstLetterVowel + jobTitle + " makes " + salaryADay + " dollars a day and works at " + more + ".");
    }
}
