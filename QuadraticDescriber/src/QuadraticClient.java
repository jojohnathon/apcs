/*
 * @author Johnathon Zheng
 * @version September 23, 2022
 * Client code for calculate part 5
 */
import java.util.*;

public class QuadraticClient {

	public static void main(String[] args) {
		//greeting
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Quadratic Describer");
		System.out.println("Provide values for coefficients a, b, and c\n");
		
		//loop(while)
		boolean run = true;
		while(run) {
			try {
				//get input from user
				System.out.print("a: ");
				double a = sc.nextDouble();
				System.out.print("b: ");
				double b = sc.nextDouble();
				System.out.print("c: ");
				double c = sc.nextDouble();
				System.out.println();
				//call quadradescriber to analyze the function
				Quadratic.quadrDescriber(a, b, c);
				
				System.out.println("Do you want to keep going? (type \"quit\" to end)");
				String keepGoing = sc.next().toLowerCase();
				if (keepGoing.equals("quit") || keepGoing.equals("q") || keepGoing.equals("no")) {
					run = false;
				}
			} catch (Exception e) {
				System.out.println("\nPlease enter a number\n");
				String keepGoing = sc.next();
				}
			}
			sc.close();
		}
	}
