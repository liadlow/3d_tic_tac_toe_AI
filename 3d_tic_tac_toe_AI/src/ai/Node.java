package ai;

import java.util.ArrayList;
import game.*;


public class Node {

	/**
	 * @param args
	 */
    private Node parent;
    protected ArrayList<Node> children;
    private Grid state;
	private int score;
	private int highScore;//// 
	private int lowScore;////
	private int tmpscore;
	private Coordinates move;
    
    public Node(Node parent, Grid st){
    	this.parent = parent;
    	this.children = new ArrayList<Node>();
    	this.score = 0;
    	this.state = st;
    	this.move = null;
    	this.highScore = -999999;  ////
    	this.lowScore = 999999;  ////
    }
   
	public int getTmpscore() {
		return tmpscore;
	}

	public void setTmpscore(int tmpscore) {
		this.tmpscore = tmpscore;
	}

	public int getHighScore(){
    	return this.highScore;
    }
    
    public void setHighScore(int high){
    	this.highScore = high;
    }
    
    public int getLowScore(){
    	return this.lowScore;
    }
    
    public void setLowScore(int low){
    	this.lowScore = low;
    }
    
    public void setState(Grid st){
    	this.state = st;
    }
    
    public void setScore(int val){
    	this.score = val;
    }

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public ArrayList<Node> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}

	public Grid getSt() {
		return this.state;
	}

	public int getScore() {
		return score;
	}
    
	public void setMove(Coordinates mv){
		this.move = mv;
	}
	
	public Coordinates getMove(){
		return this.move;
	}
	
	public boolean hasChildren(){
		if(this.children.isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean isRoot(){
		if(this.parent != null){
			return false;
		}else{
			return true;
		}
	}
    
	public ArrayList<Node> getLeaves(Node cur){
		while(cur.hasChildren()){
			//If the current node does not have grand children (children of its children) then return its children as leaves
			if(!cur.getChildren().get(0).hasChildren()){
				return cur.getChildren();
			}else{
				//Get first child -- if one child has more children then all children of the same level will
				cur = cur.getChildren().get(0);
			}
		}
		return null;
	}
	
}
