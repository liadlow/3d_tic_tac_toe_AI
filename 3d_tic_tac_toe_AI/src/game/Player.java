package game;

import java.util.ArrayList;

public class Player {
	
	private String name, symbol;
	private int num_ttts; //number of tic tac toes
	private boolean AI, turnToPlay;
	
	public Player(String name, String symbol, boolean aI) {
		super();
		this.name = name;
		this.symbol = symbol;
		AI = aI;
	}
	
	public Coordinates make_move(ArrayList<Coordinates> empty_cells) {
		Coordinates move = null;
		if(!AI) {
			move = Panel.movePrompt();
			while(!move.isValid(empty_cells)) {
				move = Panel.wrongMove();
			}
		}
		else {
			//MINIMAX
		}
		return move;
	}

	public void add_ttts(int ttts) {
		num_ttts += ttts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public boolean isAI() {
		return AI;
	}

	public void setAI(boolean aI) {
		AI = aI;
	}

	public boolean isTurnToPlay() {
		return turnToPlay;
	}

	public void setTurnToPlay(boolean turnToPlay) {
		this.turnToPlay = turnToPlay;
	}

	public int getNum_ttts() {
		return num_ttts;
	}

	public void setNum_ttts(int num_tts) {
		this.num_ttts = num_tts;
	}
	
}
