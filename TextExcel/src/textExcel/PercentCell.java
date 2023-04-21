package textExcel;

public class PercentCell extends RealCell {

    public PercentCell(String text) {
        super(text);
    }

    public double getDoubleValue() {
        return Double.valueOf(super.fullCellText()) / 100.0; //return the percentage in decimal form
    }

    public String abbreviatedCellText() {
        if (super.fullCellText().indexOf(".") == -1 ) { //check for decimal point and then add % sign
            return (super.fullCellText() + "%" + "             ").substring(0, 10);
        }
        //truncate decimals and then add % sign
        return (super.fullCellText().substring(0, super.fullCellText().indexOf(".")) + "%" + "                 ").substring(0, 10);
    }

    public String fullCellText() {
        return getDoubleValue() + "";
    }
}
