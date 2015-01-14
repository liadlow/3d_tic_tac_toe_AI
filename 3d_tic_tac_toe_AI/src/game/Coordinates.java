package game;

import java.util.ArrayList;

public class Coordinates {
	
	private int level, x, y; // x = row, y = column

	public Coordinates(int level, int x, int y) {
		super();
		this.level = level;
		this.x = x;
		this.y = y;
	}
	
	public Coordinates(Coordinates cell){
		this.level = cell.level;
		this.x = cell.x;
		this.y = cell.y;
	}

	// checks validity concerning cell availability
	public boolean isValid(ArrayList<Coordinates> empty_cells) {
		for(Coordinates cell : empty_cells) {
			if(this.equals(cell)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * 
	 * neighbours functions find the number of a cell's friend or enemy neighbours with weights (+1 - friend, -1 - opponent)
	 * in case of empty line returns -3
	 *
	 * start neighbours functions ===========================================================================================
	 */
	public int neighboursX(Grid g, String symbol) {
		Coordinates n1 = rowNext(), n2 = n1.rowNext();
		int neighbours = 0;
		String[][] l = g.getLevel(level);
		neighbours += l[n1.x - 1][n1.y - 1].equals(symbol) ? 1 : l[n1.x - 1][n1.y - 1].equals(" ") ? 0 : -1;
		neighbours += l[n2.x - 1][n2.y - 1].equals(symbol) ? 1 : l[n2.x - 1][n2.y - 1].equals(" ") ? neighbours != 0 ? 0 : -3 : -1;
		return neighbours;
	}
	
	public int neighboursY(Grid g, String symbol) {
		Coordinates n1 = colNext(), n2 = n1.colNext();
		int neighbours = 0;
		String[][] l = g.getLevel(level);
		neighbours += l[n1.x - 1][n1.y - 1].equals(symbol) ? 1 : l[n1.x - 1][n1.y - 1].equals(" ") ? 0 : -1;
		neighbours += l[n2.x - 1][n2.y - 1].equals(symbol) ? 1 : l[n2.x - 1][n2.y - 1].equals(" ") ? neighbours != 0 ? 0 : -3 : -1;
		return neighbours;
	}
	
	public int neighboursZ(Grid g, String symbol) {
		Coordinates n1 = below(), n2 = n1.below();
		int neighbours = 0;
		String[][] l1 = g.getLevel(n1.level), l2 = g.getLevel(n2.level);
		neighbours += l1[n1.x - 1][n1.y - 1].equals(symbol) ? 1 : l1[n1.x - 1][n1.y - 1].equals(" ") ? 0 : -1;
		neighbours += l2[n2.x - 1][n2.y - 1].equals(symbol) ? 1 : l2[n2.x - 1][n2.y - 1].equals(" ") ? neighbours != 0 ? 0 : -3 : -1;
		return neighbours;
	}
	
	public int neighboursLevelDiag1(Grid g, String symbol) {
		int neighbours = 0;
		if(isInLevelDiag1()) {
			Coordinates n1 = levelDiag1Next(), n2 = n1.levelDiag1Next();
			String[][] l = g.getLevel(level);
			neighbours += l[n1.x - 1][n1.y - 1].equals(symbol) ? 1 : l[n1.x - 1][n1.y - 1].equals(" ") ? 0 : -1;
			neighbours += l[n2.x - 1][n2.y - 1].equals(symbol) ? 1 : l[n2.x - 1][n2.y - 1].equals(" ") ? neighbours != 0 ? 0 : -3 : -1;
		}
		return neighbours;
	}
	
	public int neighboursLevelDiag2(Grid g, String symbol) {
		int neighbours = 0;
		if(isInLevelDiag2()) {
			Coordinates n1 = levelDiag2Next(), n2 = n1.levelDiag2Next();
			String[][] l = g.getLevel(level);
			neighbours += l[n1.x - 1][n1.y - 1].equals(symbol) ? 1 : l[n1.x - 1][n1.y - 1].equals(" ") ? 0 : -1;
			neighbours += l[n2.x - 1][n2.y - 1].equals(symbol) ? 1 : l[n2.x - 1][n2.y - 1].equals(" ") ? neighbours != 0 ? 0 : -3 : -1;
		}
		return neighbours;
	}
	
	public int neighboursInterRow1(Grid g, String symbol) {
		int neighbours = 0;
		if(isInInterRow1()) {
			Coordinates n1 = interRow1Next(), n2 = n1.interRow1Next();
			String[][] l1 = g.getLevel(n1.level), l2 = g.getLevel(n2.level);
			neighbours += l1[n1.x - 1][n1.y - 1].equals(symbol) ? 1 : l1[n1.x - 1][n1.y - 1].equals(" ") ? 0 : -1;
			neighbours += l2[n2.x - 1][n2.y - 1].equals(symbol) ? 1 : l2[n2.x - 1][n2.y - 1].equals(" ") ? neighbours != 0 ? 0 : -3 : -1;
		}
		return neighbours;
	}
	
	public int neighboursInterRow2(Grid g, String symbol) {
		int neighbours = 0;
		if(isInInterRow2()) {
			Coordinates n1 = interRow2Next(), n2 = n1.interRow2Next();
			String[][] l1 = g.getLevel(n1.level), l2 = g.getLevel(n2.level);
			neighbours += l1[n1.x - 1][n1.y - 1].equals(symbol) ? 1 : l1[n1.x - 1][n1.y - 1].equals(" ") ? 0 : -1;
			neighbours += l2[n2.x - 1][n2.y - 1].equals(symbol) ? 1 : l2[n2.x - 1][n2.y - 1].equals(" ") ? neighbours != 0 ? 0 : -3 : -1;
		}
		return neighbours;
	}
	
	public int neighboursInterCol1(Grid g, String symbol) {
		int neighbours = 0;
		if(isInInterCol1()) {
			Coordinates n1 = interCol1Next(), n2 = n1.interCol1Next();
			String[][] l1 = g.getLevel(n1.level), l2 = g.getLevel(n2.level);
			neighbours += l1[n1.x - 1][n1.y - 1].equals(symbol) ? 1 : l1[n1.x - 1][n1.y - 1].equals(" ") ? 0 : -1;
			neighbours += l2[n2.x - 1][n2.y - 1].equals(symbol) ? 1 : l2[n2.x - 1][n2.y - 1].equals(" ") ? neighbours != 0 ? 0 : -3 : -1;
		}
		return neighbours;
	}
	
	public int neighboursInterCol2(Grid g, String symbol) {
		int neighbours = 0;
		if(isInInterCol2()) {
			Coordinates n1 = interCol2Next(), n2 = n1.interCol2Next();
			String[][] l1 = g.getLevel(n1.level), l2 = g.getLevel(n2.level);
			neighbours += l1[n1.x - 1][n1.y - 1].equals(symbol) ? 1 : l1[n1.x - 1][n1.y - 1].equals(" ") ? 0 : -1;
			neighbours += l2[n2.x - 1][n2.y - 1].equals(symbol) ? 1 : l2[n2.x - 1][n2.y - 1].equals(" ") ? neighbours != 0 ? 0 : -3 : -1;
		}
		return neighbours;
	}
	
	public int neighboursInterDiag1(Grid g, String symbol) {
		int neighbours = 0;
		if(isInInterDiag1()) {
			Coordinates n1 = interDiag1Next(), n2 = n1.interDiag1Next();
			String[][] l1 = g.getLevel(n1.level), l2 = g.getLevel(n2.level);
			neighbours += l1[n1.x - 1][n1.y - 1].equals(symbol) ? 1 : l1[n1.x - 1][n1.y - 1].equals(" ") ? 0 : -1;
			neighbours += l2[n2.x - 1][n2.y - 1].equals(symbol) ? 1 : l2[n2.x - 1][n2.y - 1].equals(" ") ? neighbours != 0 ? 0 : -3 : -1;
		}
		return neighbours;
	}
	
	public int neighboursInterDiag2(Grid g, String symbol) {
		int neighbours = 0;
		if(isInInterDiag2()) {
			Coordinates n1 = interDiag2Next(), n2 = n1.interDiag2Next();
			String[][] l1 = g.getLevel(n1.level), l2 = g.getLevel(n2.level);
			neighbours += l1[n1.x - 1][n1.y - 1].equals(symbol) ? 1 : l1[n1.x - 1][n1.y - 1].equals(" ") ? 0 : -1;
			neighbours += l2[n2.x - 1][n2.y - 1].equals(symbol) ? 1 : l2[n2.x - 1][n2.y - 1].equals(" ") ? neighbours != 0 ? 0 : -3 : -1;
		}
		return neighbours;
	}
	
	public int neighboursInterDiag3(Grid g, String symbol) {
		int neighbours = 0;
		if(isInInterDiag3()) {
			Coordinates n1 = interDiag3Next(), n2 = n1.interDiag3Next();
			String[][] l1 = g.getLevel(n1.level), l2 = g.getLevel(n2.level);
			neighbours += l1[n1.x - 1][n1.y - 1].equals(symbol) ? 1 : l1[n1.x - 1][n1.y - 1].equals(" ") ? 0 : -1;
			neighbours += l2[n2.x - 1][n2.y - 1].equals(symbol) ? 1 : l2[n2.x - 1][n2.y - 1].equals(" ") ? neighbours != 0 ? 0 : -3 : -1;
		}
		return neighbours;
	}
	
	public int neighboursInterDiag4(Grid g, String symbol) {
		int neighbours = 0;
		if(isInInterDiag4()) {
			Coordinates n1 = interDiag4Next(), n2 = n1.interDiag4Next();
			String[][] l1 = g.getLevel(n1.level), l2 = g.getLevel(n2.level);
			neighbours += l1[n1.x - 1][n1.y - 1].equals(symbol) ? 1 : l1[n1.x - 1][n1.y - 1].equals(" ") ? 0 : -1;
			neighbours += l2[n2.x - 1][n2.y - 1].equals(symbol) ? 1 : l2[n2.x - 1][n2.y - 1].equals(" ") ? neighbours != 0 ? 0 : -3 : -1;
		}
		return neighbours;
	}
	/*
	 * end neighbours functions ===============================================================================================
	 */
	
	
	/*
	 * "next" functions find the next cell in the line and return its coordinates.
	 * the isIn functions specify if the cell is part of a line.
	 * 
	 * start next-isIn functions ==============================================================================================
	 */
	private Coordinates colNext() {
		if(x == 3) {
			return new Coordinates(level, 1, y);
		}
		else {
			return new Coordinates(level, x + 1, y);
		}
	}
	
	private Coordinates rowNext() {
		if(y == 3) {
			return new Coordinates(level, x, 1);
		}
		else {
			return new Coordinates(level, x, y + 1);
		}
	}
	
	private boolean isInLevelDiag1() {
		return (x == y);
	}
	
	private Coordinates levelDiag1Next() {
		if(x == 3) {
			return new Coordinates(level, 1, 1);
		}
		else {
			return new Coordinates(level, x + 1, y + 1);
		}
	}
	
	private boolean isInLevelDiag2() {
		return ((x == 2 && y == 2) || (Math.abs(x-y) == 2));
	}
	
	private Coordinates levelDiag2Next() {
		if(x == 1 && y == 3) {
			return new Coordinates(level, 3, 1);
		}
		else {
			return new Coordinates(level, x - 1, y + 1);
		}
	}
	
	private Coordinates below() {
		if(level == 3) {
			return new Coordinates(1, x, y);
		}
		else {
			return new Coordinates(level + 1, x, y);
		}
	}
	
	private boolean isInInterRow1() {
		return (level == y);
	}
	
	private Coordinates interRow1Next() {
		if(level == 3) {
			return new Coordinates(1, x, 1);
		}
		else {
			return new Coordinates(level + 1, x, y + 1);
		}
	}
	
	private boolean isInInterRow2() {
		return ((level == 2 && y == 2) || (Math.abs(level - y) == 2));
	}
	
	private Coordinates interRow2Next() {
		if(level == 3) {
			return new Coordinates(1, x, 3);
		}
		else {
			return new Coordinates(level + 1, x, y - 1);
		}
	}
	
	private boolean isInInterCol1() {
		return (level == x);
	}
	
	private Coordinates interCol1Next() {
		if(level == 3) {
			return new Coordinates(1, 1, y);
		}
		else {
			return new Coordinates(level + 1, x + 1, y);
		}
	}
	
	private boolean isInInterCol2() {
		return ((level == 2 && x == 2) || (Math.abs(level - x) == 2));
	}
	
	private Coordinates interCol2Next() {
		if(level == 3) {
			return new Coordinates(1, 3, y);
		}
		else {
			return new Coordinates(level + 1, x - 1, y);
		}
	}
	
	private boolean isInInterDiag1() {
		return (level == x && level == y);
	}
	
	private Coordinates interDiag1Next() {
		if(level == 3) {
			return new Coordinates(1, 1, 1);
		}
		else {
			return new Coordinates(level + 1, x + 1, y + 1);
		}
	}
	
	private boolean isInInterDiag2() {
		return ((level == 2 && x == 2 && y == 2) || (level == x && Math.abs(level - y) == 2));
	}
	
	private Coordinates interDiag2Next() {
		if(level == 3) {
			return new Coordinates(1, 1, 3);
		}
		else {
			return new Coordinates(level + 1, x + 1, y - 1);
		}
	}
	
	private boolean isInInterDiag3() {
		return ((level == 2 && x == 2 && y == 2) || (x == y && Math.abs(level - y) == 2));
	}
	
	private Coordinates interDiag3Next() {
		if(level == 3) {
			return new Coordinates(1, 3, 3);
		}
		else {
			return new Coordinates(level + 1, x - 1, y - 1);
		}
	}
	
	private boolean isInInterDiag4() {
		return ((level == 2 && x == 2 && y == 2) || (level == y && Math.abs(level - x) == 2));
	}
	
	private Coordinates interDiag4Next() {
		if(level == 3) {
			return new Coordinates(1, 3, 1);
		}
		else {
			return new Coordinates(level + 1, x - 1, y + 1);
		}
	}
	/*
	 * end next-isIn functions ================================================================================================
	 */
	

	/*
	 * line functions return the 3 coordinates consisting the line asked in an ArrayList
	 * 
	 * start line functions ===================================================================================================
	 */
	public ArrayList<Coordinates> xline() {
		ArrayList<Coordinates> line = new ArrayList<Coordinates>();
		line.add(this);
		line.add(rowNext());
		line.add(rowNext().rowNext());
		return line;
	}

	public ArrayList<Coordinates> yline() {
		ArrayList<Coordinates> line = new ArrayList<Coordinates>();
		line.add(this);
		line.add(colNext());
		line.add(colNext().colNext());
		return line;
	}

	public ArrayList<Coordinates> zline() {
		ArrayList<Coordinates> line = new ArrayList<Coordinates>();
		line.add(this);
		line.add(below());
		line.add(below().below());
		return line;
	}

	public ArrayList<Coordinates> ldiag1line() {
		ArrayList<Coordinates> line = new ArrayList<Coordinates>();
		line.add(this);
		line.add(levelDiag1Next());
		line.add(levelDiag1Next().levelDiag1Next());
		return line;
	}

	public ArrayList<Coordinates> ldiag2line() {
		ArrayList<Coordinates> line = new ArrayList<Coordinates>();
		line.add(this);
		line.add(levelDiag2Next());
		line.add(levelDiag2Next().levelDiag2Next());
		return line;
	}

	public ArrayList<Coordinates> irow1line() {
		ArrayList<Coordinates> line = new ArrayList<Coordinates>();
		line.add(this);
		line.add(interRow1Next());
		line.add(interRow1Next().interRow1Next());
		return line;
	}

	public ArrayList<Coordinates> irow2line() {
		ArrayList<Coordinates> line = new ArrayList<Coordinates>();
		line.add(this);
		line.add(interRow2Next());
		line.add(interRow2Next().interRow2Next());
		return line;
	}

	public ArrayList<Coordinates> icol1line() {
		ArrayList<Coordinates> line = new ArrayList<Coordinates>();
		line.add(this);
		line.add(interCol1Next());
		line.add(interCol1Next().interCol1Next());
		return line;
	}

	public ArrayList<Coordinates> icol2line() {
		ArrayList<Coordinates> line = new ArrayList<Coordinates>();
		line.add(this);
		line.add(interCol2Next());
		line.add(interCol2Next().interCol2Next());
		return line;
	}

	public ArrayList<Coordinates> idiag1line() {
		ArrayList<Coordinates> line = new ArrayList<Coordinates>();
		line.add(this);
		line.add(interDiag1Next());
		line.add(interDiag1Next().interDiag1Next());
		return line;
	}

	public ArrayList<Coordinates> idiag2line() {
		ArrayList<Coordinates> line = new ArrayList<Coordinates>();
		line.add(this);
		line.add(interDiag2Next());
		line.add(interDiag2Next().interDiag2Next());
		return line;
	}

	public ArrayList<Coordinates> idiag3line() {
		ArrayList<Coordinates> line = new ArrayList<Coordinates>();
		line.add(this);
		line.add(interDiag3Next());
		line.add(interDiag3Next().interDiag3Next());
		return line;
	}

	public ArrayList<Coordinates> idiag4line() {
		ArrayList<Coordinates> line = new ArrayList<Coordinates>();
		line.add(this);
		line.add(interDiag4Next());
		line.add(interDiag4Next().interDiag4Next());
		return line;
	}
	/*
	 * end line functions =====================================================================================================
	 */
	
	public boolean equals(Coordinates cord) {
		return (cord.getLevel() == level && cord.getX() == x && cord.getY() == y);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

}
