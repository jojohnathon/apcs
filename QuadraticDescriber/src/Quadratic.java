/*
 * @author Johnathon Zheng
 * @version September 23, 2022
 * methods required to analyze a quadratic function 
 */
import java.util.*;

public class Quadratic {
    public static void quadrDescriber (double a, double b, double c) {
        System.out.println("Description of the graph of: ");
        System.out.println("y = " + a + "x^2" + " + " + b + "x" + " + " + c);

        if (a > 0.0) {
            System.out.println("Opens: Up");
        } else {
            System.out.println("Opens: Down");
        }
        System.out.print("Axis of Symmetry: ");
        System.out.println("Vertex: ");
        System.out.println("x-intercept(s): ");
        System.out.println("y-intercept: ");
    }

    public static String quadForm(int a, int b, int c) {
        if (discriminant(a, b, c) > 0) { //two solutions
            double solutionOne = ((-1 * b) + (sqrt(discriminant(a, b, c)))) / (2 * a);
            double solutionTwo = ((-1 * b) - (sqrt(discriminant(a, b, c)))) / (2 * a);
            return round2(minDouble(solutionOne, solutionTwo)) + " and " + round2(max(solutionTwo, solutionOne));
        } else if (discriminant(a, b, c) == 0) { //one solution
            double solutionOne = ((-1 * b) + (sqrt(discriminant(a, b, c)))) / (2 * a);
            return round2(solutionOne) + "";
        } else { // no real solutions
            return "no real roots";
        }
     }

     public static double discriminant(double a, double b, double c) {
		double answer = 0;
		answer = (b*b) - (4 * a * c);
		return answer;
	}

    public static double sqrt(double n) {
		if (n < 0) throw new IllegalArgumentException("Please enter a number greater than 0");
		double initialGuess = n / 2;
		double answer;
		do {
			answer = initialGuess - ((initialGuess * initialGuess) - n) / (2 * initialGuess);
			initialGuess = answer;
		} while (absValue(answer * answer - n) >= 0.005);
		return round2(answer);
	 }

     public static double round2(double num) {
        if (num > 0) {
            double answer = (num * 100) + 0.5; //convert to int
            int answer1 = (int)answer; //truncate 
            double answer2 = (double)answer1/100; //convert back to double
            return answer2;
        } else {
            double answer = (num * 100) - 0.5; //convert to int
            int answer1 = (int)answer; //truncate 
            double answer2 = (double)answer1/100; //convert back to double
            return answer2;
        }
    }

    public static double absValue(double num) {
        double answer = num;
        if (num < 0) {
            answer /= -1;
        } return answer;
    }

    public static double minDouble(double num1, double num2) {
		double answer = num1;
		if (num1 > num2) {
			answer = num2;
		} return answer;
	 }

     public static double max(double num1, double num2) {
        double answer = num1;
        if (num1 < num2) {
            answer = num2;
        } return answer;
    }
}
