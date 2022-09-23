/*
 * @author Johnathon Zheng
 * @version September 23, 2022
 * Client code for calculate part 5
 */
import java.util.*;

public class QuadraticClient {

	public static void main(String[] args) {
		//greeting
		System.out.println("Welcome to the Quadratic Describer");
		System.out.println("Provide values for coefficients a, b, and\n");
		//loop(while)
		boolean run = true;
		while(run) {
			//get input from user
			Scanner sc = new Scanner(System.in);
			System.out.println("a: ");
			double a = sc.nextDouble();
			System.out.println("b: ");
			double b = sc.nextDouble();
			System.out.println("c: ");
			double c = sc.nextDouble();

			//call quadradescriber to analyze the function
			Quadratic.quadrDescriber(a, b, c);

		}
			//print the results
			//ask go again?
			System.out.println("Do you want to keep going? (type \"quit\" to end)");
			String keepGoing = sc.next();
			if (keepGoing.equals("quit")) {

			}
			//get answer
		}

}
