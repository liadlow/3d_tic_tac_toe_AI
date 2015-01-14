package ai;

import game.*;

import java.util.ArrayList;

public class Minimax {
	private Node root;
	private Player pl;
	private static int depth;
	
	public Minimax(Node root, Player pl, int dep){
		this.root = root;
		this.pl = pl;
		depth = dep;
	}
	

	public Node genStates(Node parent, int dep, String symbol){
		Node n = null;
		
		for(Coordinates cell: parent.getSt().getEmpty_cells()){
			Coordinates tmpcell = new Coordinates(cell);
			
			Grid tmp = new Grid(parent.getSt()); //Create and init new possible grid state
			
			int level = tmpcell.getLevel();
			if(level == 1){ //Check grid level
				if(!tmp.getLevel1sp(tmpcell.getX()-1, tmpcell.getY()-1).equals(" ")){
					continue; //Just in case there is an invalid entry in the Empty_cells array list
				}
				tmp.setLevel1sp(tmpcell.getX()-1, tmpcell.getY()-1, symbol);  //Add move
			}else if(level == 2){
				if(!tmp.getLevel2sp(tmpcell.getX()-1, tmpcell.getY()-1).equals(" ")){
					continue;
				}
				tmp.setLevel2sp(tmpcell.getX()-1, tmpcell.getY()-1, symbol);
			}else if(level == 3){
				if(!tmp.getLevel3sp(tmpcell.getX()-1, tmpcell.getY()-1).equals(" ")){
					continue;
				}
				tmp.setLevel3sp(tmpcell.getX()-1, tmpcell.getY()-1, symbol);
			}
			
			tmp.getEmpty_cells().remove(tmpcell); //Remove cell from available cells arary list
			n = new Node(parent, tmp); // Create and init new tree noce
			n.setMove(tmpcell); //Declare the move that was made in each node
			
			if(!n.isRoot()){
				int score = tmp.evScore(tmpcell, symbol);
				if(dep%2 == 0){
					score *= -1;
					n.setScore(score);
				}else{
					n.setScore(score);
				}
			}
				//=========================================<DEBUG>==================================================
//				Panel.showGrid(n.getSt().getLevel1(), n.getSt().getLevel2(), n.getSt().getLevel3(), this.pl.getName(), this.pl.getNum_ttts(), this.pl.getNum_ttts(), "ads", 0);
//				System.out.println("debuged cell coordinates: level - "+tmpcell.getLevel()+", x - "+tmpcell.getX()+", y - "+tmpcell.getY());
//				System.out.println("leaf score: "+score);
				//=========================================</DEBUG>==================================================
			//}
			parent.children.add(n);  //append newly created node to parent node as child
			
			if(dep < depth){ //If required depth level is not reached, recursively call this method for the opponent
				if(symbol == "X"){ //decide on turn and choose appropriate call
					n = genStates(n, dep+1, "O");
				}else{
					n = genStates(n, dep+1, "X");
				}
			}
		}		
		return parent;
	}
	
	public void getBestMove(Node parent, int dep){
		ArrayList<Node> children = null;
		Node child = null;
		int i;
		
		if(parent.hasChildren()){
			children = parent.getChildren();
			for(i=0; i<children.size(); i++){
				//recursion
				child = children.get(i);
				getBestMove(child, dep+1);
			}
			if(dep%2 == 0){
				parent.setScore(parent.getScore()+parent.getHighScore());
			}else{
				parent.setScore(parent.getScore()+parent.getLowScore());
			}
		}
		if(!parent.isRoot()){
			if(dep%2 == 0){
				int score = parent.getScore();
				if(score < parent.getParent().getLowScore()){
					parent.getParent().setLowScore(score);
					return;
				}else{
					return;
				}
			}else{
				//AI move
				int score = parent.getScore();
				
				if(score > parent.getParent().getHighScore()){
					parent.getParent().setHighScore(score);
					if(dep == 1){
						parent.getParent().setMove(parent.getMove());
					}
					return;
				}else{
					return;
				}
			}
		}
		
		System.out.println("Move's score: "+parent.getScore());
		return;
	}
	

	public Node getRoot() {
		return this.root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Player getpl() {
		return this.pl;
	}

	public void setpl(Player pl) {
		this.pl = pl;
	}
	
	
}
