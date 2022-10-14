import java.util.Scanner;

/*
@author johnathon zheng
@version october 14, 2022
generates an hourglass
*/
public class Hourglass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How long is your hourglass");
        int length = sc.nextInt();
        sc.close();

        base(length);
        System.out.println();

        int spaceCount = 1;
        for (int i = (length - 2); i > 0; i-=2) {
            space(spaceCount);
            bodyGen(i, true);
            System.out.println();
            spaceCount++;
        }

        space(length/2);
        System.out.println("||");

        spaceCount = (length / 2) - 1;
        for (int i = 2; i <= (length - 2); i+=2) {
            space(spaceCount);
            bodyGen(i, false);
            System.out.println();
            spaceCount--;
        }

        base(length);
    }

    public static void bodyGen(int num, boolean flipped) {
        //String str;
        if (flipped) {
            
            System.out.print("\\");
            for (int i = 0; i < num; i++) {
                System.out.print("*");
            }
            System.out.print("/");
        } else {
            System.out.print("/");
            for (int i = 0; i < num; i++) {
                System.out.print("*");
            }
            System.out.print("\\");
        }
    }

    public static void base(int length) {
        System.out.print("|");
        for (int i = 0; i < length; i++) {
            System.out.print("\"");
        }
        System.out.print("|");
    }

    public static void space(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(" ");
        }
    }

}
