import java.util.Scanner;

public class Tutorial {

    private String instructionsTutorial;
    private String commandTutorial;

    public void tutorialTime(InteractionPanel panel) {
        Menus menu = new Menus();

        Scanner s = new Scanner(System.in);
        System.out.println("Hello, " + panel.getName() + ". Time to skate. You're going to want to start by learning a " +
                "few basic tricks. Type in 'O' to ollie.");
        instructionsTutorial = "Type in 'O' to do an ollie.";
        commandTutorial = "O";
        String possiblyUnimportant = s.nextLine();

        if (possiblyUnimportant.equalsIgnoreCase("O")) {
            doATrickPart1("O", panel);
        } else {
            repeatTheInstructions();
            doATrickPart1("O", panel);
        }

        System.out.println("Great! Now, time for some flip tricks. Type in a 'K' to do a kickflip.");
        instructionsTutorial = "Type in 'K' to do a kickflip.";
        commandTutorial = "K";
        String kickChoice = s.nextLine();

        if (kickChoice.equalsIgnoreCase("k")) {
            doATrickPart1("K", panel);
        } else {
            repeatTheInstructions();
            doATrickPart1("k", panel);
        }

        System.out.println("Awesome! Now let's flip it the other direction. Type in 'H' to heelflip.");
        instructionsTutorial = "Type in 'H' to do a heelflip.";
        commandTutorial = "H";
        String heelChoice = s.nextLine();

        if (heelChoice.equalsIgnoreCase("H")) {
            doATrickPart1("H", panel);
        } else {
            repeatTheInstructions();
            doATrickPart1("h", panel);
        }

        System.out.println("Now you're getting it! Let's try a rotation. Type in an 'S' to do a shuv-it.");
        instructionsTutorial = "Type in 'S' to do a shuv-it.";
        commandTutorial = "S";
        String shuvChoice = s.nextLine();

        if (shuvChoice.equalsIgnoreCase("s")) {
           doATrickPart1("s", panel);
        } else {
            repeatTheInstructions();
            doATrickPart1("s", panel);
        }

        System.out.println("You're almost there! Let's change the obstacle. To switch locations, type in 'Location menu'.");
        instructionsTutorial = "Type in 'Location Menu' to switch your location.";
        commandTutorial = "Location Menu";
        String locationChoice = s.nextLine();

        if (locationChoice.equalsIgnoreCase("Location Menu")) {
            System.out.println("Switch to the flatbar.");
            menu.locationMenu(panel);
        } else {
            repeatTheInstructions();
            System.out.println("Switch to the flatbar.");
            doATrickPart1("Location menu", panel);
        }

        if (!panel.getLocation().equalsIgnoreCase("Flatbar")) {
            flatbarChecker(panel);
        }

        System.out.println("Now we can do some special tricks. Since we're on the flatbar, type in 'F' to fifty-fifty grind.");
        instructionsTutorial = "Type in 'F' to fifty-fifty grind.";
        commandTutorial = "F";
        String hasSomeImportance = s.nextLine();
        if (hasSomeImportance.equalsIgnoreCase("F")) {
           doATrickPart1("F", panel);
        } else {
            repeatTheInstructions();
           doATrickPart1("F", panel);
        }

        System.out.println("There you go! Now, to access the full list of tricks you can do by typing in 'Trick Menu'. Give it a try!");
        instructionsTutorial = "Type in 'Trick Menu' to view the trick menu.";
        commandTutorial = "Trick Menu";
        if (s.nextLine().equalsIgnoreCase("Trick menu")) {
            menu.trickMenu(panel);
        } else {
            repeatTheInstructions();
            menu.trickMenu(panel);
        }
//pass in "inTutorial boolean to conserve line space
        tutorialPart2(panel);
    }

    public void tutorialPart2(InteractionPanel panel) {
        Scanner s = new Scanner(System.in);
        Menus menu = new Menus();

        System.out.println("Looks like you've got down the basics of tricks and location switches. All that's left is the ability to switch skaters. \n" +
                "Every skater has their own special moves or locations. To change your skater, type in 'Skater Menu'.");
        instructionsTutorial = "To change your skater, type in 'Skater Menu'.";
        commandTutorial = "Skater Menu";
        String skaterChoice = s.nextLine();

        if (skaterChoice.equalsIgnoreCase("Skater Menu")) {
            menu.skaterMenu(panel);
        } else {
            repeatTheInstructions();
            doATrickPart1("Skater Menu", panel);
        }

        System.out.println("Great job! You passed the tutorial. To get a few pointers, you can type in 'Tips'. Now that you know how, you can play the game!");
        panel.gamePlayer();
    }

    public void flatbarChecker(InteractionPanel panel) {
        Menus menu = new Menus();

        do {
            System.out.println("\nChoose the flatbar in the locations menu.");
            menu.locationMenu(panel);
        } while (!panel.getLocation().equalsIgnoreCase("flatbar"));

    }

    //waits for the correct input to proceed
    public void repeatTheInstructions() {
        String seeIfTheyGetItNow;
        do {
            Scanner s = new Scanner(System.in);
            System.out.println(instructionsTutorial);
            seeIfTheyGetItNow = s.nextLine();
        } while (!seeIfTheyGetItNow.equalsIgnoreCase(commandTutorial));

    }

    //the tutorial version of doing a trick
    public void doATrickPart1(String trickCommand, InteractionPanel panel) {
        Menus menu = new Menus();

        if (trickCommand.equalsIgnoreCase("o")) {
            System.out.println(panel.getName() + " does an ollie!");
        }
        if (trickCommand.equalsIgnoreCase("k")) {
            System.out.println(panel.getName() + " does a kickflip!");
        }
        if (trickCommand.equalsIgnoreCase("h")) {
            System.out.println(panel.getName() + " does a heelflip!");
        }
        if (trickCommand.equalsIgnoreCase("S")) {
            System.out.println(panel.getName() + " does a shuv-it!");
        }
        if ((trickCommand.equalsIgnoreCase("F") && (panel.getLocation().equalsIgnoreCase("Flatbar")))) {
            System.out.println(panel.getName() + " does a 50-50 grind!");
        }
        if (trickCommand.equalsIgnoreCase("Location Menu")) {
            menu.locationMenu(panel);
        }
        if (trickCommand.equalsIgnoreCase("Trick menu")) {
            menu. trickMenu(panel);
        }
        if (trickCommand.equalsIgnoreCase("Skater menu")) {
            menu.skaterMenu(panel);
        }
    }

}
