/*
@author johnathon Zheng
@version October 7, 2022
Client code that will process the file and print results
*/
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class CountryDataClient {

	public static void main(String[] args) throws FileNotFoundException {
		
		File inputFile = new File("Country Data Project\\src\\CountryDataSet - Sheet1.csv");
		Scanner sc = new Scanner(inputFile);
		//get and put the series into an array
		String series = sc.nextLine();
		String[] seriesArr = series.split(",");
		series = seriesArr[0];
		//get and format the years
		String yearsRaw = sc.nextLine();
		String[] yearsArr = yearsRaw.split(",");
		int numYears = yearsArr.length - 1;
		//put the years into an array
		int[] years = new int[numYears];
		for (int i = 0; i < years.length; i++) {
			years[i] += Integer.parseInt(yearsArr[i + 1]); 
		}
		//print title
		System.out.println("GDP for " + years[0] + "-" + years[years.length - 1]);

		//print out all the data
		while(sc.hasNextLine()) { 
			String dataRaw = sc.nextLine();
			String[] dataArr = dataRaw.split(",");
			double[] data = new double[numYears];
			for (int j = 0; j < dataArr.length - 1; j++) {
				data[j] = Double.parseDouble(dataArr[j + 1]);
			}

			// System.out.println(summarizeCountry(dataArr[0], series, years, data) + "\n");

			Country country = new Country(dataArr[0], series, years, data);
			System.out.println(country.toString() + "\n");
			System.out.println("Trend: " + country.getTrend());

			Country testCountry = new Country("test", "Access to electricity (% of population)", years, data);
			System.out.println(testCountry.getAcronym());
		}

		sc.close();

		
	}
	

}
