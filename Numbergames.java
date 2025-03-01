import java.util.Random;
import java.util.Scanner;
public class Numbergames{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int maxAttempts = 7; 
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int targetNumber = random.nextInt(15) + 1; 
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100. Try to guess it!");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess;
                if (scanner.hasNextInt()) {
                    userGuess = scanner.nextInt();
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next(); 
                    continue;
                }
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }
            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was: " + targetNumber);
            }
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.startsWith("y");

            System.out.println("\nRounds won so far: " + roundsWon);
        }

        System.out.println("Thanks for playing! You won " + roundsWon + " round(s).");
        scanner.close();
    }
}
