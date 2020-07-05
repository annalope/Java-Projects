import java.util.Scanner;

public class InteractionPanel {

    private String name;
    private String location = "bowl";
    private String seeIfTheyGetItNow2;
    private int points = 0;
    private int tricksDone = 0;
    private int skillLevel;
    private String specialMove;

    //standard accessor and mutator methods for the variables
    public void setTricksDone(int tricksDone) { this.tricksDone = tricksDone; }

    public int getTricksDone() { return tricksDone; }

    public void setLocation(String location) { this.location = location; }

    public void setPoints(int points) { this.points = points; }

    public int getPoints() { return points; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    //main method. Prints the welcome message, creates the panel and asks if you'd like to go through the tutorial
    public static void main(String[] args) {
        System.out.println("Welcome to Tony Hawk Pro Skater.");
        InteractionPanel panel = new InteractionPanel();
        getSkaterName(panel);
        panel.askIfToDoTutorial(panel);
    }

    //actually plays the game
    public void gamePlayer() {
        DoATrick doTrick = new DoATrick();
        //this is used to see if they want to keep playing the game
        boolean likeToPlay = true;

        do {
            System.out.println("\nEnter a command.");
            Scanner s = new Scanner(System.in);
            String trickInput = s.nextLine();

            //it will keep asking you to enter in commands and do tricks until you type in exit game
            if (trickInput.equalsIgnoreCase("Exit game")) {
                likeToPlay = false;
            } else {
                doTrick.doATrick(trickInput, location, name, this);
            }
        } while (likeToPlay == true);
    }

    //this asks if you want to do the tutorial. If not, it goes straight to the gameplay.
    public void askIfToDoTutorial(InteractionPanel panel) {
        Tutorial tutorial = new Tutorial();
        Scanner s = new Scanner(System.in);
        DoATrick doTrick = new DoATrick();

        System.out.println(name + ", would you like to go through the tutorial?");
        String questionAnswer = s.nextLine();
        if (questionAnswer.equalsIgnoreCase("yes")) {
            tutorial.tutorialTime(panel);
        } else if (questionAnswer.equalsIgnoreCase("no")) {
            System.out.println("Ok. Let's get right to the tricks.");
            String variable = s.nextLine();
            doTrick.doATrick(variable, location, name, this);
            gamePlayer();
        } else {
            askIfRepeat();
            if (seeIfTheyGetItNow2.equalsIgnoreCase("yes")) {
                tutorial.tutorialTime(panel);
            } else if (seeIfTheyGetItNow2.equalsIgnoreCase("no")) {
                System.out.println("Ok. Let's get right to the tricks.");
                doTrick.doATrick(s.nextLine(), location, name, this);
                gamePlayer();
            }
        }
    }

    //this method repeats until they enter a valid input
    public void askIfRepeat() {
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Please enter either 'yes' or 'no'.");
            seeIfTheyGetItNow2 = s.nextLine();
        }
        while (!(seeIfTheyGetItNow2.equalsIgnoreCase("yes") || (seeIfTheyGetItNow2.equalsIgnoreCase("no"))));
    }


    //allows the user to get and set their skater
    public static String getSkaterName(InteractionPanel panel) {
        Scanner s = new Scanner(System.in);
        Skater skater = new Skater();

        System.out.println("Choose your skater. \n 1. Tony Hawk \n 2. Daewon Song" +
                "\n 3. Bob Burnquist \n 4. Jeff Grosso \n 5. Rodney Mullen \n 6. Bucky Lasek \n 7. Aaron 'Jaws' Homoki \n " +
                "8. Andrew Reynolds \n 9. Paul Rodriguez \n 10. Jamie Foy \n 11. Jonny Giger \n 12. Our Lord and Savior, Ben <3" );
        int choice = s.nextInt();
        String[] proSkaters = new String[12];
        proSkaters[0] = "Tony Hawk";
        proSkaters[1] = "Daewon Song";
        proSkaters[2] = "Bob Burnquist";
        proSkaters[3] = "Jeff Grosso";
        proSkaters[4] = "Rodney Mullen";
        proSkaters[5] = "Bucky Lasek";
        proSkaters[6] = "Jaws";
        proSkaters[7] = "Andrew Reynolds";
        proSkaters[8] = "Paul Rodriguez";
        proSkaters[9] = "Jamie Foy";
        proSkaters[10] = "Jonny Giger";
        proSkaters[11] = "Our Lord and Savior, Ben <3";
        skater.setSkaterStats(proSkaters[(choice - 1)], panel);
        return proSkaters[(choice - 1)];
    }

}