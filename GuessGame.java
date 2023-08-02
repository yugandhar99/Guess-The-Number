import java.lang.Math;
import java.util.Scanner;

public class GuessGame {
    public static int Gussed_number;
    public static int Number = (int) (Math.random() * (99 - 10 + 1) + 10);

    public static void main(String[] args) {
        System.out.println(
                "Welcome to Guess the Number Game.\nIn this game you are given 5 chance to guess the number between 10 to 99.\nEnter 100 if you need more hints.\nGuess the Number:");
        guess();
    }

    static void guess() {
        for (int i = 0; i < 5; i++) {
            Scanner input = new Scanner(System.in);
            Gussed_number = input.nextInt();
            if (Integer.valueOf(Gussed_number) != Number) {
                if (i == 4) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Sorry!...\nYour 5 Chances are over. The Number is " + Number);
                    break;
                } else {
                    System.out.println(clue());
                }
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(Number + "\nCongralutions!..\nYou have Gussed the Correct Number");
                break;
            }
        }
    }

    static String clue() {
        int difference = Gussed_number - Number;
        String output = "";
        if (Gussed_number == 100) {
            output = "The number is divisible by";
            if (Number % 2 == 0) {
                output = output + " 2";
            }
            if (Number % 3 == 0) {
                output = output + " 3";
            }
            if (Number % 5 == 0) {
                output = output + " 5.";
            }
            return output;
        } else if (difference < 10 && difference > -10) {
            output = "The Number is Within the range of 10 with reference to " + Gussed_number;
            return output;
        } else if (Gussed_number > Number) {
            output = "The number is less than " + Gussed_number;
            return output;
        } else if (Gussed_number < Number) {
            output = "The number is Greater than " + Gussed_number;
            return output;
        } else {
            return output;
        }
    }

}
