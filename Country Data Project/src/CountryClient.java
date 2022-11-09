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
		
		File inputFile = new File("Country Data Project\\src\\CountryDataSet - Sheet1.csv");
		Scanner sc = new Scanner(inputFile);
		
		String series = sc.nextLine();
		String[] seriesArr = series.split(",");
		series = seriesArr[0];
	
		String yearsRaw = sc.nextLine();
		String[] yearsArr = yearsRaw.split(",");
		int numYears = yearsArr.length - 1;
		
		int[] years = new int[numYears];
		for (int i = 0; i < years.length; i++) {
			years[i] += Integer.parseInt(yearsArr[i + 1]); 
		}

		// String dataRaw = sc.nextLine();
		// String[] dataArr = dataRaw.split(",");
		// double[] data = new double[numYears];
		// for (int i = 0; i < dataArr.length - 1; i++) {
		// 	data[i] = Double.parseDouble(dataArr[i + 1]);
		// }


		while (true) {
			

			


			for(int i = 0; i < numYears; i++) {
				String dataRaw = sc.nextLine();
				String[] dataArr = dataRaw.split(",");
				double[] data = new double[numYears];
				for (int j = 0; j < dataArr.length - 1; j++) {
					data[j] = Double.parseDouble(dataArr[j + 1]);
				}

				System.out.println(summarizeCountry(dataArr[0], series, years, data) + "\n");
			}

			if (sc.hasNextLine()) {
				break;
			 }
		}
		sc.close();
	}

	public static String summarizeCountry (String name, String series, int[] years, double[] values) {
		String ans = "";
		for (int i = 0; i < years.length; i++) {
			ans += years[i] + "		";
		}
		ans += "\n";
		for (int i = 0; i < values.length; i++) {
			double valueRounded = Math.round(values[i] * 100.0) / 100.0; 
			ans += valueRounded + "		"; 
		}
		ans += "\nThis is the \"" + series + "\" for " + name + "\nMinimum: " + min(values) + "\nMaximum: " + max(values);

		return ans;			
	}

	public static double max (double[] arr) {
		double max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return Math.round(max * 100.0) / 100.0;
	}

	public static double min (double[] arr) {
		double min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return Math.round(min * 100.0) / 100.0;
	}

}
