/*
@author johnathon zheng
@version october 14, 2022
returns the min, max, maximum even num, and sum of all even numbers 
*/
import java.util.Scanner;

public class ProcessingNumbers {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("how many");
		int howMany = console.nextInt();
		int sum = 0;
		int max = 0;
		int min = 0;
		int num;
		System.out.println("Enter a number: ");
		int firstNum = console.nextInt();

		System.out.println("Enter a number: ");
		int secondNum = console.nextInt();
		min = min(firstNum, secondNum);
		max = max(firstNum, secondNum);
		if (min % 2 == 0){
			sum += min;
		} else if (max % 2 == 0){
			sum += max;
		}
		for (int i = 0; i < (howMany - 2); i++) {
			num = console.nextInt();
			if (num % 2 == 0) sum += num;
			if (num > max) max = num;
			if (num < min) min = num;
		}

		System.out.println(min);
		System.out.println(max);
		System.out.println(sum);
		console.close();


	}
	
	public static int min(int num1, int num2) {
		 int answer = num1;
		 if (num1 > num2) {
			 answer = num2;
		 } return answer;
	 }

	public static int max(int num1, int num2) {
		int answer = num1;
		if (num1 < num2) {
			answer = num2;
		} return answer;
	}

}
