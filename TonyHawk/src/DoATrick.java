import java.util.Random;
public class DoATrick {

    private int skillLevel; // of the skater, used to calculate odds of landing
    private String an = "an ";
    private String a = "a ";
    private String preposition = "";
    private String aOrAn;
    private int tricksDoneCombo = 0;
    private int pointsGotten = 0;
    private int chances;

    public void doATrick(String trickCommand, String location, String name, InteractionPanel panel) {
        Menus menu = new Menus();
        trickCommand.toLowerCase();
        Tutorial tutorial = new Tutorial();

        //menu checks
        if (trickCommand.equalsIgnoreCase("tips")) {
            menu.tipsMenu();
        } else if (trickCommand.equalsIgnoreCase("trick menu")) {
            menu.trickMenu(panel);
        } else if (trickCommand.equalsIgnoreCase("location menu")) {
            menu.locationMenu(panel);
        } else if (trickCommand.equalsIgnoreCase("skater menu")) {
            menu.skaterMenu(panel);
        } else if (trickCommand.equalsIgnoreCase("stats")) {
            menu.statsMenu(panel);
        } else if (trickCommand.equalsIgnoreCase("tutorial")){
            tutorial.tutorialTime(panel);
        } else if (trickCommand.length() > 3) {
            //impossibility check
            System.out.println("You can only combine three tricks at once.");
        } else if (trickCommand.length() > 1) {
            //combo checks
            boolean failedTrick = false;
            printer(comboTricks(trickCommand, location, name, panel, failedTrick));
        } else {
            //normal tricks no combo
            String trick = massiveSwitchCaseStatement(trickCommand.charAt(0), location, panel); //needs its own line to update the aOrAn variable
            printer(assembleAllParts(location, name, (aOrAn + trick), chances, (chances * 100), panel));
        }
    }

    private String comboTricks(String trickCommands, String location, String name, InteractionPanel panel, boolean failedTrick) {
        String toBePrinted = "";
        pointsGotten = 0; //this variable keeps track of how many points incurred over the course of this combo

        for (int i = 0; i < trickCommands.length(); i++) {
            String someVariable = massiveSwitchCaseStatement(trickCommands.charAt(i), location, panel);
            String fixedSomeVariable = someVariable.substring(0, 2);

            if (fixedSomeVariable.equalsIgnoreCase("Yo")) {
                toBePrinted = someVariable;
                failedTrick = true;
            } else {
                if (i == 0) {
                    // if this is the first trick
                    if (!failedTrick) {
                        tricksDoneCombo += 1;
                        //firecrackering dwn some stairs has slightly different grammar than the other tricks
                        if (trickCommands.charAt(i) == '1') {
                            toBePrinted += name + massiveSwitchCaseStatement(trickCommands.charAt(i), location, panel);
                        } else {
                            toBePrinted += name + " does " + aOrAn + massiveSwitchCaseStatement(trickCommands.charAt(i), location, panel);

                        }
                    }
                } else if (i == trickCommands.length() - 1) {
                    // if this is the last trick
                    if (!failedTrick) {
                        tricksDoneCombo += 1;
                        if (trickCommands.charAt(i - 1) == '1') {
                            toBePrinted += " and does " + aOrAn + massiveSwitchCaseStatement(trickCommands.charAt(i), location, panel) + checkPreposition(location) + " the " + location + "."
                                    + "\n" + "+" + (pointsGotten / 2) + " points";
                        } else {
                        toBePrinted += " " + massiveSwitchCaseStatement(trickCommands.charAt(i), location, panel) + checkPreposition(location) + " the " + location + "."
                                + "\n" + "+" + (pointsGotten / 2) + " points";
                        }
                    }
                } else {
                    // if this is some trick in between the first and last
                    if (!failedTrick) {
                        tricksDoneCombo += 1;

                        if (trickCommands.charAt(i - 1) == '1') {
                            toBePrinted += " and does " + aOrAn + massiveSwitchCaseStatement(trickCommands.charAt(i), location, panel);
                        } else {
                            toBePrinted += " " + massiveSwitchCaseStatement(trickCommands.charAt(i), location, panel);
                        }
                    }

                }
            }
        }
        panel.setTricksDone(panel.getTricksDone() + tricksDoneCombo);
        return (toBePrinted);
    }

    //decides whether you are doing the trick on, down, or in the obstacle
    private String checkPreposition(String location) {
        if (location.equalsIgnoreCase("3 stair") || location.equalsIgnoreCase("5 stair")
                || location.equalsIgnoreCase("8 stair") || location.equalsIgnoreCase("3 stair handrail")
                || location.equalsIgnoreCase("5 stair handrail") || location.equalsIgnoreCase("8 stair handrail")) {
            preposition = " down";
        } else if (location.equalsIgnoreCase("flatbar") || location.equalsIgnoreCase("ledge")
                || location.equalsIgnoreCase("miniramp") || location.equalsIgnoreCase("hubba")
                || location.equalsIgnoreCase("vert ramp")) {
            preposition = " on";
        } else if (location.equalsIgnoreCase("bowl")) {
            preposition = " in";
        }

        return preposition;
    }

    // it is what it is
    private String massiveSwitchCaseStatement(char trickCommand, String location, InteractionPanel panel) {
        TrickMethods trickMethod = new TrickMethods();

        switch (trickCommand) {
            case ('a'):
                aOrAn = "an ";
                pointsGotten += 200;
                chances = 2;
                updatePoints(panel, 100);
                return trickMethod.aerial(location);
            case ('b'):
                aOrAn = "a ";
                pointsGotten += 200;
                chances = 2;
                updatePoints(panel, 100);
                return trickMethod.backsideAir(location);
            case ('c'):
                aOrAn = "a ";
                pointsGotten += 300;
                chances = 3;
                updatePoints(panel, 150);
                return trickMethod.casperSlide(location);
            case ('d'):
                pointsGotten += 300;
                chances = 3;
                updatePoints(panel, 150);
                aOrAn = "a ";
                return trickMethod.dragonflip(location);
            case ('e'):
                pointsGotten += 200;
                chances = 2;
                updatePoints(panel, 100);
                aOrAn = "an ";
                return trickMethod.eggplant(location);
            case ('f'):
                pointsGotten += 100;
                chances = 1;
                updatePoints(panel, 50);
                aOrAn = "a ";
                return trickMethod.fiftyFifty(location);
            case ('g'):
                chances = 3;
                pointsGotten += 300;
                updatePoints(panel, 150);
                aOrAn = "a ";
                return trickMethod.ghettoBird(location);
            case ('h'):
                aOrAn = "a ";
                pointsGotten += 200;
                chances = 2;
                updatePoints(panel, 100);
                return trickMethod.heelflip();
            case ('i'):
                pointsGotten += 300;
                chances = 3;
                aOrAn = "an ";
                updatePoints(panel, 150);
                return trickMethod.impossible();
            case ('j'):
                chances = 2;
                pointsGotten += 200;
                aOrAn = "a ";
                updatePoints(panel, 100);
                return trickMethod.judoAir(location);
            case ('k'):
                pointsGotten += 100;
                chances = 1;
                aOrAn = "a ";
                updatePoints(panel, 50);
                return trickMethod.kickflip();
            case ('l'):
                pointsGotten += 300;
                chances = 3;
                updatePoints(panel, 150);
                aOrAn = "a ";
                return trickMethod.laserflip(location);
            case ('m'):
                chances = 1;
                pointsGotten += 100;
                updatePoints(panel, 50);
                aOrAn = "a ";
                return trickMethod.manual(location);
            case ('n'):
                chances = 2;
                pointsGotten += 200;
                updatePoints(panel, 100);
                aOrAn = "a ";
                return trickMethod.noseblunt(location);
            case ('o'):
                chances = 1;
                pointsGotten += 100;
                updatePoints(panel, 50);
                aOrAn = "an ";
                return trickMethod.ollie();
            case ('p'):
                chances = 2;
                pointsGotten += 200;
                updatePoints(panel, 100);
                aOrAn = "a ";
                return trickMethod.pressureFlip();
            case ('q'):
                chances = 3;
                pointsGotten += 300;
                updatePoints(panel, 150);
                aOrAn = "a ";
                return trickMethod.hospitalFlip();
            case ('r'):
                chances = 1;
                pointsGotten += 100;
                updatePoints(panel, 50);
                aOrAn = "a ";
                return trickMethod.rockNRoll(location);
            case ('s'):
                chances = 1;
                pointsGotten += 100;
                updatePoints(panel, 50);
                aOrAn = "a ";
                return trickMethod.shuvit();
            case ('t'):
                chances = 2;
                pointsGotten += 200;
                updatePoints(panel, 100);
                aOrAn = "a ";
                return trickMethod.tailslide(location);
            case ('u'):
                chances = 1;
                pointsGotten += 100;
                updatePoints(panel, 50);
                aOrAn = "a ";
                return trickMethod.noComply();
            case ('v'):
                chances = 2;
                pointsGotten += 200;
                updatePoints(panel, 100);
                aOrAn = "a ";
                return trickMethod.varialFlip();
            case ('w'):
                chances = 4;
                pointsGotten += 400;
                updatePoints(panel, 200);
                aOrAn = "a ";
                return trickMethod.primoSlide(location);
            case ('x'):
                chances = 3;
                pointsGotten += 300;
                updatePoints(panel, 150);
                aOrAn = "a ";
                return trickMethod.crookedGrind(location);
            case ('y'):
                chances = 3;
                pointsGotten += 300;
                updatePoints(panel, 150);
                aOrAn = "a ";
                return trickMethod.mctwist(location);
            case ('z'):
                chances = 1;
                pointsGotten += 100;
                updatePoints(panel, 50);
                aOrAn = "a ";
                return trickMethod.boardslide(location);
            case ('1'):
                chances = 1;
                pointsGotten += 100;
                updatePoints(panel, 50);
                return trickMethod.firecracker(location);
            case ('2'):
                chances = 3;
                pointsGotten += 300;
                updatePoints(panel, 150);
                aOrAn = "a ";
                return trickMethod.bigspin();
            case ('3'):
                chances = 2;
                pointsGotten += 200;
                aOrAn = "a ";
                updatePoints(panel, 100);
                return trickMethod.three60();
            case ('4'):
                pointsGotten += 400;
                aOrAn = "a ";
                updatePoints(panel, 200);
                return trickMethod.darkslide(location);
            case ('5'):
                pointsGotten += 300;
                chances = 3;
                aOrAn = "a ";
                updatePoints(panel, 150);
                return trickMethod.fiveOh(location);
            case ('6'):
                pointsGotten += 300;
                chances = 3;
                aOrAn = "a ";
                updatePoints(panel, 150);
                return trickMethod.lipslide(location);
            case ('7'):
                chances = 3;
                pointsGotten += 300;
                aOrAn = "a ";
                updatePoints(panel, 150);
                return trickMethod.seven20();
            case ('8'):
                chances = 2;
                pointsGotten += 200;
                aOrAn = "a ";
                updatePoints(panel, 100);
                return trickMethod.boneless();
            case ('9'):
                chances = 4;
                pointsGotten += 400;
                aOrAn = "a ";
                updatePoints(panel, 200);
                return trickMethod.nineHundred();
            case ('0'):
                chances = 3;
                aOrAn = "a ";
                updatePoints(panel, 300);
                return trickMethod.hardflip();
            default:
                return "";
        }
    }

    //updates the points value after you do a trick
    private void updatePoints(InteractionPanel panel, int pointValue) {
        pointsGotten += pointValue;
        panel.setPoints(panel.getPoints() + pointValue);
    }

    //puts together the entire sentence
    private String assembleAllParts(String location, String name, String trickDone, int chances, int pointValue, InteractionPanel panel) {
        if (oddsOfLanding(chances)) { //the trick is done
            updatePoints(panel, pointValue);
            return stringCreator(location, name, trickDone, pointValue, panel);
        } else { //the trick is failed
            return failureString(location, name, trickDone);
        }
    }

    //prints out what happens when you fail a trick
    private String failureString(String location, String name, String trickDone) {
        String preposition = checkPreposition(location);
        return (name + " failed to do " + trickDone + preposition + " the " + location + ".");
    }

    private boolean oddsOfLanding(int chances) { //calculates your odds
        Random r = new Random();
        double randomNum = r.nextInt(chances);

        if (chances == 1) { //will always land the trick in this case
            return true;
        }

        if (randomNum == 1) {
            return true;
        } else {
         return false;
        }
    }

    private void printer(String message) { //simplifies the printing process and reduces repeated text
        System.out.println(message);
    }

    private String stringCreator(String location, String name, String trickDone, int pointValue, InteractionPanel panel) {
        String checker = trickDone.substring(0, 2);
        //creates the actual string and returns it to be printed
        if (checker.equalsIgnoreCase("Yo")) {
            //if you aren't in the proper location to do the trick
            return trickDone;
        } else {
            panel.setTricksDone(panel.getTricksDone() + 1);
            return (name + " does " + trickDone + checkPreposition(location) + " the " + location + "!" +"\n" +
                    "+" + pointValue + " points!");
        }
    }
}
