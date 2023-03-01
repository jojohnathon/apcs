package textExcel;

public class TextCell implements Cell {
    String text;

    @Override
    public String abbreviatedCellText() {
        //pad the text with extra spaces if needed
        if (text.length() > 10) {
            for (int i = 0; i < (10 - text.length()); i++) {
                text += " ";
            }
        }
        return text.substring(0, 11);
    }

    @Override
    public String fullCellText() {
        return "\"" + text + "\"";
    }

    public TextCell(String text) {
        this.text = text;
    }
    
}
