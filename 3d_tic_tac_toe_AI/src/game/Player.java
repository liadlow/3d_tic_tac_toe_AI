package game;

import ai.*;

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
	
	public Coordinates make_move(Grid grid) {
		Coordinates move = null;
		if(!AI) {
			move = Panel.movePrompt();
			while(!move.isValid(grid.getEmpty_cells())) {
				move = Panel.wrongMove();
			}
		}
		else {
			//MINIMAX
			
			Node root = new Node(null, new Grid(grid)); //Init root node - no parent/state: current
			Minimax mnmx = new Minimax(root, this, 4);  //last arg is the depth to search
			root = mnmx.genStates(root, 1, this.getSymbol());
			mnmx.getBestMove(root, 0);
			move = root.getMove();
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
