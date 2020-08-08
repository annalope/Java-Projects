public class Pet {

    private String name;
    private String type;
    private Person owner;
    private int petPrice;
    private double weeklyMaintenance;

    public Pet(String name, String type, Person owner) {
        this.name = name;
        this.type = type;
        this.owner = owner;
        if (type.equalsIgnoreCase("horse")) {
            weeklyMaintenance = 5;
            petPrice = 50;
        } else if (type.equalsIgnoreCase("cat") || type.equalsIgnoreCase("dog")) {
            weeklyMaintenance = 0.5;
            petPrice = 20;
        } else if (type.equalsIgnoreCase("parrot") || type.equalsIgnoreCase("fish")) {
            weeklyMaintenance = 0.25;
            petPrice = 15;
        } else {
            petPrice = 5;
            weeklyMaintenance = 0.1;
        }
    }

    public double getDailyMaintenance() {
        return weeklyMaintenance;
    }
}
