import java.util.ArrayList;

/*
 * Print a message to the console
 * @author Johnathon Zheng
 * @version Start date: August 18, 2022
 */
public class HelloWorld {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		mystery2(list);

		

	}

	public static void mystery2(ArrayList<Integer> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			if (i % 2 == 0) {
				list.add(list.get(i));
			} else {
				list.add(0, list.get(i));
			}
		}
		System.out.println(list);
	}

	

}
