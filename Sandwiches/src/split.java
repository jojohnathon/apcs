import java.util.Arrays;

import javax.swing.plaf.synth.SynthSeparatorUI;

/*
 * @author Johnathon Zheng
 * @version november 2, 2022
 * practice using arrays and the string method split() to process strings
 */

public class split {

 

 public static void main(String[] args) {

// Your task Part 0

//String.split();

//It's a method that acts on a string, <StringName>.split(<sp>);

//Where sp is the string where the string splits

//And it returns an array

// Example: "I like apples!".split(" ");

// it will split at spaces and return an array of ["I","like","apples!"]
String[] ex1 = "I like apples!".split(" ");
System.out.println(Arrays.toString(ex1));
// Example 2: "I really like really red apples!".split("really")

// it will split at the word "really" and return an array of ["I "," like ","red apples!"]

//play around with String.split!

//What happens if you "I reallyreally likeapples".split("really") ?
String[] ex2 = "I reallyreally likeapples".split("really");
System.out.println(Arrays.toString(ex2));
//Your task Part 1:

/*Write a method that take in a string like


* describing a sandwich.

* Use String.split to split up the sandwich by the word "bread" and return what's in the middle of

* the sandwich and ignores what's on the outside

* What if it's a fancy sandwich with multiple pieces of bread?

*/
String[] sandwich = "applespineapplesbreadlettucetomatobaconmayohambreadcheese".split("bread");
String[] asdf = "apples pineapples bread lettuce tomato bread bacon mayo ham bread cheese water".split(" ");
String[] test = "applespineapplesbreadlettucetomatobaconmayohambreadcheesewater".split("bread");


System.out.println(Arrays.toString(sandwich));
System.out.println(Arrays.toString(asdf));
System.out.println(Arrays.toString(test));

System.out.println(partOne("breadhambreadmayobaconbreadavacadobread"));
System.out.println(partOne("applespineapplesbreadlettucetomatobaconmayohambreadcheesewater"));
System.out.println(partTwo("apples pineapples bread lettuce tomato bacon mayo ham bread cheese water"));

}

public static String partOne(String str) {
    String[] sandwich = str.split("bread");
    String ans = "";
    for (int i = 1; i < sandwich.length; i++) {
        ans += sandwich[i];
    }
    return ans;
}

//Your task pt 2:

/*Write a method that take in a string like

* "apples pineapples bread lettuce tomato bacon mayo ham bread cheese"

* describing a sandwich

* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of

* the sandwich and ignores what's on the outside.

*The output for the example above should be lettucetomatobaconmayoham

* You should call the method from part one in order to increase your reuse of code and reduce

*the complexity of part 2.

*/

public static String partTwo(String str) {
    String ans = "";
    String[] arr = str.split(" ");
    for(int i = 1; i < arr.length; i++) {
        ans += arr[i];
    }
    
    return partOne(ans); //returns stuff inside canvas
}

}



 