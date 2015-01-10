package game;

import java.util.Random;

public class Game {
	
	private Player player, pc;
	private boolean gameover;
	private Grid grid;

	public Game(String name, String symbol) {
		super();
		this.player = new Player(name, symbol, false);
		this.pc = new Player("computer", oppositeSymbol(), true);
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
			player.setTurnToPlay(true);
			pc.setTurnToPlay(false);
			return player;
		}
		else {
			pc.setTurnToPlay(true);
			player.setTurnToPlay(false);
			return pc;
		}
	}

	// main method. after initialization infinite loop till game ends
	public void play(Player turn) {
		while(true) {
			Coordinates cord = turn.make_move(grid.getEmpty_cells());
			grid.lock_move(cord);
			int ttts = grid.check_ttt(cord); //check for new tic tac toes
			turn.add_ttts(ttts);
			if(grid.isFull()) {
				gameover = true;
				break;
			}
			else {
				turn = changePlayer(turn);
			}
		}
		//flow is here only if game is over
		System.out.println("winner is "+turn.getName());
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
