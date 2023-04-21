package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{

		// TestsALL.Helper th = new TestsALL.Helper();		//getGridText tester
        // System.out.println(th.getText());		


		//initialize textexcel
	    boolean quit = true;
		Scanner sc = new Scanner(System.in);
		Spreadsheet excel = new Spreadsheet();
		
		//main loop
		System.out.println(excel.getGridText());
		while (quit) {
			String command = sc.nextLine();
			if (command.equalsIgnoreCase("quit")) { 
				quit = false;
			}

			System.out.println(excel.processCommand(command));

		}
		sc.close();
	}
}
