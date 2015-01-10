package game;

import java.util.ArrayList;

public class Coordinates {
	
	private int level, x, y;

	public Coordinates(int level, int x, int y) {
		super();
		this.level = level;
		this.x = x;
		this.y = y;
	}

	public boolean isValid(ArrayList<Coordinates> empty_cells) {
		for(Coordinates cell : empty_cells) {
			if(this.equals(cell)) {
				return true;
			}
		}
		return false;
	}
	
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
