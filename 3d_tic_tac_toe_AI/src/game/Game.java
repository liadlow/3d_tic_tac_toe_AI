package game;

public class Game {
	
	private Player player1, player2;
	private int player1_ttt, player2_ttt;
	private boolean gameover;

	public Game(String name, String symbol) {
		System.out.println("Game initialized by "+name+" with the symbol "+symbol);
	}

	public Player randomFirst() {
		System.out.println("First player chosen");
		return null;
	}

	public void play(Player randomFirst) {
		System.out.println("Playing...");		
	}

}
