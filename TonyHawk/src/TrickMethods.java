public class TrickMethods {
//this class is very large, but essentially every method returns the trick done if you are in the right location to do it.
// if you aren't in the location to do it, it returns where you must be. the name of each trick is the name of the method.


    public String hardflip() {
        return "hardflip";
    }

    public String boardslide(String location) {
        if (location.equalsIgnoreCase("5 stair handrail") || location.equalsIgnoreCase("8 stair handrail")
                || location.equalsIgnoreCase("flatbar") || location.equalsIgnoreCase("hubba")
        || location.equalsIgnoreCase("ledge")) {
            return "boardslide";
        } else {
            return "You must be at a rail, hubba, or ledge to do this trick.";
        }
    }

    //if the trick has no location input, it can be done anywhere
    public String nineHundred() {
        return "900";

    }

    public String boneless() {
        return "boneless";
    }

    public String seven20() {
        return "720";
    }

    public String lipslide(String location) {
        if (location.equalsIgnoreCase("5 stair handrail") || location.equalsIgnoreCase("8 stair handrail")
                || location.equalsIgnoreCase("flatbar")) {
            return "lipslide";
        } else {
            return "You must be at a stairset handrail to do this trick.";
        }
    }

    public String fiveOh(String location) {
        if (!location.equalsIgnoreCase("3 stair") &&
                !location.equalsIgnoreCase("5 stair") && !location.equalsIgnoreCase("8 stair")
                && !location.equalsIgnoreCase("flatground")) {
            return "5-0 grind";
        } else {
            return "You can do this trick anywhere but the flatground, 3 stair, 5 stair, or 8 stair.";
        }
    }

    public String darkslide(String location) {
        if (!location.equalsIgnoreCase("vert ramp") && location.equalsIgnoreCase("bowl")) {
            return "darkslide";
        } else {
            return "You can do this trick anywhere but the vert ramp or bowl.";
        }
    }

    public String three60() {
        return "360";
    }

    public String bigspin() {
        return "bigspin";
    }

    //this one is a little bit of an outlier because the trick name is usually used more as a verb than a noun like
    // the other tricks. It had to have an extra case coded into the overall print statement because of it.
    public String firecracker(String location) {
        if (location.equalsIgnoreCase("3 stair") || location.equalsIgnoreCase("5 stair")
        || location.equalsIgnoreCase("8 stair")) {
            return "firecrackers";
        } else {
            return "You must be at a stairset to do this trick.";
        }
    }

    public String mctwist(String location) {
        if (location.equalsIgnoreCase("bowl") || location.equalsIgnoreCase("vert ramp")) {
            return "mctwist";
        } else {
            return "You must be at the bowl or vert ramp to do this trick.";
        }
    }

    public String crookedGrind(String location) {
        if (!location.equalsIgnoreCase("3 stair") &&
                !location.equalsIgnoreCase("5 stair") && !location.equalsIgnoreCase("8 stair")
                && !location.equalsIgnoreCase("flatground")) {
            return "crooked grind";
        } else {
            return "You can do this trick anywhere but the flatground, 3 stair, 5 stair, or 8 stair.";
        }
    }

    public String primoSlide(String location) {
        if (location.equalsIgnoreCase("ledge") ||
                location.equalsIgnoreCase("flatground")) {
            return "primo slide";
        } else {
            return "You must be at the ledge or flatground to do this trick.";
        }
    }

    public String varialFlip() {
        return "varial flip";
    }

    public String noComply() {
        return "no-comply";
    }

    public String tailslide(String location) {
        if (!location.equalsIgnoreCase("3 stair") &&
                !location.equalsIgnoreCase("5 stair") && !location.equalsIgnoreCase("8 stair")
                && !location.equalsIgnoreCase("flatground")) {
            return "tailslide";
        } else {
            return "You can do this trick anywhere but the flatground, 3 stair, 5 stair, or 8 stair.";
        }
    }

    public String shuvit() {
        return "shuv-it";
    }

    public String rockNRoll(String location) {
        if (location.equalsIgnoreCase("miniramp") ||
                location.equalsIgnoreCase("vert ramp") || location.equalsIgnoreCase("bowl")) {
            return "rock and roll";
        } else {
            return "You must be at the miniramp, bowl, or vert ramp to do this trick.";
        }
    }

    public String hospitalFlip() {
        return "hospital flip";
    }

    public String pressureFlip() {
        return "pressureflip";
    }

    public String ollie() {
        return "ollie";
    }

    public String noseblunt(String location) {
        if (!location.equalsIgnoreCase("3 stair") &&
                !location.equalsIgnoreCase("5 stair") && !location.equalsIgnoreCase("8 stair")
        && !location.equalsIgnoreCase("flatground")) {
            return "noseblunt";
        } else {
            return "You can do this trick anywhere but the flatground, 3 stair, 5 stair, or 8 stair.";
        }
    }

    public String manual(String location) {
        if (location.equalsIgnoreCase("legde") ||
                location.equalsIgnoreCase("flatground") || location.equalsIgnoreCase("hubba")) {
            return "manual";
        } else {
            return "You must be at the ledge, flatground, or hubba to do this trick.";
        }
    }

    public String laserflip(String location) {
        if (!location.equalsIgnoreCase("miniramp") &&
                !location.equalsIgnoreCase("vert ramp") && !location.equalsIgnoreCase("bowl")) {
            return "laser flip";
        } else {
            return "You can do this trick anywhere but the miniramp, bowl, or vert ramp.";
        }
    }

    public String kickflip() {
        return "kickflip";
    }

    public String judoAir(String location) {
        if (location.equalsIgnoreCase("miniramp") ||
                location.equalsIgnoreCase("vert ramp") || location.equalsIgnoreCase("bowl")) {
            return "judo air";
        } else {
            return "You must be at the miniramp, bowl, or vert ramp to do this trick.";
        }
    }

    public String impossible() {
        return "impossible";
    }

    public String heelflip() {
        return "heelflip";
    }

    public String ghettoBird(String location) {
        if (location.equalsIgnoreCase("flatground") ||
                location.equalsIgnoreCase("8 stair") || location.equalsIgnoreCase("5 stair")
                || location.equalsIgnoreCase("3 stair")) {
            return "ghetto bird";
        } else {
            return "You must be at the flatground, 3 stair, 5 stair, or 8 stair to do this trick.";
        }
    }

    public String fiftyFifty(String location) {
        if (!location.equalsIgnoreCase("3 stair") && !location.equalsIgnoreCase("5 stair") &&
                !location.equalsIgnoreCase("8 stair") && !location.equalsIgnoreCase("Flatground")) {
            return "fifty-fifty grind";
        } else {
            return "You can do this trick anywhere but the 3 stair, 5 stair, 8 stair, or flatground.";
        }
    }

    public String eggplant(String location) {
        if (location.equalsIgnoreCase("miniramp") ||
                location.equalsIgnoreCase("vert ramp") || location.equalsIgnoreCase("bowl")) {
            return "eggplant";
        } else {
            return "You must be at the miniramp, bowl, or vert ramp to do this trick.";
        }
    }

    public String dragonflip(String location) {
        if (location.equalsIgnoreCase("flatground") ||
                location.equalsIgnoreCase("3 stair") || location.equalsIgnoreCase("5 stair")
                || location.equalsIgnoreCase("8 stair")) {
            return "dragonflip";
        } else {
            return "You must be at the flatground, 3 stair, 5 stair, or 8 stair to do this trick.";
        }
    }

    public String casperSlide(String location) {
        if (location.equalsIgnoreCase("hubba") || location.equalsIgnoreCase("5 stair handrail")
                || location.equalsIgnoreCase("flatbar") || location.equalsIgnoreCase("8 stair handrail")) {
            return "casper slide";
        } else {
            return "You must be at the flatbar, hubba, 5 stair handrail, or 8 stair handrail to do this trick.";
        }
    }

    public String backsideAir(String location) {
        if (location.equalsIgnoreCase("bowl") || location.equalsIgnoreCase("vert ramp")
                || location.equalsIgnoreCase("miniramp")) {
            return "backside air";
        } else {
            return "You must be in the bowl, vert ramp, or miniramp to do this trick.";
        }
    }

    public String aerial(String location) {
        if ((location.equalsIgnoreCase("bowl")) || location.equalsIgnoreCase("vert ramp")) {
            return "aerial";
        } else {
            return "You must be in the bowl or the vert ramp to do this trick.";
        }
    }

    //was scrolling down here worth it?
}
