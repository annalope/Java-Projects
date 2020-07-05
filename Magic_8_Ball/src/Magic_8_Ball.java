import java.util.Scanner;
import java.util.Random;

public class Magic_8_Ball {

    protected static final String one = "As I see it, yes.";
    protected static final String two = "Ask again later.";
    protected static final String three = "Better not tell you now.";
    protected static final String four = "Cannot predict now.";
    protected static final String five = "Concentrate and ask again.";
    protected static final String six = "Don't count on it.";
    protected static final String seven = "It is certain.";
    protected static final String eight = "It is decidedly so.";
    protected static final String nine = "Most likely.";
    protected static final String ten = "My reply is no.";
    protected static final String eleven = "My sources say no.";
    protected static final String twelve = "Outlook not so good.";
    protected static final String thirteen = "Outlook good.";
    protected static final String fourteen = "Reply hazy, try again.";
    protected static final String fifteen = "Signs point to yes.";
    protected static final String sixteen = "Very doubtful.";
    protected static final String seventeen = "Without a doubt.";
    protected static final String eighteen = "Yes.";
    protected static final String nineteen = "Yes – definitely.";
    protected static final String twenty = "You may rely on it.";

    public static void main (String[] args) {
        callTheseThings();
    }

    public static void getInputFromUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your question.");
        String result = input.nextLine();
        //return result;
    }

    public static String getTheAnswer() {
        Random r = new Random();
        int num = r.nextInt(21);
        String answer = "";

        switch(num) {
            case(1):
                answer = one;
                break;
            case(2):
                answer = two;
                break;
            case(3):
                answer = three;
                break;
            case(4):
                answer = four;
                break;
            case(5):
                answer = five;
                break;
            case(6):
                answer = six;
                break;
            case(7):
                answer = seven;
                break;
            case(8):
                answer = eight;
                break;
            case(9):
                answer = nine;
                break;
            case(10):
                answer = ten;
                break;
            case(11):
                answer = eleven;
                break;
             case(12):
                answer = twelve;
                 break;
            case(13):
                answer = thirteen;
                break;
            case(14):
                answer = fourteen;
                break;
            case(15):
                answer = fifteen;
                break;
            case(16):
                answer = sixteen;
                break;
            case(17):
                answer = seventeen;
                break;
            case(18):
                answer = eighteen;
                break;
            case(19):
                answer = nineteen;
                break;
            case(20):
                answer = twenty;
                break;
            default:
        }
        return answer;
    }

    public static void callTheseThings() {
       getInputFromUser();
       System.out.println(getTheAnswer() + "\n");
       callTheseThings();
    }

}
