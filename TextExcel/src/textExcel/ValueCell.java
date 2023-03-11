package textExcel;

public class ValueCell extends RealCell {

    public ValueCell(String text) {
        super(text);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String abbreviatedCellText() {
            return (Double.valueOf(super.fullCellText()) + "           ").substring(0, 10);
    }


}
