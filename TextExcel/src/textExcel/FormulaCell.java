package textExcel;

public class FormulaCell extends RealCell {
    private String formula;
    public FormulaCell(String text) {
        super(text);
        formula = text;
    }

    public double getDoubleValue() {
        String[] formula = this.formula.substring(2, this.formula.length() - 2).split(" ");
        double ans = 0;
        
        for (int i = 0; i < formula.length; i++) {
            char operator = ' ';
            if (i % 2 == 0) {
                ans = Double.parseDouble(formula[i]);
            } else if (!(formula.length == 1)){
                operator = formula[i].charAt(0);
                if (operator == '+') {
                    ans += Double.parseDouble(formula[i + 1]);
                    i++;
                } else if (operator == '-') {
                    ans -= Double.parseDouble(formula[i + 1]);
                    i++;
                } else if (operator == '*') {
                    ans *= Double.parseDouble(formula[i + 1]);
                    i++;

                } else if (operator == '/') {
                    ans /= Double.parseDouble(formula[i + 1]);
                    i++;

                }
            }
            
        }
        return ans;
    }

    public String abbreviatedCellText() {
        return (getDoubleValue() + "                ").substring(0, 10);
    }

    public boolean isNum(String num) {
        //TODO take in spreadsheet object in checkpoint 5 and remove this method
		if (num.matches("-?\\d+")) {
			// -?     --> negative sign, could have none or one
			// \\d+   --> one or more digits
			return true;
		}
		return false;
	}
    
}
