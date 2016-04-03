package fr.esiea.project.tetris.model;

public class Model {

	public Score score;
	public Board board;
	public Tetrimino tetrimino;
	int nextX;
	int nextY;
	private int[][] nextArray;

	public Model() {
		score = new Score();
		board = new Board();
		tetrimino = new Tetrimino();
		this.newTetrimino();
	}

	public void newTetrimino()
	{
		tetrimino.create();
		nextX = 0;
		nextY = 3;
	}

	public boolean checkEndOfGame() {
		//collision décor dès le placement de la pièce
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				if ((board.boardArray[nextX+i][nextY+j] != 0) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public void anchorTetrimino() {
		nextX = tetrimino.posX;
		nextY = tetrimino.posY;
		// ajout du Tetrimino à la board avant de passer au suivant
		for (int i = 0; i < Board.NB_LINES; i++){
			for (int j = 0; j < Board.NB_COL; j++) {
				board.boardArray[nextX+i][nextY+j] = tetrimino.tetriminoArray[i][j];
			}
		}
	}

	public boolean turnTetrimino() {
		nextArray = tetrimino.arrayOrientations[(tetrimino.orientation+1)%4];
		if (blocked_left())
			return false;
		if (blocked_right())
			return false;
		if (blocked_down())
			return false;
		if (blocked_decor()){
			return false;
		}
		tetrimino.turn();
		return true;
	}

	public boolean moveLeft() {
		nextY = tetrimino.posY - 1;
		nextArray = tetrimino.tetriminoArray;
		if (! blocked_decor()) {
			tetrimino.goLeft();
			return true;
		}
		return false;
	}

	public boolean moveRight() {
		nextY = tetrimino.posY + 1;
		nextArray = tetrimino.tetriminoArray;
		if (! blocked_decor()) {
			tetrimino.goRight();
			return true;
		}
		return false;
	}

	public boolean moveDown() {
		nextX = tetrimino.posX + 1;
		nextArray = tetrimino.tetriminoArray;
		if (! blocked_decor()) {
			tetrimino.goDown();
			return true;
		}
		return false;
	}
	private boolean blocked_decor(){
		//collision décor
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
				//prevent outofbond
				if (nextArray[i][j] != 0) {
					if (board.boardArray[nextX+i][nextY+j] != 0) 
						return true;
				}
			}
		}
		return false;
	}


	private boolean blocked_down() {
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				if ((nextX+i >= 20) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean blocked_left() {
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				if ((nextY+j < 0) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean blocked_right() {
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				if ((nextY+j >= 10) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		return false;
	}
}
