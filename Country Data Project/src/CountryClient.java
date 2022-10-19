/*
@author johnathon Zheng
@version October 7, 2022
Client code that will process the file and print results
*/
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class CountryClient {

	public static void main(String[] args) throws FileNotFoundException {
		
		File inputFile = new File("Country Data Project\\src\\multipleCountry2.txt");
		Scanner sc = new Scanner(inputFile);
		
		String series = sc.nextLine();
		int numYears = sc.nextInt();
		// System.out.println(series);
		//TODO String input; 
		// Integer.parseInt(string) 


		while (true) {
			String country = sc.nextLine();
			country = sc.nextLine();
			if (country.equals("END")) {
				break;
			 }

			for(int i = 0; i < numYears; i++) {
				String year = sc.next();
				System.out.print(year + "	");
			}
			double max = 0;
			double min = 0;
			System.out.println();
			for (int i = 0; i < numYears; i++) {
				double data = Math.round(sc.nextDouble() * 100.0) / 100.0;
				System.out.print(data + "	");
				if (i == 0) {
					max = data;
					min = data;
				}
				if (data > max) {
					max = data;
				} else if (data < min) {
					min = data;
				}
			}
			
			System.out.println("\nThis is the \"" + series + "\" for " + country);
			
			//TODO min max
			System.out.println("Minimum: " + min);
			System.out.println("Maximum: " + max);
			System.out.println();
			

		}
		
		sc.close();
	}

}
