package game;

import java.util.Random;

import ai.Minimax;
import ai.Node;

public class Player {
	
	private String name, symbol;
	private int num_ttts; //number of tic tac toes
	private boolean AI;
	
	public Player(String name, String symbol, boolean aI) {
		super();
		this.name = name;
		this.symbol = symbol;
		AI = aI;
	}
	
	public Coordinates make_move(Grid grid, int hlevel) {
		Coordinates move = null;
		if(!AI) {
			move = Panel.movePrompt();
			while(!move.isValid(grid.getEmpty_cells())) {
				move = Panel.wrongMove();
			}
		}
		else {
			//MINIMAX
			if(hlevel == 0) {
			  	Random rand = new Random();
					int randomNum = rand.nextInt((grid.getEmpty_cells().size() - 1) + 1) + 1;
					move = grid.getEmpty_cells().get(randomNum - 1);
			  }
			  else {
				Node root = new Node(null, new Grid(grid)); //Init root node - no parent/state: current
			  	Minimax mnmx = new Minimax(root, this, hlevel);  //last arg is the depth to search
				root = mnmx.genStates(root, 1, this.getSymbol());
				mnmx.getBestMove(root, 0);
				move = root.getMove();
			  }
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

	public String getOppSymbol(){
		if(this.getSymbol().equals("X")){
			return "O";
		}else{
			return "X";
		}
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

	public int getNum_ttts() {
		return num_ttts;
	}

	public void setNum_ttts(int num_tts) {
		this.num_ttts = num_tts;
	}
	
}
