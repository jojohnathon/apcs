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
		System.out.println("What is your name?")
		String name = sc.nextLine();
		System.out.println("Hello " + name + ".");
		while(run) {
			System.out.println("Pick the lowest number: ");
			int lowest = sc.nextInt();
			System.out.println("Pick the highest number: ");
			int highest = sc.nextInt(); //TODO check input
			System.out.println("Pick a number between " + lowest + " and " + highest);
			int guess = sc.nextInt();

			int secret = getRandomNumber(lowest, highest);
			boolean johanthon = true;
			while(johnathon) {
				if (secret == guess) {
					System.out.println("You guessed right!");
					System.out.println("My number was " + secret + "!");
					johnathon = false;
				} else {
					String lowHigh = compareToSecret(guess, secret);
					System.out.println("Nope " + guess + "is too " + lowHigh);
					System.out.println("Guess again!");
				}
			}

			System.out.println("Play again?");
			String keepGoing = sc.next();
			
		}
	}

}
