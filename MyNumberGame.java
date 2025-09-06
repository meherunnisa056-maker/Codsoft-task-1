import java.util.Scanner;
import java.util.Random;
public class MyNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println(" Welcome to the Guessing Challenge!");
        int totalScore = 0;
        boolean playAgain = true;
        while (playAgain) {
            System.out.print("\nEnter the smallest number: ");
            int min = sc.nextInt();
            System.out.print("Enter the largest number: ");
            int max = sc.nextInt();
            int target = rand.nextInt(max - min + 1) + min;
            int maxAttempts = 5;
            int attemptsUsed = 0;
            boolean guessed = false;
            System.out.println("I have picked a number between " + min + " and " + max);
            System.out.println("You have " + maxAttempts + " attempts to guess it! ");
            while (attemptsUsed < maxAttempts) {
                System.out.print("Attempt " + (attemptsUsed + 1) + " - Your guess: ");
                int guess = sc.nextInt();
                attemptsUsed++;
                if (guess == target) {
                    System.out.println(" Correct! You nailed it in " + attemptsUsed + " attempts.");
                    guessed = true;
                    totalScore += (maxAttempts - attemptsUsed + 1) * 10;
                    break;
                } else if (guess < target) {
                    System.out.println(" Too low! Try a higher number.");
                } else {
                    System.out.println(" Too high! Try a lower number.");
                }
            }

            if (!guessed) {
                System.out.println(" Out of attempts! The number was: " + target);
            }

            System.out.println("Current Score: " + totalScore);
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = sc.next();
            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n Final Score: " + totalScore);
        System.out.println("Thanks for playing! ");
        sc.close();
    }
}