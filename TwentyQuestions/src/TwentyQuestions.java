import java.util.Scanner;


public class TwentyQuestions {

    int questionNumber = 1;
    String player1Name;
    String player2Name;
    String thingToGuess;
    boolean gameWon = false;
    Scanner s = new Scanner(System.in);

    public static void main (String[] args) {
        TwentyQuestions twentyQuestions = new TwentyQuestions();
        twentyQuestions.beginGame();
    }

    private void beginGame() {
        System.out.println("Player 1, what is your name?");
        player1Name = s.nextLine();
        System.out.println("Player 2, what is your name?");
        player2Name = s.nextLine();
        System.out.println(player1Name + ", choose something for " + player2Name + " to guess.");
        thingToGuess = s.nextLine();
        for (int i = 0; i < 30; i++) {
            System.out.print("\n");
        }
        askQuestion();
    }

    private void askQuestion() {
        if (questionNumber > 1) {
            s.nextLine();
        }
        System.out.println(player2Name + ", this is question " + questionNumber + ". "
        + "What is your question?");
        s.nextLine();
        int num = printMenu();

        switch (num) {
            case (1):
                System.out.println(player2Name + ", " + player1Name + " says the answer to your question is yes.");
                break;
            case (2):
                System.out.println(player2Name + ", " + player1Name + " says the answer to your question is no.");
                break;
            case (3):
                System.out.println(player2Name + ", " + player1Name + " says the answer to your question is sometimes.");
                break;
            case (4):
                System.out.println("Congratulations, " + player2Name + ". You have guessed correctly and won the game.");
                gameWon = true;
            default:
        }
        System.out.print("\n");
        questionNumber++;
        if (!gameWon) {
            if (questionNumber < 21) {
                askQuestion();
            } else {
                System.out.print("\n \n " + player2Name + " you have asked 20 questions and have not guessed correctly. The answer you were looking for was " + thingToGuess + ". " + player1Name +
                " wins.");
            }
        }
    }

    private int printMenu() {
        System.out.println(player1Name + ", enter the number that corresponds to the answer to this question. \n 1. Yes" +
                "\n 2. No \n 3. Sometimes \n 4. " + player2Name + " has guessed correctly.");
        int choice = s.nextInt();
        if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
            System.out.println("That is not a valid response.");
            printMenu();
        } else {
            return choice;
        }
        return 0;
    }

}
