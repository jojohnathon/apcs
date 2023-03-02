package textExcel;

public class TextCell implements Cell {
    private String text;

    @Override
    public String abbreviatedCellText() {
        //pad the text with extra spaces if needed
        if (text.length() < 10) {
            int missingSpaces = 10 - text.length();
            for (int i = 0; i < missingSpaces; i++) {
                text += " ";
            }
            return text;
        }
        return text.substring(0, 10);
    }

    @Override
    public String fullCellText() {
        return "\"" + text + "\"";
    }

    public TextCell(String text) {
        this.text = text;
    }
    
}
