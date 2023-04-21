package textExcel;

public class RealCell implements Cell{
    private String text; 
    @Override
    public String abbreviatedCellText() {
        String temp = text + "                        ";
        return temp.substring(0, 10);

    }

    @Override
    public String fullCellText() {
        return text;
    }
    
    public double getDoubleValue() {
        return Double.valueOf(text);
    }

    public RealCell(String text) {
        this.text = text;
    }
    
}
