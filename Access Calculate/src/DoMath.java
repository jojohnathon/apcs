/*
 * @author Johnathon Zheng
 * @version August 26, 2022
 * Client code that will test the math library and test the methods in the calculate class
 */
public class DoMath {

	public static void main(String[] args) {
		//test square
		System.out.println("Square Function:");
		System.out.println(Calculate.square(4));
		System.out.println(Calculate.square(-3));
		//test cube
		System.out.println("Cube Function:");
		System.out.println(Calculate.cube(-3));
		System.out.println(Calculate.cube(2));
		//test average
		System.out.println("Average function:");
		System.out.println(Calculate.average(2, 3));
		System.out.println(Calculate.average(-2, 0));
		//test average
		System.out.println("Average function:");
		System.out.println(Calculate.average(2, 3, 4));
		System.out.println(Calculate.average(-2, -1, 5));
		//test toDegrees
		System.out.println("toDegrees:");
		System.out.println(Calculate.toDegrees(0));
		System.out.println(Calculate.toDegrees(2 * 3.14159));
		//test to Radians
		System.out.println("toRadians:");
		System.out.println(Calculate.toRadians(0));
		System.out.println(Calculate.toRadians(360));
		//test discriminant
		System.out.println("discriminant:");
		System.out.println(Calculate.discriminant(2, -2 , 5));
		System.out.println(Calculate.discriminant(0, 1.5, -2));
		//test toImproperFrac
		System.out.println("toImproperFrac:");
		System.out.println(Calculate.toImproperFrac(3, 1, 2)); 
		System.out.println(Calculate.toImproperFrac(-2, 0, 1)); 
		//test toMixedNum
		System.out.println("toMixedNum:");
		System.out.println(Calculate.toMixedNum(7, 2));
		System.out.println(Calculate.toMixedNum(10, 5));
		//test foil
		System.out.println("foil:");
		System.out.println(Calculate.foil(2, 3, 6, -7, "n"));
		System.out.println(Calculate.foil(1, 1, 1, -1, "x"));
		//divisble by
		System.out.println("isDivisibleBy: ");
		System.out.println(Calculate.isDivivsibleBy(-2, 2));
		System.out.println(Calculate.isDivivsibleBy(1, 3));
		System.out.println(Calculate.isDivivsibleBy(0, 100));
		//abs value
		System.out.println("absolute value:");
		System.out.println(Calculate.absValue(-20));
		System.out.println(Calculate.absValue(100.1));
		//max
		System.out.println("max:");
		System.out.println(Calculate.max(2.5, 3));
		System.out.println(Calculate.max(-3, 100.5));
		//max overload
		System.out.println(Calculate.max(-3, -20, 1));
		System.out.println(Calculate.max(50.25, -20.1, 30));
		System.out.println(Calculate.max(-2, -69, 54));
		//min
		System.out.println("min:");
		System.out.println(Calculate.min(2, 7));
		System.out.println(Calculate.min(-10, 0));
		//round2
		System.out.println("round2");
		System.out.println(Calculate.round2(3.14159));
		System.out.println(Calculate.round2(-2.718));
		//exponent
		System.out.println("exponent ");
		System.out.println(Calculate.exponent(-5.5, 2));
		System.out.println(Calculate.exponent(1.2, 10));
		//factorial
		System.out.println("factorial ");
		System.out.println(Calculate.factorial(5));
		System.out.println(Calculate.factorial(10));
		//isPrime
		System.out.println("IsPrime: ");
		System.out.println(Calculate.isPrime(11));
		System.out.println(Calculate.isPrime(0));
		
		//sqrt
		System.out.println("Square root: ");
		System.out.println(Calculate.sqrt(4));
		System.out.println(Calculate.sqrt(612));
		System.out.println(Calculate.sqrt(10));
		System.out.println(Calculate.sqrt(1024));
		System.out.println(Calculate.sqrt(2048));
		System.out.println(Calculate.sqrt(100));


	}

}
