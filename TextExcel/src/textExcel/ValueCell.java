package textExcel;

public class ValueCell extends RealCell {

    public ValueCell(String text) {
        super(text);
    }

    @Override
    public String abbreviatedCellText() {
            return (Double.valueOf(super.fullCellText()) + "           ").substring(0, 10);
    }


}
