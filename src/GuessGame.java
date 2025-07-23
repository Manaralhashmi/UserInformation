import java.util.Scanner;          // To read user input
import java.util.Random;           // To generate random numbers
import java.util.ArrayList;        // To store user guesses

public class GuessGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);       // Create Scanner object
        Random random = new Random();                 // Create Random object

        String playAgain;     // To check if user wants to play again

        do {
            int maxTries = 0;                         // Number of allowed tries
            int randomNumber = random.nextInt(100) + 1;  // Random number between 1 and 100
            int guess;
            int attempts = 0;

            ArrayList<Integer> guessList = new ArrayList<>();  // To track guesses

            // ===================== DIFFICULTY SELECTION =====================
            System.out.println("Choose difficulty level:");
            System.out.println("1. Easy (10 tries)");
            System.out.println("2. Medium (7 tries)");
            System.out.println("3. Hard (5 tries)");
            System.out.print("Enter your choice (1/2/3): ");
            int level = input.nextInt();

            // Set maxTries based on difficulty level
            if (level == 1) {
                maxTries = 10;
            } else if (level == 2) {
                maxTries = 7;
            } else if (level == 3) {
                maxTries = 5;
            } else {
                System.out.println("Invalid choice. Defaulting to Easy.");
                maxTries = 10;
            }

            System.out.println(" I have selected a number between 1 and 100. Try to guess it!");
            System.out.println("You have " + maxTries + " attempts.");

            // ===================== GAME LOOP =====================
            do {
                System.out.print(" Enter your guess: ");
                guess = input.nextInt();
                guessList.add(guess);   // Store the guess
                attempts++;

                if (guess < randomNumber) {
                    System.out.println(" Too low!");
                } else if (guess > randomNumber) {
                    System.out.println(" Too high!");
                } else {
                    System.out.println(" Correct! The number was " + randomNumber);
                    System.out.println(" You guessed it in " + attempts + " tries.");
                    break;
                }

            } while (attempts < maxTries);

            //END OF ROUND 
            if (guess != randomNumber) {
                System.out.println("You ran out of tries. The number was: " + randomNumber);
            }

            // Print all guesses
            System.out.println("Your guesses were:");
            for (int g : guessList) {
                System.out.print(g + " ");
            }
            System.out.println();  // Move to next line

            // Ask if user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            input.nextLine();         // Clear buffer
            playAgain = input.nextLine();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing. Goodbye!");
        input.close();
    }
}
