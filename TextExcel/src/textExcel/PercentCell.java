package textExcel;

public class PercentCell extends RealCell {

    public PercentCell(String text) {
        super(text);
        //TODO Auto-generated constructor stub
    }

    public double getDoubleValue() {
        return Double.valueOf(super.fullCellText()) / 100.0; //return the percentage in decimal form
    }

    public String abbreviatedCellText() {
        if (super.fullCellText().indexOf(".") == -1 ) {
            return (super.fullCellText() + "%" + "             ").substring(0, 10);
        }
        return (super.fullCellText().substring(0, super.fullCellText().indexOf(".")) + "%" + "                 ").substring(0, 10);
    }

    public String fullCellText() {
        return getDoubleValue() + "";
    }
}
