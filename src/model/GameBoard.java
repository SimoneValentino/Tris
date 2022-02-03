package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GameBoard {

	public static void main(String[] args) {
		List<Player> players= new ArrayList<>();
		Scanner scn= new Scanner(System.in);
		//		Volevo gestire il control flow con un try con molteplici catch, uno per ogni eccezione con all'interno del catch
		//		una stampa del perchè è avvenuto e quale input evitare per risolvere il problema, chiamando poi il metodo playTurn
		//		e dare la possibilità di reinserire l'input adeguato.
		//		Però non ho capito perchè non parte il metodo, ho provato anche ad applicare il try catch dirattamente nel metodo,
		//		nella classe di utility Gamelogic però sebbene permetta di reinserire l'input pare che mantenga il precedente facendo
		//		partire un'altra exception.
		//		Alla fine ho optato per risolvere con dei classici if else.
		try {		

			System.out.print("Player 1 choose your name: ");

			Player player1= new Player(scn.next(),0);

			System.out.print("Player 2 choose youre name: ");

			Player player2= new Player(scn.next(),0);

			players.add(player1);
			players.add(player2);

			int menu=0;


			do {
				System.out.println("MENU: 1)Play, 2)Scoreboard, 3)exit");
				menu=scn.nextInt();
				switch(menu) {

				case 1:
					Player firstPlayer=GameLogic.firstPlayer(players);
					Player secondPlayer= GameLogic.secondPlayer(players, firstPlayer);



					System.out.println(firstPlayer.getName()+" starts with X mark!");
					System.out.println(secondPlayer.getName()+" plays next with O mark!");
					GameLogic.printBoard();

					System.out.println("Pick a number to place your mark!");
					GameLogic.play(firstPlayer,secondPlayer);
					System.out.println("play again? Y(1)/N(3)");
					menu=scn.nextInt();
					break;
				case 2:
					System.out.println(player1.getName()+" "+player1.getScore());
					System.out.println(player2.getName()+" "+player2.getScore());
					break;


				}
			}while(menu!=3);
			System.out.println("Thank you for playing!!!!");
		} catch (InputMismatchException e) {

			System.out.println("letters and special Characters not accepted!!!");

			e.printStackTrace();
			GameLogic.playTurn();

		}
		finally {
			scn.close();
		}


	}

}
