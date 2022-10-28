import java.util.Arrays;

public class ArraysLab {

	public static void main(String[] args) {
		int appendNum = 200;
		int removeIdx = 5;
		
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = sum(a1, a2);
		int[] appendArr = append(a1, appendNum);
		int[] removeArr = remove(a2, removeIdx);
		
		int sumOfFEvens = sumEven(appendArr);
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr)); 
		System.out.println(sumOfFEvens);
		rotateRight(a1);
		System.out.println(Arrays.toString(a1));
	}
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] answer = new int[arr1.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = arr1[i] + arr2[i];
		}
		return answer;
	}

	public static int[] append(int[] arr, int num) {
		int[] answer = new int[arr.length + 1];
		for (int i = 0; i < (arr.length); i++) {
			answer[i] = arr[i];
		}
		answer[arr.length] = num;
		return answer;
	}

	public static int[] remove(int[] arr, int idx) { 
		int[] answer = new int[arr.length - 1];
		for (int i = 0; i < (arr.length - 1); i++) {
			if (i < idx) {
				answer[i] = arr[i];
			} else if ( i >= idx) {
				answer[i] = arr[i + 1];
			} 
		}
		return answer;
	}

	public static int sumEven(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				sum += arr[i];
			}
		}
		return sum;
	}

	public static void rotateRight(int[] arr) {
		int last = arr[arr.length - 1];
		for (int i = (arr.length - 1); i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = last;
	}
}
