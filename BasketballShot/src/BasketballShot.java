import java.util.Scanner;

public class BasketballShot {

    int distance;
    double points = 0;
    Scanner s = new Scanner(System.in);
    public static void main (String[] args) {
        BasketballShot basketballShot = new BasketballShot();
        basketballShot.run();
    }

    private void run() {
        System.out.println("\nHow far away would you like to shoot from?");
        distance = s.nextInt();
        takeShot();
    }

    private void takeShot() {
        if (calculateMissOrNot()) {
            updatePoints((distance/ (float) 2));
            System.out.println("You made a shot from " + distance + " feet away. You now have " + points + " points. \n");
            run();
        } else {
            System.out.println("You missed a shot from " + distance + " feet away. You still have " + points + " points.\n");
            run();
        }
    }

    private void updatePoints(double amount) {
        points += amount;
    }

    private boolean calculateMissOrNot() {
        double num = Math.random();
        if (num <= (1/(float) distance)) {
            return true;
        } else {
            return false;
        }
    }

}
