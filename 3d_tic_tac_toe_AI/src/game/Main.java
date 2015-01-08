package game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//player chooses symbol and name
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Your name:");
		String name = keyboard.nextLine();
		System.out.println("Choose your symbol (X/O)");
		String symbol = keyboard.nextLine();
		keyboard.close();
		
		//initialize game
		Game game = new Game(name, symbol);
		
		//start game
		game.play(game.randomFirst());
		
	}

}
