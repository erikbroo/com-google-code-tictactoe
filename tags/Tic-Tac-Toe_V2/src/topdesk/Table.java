package topdesk;

import java.util.ArrayList;
import java.util.Arrays;

public class Table {

	private ArrayList<SmartField> table;
	private int counter = 0;
	private SmartField lastMove;
	private final int[][] winnerStates = { { 1, 1, 1, 0, 0, 0, 0, 0, 0 },

	{ 0, 0, 0, 1, 1, 1, 0, 0, 0 },

	{ 0, 0, 0, 0, 0, 0, 1, 1, 1 },

	{ 1, 0, 0, 0, 1, 0, 0, 0, 1 },

	{ 1, 0, 0, 1, 0, 0, 1, 0, 0 },

	{ 0, 1, 0, 0, 1, 0, 0, 1, 0 },

	{ 0, 0, 1, 0, 0, 1, 0, 0, 1 },

	{ 0, 0, 1, 0, 1, 0, 1, 0, 0 } };

	public Table() {

		init();
	}

	public void init() {
		this.table = new ArrayList<SmartField>();
		for (Field field : Field.values()) {
			SmartField smartfield = new SmartField(field, FieldStatus.EMPTY);
			table.add(smartfield);

		}
		counter = 0;// Remove duplicates
		// List table = new ArrayList(new HashSet(temptable));
	}

	public boolean isGameOver() {
		boolean result = false;
		int xWin = 0;
		int oWin = 0;
		int actualStateX[] = new int[9];
		int actualStateO[] = new int[9];
		// ------------------------------------------------------------------
		for (SmartField smartfield : getTable()) {
			if (((smartfield.getFieldStatus().toString()).equals(FieldStatus.X
					.toString()))) {
				actualStateX[smartfield.getField().ordinal()] = 1;

			}
			if (((smartfield.getFieldStatus().toString()).equals(FieldStatus.O
					.toString()))) {
				actualStateO[smartfield.getField().ordinal()] = 1;

			}
		}

	
		if (getCounter() % 2 != 0) {
			// Check X
			for (int index = 0; index < winnerStates.length; index++) {
				for (int j = 0; j < 9; j++) {
					if ((winnerStates[index][j] + actualStateX[j]) == 2) {
						xWin++;
					}

				}
				if (xWin == 3) {
					result = true;
					System.out.println(" X win");
				} else {
					xWin = 0;
				}
			}

		} else if (getCounter() % 2 == 0) {
			// Check Y

			for (int index = 0; index < winnerStates.length; index++) {
				for (int j = 0; j < 9; j++) {
					if ((winnerStates[index][j] + actualStateO[j]) == 2) {
						oWin++;
					}

				}
				if (oWin == 3) {
					result = true;
					System.out.println(" O win");
				} else {
					oWin = 0;
				}
			}

		}
		if (getCounter() == 9) {
			System.out.println("Tele a tabla!");
			result = true;
		}
		return result;
	}

	public ArrayList<SmartField> getTable() {
		return table;
	}

	public void printTable() {
		int counter = 1;
		for (SmartField smf : table) {
			System.out.print(smf.getFieldStatus() + " | ");
			if ((counter % 3) == 0) {

				System.out.println();

			}// counter++;
		}
	}

	public ArrayList<SmartField> getEmptyFields() {
		ArrayList<SmartField> listOfEmptyFields = new ArrayList<SmartField>();

		for (SmartField smartField : table) {
			if (smartField.getFieldStatus().equals(FieldStatus.EMPTY)) {
				listOfEmptyFields.add(smartField);
			}

		}

		return listOfEmptyFields;
	}

	public int getCounter() {
		// for (SmartField smartField : getTable()) {
		// if (!(smartField.getFieldStatus().equals(FieldStatus.EMPTY))) {
		// counter++;
		// }
		// }
		return counter;
	}

	public SmartField getLastMove() {
		return lastMove;
	}

	public void makeMove(SmartField move) {
		for (SmartField smf : table) {
			if (smf.getField().equals(move.getField())) {
				table.set(table.indexOf(smf), move);
				counter++;
			}
		}

		lastMove = move;

	}

}
