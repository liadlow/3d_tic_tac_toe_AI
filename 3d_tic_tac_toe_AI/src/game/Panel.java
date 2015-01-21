/*
 * user interaction. Show messages and get input.
 */

package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Panel {
	
	private static Scanner keyboard = new Scanner(System.in);
	
	// prompt user to make move
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
	
	public static String levelPrompt(){
		System.out.println("Choose the difficult level (0 - 3 year old, 1 - Easy, 2 - Medium, 3 - Hard, 4 - Expert):");
		
		String level = keyboard.nextLine();
		while(!level.equals("0") && !level.equals("1") && !level.equals("2") && !level.equals("3") && !level.equals("4")){
			System.out.println("Please provide a valid difficulty level(0-4):");
			level = keyboard.nextLine();
		}
		return level;
	}
	
	// custom getInt
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

	// show move error concerning availability
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

	//main UI
	public static void showGrid(String[][] level1, String[][] level2, String[][] level3, String name, int player, int pc, String turn, int streak) {
		System.out.println("==================================== 3D  Tic-Tac-Toe ====================================\n");
		System.out.println("                -Level 1-               -Level 2-               -Level 3-                \n");
		System.out.println("                "+level1[0][0]+" | "+level1[0][1]+" | "+level1[0][2]+"               "+level2[0][0]+" | "+level2[0][1]+" | "+level2[0][2]+"               "+level3[0][0]+" | "+level3[0][1]+" | "+level3[0][2]+"                ");
		System.out.println("               --- --- ---             --- --- ---             --- --- ---               ");
		System.out.println("                "+level1[1][0]+" | "+level1[1][1]+" | "+level1[1][2]+"               "+level2[1][0]+" | "+level2[1][1]+" | "+level2[1][2]+"               "+level3[1][0]+" | "+level3[1][1]+" | "+level3[1][2]+"                ");
		System.out.println("               --- --- ---             --- --- ---             --- --- ---               ");
		System.out.println("                "+level1[2][0]+" | "+level1[2][1]+" | "+level1[2][2]+"               "+level2[2][0]+" | "+level2[2][1]+" | "+level2[2][2]+"               "+level3[2][0]+" | "+level3[2][1]+" | "+level3[2][2]+"                \n");
		System.out.println("  name: "+name+"                                                           computer");
		System.out.println("                                   "+player+"        -        "+pc+"                                   \n");
		System.out.println("  turn: "+turn+"\n");
		System.out.println("                                   current streak:  "+(streak == 0 ? "-" : streak)+"                                    \n");
	}

	// last screen
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

	// show the new tic tac toes with *
	public static void showttts(String[][] level1, String[][] level2, String[][] level3,
			String name, int player, int pc, String turn, String symbol, ArrayList<ArrayList<Coordinates>> lines) {
		boolean playerturn = name.equals(turn);
		for(int i = 0; i < lines.size(); i++) {
		// replace the tic tac toe marks with *
			for(int j = 0; j < 3; j++) {
				switch(lines.get(i).get(j).getLevel()) {
					case 1:
						level1[lines.get(i).get(j).getX() - 1][lines.get(i).get(j).getY() - 1] = "*";
						break;
					case 2:
						level2[lines.get(i).get(j).getX() - 1][lines.get(i).get(j).getY() - 1] = "*";
						break;
					case 3:
						level3[lines.get(i).get(j).getX() - 1][lines.get(i).get(j).getY() - 1] = "*";
						break;
				}
			}
			// show hte grid to user
			showGrid(level1, level2, level3, name, playerturn ? player + 1 : player, playerturn ? pc : pc + 1, turn, i + 1);
			for(int j = 0; j < 3; j++) {
			// place back the symbols of the turn player
				switch(lines.get(i).get(j).getLevel()) {
					case 1:
						level1[lines.get(i).get(j).getX() - 1][lines.get(i).get(j).getY() - 1] = symbol;
						break;
					case 2:
						level2[lines.get(i).get(j).getX() - 1][lines.get(i).get(j).getY() - 1] = symbol;
						break;
					case 3:
						level3[lines.get(i).get(j).getX() - 1][lines.get(i).get(j).getY() - 1] = symbol;
						break;
				}
			}
			try {
				// pause execution for 2 seconds so the user can see the tic tac toe cells
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
			}
		}
	}

}
