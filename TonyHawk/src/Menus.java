import java.util.Scanner;

public class Menus {

    //some tips to help with gameplay
    public void tipsMenu() {
        System.out.println("The main tips to play the game: \n" +
                "1. Enter a letter command to do a trick. \n" +
                "2. Type in multiple letters to combine tricks. \n" +
                "3. Type in 'Skater Menu' to switch skaters. \n" +
                "4. Type in 'Tutorial' to go through the tutorial again. \n" +
                "5. Type in 'Location Menu' to visit a new location. \n" +
                "6. Type in 'Stats' to view your points and other skater statistics.");
    }

    //a dictionary explaining every trick this game codes for, the respective command, and the location you must be in to execute it
    public void trickMenu(InteractionPanel panel) {
        Scanner s = new Scanner(System.in);

        System.out.println("\nHere's a list of the tricks you can do and where you need to be to do them:\n" +
                "1. A - Aerial. You must be in the bowl or vert ramp to do this trick. \n" +
                "2. B - Backside Air. You must be at the vert ramp, miniramp, or bowl to do this trick.\n" +
                "3. C - Casper Slide. You can do this trick at the flatbar, hubba, 5 stair handrail, or 8 stair handrail. \n" +
                "4. D - Dragonflip. You can do this trick on flatground, the 3 stair, the 5 stair, or the 8 stair. \n" +
                "5. E - Egg Plant. You can do this trick on the miniramp, vert ramp, or the bowl. \n" +
                "6. F - Fifty-Fifty Grind. You can do this trick anywhere but the 3 stair, 5 stair, and 8 stair. \n" +
                "7. G - Ghetto Bird. You must be at the flatground, 5 stair, or 8 stair to do this trick.\n" +
                "8. H - Heelflip. You can do this trick anywhere. \n" +
                "9. I - Impossible. You can do this trick anywhere. \n" +
                "10. J - Judo Air. You can do this trick on the miniramp, vert ramp, or the bowl. \n" +
                "Type in 'Exit' to return to the main menu or type in 'Continue' to see more tricks.");
        String choice = s.nextLine();

        if (choice.equalsIgnoreCase("Exit")) {
            System.out.println("\n");
            panel.gamePlayer();
        } else if (choice.equalsIgnoreCase("Continue")) {
            System.out.println(
                    "11. K - Kickflip. You can do this trick anywhere. \n" +
                    "12. L - Laser Flip. You can do this trick anywhere but the miniramp, vert ramp, or bowl.\n" +
                    "13. M - Manual. You must be at the ledge, flatground, or hubba to do this trick. \n" +
                    "14. N - Noseblunt. You can do this trick anywhere but the flatground, 3 stair, 5 stair, or 8 stair. \n" +
                    "15. O - Ollie. You can do this trick anywhere. \n" +
                    "16. P - Pressureflip. You can do this trick anywhere. \n" +
                    "17. Q - Hospital Flip. You can do this trick anywhere.\n" +
                    "18. R - Rock and Roll. You must be at the mini ramp, vert ramp, or bowl. \n" +
                    "19. S - Shuv-it. You can do this trick anywhere. \n" +
                    "20. T - Tailslide. You can do this trick anywhere but the 3 stair, 5 stair, 8 stair or flatground. \n" +
                    "Type in 'Exit' to return to the main menu or type in 'Continue' to see more tricks.");
            String secondChoice = s.nextLine();

            if (secondChoice.equalsIgnoreCase("Exit")) {
                System.out.println("\n");
                panel.gamePlayer();
            } else if (secondChoice.equalsIgnoreCase("Continue")) {
                System.out.println(
                        "21. U - No-comply. You can do this trick anywhere. \n" +
                        "22. V - Varial Flip. You can do this trick anywhere.\n" +
                        "23. W - Primo slide. You must be at the ledge or flatground to do this trick. \n" +
                        "24. X - Crooked Grind. You can do this trick anywhere but the 3 stair, 5 stair, 8 stair, or flatground. \n" +
                        "25. Y - McTwist. You can do this trick at the bowl or vert ramp. \n" +
                        "26. Z - Boardslide. You can do this trick at the flatbar, ledge, hubba, 5 stair handrail, or 8 stair handrail. \n" +
                        "27. 1 - Firecracker. You can do this trick down the 3 stair, 5 stair, or 8 stair.\n" +
                        "28. 2 - Bigspin. You can do this trick anywhere. \n" +
                        "29. 3 - 360. You can do this trick anywhere. \n" +
                        "30. 4 - Darkslide. You can do this trick anywhere but the bowl or vert ramp. \n" +
                        "Type in 'Exit' to return to the main menu or type in 'Continue' to see more tricks.");
                String thirdChoice = s.nextLine();

                if (thirdChoice.equalsIgnoreCase("Exit")) {
                    System.out.println("\n");
                    panel.gamePlayer();
                } else if (thirdChoice.equalsIgnoreCase("Continue")) {
                    System.out.println(
                            "31. 5 - 5-0 Grind. You can do this trick anywhere but the 3 stair, 5 stair, 8 stair, or flatground.\n" +
                            "32. 6 - Lipslide. You can do this trick on the 5 stair handrail, 8 stair handrail, or the flatbar.\n" +
                            "33. 7 - 720. You can do this trick anywhere.\n" +
                            "34. 8 - Boneless. You can do this trick anywhere but the 5 stair handrail or 8 stair handrail.\n" +
                            "35. 9 - 900. You can do this trick anywhere. \n" +
                             "36. 0 - Hardflip. You can do this trick anywhere. \n" +
                            "Type in 'Exit' to return to the game and 'Trick Menu' to go back to the start of the list.");
                    String fourthChoice = s.nextLine();

                    if (fourthChoice.equalsIgnoreCase("exit")) {
                        System.out.println("\n");
                        panel.gamePlayer();
                    } else if (fourthChoice.equalsIgnoreCase("trick menu")){
                        trickMenu(panel);
                    } else {
                        System.out.println("\nThis is the end of the trick menu. If you wish to go back to the beginning, \n" +
                                "type in 'Trick Menu'. Type in 'Exit' to return to the game.");
                        String exitChoice = s.nextLine();
                        if (exitChoice.equalsIgnoreCase("Trick menu")) {
                            trickMenu(panel);
                        } else if (exitChoice.equalsIgnoreCase("exit")){

                        } else {
                            repeatFinalTrickMenu(panel);
                        }
                    }
                }
            }
        }
    }

    //the final message repeated at the end of the trick menu
    public void repeatFinalTrickMenu(InteractionPanel panel) {
        Scanner s = new Scanner(System.in);
        String exitChoice;

        do {
            System.out.println("This is the end of the trick menu. If you wish to go back to the beginning, \n" +
                    "type in 'Trick Menu'. Type in 'Exit' to return to the game.");
            exitChoice = s.nextLine();
            if (exitChoice.equalsIgnoreCase("Trick menu")) {
                trickMenu(panel);
                break;
            } else if (exitChoice.equalsIgnoreCase("exit")){
                break;
            }
        } while (true);
    }

    //allows you to switch skaters
    public void skaterMenu(InteractionPanel panel) {
        System.out.println();
        String tempName = panel.getSkaterName(panel);
        panel.setName(tempName);
        System.out.println("You are now playing as " + panel.getName() + ".");
    }

    //allows you to switch locations
    public void locationMenu(InteractionPanel panel) {
        Scanner s = new Scanner(System.in);

        System.out.println("\nChoose from these locations: \n 1. Flatground \n 2. Flatbar \n 3. Ledge \n 4. Miniramp  \n 5. " +
                "Bowl \n 6. 3 stair \n 7. 5 stair \n 8. 5 Stair Handrail \n 9. Hubba \n 10. 8 Stair \n 11. 8 Stair Handrail \n 12. Vert Ramp");
        int locChoice = s.nextInt();
        String[] normalLocations = new String[12];
        normalLocations[0] = "Flatground";
        normalLocations[1] = "Flatbar";
        normalLocations[2] = "Ledge";
        normalLocations[3] = "Miniramp";
        normalLocations[4] = "Bowl";
        normalLocations[5] = "3 Stair";
        normalLocations[6] = "5 Stair";
        normalLocations[7] = "5 Stair Handrail";
        normalLocations[8] = "Hubba";
        normalLocations[9] = "8 Stair";
        normalLocations[10] = "8 Stair Handrail";
        normalLocations[11] = "Vert Ramp";

        panel.setLocation(normalLocations[(locChoice - 1)]);
        System.out.println("You are now skating the " + panel.getLocation() + ".");
    }

    //allows you to view points and other stats for your skater
    public void statsMenu(InteractionPanel panel) {
        System.out.println("Stats for " + panel.getName() + ":");
        System.out.println(panel.getName() + " has " + panel.getPoints() + " points.");
        String trick;
        if (panel.getTricksDone() == 1) {
            trick = "trick";
        } else {
            trick = "tricks";
        }
        System.out.println(panel.getName() + " has done " + panel.getTricksDone() + " " + trick + ".");
        System.out.println(panel.getName() + " is currently skating the " + panel.getLocation() + ".");
    }

}
