import java.util.ArrayList;

public class Country {
    String countryName = "";
    String series = "";
    ArrayList<Integer> years = new ArrayList<>();
    ArrayList<Double> data = new ArrayList<>();


    public Country(String countryName, String series, ArrayList<Integer> years, ArrayList<Double> data) {
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

    public ArrayList<Integer> getYears() {
        return years;
    }

    public ArrayList<Double> getData() {
        return data;
    }

    public void setSeries(String newSeries) {
        this.series = newSeries;
    }

    public void setData(ArrayList<Double> list) {
        this.data = list;
    }
    public String getUnits() {
        int start = series.indexOf("(");
        int end = series.indexOf(")");
        if (start == -1) return "";
        String ans = series.substring(start + 1, end);
        return ans;
    }

    public String getTrend() {
        if (trendsUp()) {
            return "up";
        } 
        if (trendsDown()) {
            return "down";
        }
        return "no trend";
    }

    private boolean trendsUp() {
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i) <= data.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

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

    public double max () {
        double max = data.get(0);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) > max) {
                max = data.get(i);
            }
        }
        return max;
    }

    public double min () {
        double min = data.get(0);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) < min) {
                min = data.get(i);
            }
        }
        return min;
    }

    public void addDataPoint(int year, double newDatum) {
        years.add(year);
        data.add(newDatum);
    }

    public void editDataPoint(int year, double newDatum) {
        for (int i = 0; i < years.size(); i++) {
            if (years.get(i) == year) {
                data.set(i, newDatum);
            }
        }
    }

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
		ans += "\nThis is the \"" + series + "\" for " + countryName + "\nMinimum: " + Math.round(min() * 100.0) / 100.0  + "\nMaximum: " + Math.round(max() * 100.0) / 100.0;

		return ans;	
    }
    
}
