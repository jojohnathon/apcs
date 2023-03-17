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
                    int boals = i + (char)'A';
                    char newColLetter = (char) boals;
                    String newRowNum = j + 1 + "";
                    SpreadsheetLocation selectedCell = new SpreadsheetLocation(newColLetter + newRowNum);
                    // SpreadsheetLocation selectedCell = new SpreadsheetLocation(startingCell.getCol() + ((char)'A' + i) + startingCell.getRow() + i + "");
                    ans += ((RealCell) spread.getCell(selectedCell)).getDoubleValue();
                    iteratedCellCount++;
                    
                }
            }
            if (formula[0].equalsIgnoreCase("AVG")) {
                return ans / iteratedCellCount;
            } else {
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
