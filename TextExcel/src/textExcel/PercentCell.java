package textExcel;

public class PercentCell extends RealCell {

    public PercentCell(String text) {
        super(text);
        //TODO Auto-generated constructor stub
    }

    public double getDoubleValue() {
        return Double.valueOf(fullCellText()) * 100; //return the percentage in decimal form
    }

    public String abbreviatedCellText() {
        String poop = fullCellText() + "%" + "                 ";
        return poop.substring(0, 10);
    }
}
