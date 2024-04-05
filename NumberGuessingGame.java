import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound);

        for (int round = 1; ; round++) {
            System.out.println("Round " + round);
            int attempts = 0;

            while (true) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += (maxAttempts - attempts + 1);  
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }

                if (attempts >= maxAttempts) {
                    System.out.println("You've run out of attempts. The correct number was " + targetNumber);
                    break;
                }
            }

            System.out.println("Your score: " + score);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = sc.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your final score is: " + score);
                break;
            }

            targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        }

        sc.close();
    }
}
