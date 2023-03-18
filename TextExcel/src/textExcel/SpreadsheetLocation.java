package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
    private String cellName;

    @Override
    public int getRow()
    {
        //remove the letter in front and subtract one
        return Integer.valueOf(
            cellName.substring(1)) - 1;
    }

    @Override
    public int getCol()
    {
        //look at the letter and subtract the ASCII value to convert char into int
        return cellName.charAt(0) - (char) 'A';
    }
    
    public SpreadsheetLocation(String cellName)
    {
        this.cellName = cellName.toUpperCase();
    }

}
