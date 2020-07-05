public class Skater {

    private String specialMove;
    private int skillLevel;
    private String skaterType; //whether they are a vert or street skater


    public String getSkaterType() { return skaterType; }

    public int getSkillLevel() {
        return skillLevel;
    }

    public String getSpecialMove() {
        return specialMove;
    }

    //this will update the skater's stats
    public void setSkaterStats(String skater, InteractionPanel panel) {
        panel.setName(skater);

        switch (skater) {
            case ("Tony Hawk"):
                skillLevel = 10;
                specialMove = "900";
                skaterType = "Vert";
                break;
            case ("Daewon Song"):
                skillLevel = 9;
                specialMove = "hardflip";
                skaterType = "Street";
                break;
            case ("Bob Burnquist"):
                skillLevel = 9;
                specialMove = "mctwist";
                skaterType = "Vert";
                break;
            case ("Jeff Grosso"):
                skillLevel = 8;
                specialMove = "eggplant";
                skaterType = "Vert";
                break;
            case ("Rodney Mullen"):
                skillLevel = 10;
                specialMove = "darkslide";
                skaterType = "Street";
                break;
            case ("Bucky Lasek"):
                skillLevel = 9;
                specialMove = "backside air";
                skaterType = "Vert";
                break;
            case ("Jaws"):
                skillLevel = 9;
                specialMove = "heelflip";
                skaterType = "Street";
                break;
            case ("Andrew Reynolds"):
                skillLevel = 9;
                specialMove = "aerial";
                skaterType = "Vert";
                break;
        }
    }
}
