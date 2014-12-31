package topdesk;


import java.util.ArrayList;
import java.util.Arrays;

public class Table {

	private ArrayList<SmartField> table;
	int counter = 0;
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

		}counter=0;// Remove duplicates
			// List table = new ArrayList(new HashSet(temptable));
	}

	public boolean isGameOver() {
		boolean result = false;
		int actualStateX[] = new int[9];
		int actualStateY[] = new int[9];
		//------------------------------------------------------------------ 
		for(SmartField smartfield: getTable()){
			if (((smartfield.getFieldStatus().toString()).equals(FieldStatus.X.toString()))) {
				actualStateX[smartfield.getField().ordinal()] = 1;

			}
			if (((smartfield.getFieldStatus().toString()).equals(FieldStatus.O.toString()))) {
				actualStateY[smartfield.getField().ordinal()] = 1;

			}
		}
		
		
		System.out.println("ActualX: ");
		for(int tempindex=0; tempindex < actualStateX.length;tempindex++){
			
			System.out.print(actualStateX[tempindex]);
		}
		System.out.println("--------------------------------");
		System.out.println("ActualY: ");
		for(int tempindex=0; tempindex < actualStateY.length;tempindex++){
			
			System.out.print(actualStateY[tempindex]);
		}
		
		/*Az értékelést maskolással kell csinálni, mert nincs benne a vizsgalatban az a lehetoseg
		 * amikor valamilyen nyero allas mellett egy masik helyen is van a nyero typushoz tartozo 
		 * mezõ. 
		 * Tesztelés: Done 
		 * Solution: A meglevõ megoldás helyett logikai és muvelettel kell maszkolni az aktuális 
		 * tábla állást.   
		 */
				
		if (getCounter() % 2 != 0) {
			// Check X
			
			for (int index = 0; index < winnerStates.length; index++) {
				if ((winnerStates[index][0] == actualStateX[0])
						&& (winnerStates[index][1] == actualStateX[1])
						&& (winnerStates[index][2] == actualStateX[2])
						&& (winnerStates[index][3] == actualStateX[3])
						&& (winnerStates[index][4] == actualStateX[4])
						&& (winnerStates[index][5] == actualStateX[5])
						&& (winnerStates[index][6] == actualStateX[6])
						&& (winnerStates[index][7] == actualStateX[7])
						&& (winnerStates[index][8] == actualStateX[8])) {
					result = true;
					System.out.println(" X win");
				}
			}
		} else if (getCounter() % 2 == 0) {
			// Check Y
			
			for (int index = 0; index < winnerStates.length; index++) {
				if ((winnerStates[index][0] == actualStateY[0])
						&& (winnerStates[index][1] == actualStateY[1])
						&& (winnerStates[index][2] == actualStateY[2])
						&& (winnerStates[index][3] == actualStateY[3])
						&& (winnerStates[index][4] == actualStateY[4])
						&& (winnerStates[index][5] == actualStateY[5])
						&& (winnerStates[index][6] == actualStateY[6])
						&& (winnerStates[index][7] == actualStateY[7])
						&& (winnerStates[index][8] == actualStateY[8])) {
					result = true;
					System.out.println(" O win");
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
