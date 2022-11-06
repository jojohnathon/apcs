import java.util.Arrays;


/*
 * @author Johnathon Zheng
 * @version november 2, 2022
 * practice using arrays and the string method split() to process strings
 */

public class split {

 

 public static void main(String[] args) {
        System.out.println(partOne("applespinapplesbreadmayohambreadcheese"));
		System.out.println(partOne("breadmayobread"));
		System.out.println(partOne("applesbreadmayobread"));
		System.out.println(partOne("breadhambreadcheese"));
		System.out.println(partOne("breadbread"));
		System.out.println(partOne("breadcheese"));
		System.out.println(partOne("hamcheesebread"));
		System.out.println(partOne("cheese"));
		System.out.println(partOne("breadcheesebreadhambread"));
		System.out.println(partOne("hambreadmayobaconbreadavocadobread"));
		
		System.out.println();
		
		System.out.println(partTwo("apples bread mayo bread"));
		System.out.println(partTwo("bread ham bread cheese"));
		System.out.println(partTwo("bread bread"));
		System.out.println(partTwo("bread cheese"));
		System.out.println(partTwo("ham bread mayo bacon bread avocado bread"));
 }
public static String partOne(String str) {
    String ans = "";
    
    int topBread = str.indexOf("bread");
    int bottomBread = str.lastIndexOf("bread");
    
    if (topBread == -1 || bottomBread == -1 || topBread == bottomBread) {
        return "not a sandwich!";
    }
    str = str.substring(topBread + 5, bottomBread);
    String[] sandwich = str.split("bread");

    for (int i = 0; i < sandwich.length; i++) {
        ans += sandwich[i];
    }
    if (ans.equals("")) {
        return "not a sandwich!";
    }
    return ans;
}

public static String partTwo(String str) {
    String[] arr = str.split(" ");
    String ans = "";
    for (int i = 0; i < arr.length; i++) {
        ans += arr[i];
    }
    return partOne(ans);

}


}



 