package fr.esiea.project.tetris.model;

public class Model {

	private Score score;
	private Board board;
	private Tetrimino tetrimino;
	private int nextX;
	private int nextY;
	private int[][] nextArray;
	
	public Model() {
		score = new Score();
		board = new Board();
		tetrimino = Tetrimino.getInstance();
		this.newTetrimino();
		board.init();
		nextArray = tetrimino.tetriminoArray;
	}
	
	public Score getScore() {
		return this.score;
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public Tetrimino getTetrimino(){
		return this.tetrimino;
	}
	
	public void newTetrimino()
	{
		tetrimino.create();
		nextX = 0;
		nextY = 3;
	}
	
	public boolean checkEndOfGame() {
		//collision décor dès le placement de la pièce
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
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
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
				//anchor only colored block :)
				if (tetrimino.tetriminoArray[i][j] != 0)
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
		if (blocked_decor())
			return false;
		tetrimino.turn();
		return true;
	}
	
	public boolean moveLeft() {
		nextY = tetrimino.posY - 1;
		nextArray = tetrimino.tetriminoArray;
		if (blocked_left())
		{
			nextY = tetrimino.posY;
			return false;
		}
		if (blocked_decor())
		{
			nextY = tetrimino.posY;
			return false;
		}
		tetrimino.left();
		return true;
	}

	public boolean moveRight() {
		nextY = tetrimino.posY + 1;
		nextArray = tetrimino.tetriminoArray;
		if (blocked_right())
		{
			nextY = tetrimino.posY;
			return false;
		}
		if (blocked_decor())
		{
			nextY = tetrimino.posY;
			return false;
		}
		tetrimino.right();
		return true;
	}

	public boolean moveDown() {
		nextX = tetrimino.posX + 1;
		nextArray = tetrimino.tetriminoArray;
		if (blocked_down())
		{
			nextY = tetrimino.posY;
			return false;
		}
		if (blocked_decor())
		{
			nextY = tetrimino.posY;
			return false;
		}
		tetrimino.down();
		return true;
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
		//collision bord bas
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
				if ((nextX+i >= Board.NB_LINES) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean blocked_left() {
		//collision bord gauche
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
				if ((nextY+j < 0) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean blocked_right() {
		//collision bord droit
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
				if ((nextY+j >= Board.NB_COL) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		return false;
	}

	
}
