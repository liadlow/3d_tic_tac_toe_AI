package game;

import java.util.ArrayList;

public class Grid {
	
	private ArrayList<Coordinates> empty_cells;
	private String[][] level1, level2, level3;

	public int check_ttt(Coordinates cord) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isFull() {
		return !empty_cells.isEmpty();
	}

	public void lock_move(Coordinates cord) {
		// TODO Auto-generated method stub
	}

	public ArrayList<Coordinates> getEmpty_cells() {
		return empty_cells;
	}

	public void setEmpty_cells(ArrayList<Coordinates> empty_cells) {
		this.empty_cells = empty_cells;
	}

}
