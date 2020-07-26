public class Person {

    int xCoor;
    int yCoor;

    public Person() {
        xCoor = 0;
        yCoor = 0;
    }

    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public String move(String direction) {
        switch (direction) {
            case ("north"):
                updateX(-1);
                return "north";
            case ("south"):
                updateX(1);
                return "south";
            case ("west"):
                updateY(-1);
                return "west";
            case ("east"):
                updateY(1);
                return "east";
        }
        return "";
    }

    private void updateX(int value) {
        this.xCoor+= value;
    }

    private void updateY(int value) {
        this.yCoor+= value;
    }
}
