package textExcel;

public class EmptyCell implements Cell{
    String text = "";
    // text for spreadsheet cell display, must be exactly length 10
    @Override
    public String abbreviatedCellText() {
        return text.substring(0, 11);

    }

    // text for individual cell inspection, not truncated or padded
    @Override
    public String fullCellText() {
        return text;
    }

    public EmptyCell() {
        
    }

}
