package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    boolean quit = true;
		Scanner sc = new Scanner(System.in);
		Spreadsheet excel = new Spreadsheet();
		while (quit) {
			String input = sc.next();
			if (input.equalsIgnoreCase("quit")) {
				quit = false;
			}

			System.out.println(excel.processCommand(input));

		}
		sc.close();
	}
}
