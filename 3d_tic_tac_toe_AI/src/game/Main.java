package game;

public class Main {

	public static void main(String[] args) {
		
		//player chooses symbol and name	
		String name = Panel.namePrompt();
		String symbol = Panel.symbolPrompt();
		int level = Integer.parseInt(Panel.levelPrompt());
		
		//initialize game
		Game game = new Game(name, symbol, level);
		
		//start game
		game.play(game.randomFirst());
		
	}

}
