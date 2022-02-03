package model;





import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {

	private static String [] board=  {"1","2","3","4","5","6","7","8","9"};

	private static String mark= "X";
	private static Scanner scn= new Scanner(System.in);
	public static void printBoard() {

		System.out.println("|---|---|---|");
		System.out.println("| "+ board[0] +" | "+ board[1] +" | "+ board[2] +" |");
		System.out.println("|---|---|---|");
		System.out.println("| "+ board[3] +" | "+ board[4] +" | "+ board[5] +" |");
		System.out.println("|---|---|---|");
		System.out.println("| "+ board[6] +" | "+ board[7] +" | "+ board[8] +" |");
		System.out.println("|---|---|---|");
	}

	public static int randomStarter() {
		int max=2;
		Random r=new Random();
		int valGen=r.nextInt(max);
		return valGen;	
	}

	public static Player firstPlayer(List <Player> players) {

		Player firstPlayer=players.get(GameLogic.randomStarter());
		return firstPlayer;

	}

	public static Player secondPlayer(List <Player> players, Player firstPlayer) {

		Player secondPlayer;
		if(players.indexOf(firstPlayer)==0) {

			return secondPlayer=players.get(1);

		}
		else {

			return secondPlayer=players.get(0);
		}


	}



	public static void playTurn() throws InputMismatchException {

		int cell=scn.nextInt()-1;
		if(cell<=8){
			if(!(board[cell].equals("X")||board[cell].equals("O"))) {
				if(mark.equals("X")) {

					board[cell]=mark;
					printBoard();
					mark="O";

				}
				else if(mark.equals("O")) {
					board[cell]=mark;
					printBoard();
					mark="X";
				}
			}
			else {
				System.out.println("Cell already marked!");

				playTurn();

			}
		}
		else {
			System.out.println("pick a number between 1 and 9");

			playTurn();

		}
	}






	public static void play( Player firstPlayer, Player secondPlayer) {
		boolean winner=false;

		do {	

			for (int i = 0; i < 8; i++) {
				String combo=null;
				int counter=0;
				switch(i) {

				case 0: 
					combo=board[0]+board[1]+board[2];
					break;
				case 1: 
					combo=board[3]+board[4]+board[5];
					break;
				case 2: 
					combo=board[6]+board[7]+board[8];
					break;
				case 3: 
					combo=board[0]+board[3]+board[6];
					break;
				case 4: 
					combo=board[1]+board[4]+board[7];
					break;
				case 5: 
					combo=board[2]+board[5]+board[8];	
					break;
				case 6: 
					combo=board[0]+board[4]+board[8];	
					break;
				case 7: 
					combo=board[2]+board[4]+board[6];
					break;
				}

				if(combo.equals("XXX")) {

					System.out.println( firstPlayer.getName()+" wins the match!!!!");
					firstPlayer.setScore(firstPlayer.getScore()+1);
					winner=true;
					refreshArray();
					break;
				}
				else if(combo.equals("OOO")) {
					System.out.println( secondPlayer.getName()+" wins the match!!!!");
					secondPlayer.setScore(secondPlayer.getScore()+1);
					winner=true;
					refreshArray();
					break;
				}

				for (int j = 0; j < board.length; j++) {


					if(board[j].equals("X")||board[j].equals("O")) {

						counter++;
						if(counter==9) {
							System.out.println("Draw!!!");
							winner=true;
							refreshArray();
							break;
						}
					}

				}


			}
			if(winner==false) {
				playTurn();
			}
		}while(winner==false);

	}



	public static void refreshArray() {

		for (int i = 0; i < board.length; i++) {

			board[i]=""+(i+1);

		}

	}

}








