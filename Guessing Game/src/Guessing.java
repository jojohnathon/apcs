/*
 * @author Johnathon Zheng
 * @version September 28, 2022
 */
import java.util.*;
 
public class Guessing {

	public static int getRandomNumber(int low, int high) {
		int rand = (int) (Math.random() * (high - low + 1)) + low;
		return rand;
	}

	public static String compareToSecret(int guessedNum, int secretNum) {
		String guessIs = "";
		if (guessedNum < secretNum) {
			guessIs = "low";
		} else {
			guessIs = "high";
		} return guessIs;
	}

	public static boolean inRange(int low, int high, int num) {
		if (low <= num && num <= high) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		System.out.println("What is your name?");
		String name = sc.nextLine();
		System.out.println("Hello " + name + ".");
		while(run) {
			try {
				
				System.out.println("\nPick the lowest number: ");
				String input = sc.nextLine();
				int lowest = Integer.parseInt(input);
				System.out.println("\nPick the highest number: ");
				input = sc.nextLine();
				int highest = Integer.parseInt(input); //TODO check input
				if (highest < lowest) throw new IllegalArgumentException("Invalid range");
				int secret = getRandomNumber(lowest, highest);
				boolean johnathon = true;
				while(johnathon) {
					System.out.println("\nPick a number between " + lowest + " and " + highest);
					input = sc.nextLine();
					int guess = Integer.parseInt(input);
					if (secret == guess && inRange(lowest, highest, guess)) {
						System.out.println("You guessed right!");
						System.out.println("My number was " + secret + "!");
						johnathon = false;
					} else {
						String lowHigh = compareToSecret(guess, secret);
						System.out.println("\nNope! " + guess + " is too " + lowHigh);
						System.out.println("Guess again!");
					}
				}
	
				System.out.println("Play again? type \"quit\" to exit.");
				input = sc.nextLine();
				String keepGoing = input.toLowerCase();
				if (keepGoing.charAt(0) == 'q' || keepGoing.charAt(0) == 'n') {
					run = false;
				}
			} catch (Exception e) {
				System.out.println("Error:  " + e.getMessage() + ". Do you want to keep going?  (Type \"quit\" to end)");
				String keepGoing = sc.nextLine().toLowerCase();
				if (keepGoing.charAt(0) == 'q' || keepGoing.charAt(0) == 'n') {
					run = false; 
				}
				System.out.println();
			}

		
		}
	}

}
