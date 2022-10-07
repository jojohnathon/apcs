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
		File inputFile = new File("Country Data Project\\src\\singleCountryData.txt");
		Scanner sc = new Scanner(inputFile);
		
		String series = sc.nextLine();
		System.out.println(series);

		int numYears = sc.nextInt();
		for(int i = 0; i < numYears; i++) {
			int year = sc.nextInt();
			System.out.print(year + "	");
		}
		
		String country = sc.next();
		System.out.println();
		for (int i = 0; i < numYears; i++) {
			double data = sc.nextDouble();
			System.out.print(data + "	");
		}

		System.out.println("\nThis is the " + series + " for " + country);
		sc.close();
	}

}
