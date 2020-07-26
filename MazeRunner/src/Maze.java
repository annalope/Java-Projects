import java.util.Scanner;

public class Maze {
    Scanner s = new Scanner(System.in);
    Person person = new Person();
    String[][] map = new String[10][10];

    public String start() {
        String direction = printMenu().toLowerCase();
        return checkIfAllValid(direction);
    }

    private String checkIfAllValid(String direction) {
        if (onTheMap(direction) && checkIfNotWall(direction)) {
            return person.move(direction);
        } else {
            System.out.println("That is not a valid movement.");
            direction = printMenu().toLowerCase();
            checkIfAllValid(direction);
        }
        return "";
    }

    public boolean finished(){
        if (person.getxCoor() == 9 && person.getyCoor() == 9) {
            System.out.print("Congratulations! You solved the maze!");
            return true;
        } else {
            return false;
        }
    }

    private boolean onTheMap(String direction) {
        boolean result = true;
        switch (direction) {
            case ("north"):
                result = !(person.getxCoor() - 1 < 0);
                break;
            case ("south"):
                result = !(person.getxCoor()  + 1 > 9);
                break;
            case ("east"):
                result = !(person.getyCoor()  + 1 > 9);
                break;
            case ("west"):
                result = !(person.getyCoor()  - 1 < 0);
                break;
        }

        return result;
    }

    private boolean checkIfNotWall(String direction) {
        boolean result = true;
        switch (direction) {
            case ("north"):
                result = !(map[person.getxCoor() - 1][person.getyCoor()].equalsIgnoreCase("Wall"));
                break;
            case ("south"):
                result = !(map[person.getxCoor() + 1][person.getyCoor()].equalsIgnoreCase("Wall"));
                break;
            case ("east"):
                result = !(map[person.getxCoor()][person.getyCoor() + 1].equalsIgnoreCase("Wall"));
                break;
            case ("west"):
                result = !(map[person.getxCoor()][person.getyCoor() - 1].equalsIgnoreCase("Wall"));
                break;
        }
        return result;
    }

    private String printMenu() {
        System.out.println("Please enter either north, south, east, or west.");
        String direction = s.nextLine();
        if ((!direction.equalsIgnoreCase("north")) && (!direction.equalsIgnoreCase("south"))
        && (!direction.equalsIgnoreCase("west")) && (!direction.equalsIgnoreCase("east"))) {
           printMenu();
        }
        return direction;
    }

    public void printMap() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                printEachPoint(i, j);
            }
        }
    }

    private void printEachPoint(int xCoor, int yCoor) {
        if (person.getyCoor() == yCoor && person.getxCoor() == xCoor) {
            if (person.getyCoor() != 9) {
                System.out.print(" me ");
            } else {
                System.out.println(" me ");
            }
        } else {
            if (yCoor != 9) {
                if (map[xCoor][yCoor].equalsIgnoreCase("Wall")) {
                    System.out.print("|--|");
                } else if (map[xCoor][yCoor].equalsIgnoreCase("Blank")) {
                    System.out.print("    ");
                } else if (map[xCoor][yCoor].equalsIgnoreCase("Finish")) {
                    System.out.print(" end");
                }
            } else {
                if (map[xCoor][yCoor].equalsIgnoreCase("Wall")) {
                    System.out.println("|--|");
                } else if (map[xCoor][yCoor].equalsIgnoreCase("Blank")) {
                    System.out.println("    ");
                } else if (map[xCoor][yCoor].equalsIgnoreCase("Finish")) {
                    System.out.println(" end");
                }
            }
        }
    }

    public void intializeMap() {
        map[0][0] = "Blank";
        map[0][1] = "Blank";
        map[0][2] = "Wall";
        map[0][3] = "Wall";
        map[0][4] = "Wall";
        map[0][5] = "Wall";
        map[0][6] = "Wall";
        map[0][7] = "Wall";
        map[0][8] = "Wall";
        map[0][9] = "Wall";
        map[1][0] = "Wall";
        map[1][1] = "Blank";
        map[1][2] = "Wall";
        map[1][3] = "Blank";
        map[1][4] = "Wall";
        map[1][5] = "Wall";
        map[1][6] = "Blank";
        map[1][7] = "Blank";
        map[1][8] = "Blank";
        map[1][9] = "Wall";
        map[2][0] = "Wall";
        map[2][1] = "Blank";
        map[2][2] = "Wall";
        map[2][3] = "Blank";
        map[2][4] = "Blank";
        map[2][5] = "Blank";
        map[2][6] = "Blank";
        map[2][7] = "Wall";
        map[2][8] = "Blank";
        map[2][9] = "Wall";
        map[3][0] = "Wall";
        map[3][1] = "Blank";
        map[3][2] = "Wall";
        map[3][3] = "Blank";
        map[3][4] = "Wall";
        map[3][5] = "Wall";
        map[3][6] = "Blank";
        map[3][7] = "Wall";
        map[3][8] = "Blank";
        map[3][9] = "Wall";
        map[4][0] = "Wall";
        map[4][1] = "Blank";
        map[4][2] = "Blank";
        map[4][3] = "Blank";
        map[4][4] = "Wall";
        map[4][5] = "Wall";
        map[4][6] = "Blank";
        map[4][7] = "Blank";
        map[4][8] = "Wall";
        map[4][9] = "Wall";
        map[5][0] = "Wall";
        map[5][1] = "Blank";
        map[5][2] = "Wall";
        map[5][3] = "Wall";
        map[5][4] = "Wall";
        map[5][5] = "Blank";
        map[5][6] = "Wall";
        map[5][7] = "Blank";
        map[5][8] = "Wall";
        map[5][9] = "Wall";
        map[6][0] = "Wall";
        map[6][1] = "Blank";
        map[6][2] = "Blank";
        map[6][3] = "Blank";
        map[6][4] = "Blank";
        map[6][5] = "Blank";
        map[6][6] = "Wall";
        map[6][7] = "Blank";
        map[6][8] = "Blank";
        map[6][9] = "Wall";
        map[7][0] = "Wall";
        map[7][1] = "Blank";
        map[7][2] = "Wall";
        map[7][3] = "Blank";
        map[7][4] = "Wall";
        map[7][5] = "Wall";
        map[7][6] = "Wall";
        map[7][7] = "Wall";
        map[7][8] = "Blank";
        map[7][9] = "Wall";
        map[8][0] = "Wall";
        map[8][1] = "Blank";
        map[8][2] = "Wall";
        map[8][3] = "Blank";
        map[8][4] = "Blank";
        map[8][5] = "Blank";
        map[8][6] = "Blank";
        map[8][7] = "Wall";
        map[8][8] = "Blank";
        map[8][9] = "Blank";
        map[9][0] = "Wall";
        map[9][1] = "Wall";
        map[9][2] = "Wall";
        map[9][3] = "Wall";
        map[9][4] = "Wall";
        map[9][5] = "Wall";
        map[9][6] = "Wall";
        map[9][7] = "Wall";
        map[9][8] = "Wall";
        map[9][9] = "Finish";
    }
}
