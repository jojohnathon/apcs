import java.util.zip.CheckedInputStream;

public class Country {
    String countryName = "";
    String series = "";
    int[] years = new int[5];
    double[] data = new double[5];


    public Country(String countryName, String series, int[] years, double[] data) {
        //constructor
        this.countryName = countryName;
        this.series = series;
        this.years = years;
        this.data = data;
    }

    public String getUnits() {
        int start = series.indexOf("(");
        int end = series.indexOf(")");
        String ans = series.substring(start + 1, end);
        return ans;
    }

    public String getTrend() {
        if (trendsUp()) {
            return "trends up";
        } else if (trendsDown()) {
            return "trends down";
        }
        return "no trend";
    }

    private boolean trendsUp() {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] < data[i + 1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean trendsDown() {
        for (int i = 1; i < data.length; i++) {
            if (data[i] > data[i - 1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public String getAcronym() {
        //this method returns an acronym
        String input = series.substring(0, series.indexOf("(") - 1);
        String ans[] = input.split(" ");
        String excluded[] = {"of", "in", "the", "at", "to", "by", "per", "on", "a", "an"};
        String output = "";
        //look for excluded words
        //assemble string
        for (int i = 0; i < ans.length; i++) {
            String test = ans[i];
            for (int j = 0; i < excluded.length; i++) {
                if (test.equals(excluded[i])) {
                    break;
                } else {
                    output += test;
                    break;
                }
            }
        }
        
        return output.toUpperCase();
    }

    public double max (double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return Math.round(max * 100.0) / 100.0;
    }

    public double min (double[] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return Math.round(min * 100.0) / 100.0;
    }

    public String toString() {
        String ans = "";
		for (int i = 0; i < years.length; i++) {
			ans += years[i] + "		";
		}
		ans += "\n";
		for (int i = 0; i < data.length; i++) {
			double valueRounded = Math.round(data[i] * 100.0) / 100.0; 
			ans += valueRounded + "		"; 
		}
		ans += "\nThis is the \"" + series + "\" for " + countryName + "\nMinimum: " + min(data) + "\nMaximum: " + max(data);

		return ans;	
    }
    
}
