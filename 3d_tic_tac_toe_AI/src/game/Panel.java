package game;

import java.util.Scanner;

public class Panel {
	
	private static Scanner keyboard = new Scanner(System.in);

	public static Coordinates movePrompt() {
		System.out.print("Make your move by choosing the level in which you want to play (1 - upper level, 2 - mid level, 3 - lower level): ");
		int level = inputInt("Provide an integer as the level: ");
		while(level < 1 || level > 3) {
			System.out.print("Provide a valid level number: ");
			level = inputInt("Provide an integer as the level: ");
		}
		System.out.print("Choose the cell coordinates you want to mark (x,y). x stands for row and y for column.\nx: ");
		int x = inputInt("Provide an integer as the x coordinate: ");
		while(x < 1 || x > 3) {
			System.out.print("Provide a valid coordinate number: ");
			x = inputInt("Provide an integer as the x coordinate: ");
		}
		System.out.print("y: ");
		int y = inputInt("Provide an integer as the y coordinate: ");
		while(y < 1 || y > 3) {
			System.out.print("Provide a valid coordinate number: ");
			y = inputInt("Provide an integer as the y coordinate: ");
		}
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
		System.out.println("Your name: ");
		String name = keyboard.nextLine();
		return name;
	}

	public static String symbolPrompt() {
		System.out.println("Choose your symbol (X/O): ");
		String symbol = keyboard.nextLine().toUpperCase();
		while(!symbol.equals("X") && !symbol.equals("O")) {
			System.out.println("Provide a valid symbol (X/O):");
			symbol = keyboard.nextLine().toUpperCase();
		}
		return symbol;
	}

	public static void showGrid(String[][] level1, String[][] level2, String[][] level3, String name, int player, int pc) {
		System.out.println("==================================== 3D  Tic-Tac-Toe ====================================\n");
		System.out.println("                -Level 1-               -Level 2-               -Level 3-                \n");
		System.out.println("                "+level1[0][0]+" | "+level1[0][1]+" | "+level1[0][2]+"               "+level2[0][0]+" | "+level2[0][1]+" | "+level2[0][2]+"               "+level3[0][0]+" | "+level3[0][1]+" | "+level3[0][2]+"                ");
		System.out.println("               --- --- ---             --- --- ---             --- --- ---               ");
		System.out.println("                "+level1[1][0]+" | "+level1[1][1]+" | "+level1[1][2]+"               "+level2[1][0]+" | "+level2[1][1]+" | "+level2[1][2]+"               "+level3[1][0]+" | "+level3[1][1]+" | "+level3[1][2]+"                ");
		System.out.println("               --- --- ---             --- --- ---             --- --- ---               ");
		System.out.println("                "+level1[2][0]+" | "+level1[2][1]+" | "+level1[2][2]+"               "+level2[2][0]+" | "+level2[2][1]+" | "+level2[2][2]+"               "+level3[2][0]+" | "+level3[2][1]+" | "+level3[2][2]+"                \n");
		System.out.println("  name: "+name+"                                                           computer");
		System.out.println("                                   "+player+"        -        "+pc+"                                   \n");
		System.out.println("                                   current streak:  -                                    \n");
	}

	public static void gemover(String outcome) {
		System.out.println(" =======================================================================================");
		System.out.println("|                                                                                       |");
		System.out.println("|                                                                                       |");
		switch(outcome) {
			case "You won":
				System.out.println("|                                        You won                                        |");
				break;
			case "LOSER":
				System.out.println("|                                         LOSER                                         |");
				break;
			case "It's a draw":
				System.out.println("|                                      It's a draw                                      |");
		}
		System.out.println("|                                                                                       |");
		System.out.println("|                                                                                       |");
		System.out.println(" =======================================================================================");
	}

}
