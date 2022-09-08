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
	 
	 public static boolean isDivivsibleBy(int a, int b) {
		 boolean answer = false;
		 if (a % b == 0) {
			 answer = true;
		 }
		 return answer;
	 }
	 
	 public static double absValue(double a) {
		 double answer = a;
		 if (a < 0) {
			 answer /= -1;
		 }
		 return answer;
	 }
	 
	 public static double max(double a, double b) {
		 double answer = a;
		 if (a < b) {
			 answer = b;
		 }
		 return answer;
	 }
	 
	 public static double max(double a, double b, double c) {
		 double answer = a;
		 if (b >= a && b >= c) {
			answer = b;
		 } else if (c >= a && c >= a) {
			answer = c;
		 }
		 return answer;
	}
	 
	 public static int min(int a, int b) {
		 int answer = a;
		 if (a > b) {
			 answer = b;
		 }
		 return answer;
	 }
	 
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
	 
	 public static double exponent(double base, int power) {
		 double answer = base;
		 if (power == 0) return 1;
		 for (int i = 1; i < power; i++) {
			 answer = answer * base;
		 }
		 
		 return answer;
	 }

	 public static int factorial(int n) {
		int answer = n;
		for (int i  = n - 1; i > 0; i--) {
			answer = answer * i;
		}
		return answer;
		
	 }
	 
	 public static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if(isDivivsibleBy(n, i)) {
				return false;
			}
		}

		return true;
	 }
	 
	 public static int gcf(int a, int b) { //TODO refactor this bruh
		int factorA = 0;
		int factorB = 0;

		if (min(a, b) == a) {
			for (int i = 1; i <= a; i ++) {
				if (isDivivsibleBy(a, i) && isPrime(i)) { //store the greatest factor of a
					factorA = i;  
				}
			}

			for (int i = 1; i <= b; i++) {
				if (isDivivsibleBy(b, i) && isPrime(i)) {
					factorB = i;
				}
			}

			return factorB * factorA;

		} else { // if b is smaller

			for (int i = 1; i <= b; i ++) {
				if (isDivivsibleBy(b, i)) { //store the greatest factor of b
					factorB = i;  
				}
			}

			for (int i = 1; i <= a; i++) {
				if (isDivivsibleBy(a, i)) {
					factorA = i;
					if (factorB == factorA) {
						return factorA;
					}
					
				}
			}
		}
		return -1; //how
	 }

//TODO guess and check
	 public static double sqrt(double n) {
		double initialGuess = n / 2;
		double answer;

		answer = initialGuess - ((initialGuess * initialGuess) - n) / (2 * initialGuess);
		initialGuess = answer;

		while (absValue(answer * answer - n) >= 0.05) {
			answer = initialGuess - ((initialGuess * initialGuess) - n) / (2 * initialGuess);
			initialGuess = answer;
		}
		return round2(answer);

	 }
	 
}
