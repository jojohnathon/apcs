package textExcel;

import javax.swing.event.CellEditorListener;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] spreadsheet;

	@Override
	public String processCommand(String input)
	{
		String[] commandArr = input.split(" ", 2);
		SpreadsheetLocation command = new SpreadsheetLocation(commandArr[0]); //devious
		String operator = "";
		
		if (commandArr.length >= 2) {
			if (commandArr[1].contains("=")) {
				operator = commandArr[1];
			} else {
				operator = commandArr[1]; //setup clear command for a  specific cell 
			}
		}

		if (command.getCellName().equalsIgnoreCase("clear") && commandArr.length < 2) { //clear entire spreadsheet
			for (int i = 0; i < spreadsheet.length; i ++) {
				for (int j = 0; j < spreadsheet[i].length; j++) {
					spreadsheet[i][j] = new EmptyCell(); 
				}
			}
			return getGridText();

		} else if (command.getCellName().equalsIgnoreCase("clear") && commandArr.length == 2) { //clear specific cell
			SpreadsheetLocation clearCell = new SpreadsheetLocation(operator);
			spreadsheet[clearCell.getRow()][clearCell.getCol()] = new EmptyCell();
			return getGridText();
		} else if (operator.contains("=")) { //cell assignment
			int index = 0;
			for (int i = 0; i < operator.length(); i++) {
				if (operator.charAt(i) == '\"') {
					index = i + 1;
					break;
				}
			}
			spreadsheet[command.getRow()][command.getCol()] = new TextCell(operator.substring(index, operator.length() - 1)); 
			return getGridText(); 
		} else if (commandArr[0].length() > 0){ //cell inspection
			return getCell(command).fullCellText();
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
		String gridText = "   |A         |B         |C         |D         |E         |F         |G         |H         |I         |J         |K         |L         |\n";
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

}
