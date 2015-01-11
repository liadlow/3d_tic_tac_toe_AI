package game;

import java.util.ArrayList;

public class Grid {
	
	private ArrayList<Coordinates> empty_cells;
	private String[][] level1, level2, level3;

	public Grid() {
		super();
		empty_cells = new ArrayList<Coordinates>();
		level1 = new String[3][3];
		level2 = new String[3][3];
		level3 = new String[3][3];
		for(int l = 1; l <= 3; l++) {
			for(int x = 1; x <= 3; x++) {
				for(int y = 1; y <= 3; y++) {
					empty_cells.add(new Coordinates(l, x, y));
				}
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				level1[i][j] = " ";
				level2[i][j] = " ";
				level3[i][j] = " ";
			}
		}
	}
	
	public Grid(Grid grid, Coordinates cell) {
		super();
		empty_cells = grid.empty_cells;
		level1 = grid.level1;
		level2 = grid.level2;
		level3 = grid.level3;
		for(Coordinates cord : empty_cells) {
			if(cord.equals(cell)) {
				empty_cells.remove(cord);
			}
		}
	}
	
	private int heuristic(int n) {
		switch(n) {
			case 2: // 2 of our symbols before insertion
				return 100;
			case -2: // 2 of the opponents symbols before insertion
				return 50;
			case 1: // 1 of our symbols and a space before insertion
				return 10;
			case -1: // 1 of the opponents symbols and a space before insertion
				return 5;
			case -3: // only spaces before insertion
				return 1;
			default: // 1 of our and 1 of the opponents symbols before insertion
				return 0;
		}
	}
	
	//evaluation score for a possible move with coordinates `cord` and symbol `symbol`
	public int evScore(Coordinates cord, String symbol) {
		int evScore = 0;
		evScore += heuristic(cord.neighboursX(this, symbol));
		evScore += heuristic(cord.neighboursY(this, symbol));
		evScore += heuristic(cord.neighboursZ(this, symbol));
		evScore += heuristic(cord.neighboursLevelDiag1(this, symbol));
		evScore += heuristic(cord.neighboursLevelDiag2(this, symbol));
		evScore += heuristic(cord.neighboursInterRow1(this, symbol));
		evScore += heuristic(cord.neighboursInterRow2(this, symbol));
		evScore += heuristic(cord.neighboursInterCol1(this, symbol));
		evScore += heuristic(cord.neighboursInterCol2(this, symbol));
		evScore += heuristic(cord.neighboursInterDiag1(this, symbol));
		evScore += heuristic(cord.neighboursInterDiag2(this, symbol));
		evScore += heuristic(cord.neighboursInterDiag3(this, symbol));
		evScore += heuristic(cord.neighboursInterDiag4(this, symbol));
		return evScore;
	}

	//check for tic tac toes in the lines concerning cell defined by cords
	public int check_ttt(Coordinates cord, String symbol) {
		int num_ttts = 0;
		if(cord.neighboursX(this, symbol) == 2) {
			num_ttts++;
		}
		if(cord.neighboursY(this, symbol) == 2) {
			num_ttts++;
		}
		if(cord.neighboursZ(this, symbol) == 2) {
			num_ttts++;
		}
		if(cord.neighboursLevelDiag1(this, symbol) == 2) {
			num_ttts++;
		}
		if(cord.neighboursLevelDiag2(this, symbol) == 2) {
			num_ttts++;
		}
		if(cord.neighboursInterRow1(this, symbol) == 2) {
			num_ttts++;
		}
		if(cord.neighboursInterRow2(this, symbol) == 2) {
			num_ttts++;
		}
		if(cord.neighboursInterCol1(this, symbol) == 2) {
			num_ttts++;
		}
		if(cord.neighboursInterCol2(this, symbol) == 2) {
			num_ttts++;
		}
		if(cord.neighboursInterDiag1(this, symbol) == 2) {
			num_ttts++;
		}
		if(cord.neighboursInterDiag2(this, symbol) == 2) {
			num_ttts++;
		}
		if(cord.neighboursInterDiag3(this, symbol) == 2) {
			num_ttts++;
		}
		if(cord.neighboursInterDiag4(this, symbol) == 2) {
			num_ttts++;
		}
		return num_ttts;
	}

	public boolean isFull() {
		return empty_cells.isEmpty();
	}

	public void lock_move(Coordinates cord, String symbol) {
		for(Coordinates cell : empty_cells) {
			if(cell.equals(cord)) {
				empty_cells.remove(cell);
				break;
			}
		}
		int level = cord.getLevel();
		if(level == 1) {
			level1[cord.getX() - 1][cord.getY() - 1] = symbol;
		}
		else if(level == 2) {
			level2[cord.getX() - 1][cord.getY() - 1] = symbol;
		}
		else {
			level3[cord.getX() - 1][cord.getY() - 1] = symbol;
		}
	}

	public ArrayList<Coordinates> getEmpty_cells() {
		return empty_cells;
	}

	public void setEmpty_cells(ArrayList<Coordinates> empty_cells) {
		this.empty_cells = empty_cells;
	}

	public String[][] getLevel3() {
		return level3;
	}

	public void setLevel3(String[][] level3) {
		this.level3 = level3;
	}

	public String[][] getLevel1() {
		return level1;
	}

	public void setLevel1(String[][] level1) {
		this.level1 = level1;
	}

	public String[][] getLevel2() {
		return level2;
	}

	public void setLevel2(String[][] level2) {
		this.level2 = level2;
	}
	
	public String[][] getLevel(int level) {
		switch(level) {
			case 1:
				return getLevel1();
			case 2:
				return getLevel2();
			case 3:
				return getLevel3();
			default:
				return null;
		}
	}

}
