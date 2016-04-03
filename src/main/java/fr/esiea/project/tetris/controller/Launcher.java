package fr.esiea.project.tetris.controller;

import fr.esiea.project.tetris.model.Board;

public class Launcher {

	public static void main(String[] args) {
		
		Board Board = new Board();
		
		while(Game.done() == false){
			Board.go();
		}
	}

}
