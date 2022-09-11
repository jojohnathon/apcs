/*
 * @author Johnathon Zheng
 * @version August 26, 2022
 * Library of math methods
 */
public class Calculate {
	//returns the square of the input
	public static int square(int number) {
		int answer = 0;
		answer = number*number;
		return answer;
	}
	//returns the cube of the input
	public static int cube(int number) {
		int answer = 0;
		answer = number*number*number;
		return answer;
	}
	//returns the average of two numbers
	public static double average(double a, double b) {
		double answer = 0.0;
		answer = (a + b) / 2;
		return answer;
	}
	//returns the average of three numbers
	public static double average(double a, double b, double c) {
		double answer = 0.0;
		answer = (a + b + c) / 3;
		return answer;
	}
	//converts radians to degrees
	public static double toDegrees(double radians) {
		double answer = 0.0;
		answer = radians * (180/3.14159);
		return answer;
	}
	//converts degrees to radians
	public static double toRadians(double degrees) {
		double answer = 0.0;
		answer = degrees * (3.14159/180);
		return answer;
	}
	//returns the discriminant of a quadratic in standard form
	public static double discriminant(double a, double b, double c) {
		double answer = 0;
		answer = (b*b) - (4 * a * c);
		return answer;
	}
	//converts a mixed number to an improper fraction
	 public static String toImproperFrac(int a, int b, int c) {
		int answer = 0;
		answer = (a * c) + b;
		return answer + "/" + c;
	 }
	 //converts an improper fraction to a mixed number
	 public static String toMixedNum(int a, int b) {
		 String answer = "0";
		 answer = a / b + "_" + a % b + "/" + String.valueOf(b);
		 return answer;
	 }
	 //does foil method
	 public static String foil(int a, int b, int c, int d, String n) {
		 String answer;
		 answer = (a * c + n + "^2") + "+" + ((a * d) + (b * c))  + n + "+" + (b * d);
		 return answer;
	 }
	 //checks if a number is divisbile by another number
	 public static boolean isDivivsibleBy(int a, int b) {
		if (b == 0) throw new IllegalArgumentException("The second argument cannot be 0");
		 boolean answer = false;
		 if (a % b == 0) {
			 answer = true;
		 } return answer;
	 }
	 //finds absolute value of a number
	 public static double absValue(double a) {
		 double answer = a;
		 if (a < 0) {
			 answer /= -1;
		 } return answer;
	 }
	 //finds the larger of two numbers
	 public static double max(double a, double b) {
		 double answer = a;
		 if (a < b) {
			 answer = b;
		 } return answer;
	 }
	 //finds the larger of three numbers
	 public static double max(double a, double b, double c) {
		 double answer = a;
		 if (b >= a && b >= c) {
			answer = b;
		 } else if (c >= a && c >= a) {
			answer = c;
		 } return answer;
	}
	 //find the smallest of two numbers
	 public static int min(int a, int b) {
		 int answer = a;
		 if (a > b) {
			 answer = b;
		 } return answer;
	 }
	 //rubric doesn't allow min to return double so i made another
	 public static double myAwesomeMin(double a, double b) {
		double answer = a;
		if (a > b) {
			answer = b;
		} return answer;
	 }
	 //rounds a number to 2 decimal places
	 public static double round2(double a) {
		 if (a > 0) {
			 double answer = (a * 100) + 0.5; //convert to int
			 int answer1 = (int)answer; //truncate 
			 double answer2 = (double)answer1/100; //convert back to double
			 return answer2;
		 } else {
			 double answer = (a * 100) - 0.5; //convert to int
			 int answer1 = (int)answer; //truncate 
			 double answer2 = (double)answer1/100; //convert back to double
			 return answer2;
		 }
	 }
	 //raises a number to a positive integer power
	 public static double exponent(double base, int power) {
		if (power <= 0) throw new IllegalArgumentException("Please enter a power greater than 0");
		 double answer = base;
		 if (power == 0) return 1;
		 for (int i = 1; i < power; i++) {
			 answer = answer * base;
		 } return answer;
	 }
	 //calculates the factorial of a positive integer
	 public static int factorial(int n) {
		if (n < 0) throw new IllegalArgumentException("Please enter a positive number");
		int answer = n;
		for (int i  = n - 1; i > 0; i--) {
			answer = answer * i;
		} return answer;
	 }
	 //checks if a number is a prime number or not
	 public static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if(isDivivsibleBy(n, i)) {
				return false;
			}
		} return true;
	 }
	 //finds the greatest common divisor of two numbers
	 public static int gcf(int a, int b) { 
		int answer = 1;
		for (int i = 1; i <= a || i <= b; i++) {
			if (isDivivsibleBy(a, i) && isDivivsibleBy(b, i)) {
				answer = i;
			} 
		} return answer;
	 }
	 //approximates the square root of a double using newton's method
	 public static double sqrt(double n) {
		if (n < 0) throw new IllegalArgumentException("Please enter a number greater than 0");
		double initialGuess = n / 2;
		double answer;
		do {
			answer = initialGuess - ((initialGuess * initialGuess) - n) / (2 * initialGuess);
			initialGuess = answer;
		} while (absValue(answer * answer - n) >= 0.05);
		return round2(answer);
	 }
	 //finds the roots of quadratic using the quadratic formula
	 public static String quadForm(int a, int b, int c) {
		if (discriminant(a, b, c) > 0) { //two solutions
			double solutionOne = ((-1 * b) + (sqrt(discriminant(a, b, c)))) / (2 * a);
			double solutionTwo = ((-1 * b) - (sqrt(discriminant(a, b, c)))) / (2 * a);
			return round2(myAwesomeMin(solutionOne, solutionTwo)) + " and " + round2(max(solutionTwo, solutionOne));
		} else if (discriminant(a, b, c) == 0) { //one solution
			double solutionOne = ((-1 * b) + (sqrt(discriminant(a, b, c)))) / (2 * a);
			return round2(solutionOne) + "";
		} else { // no real solutions
			return "no real roots";
		}
	 }
}
