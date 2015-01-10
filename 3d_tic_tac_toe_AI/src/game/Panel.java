package game;

import java.util.Scanner;

public class Panel {
	
	private static Scanner keyboard = new Scanner(System.in);

	public static Coordinates movePrompt() {
		System.out.println("Make your move by choosing the level in which you want to play (1 - upper level, 2 - mid level, 3 - lower level)");
		int level = inputInt("Provide an integer as the level.");
		System.out.println("Choose the cell coordinates you want to mark (x,y)\nx:");
		int x = inputInt("Provide an integer as the x coordinate");
		System.out.println("y:");
		int y = inputInt("Provide an integer as the y coordinate");
		Coordinates cord = new Coordinates(level, x, y);
		return cord;
	}
	
	private static int inputInt(String errorPrompt) {
		String input = keyboard.nextLine();
		while(true) {
			try {
				return Integer.parseInt(input);
			}
			catch(NumberFormatException ex) {
				System.out.println(errorPrompt);
				input = keyboard.nextLine();
			}
		}
	}

	public static Coordinates wrongMove() {
		System.out.println("The cell you asked is already marked. Choose a free cell.");
		return movePrompt();
	}

	public static String namePrompt() {
		System.out.println("Your name:");
		String name = keyboard.nextLine();
		return name;
	}

	public static String symbolPrompt() {
		System.out.println("Choose your symbol (X/O)");
		String symbol = keyboard.nextLine().toUpperCase();
		while(!symbol.equals("X") && !symbol.equals("O")) {
			System.out.println("Provide a valid symbol (X/O).");
			symbol = keyboard.nextLine().toUpperCase();
		}
		return null;
	}

}
