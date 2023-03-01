package textExcel;

import javax.swing.event.CellEditorListener;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	Cell[][] spreadsheet;

	@Override
	public String processCommand(String input)
	{
		String[] commandArr = input.split(" ", 2);
		SpreadsheetLocation command = new SpreadsheetLocation(commandArr[0]); //devious
		String operator = "";
		String argument = "";

		if (commandArr[1].equals("=")) {
			operator = commandArr[1];
			argument = commandArr[2]; //TODO idk if the quotation marks need to be removed
		}

		//TODO use command object?
		if (command.getCellName() == "clear") { //clear entire spreadsheet
			for (int i = 0; i < spreadsheet.length; i ++) {
				for (int j = 0; j < spreadsheet[i].length; j++) {
					spreadsheet[i][j] = new EmptyCell(); 
				}
			}

		} else if (command.getCellName().equals("clear " + argument)) { //clear specific cell

		} else if (operator.equals("=")) { //cell assignment

		} else if (command){ //cell inspection

		} else {

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
		// TODO Auto-generated method stub
		String gridText = "   |A         |B         |C         |D         |E         |F         |G         |H         |I         |J         |K         |L         |   \n";
		for (int i = 1; i <= getRows(); i++) {
			gridText += i + "  |";
			for (int j = 0; j < getCols(); i++) {
				gridText += spreadsheet[i][j].abbreviatedCellText() + "|";
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
