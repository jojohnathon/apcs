package textExcel;

import java.text.NumberFormat;

public class FormulaCell extends RealCell {
    private String formula;
    private Spreadsheet spread;
    public FormulaCell(String text, Spreadsheet spread) {
        super(text);
        formula = text;
        this.spread = spread;
    }

    public double getDoubleValue() {
        String[] formula = this.formula.substring(2, this.formula.length() - 2).split(" ");
        double ans = 0;
        
        if (formula[0].equalsIgnoreCase("SUM") || formula[0].equalsIgnoreCase("AVG")) {
            String[] cellSelection = formula[1].split("-");
            SpreadsheetLocation startingCell = new SpreadsheetLocation(cellSelection[0]);
            SpreadsheetLocation lastCell = new SpreadsheetLocation(cellSelection[1]);
            int iteratedCellCount = 0; 

            for (int i = startingCell.getCol(); i <= lastCell.getCol(); i++) {
                for (int j = startingCell.getRow(); j <= lastCell.getRow(); j++) {
                    //something malicious is brewing
                    // char newColLetter = (char) (i + (char)'A');
                    // String newRowNum = j + 1 + "";
                        ans += ((RealCell) spread.getCell(new SpreadsheetLocation(((char) (i + (char)'A')) + (j + 1 + "")))).getDoubleValue();
                        iteratedCellCount++;
                }
            }
            if (formula[0].equalsIgnoreCase("AVG")) {
                return ans / iteratedCellCount;
            } else if (formula[0].equalsIgnoreCase("SUM")){
                return ans;
            } 
        } 

        for (int i = 0; i < formula.length; i++) {
            char operator = ' ';
            if (i % 2 == 0) {
                ans = fortnite(i, formula);
            } else if (!(formula.length == 1)){
                operator = formula[i].charAt(0);
                if (operator == '+') {
                    ans += fortnite(i + 1, formula);
                    i++;
                } else if (operator == '-') {
                    ans -= fortnite(i + 1, formula);
                    i++;
                } else if (operator == '*') {
                    ans *= fortnite(i + 1, formula);
                    i++;
                } else if (operator == '/') {
                    ans /= fortnite(i + 1, formula);
                    i++;

                }
            }
        }
        return ans;
    }

    public String abbreviatedCellText() {
        return (getDoubleValue() + "                ").substring(0, 10);
    }

    public Double fortnite(int i, String[] formula) {
        try {
            return Double.parseDouble(formula[i]);
        } catch (NumberFormatException e) { //must be cell ref
            SpreadsheetLocation cellReference = new SpreadsheetLocation(formula[i]);
            return ((RealCell) spread.getCell(cellReference)).getDoubleValue();
        }
    }
    
}
