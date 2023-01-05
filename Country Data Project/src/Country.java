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

    public String getCountry() {
        return countryName;
    }

    public String getSeries() {
        return series;
    }

    public int[] getYears() {
        return years;
    }

    public double[] getData() {
        return data;
    }

    public void setSeries(String newSeries) {
        this.series = newSeries;
    }

    public void setData(double[] arr) {
        this.data = arr;
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
        } 
        if (trendsDown()) {
            return "trends down";
        }
        return "no trend";
    }

    private boolean trendsUp() {
        double endValue = data[data.length - 1];
        boolean trendsUp = false;
        for (int i = 0; i < data.length - 1; i++) {
            if (endValue > data[i]) {
                trendsUp = true;
            } else if (endValue < data[i]) {
                return false;
            }
        }
        return trendsUp;
    }

    private boolean trendsDown() {
        double endValue = data[0];
        boolean trendsDown = false;
        for (int i = data.length - 2; i >= 0; i--) {
            if (endValue < data[i]) {
                trendsDown = true;
            } else if (endValue > data[i]) {
                return false;
            }
        }
        return trendsDown;
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

    public String getAcronym() {
        //this method returns an acronym
        String input = series.substring(0, series.indexOf("(") - 1);
        String ans[] = input.split(" ");
        String excluded[] = {"of", "in", "the", "at", "to", "by", "per", "on", "a", "an"};
        String output = "";
        //look for excluded words
        for (int i = 0; i < excluded.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                if (ans[j].contains(excluded[i])) {
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
