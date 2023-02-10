/*
@author johnathon Zheng
@version October 7, 2022
Client code that will process the file and print results
*/
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class CountryDataClient {

	public static void main(String[] args) throws FileNotFoundException {
		
		File inputFile = new File("Country Data Project\\src\\CountryDataSet - Sheet1.csv");
		Scanner sc = new Scanner(inputFile);
		sc.useDelimiter("[,\"\r\n]+");
		//get the series
		// String series = sc.nextLine();
		// String[] seriesArr = series.split(",");
		String series = sc.next();
		//get and format the years
		// String yearsRaw = sc.nextLine();
		// String[] yearsArr = yearsRaw.split(",");
		// int numYears = yearsArr.length - 1;
		//put the years into an array
		// int[] years = new int[numYears];
		// for (int i = 0; i < years.length; i++) {
		// 	years[i] += Integer.parseInt(yearsArr[i + 1]); 
		// }
		sc.nextLine();  //move the scanner over
		sc.next();
		ArrayList<Integer> years = new ArrayList<>();
		while(sc.hasNextInt()) {
			years.add(sc.nextInt());
		}
		//print title
		System.out.println("GDP for " + years.get(0) + "-" + years.get(years.size() - 1));

		
		ArrayList<Country> countryList = new ArrayList<>(); 
		//print out all the data
		while(sc.hasNextLine()) { 
			String countryName = sc.next(); //stores country name
			ArrayList<Double> data = new ArrayList<>();
			// sc.useDelimiter("[0-9]+.[0-9]+");
			while(sc.hasNextDouble()) {
				data.add(sc.nextDouble());
			}
			// String dataRaw = sc.nextLine();
			// String[] dataArr = dataRaw.split(",");
			// double[] data = new double[numYears];
			// for (int j = 0; j < dataArr.length - 1; j++) {
			// 	data.add(Double.parseDouble(dataArr[j + 1]));
			// }
			// System.out.println(summarizeCountry(dataArr[0], series, years, data) + "\n");
			
			Country Country = new Country(countryName, series, years, data);
			countryList.add(Country);
			System.out.println(Country.toString());
			
			// System.out.println("Trend: " + country.getTrend());
			
			// Country testCountry = new Country("test", "Mobile cellular subscriptions (per 100 people)", years, data);
			// System.out.println(testCountry.getAcronym());
		}

		sc.close();

		
	}
	//removes the country based on the name
	public static void removeByName(ArrayList<Country> countries, String name) {
		for (int i = 0; i < countries.size(); i++) {
			if (countries.get(i).getCountry().equals(name)) {
				countries.remove(i);
				i--;
			}
		}
	}
	//remove countries with the trend tyupe of 'no trend'
	public static void removeNoTrend(ArrayList<Country> countries) {
		for (int i = 0; i < countries.size(); i++) {
			if (countries.get(i).getTrend().equals("no trend")) {
				countries.remove(i);
				i--;
			}
		}
	}
	//removes countries based on trendtype
	public static ArrayList<String> getListBasedOnTrend(ArrayList<Country> countries, String trendType) {
		if (!(trendType.equals("up") || trendType.equals("down") || trendType.equals("no trend"))) throw new IllegalArgumentException("Invalid trendType");
		ArrayList<String> ans = new ArrayList<>();
		for (int i = 0; i < countries.size(); i++) {
			if (countries.get(i).getTrend().equals(trendType)) {
				ans.add(countries.get(i).getCountry());
			}
		}
		return ans;
	}
	

}
