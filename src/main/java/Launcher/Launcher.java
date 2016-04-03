package Launcher;

import Board.Board;
import Board.Game;

public class Launcher {

	public static void main(String[] args) {
		
		Board Board = new Board();
		Board.init();
		
		while(Game.done() == false){
			Board.go();
		}
	}

}
