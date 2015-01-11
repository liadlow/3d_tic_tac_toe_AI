package game;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	
	private Player player, pc;
	private boolean gameover;
	private Grid grid;

	public Game(String name, String symbol) {
		super();
		player = new Player(name, symbol, false);
		pc = new Player("computer", oppositeSymbol(), true);
		grid = new Grid();
		gameover = false;
	}

	private String oppositeSymbol() {
		if(player.getSymbol().equals("X")) {
			return "O";
		}
		else {
			return "X";
		}
	}

	public Player randomFirst() {
		Random rand = new Random();
		int randomNum = rand.nextInt((1 - 0) + 1);
		if(randomNum == 1) {
			return player;
		}
		else {
			return pc;
		}
	}

	// main method. after initialization infinite loop till game ends
	public void play(Player turn) {
		while(true) {
			Panel.showGrid(grid.getLevel1(), grid.getLevel2(), grid.getLevel3(), player.getName(), player.getNum_ttts(), pc.getNum_ttts(), turn.getName(), 0);
			Coordinates cord = turn.make_move(grid.getEmpty_cells());
			
			// random input for testing
			if(cord == null && turn.isAI()) {
				Random rand = new Random();
				int randomNum = rand.nextInt((grid.getEmpty_cells().size() - 1) + 1) + 1;
				cord = grid.getEmpty_cells().get(randomNum - 1);
			}
				
				
			grid.lock_move(cord, turn.getSymbol());
			ArrayList<ArrayList<Coordinates>> ttts = grid.check_ttt(cord, turn.getSymbol()); //check for new tic tac toes
			if(!ttts.isEmpty()) {
				Panel.showttts(grid.getLevel1(), grid.getLevel2(), grid.getLevel3(), player.getName(), player.getNum_ttts(), pc.getNum_ttts(), turn.getName(), turn.getSymbol(), ttts);
			}
			turn.add_ttts(ttts.size());
			if(grid.isFull()) {
				gameover = true;
				Panel.showGrid(grid.getLevel1(), grid.getLevel2(), grid.getLevel3(), player.getName(), player.getNum_ttts(), pc.getNum_ttts(), turn.getName(), 0);
				int playert = player.getNum_ttts(), pct = pc.getNum_ttts();
				Panel.gemover(playert > pct ? "You won" : playert < pct ? "LOSER" : "It's a draw");
				break;
			}
			else {
				turn = changePlayer(turn);
			}
		}
	}
	
	private Player changePlayer(Player current) {
		if(current.isAI()) {
			return player;
		}
		else {
			return pc;
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPc() {
		return pc;
	}

	public void setPc(Player pc) {
		this.pc = pc;
	}

	public boolean isGameover() {
		return gameover;
	}

	public void setGameover(boolean gameover) {
		this.gameover = gameover;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

}
