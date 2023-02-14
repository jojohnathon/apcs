/*
@author johnathon Zheng
@version February 13, 2023
takes data and puts it into a Country object
*/

import java.util.ArrayList;

public class Country {
    String countryName = "";
    String series = "";
    ArrayList<Integer> years = new ArrayList<>();
    ArrayList<Double> data = new ArrayList<>();


    public Country(String countryName, String series, ArrayList<Integer> years, ArrayList<Double> data) {
        //constructor for Country object
        this.countryName = countryName;
        this.series = series;
        this.years = years;
        this.data = data;
    }
    //returns the name of the current country
    public String getCountry() {
        return countryName;
    }
    //returns the series of the country without the things in parenthesis
    public String getSeries() {
        int index = 0;
        for (int i = 0; i < series.length(); i++) {
            if (series.charAt(i) == '(') {
                index = i;
            } 
        }
        if (index == 0){
            return series;
        }
        return series.substring(0, index);
    }
    //return a list of the years in the data
    public ArrayList<Integer> getYears() {
        return years;
    }
    //return a list of data points
    public ArrayList<Double> getData() {
        return data;
    }
    //set the name of the series
    public void setSeries(String newSeries) {
        this.series = newSeries;
    }
    //replace the data list with a new data list
    public void setData(ArrayList<Double> list) {
        this.data = list;
    }
    //finds the unit of measurement in the series
    public String getUnits() {
        int start = series.indexOf("(");
        int end = series.indexOf(")");
        if (start == -1) return "";
        String ans = series.substring(start + 1, end);
        return ans;
    }
    //finds the trend type
    public String getTrend() {
        if (trendsUp()) {
            return "up";
        } 
        if (trendsDown()) {
            return "down";
        }
        return "no trend";
    }
    //checks if all the data values increase after each other
    private boolean trendsUp() {
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i) <= data.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    //checks if all the data values decrease after each other
    private boolean trendsDown() {
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i) >= data.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    //remove something from an array
    private String[] remove(String[] ans, int idx) { 
		String[] answer = new String[ans.length - 1];
		for (int i = 0; i < (ans.length - 1); i++) {
			if (i < idx) {
				answer[i] = ans[i];
			} else if ( i >= idx) {
				answer[i] = ans[i + 1];
			} 
		}
		return answer;
	}
    //turns the series name into an acronym
    public String getAcronym() {
        //this method returns an acronym
        String ans[] = getSeries().split(" ");
        String excluded[] = {"of", "in", "the", "at", "to", "by", "per", "on", "a", "an"};
        String output = "";
        //look for excluded words
        for (int i = 0; i < excluded.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                if (excluded[i].contains(ans[j])) {
                    ans = remove(ans, j); //call remove method
                }
            }
        }
        //assemble string
        for (int i = 0; i < ans.length; i++) {
            output += ans[i].charAt(0);
        }
        return output.toUpperCase();
    }
    //finds the maximum of the data
    public double max () {
        double max = data.get(0);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) > max) {
                max = data.get(i);
            }
        }
        return max;
    }
    //finds the minimum of the data
    public double min () {
        double min = data.get(0);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) < min) {
                min = data.get(i);
            }
        }
        return min;
    }
    //add a new data value to the list
    public void addDataPoint(int year, double newDatum) {
        years.add(year);
        data.add(newDatum);
    }
    //edit a certain data point
    public void editDataPoint(int year, double newDatum) {
        for (int i = 0; i < years.size(); i++) {
            if (years.get(i) == year) {
                data.set(i, newDatum);
            }
        }
    }
    //prints out data from the country
    public String toString() {
        String ans = "";
		for (int i = 0; i < years.size(); i++) {
			ans += years.get(i) + "		";
		}
		ans += "\n";
		for (int i = 0; i < data.size(); i++) {
			double valueRounded = Math.round(data.get(i) * 100.0) / 100.0; 
			ans += valueRounded + "		"; 
		}
		ans += "\nThis is the \"" + series + "\" for " + countryName + 
        "\nMinimum: " + min() +
        "\nMaximum: " + max() +
        "\nTrend: " + getTrend() + "\n";

		return ans;	
    }
    
}
