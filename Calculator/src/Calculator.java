import java.util.Scanner;

public class Calculator {
    Scanner s = new Scanner(System.in);
    int input1;
    int input2;

    public static void main (String[] args) {
        Calculator calculator = new Calculator();
        calculator.askForCalculation();
    }

    public void askForCalculation() {
        System.out.println("Please enter a calculation.");
        String input = s.nextLine();
        char operation = getInputValues(input);
        doCalculation(operation);
    }

    private void doCalculation(char operation) {
        switch (operation) {
            case ('*'):
                System.out.println("The answer to your calculation is " + (input1 * input2) + ".");
                break;
            case ('/'):
                System.out.println("The answer to your calculation is " + (input1 / (float) input2) + ".");
                break;
            case ('+'):
                System.out.println("The answer to your calculation is " + (input1 + input2) + ".");
                break;
            case ('-'):
                System.out.println("The answer to your calculation is " + (input1 - input2) + ".");
                break;
            case ('^'):
                System.out.println("The answer to your calculation is " + (Math.pow(input1, input2)) + ".");
                break;
            case ('l'):
                System.out.println("The answer to your calculation is " + ((Math.log(input2)) / (Math.log(input1))) + ".");
                break;
            case ('s'):
                if (input1 == 0) {
                    input1 = 1;
                }
                System.out.println("The answer to your calculation is " + (input1 * Math.sin(input2)) + ".");
                break;
            case ('t'):
                if (input1 == 0) {
                    input1 = 1;
                }
                System.out.println("The answer to your calculation is " + (input1 * Math.tan(input2)) + ".");
                break;
            case ('c'):
                if (input1 == 0) {
                    input1 = 1;
                }
                System.out.println("The answer to your calculation is " + (input1 * Math.cos(input2)) + ".");
                break;
            default:
        }
        System.out.println("\n \n \n");
        askForCalculation();
    }

    private char getInputValues(String theInput) {
        for (int i = 0; i < theInput.length(); i++) {
            char car = theInput.charAt(i);
            if (car != '0' && car != '1' && car != '2' && car != '3' && car != '4' && car != '5' && car != '6'
                    && car != '7' && car != '8' && car != '9') {
                input1 = Integer.parseInt(theInput.substring(0, i));
                if (car == 'l' || car == 'L') {
                    car = 'l';
                    input2 = Integer.parseInt(theInput.substring(i + 3));
                } else if (car == 's' || car == 'S') {
                    car = 's';
                    input2 = Integer.parseInt(theInput.substring(i + 3));
                } else if (car == 'c' || car == 'C') {
                    car = 'c';
                    input2 = Integer.parseInt(theInput.substring(i + 3));
                } else if (car == 't' || car == 'T') {
                    car = 't';
                    input2 = Integer.parseInt(theInput.substring(i + 3));
                } else {
                    input2 = Integer.parseInt(theInput.substring(i + 1));
                }
                return car;
            }
        }
        return 'f';
    }

}
