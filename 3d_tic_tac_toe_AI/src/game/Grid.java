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
	
	public Grid(Grid grid){
		this.empty_cells = grid.empty_cells;
		this.level1 = new String[3][3];
		this.level2 = new String[3][3];
		this.level3 = new String[3][3];
		
    	for(int i = 0; i<3; i++){
    		for(int j = 0; j<3; j++){
    			this.level1[i][j] = grid.getLevel1sp(i, j);
    		}
    	}
    	
    	for(int i = 0; i<3; i++){
    		for(int j = 0; j<3; j++){
    			this.level2[i][j] = grid.getLevel2sp(i, j);
    		}
    	}
    	
    	for(int i = 0; i<3; i++){
    		for(int j = 0; j<3; j++){
    			this.level3[i][j] = grid.getLevel3sp(i, j);
    		}
    	}
    }
	
	private int heuristic(int n) {
		switch(n) {
			case 2: // 2 of our symbols before insertion
				return 1000; //100
			case -2: // 2 of the opponents symbols before insertion
				return 200; //50
			case 1: // 1 of our symbols and a space before insertion
				return 20; //10
			case -1: // 1 of the opponents symbols and a space before insertion
				return 3; //5
			case -3: // only spaces before insertion
				return 1; //1
			default: // 1 of our and 1 of the opponents symbols before insertion
				return 0;  //0
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
	public ArrayList<ArrayList<Coordinates>> check_ttt(Coordinates cord, String symbol) {
		ArrayList<ArrayList <Coordinates>> lines = new ArrayList<ArrayList <Coordinates>>();
		if(cord.neighboursX(this, symbol) == 2) {
			lines.add(cord.xline());
		}
		if(cord.neighboursY(this, symbol) == 2) {
			lines.add(cord.yline());
		}
		if(cord.neighboursZ(this, symbol) == 2) {
			lines.add(cord.zline());
		}
		if(cord.neighboursLevelDiag1(this, symbol) == 2) {
			lines.add(cord.ldiag1line());
		}
		if(cord.neighboursLevelDiag2(this, symbol) == 2) {
			lines.add(cord.ldiag2line());
		}
		if(cord.neighboursInterRow1(this, symbol) == 2) {
			lines.add(cord.irow1line());
		}
		if(cord.neighboursInterRow2(this, symbol) == 2) {
			lines.add(cord.irow2line());
		}
		if(cord.neighboursInterCol1(this, symbol) == 2) {
			lines.add(cord.icol1line());
		}
		if(cord.neighboursInterCol2(this, symbol) == 2) {
			lines.add(cord.icol2line());
		}
		if(cord.neighboursInterDiag1(this, symbol) == 2) {
			lines.add(cord.idiag1line());
		}
		if(cord.neighboursInterDiag2(this, symbol) == 2) {
			lines.add(cord.idiag2line());
		}
		if(cord.neighboursInterDiag3(this, symbol) == 2) {
			lines.add(cord.idiag3line());
		}
		if(cord.neighboursInterDiag4(this, symbol) == 2) {
			lines.add(cord.idiag4line());
		}
		return lines;
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
	
	public void setLevel1sp(int i, int j, String sym){
		this.level1[i][j] = sym;
	}
	
	public void setLevel2sp(int i, int j, String sym){
		this.level2[i][j] = sym;
	}
	
	public void setLevel3sp(int i, int j, String sym){
		this.level3[i][j] = sym;
	}
	
	public String getLevel1sp(int i, int j){
		return this.level1[i][j];
	}
	
	public String getLevel2sp(int i, int j){
		return this.level2[i][j];
	}
	
	public String getLevel3sp(int i, int j){
		return this.level3[i][j];
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
