package fr.esiea.project.tetris.model;

public class Model {
	
	Score score;
	 Board board;
	 Tetrimino tetrimino;
	 int nextX;
	 int nextY;
	 	
	 public Model() {
		 score = new Score();
		 board = new Board();
		 tetrimino = new Tetrimino();
	 }

	 public void newTetrimino()
	 {
		 tetrimino.create();
		 nextX = 0;
		 nextY = 3;
	 }
}
