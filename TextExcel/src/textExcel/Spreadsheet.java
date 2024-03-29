package textExcel;
// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] spreadsheet;

	@Override
	public String processCommand(String input) 
	{
		String[] commandArr = input.split(" ", 2);
		SpreadsheetLocation command = new SpreadsheetLocation(commandArr[0]); 
		String operator = "";
		
		if (commandArr.length >= 2) {
			if (commandArr[1].contains("=")) {
				operator = commandArr[1];
			} else {
				operator = commandArr[1]; //setup clear command for a  specific cell 
			}
		}

		if (commandArr[0].equalsIgnoreCase("clear") && commandArr.length < 2) { //clear entire spreadsheet
			for (int i = 0; i < spreadsheet.length; i ++) {
				for (int j = 0; j < spreadsheet[i].length; j++) {
					spreadsheet[i][j] = new EmptyCell(); 
				}
			}
			return getGridText();

		} else if (commandArr[0].equalsIgnoreCase("clear") && commandArr.length == 2) { //clear specific cell
			SpreadsheetLocation clearCell = new SpreadsheetLocation(operator);
			spreadsheet[clearCell.getRow()][clearCell.getCol()] = new EmptyCell();
			return getGridText();
		} else if (operator.contains("=")) { //cell assignment
			int index = operator.indexOf("\"") + 1;

			int rowNum = command.getRow();
			int colNum = command.getCol();
			try {
				if (index == 3) { 
					//create text cell
					spreadsheet[rowNum][colNum] = new TextCell(operator.substring(index, operator.length() - 1)); 
				} else if (operator.contains("%")){ 
					//create percent cell
					spreadsheet[rowNum][colNum] = new PercentCell(operator.substring(2, operator.length() - 1));
				} else if (!operator.contains("(") || isNum(operator.substring(2))) { 
					//create value cell
					spreadsheet[rowNum][colNum] = new ValueCell(operator.substring(2));
				} else {
					//create formula cell
					spreadsheet[rowNum][colNum] = new FormulaCell(operator.substring(2), this);
				}
				return getGridText(); 
			} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
				return "ERROR: invalid cell assignment";
			}

		} else if (commandArr[0].length() > 0){ 
			//cell inspection
			try {
				return getCell(command).fullCellText();
			} catch (NumberFormatException nfe) {
				return "ERROR: invalid command";
			}
		}
		return "";
	}

	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return spreadsheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		//generate column header letters
		String gridText = "   |";
		for (char c = 'A'; c <= 'L'; c++) {
			gridText += c + "         |";
		}
		//create individual rows
		gridText += "\n";
		for (int i = 0; i < getRows(); i++) {
			if (i <= 8) {
				gridText += i + 1 + "  |";
			} else {
				gridText += i + 1 + " |";
			}
			for (int j = 0; j < getCols(); j++) {
				gridText += spreadsheet[i][j].abbreviatedCellText();
				gridText +=   "|";
				
				}
				gridText += "\n";
			}
			return gridText;
		}

	public Spreadsheet() {
		this.spreadsheet = new Cell[20][12];
		for (int i = 0; i < spreadsheet.length; i ++) {
			for (int j = 0; j < spreadsheet[i].length; j++) {
				spreadsheet[i][j] = new EmptyCell(); 
			}
		}

	}

	public boolean isNum(String num) {
		if (num.matches("-?\\d+")) {
			// -?     --> negative sign, could have none or one
			// \\d+   --> one or more digits
			return true;
		}
		return false;
	}

}
