package game;

public class Main {

	public static void main(String[] args) {
		
		//player chooses symbol and name		
		String name = Panel.namePrompt();
		String symbol = Panel.symbolPrompt();
		
		//initialize game
		Game game = new Game(name, symbol);
		
		//start game
		game.play(game.randomFirst());
		
	}

}
