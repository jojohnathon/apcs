package textExcel;

public class TextCell implements Cell {
    private String text;

    @Override
    public String abbreviatedCellText() {
        String poop = text + "                               ";
        return poop.substring(0, 10);
    }

    @Override
    public String fullCellText() {
        return "\"" + text + "\"";
    }

    public TextCell(String text) {
        this.text = text;
    }
    
}
