package test;
/*
 * Prints hello world
 * @Author: Johnathon Zheng
 * @Date: 8/19/22
 */

import java.util.Arrays;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello world");
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};

		System.out.println("num: " + num);
		System.out.println("strMain: " + strMain);
		System.out.println("arrMain: " + Arrays.toString(arrMain));

		changeMe(num, strMain, arrMain);

		System.out.println("num: " + num);
		System.out.println("strMain: " + strMain);
		System.out.println("arrMain: " + Arrays.toString(arrMain));

		int[] arr = {0, 1, 2, 3};
		int[] two = arr;
		arr[3] = 90;
		System.out.println(Arrays.toString(arr));

	}

	public static void changeMe(int x, String str, int[] arr) {
		x = 2;
		str = "asdf";
		arr[0] = 234; 
	}
}
