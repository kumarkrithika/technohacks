import java.util.Scanner;

public class GuessingGame { // Class name matches file name

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Generate a random number between 1 and 100 (inclusive)
        int randomNumber = (int) (Math.random() * 100) + 1;

        int guess;
        do {
            System.out.println("Guess a number between 1 and 100:");
            guess = scanner.nextInt();

            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number!");
            }
        } while (guess != randomNumber);

        scanner.close();
    }
}

     