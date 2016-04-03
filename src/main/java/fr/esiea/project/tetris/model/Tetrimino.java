package fr.esiea.project.tetris.model;

import java.util.Random;

public class Tetrimino {
	final int NUMBER_PIECES = 7;
	private Random random;
	private int piece;
	//0
	private int [][][] piece1 = { { {0,1,1,0},{0,1,1,0},{0,1,1,0},{0,1,1,0} } , 
			{ {0,1,1,0},{0,1,1,0},{0,1,1,0},{0,1,1,0} } ,
			{ {0,1,1,0},{0,1,1,0},{0,1,1,0},{0,1,1,0} } , 
			{ {0,1,1,0},{0,1,1,0},{0,1,1,0},{0,1,1,0} } };
	
	//L
	private int [][][] piece2 = { { {0,1,0,0},{0,1,0,0},{0,1,1,0},{0,0,0,0} } , 
			{ {0,0,0,0},{0,1,1,1},{0,1,0,0},{0,0,0,0} } ,
			{ {0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0} } , 
			{ {0,0,1,0},{1,1,1,0},{0,0,0,0},{0,0,0,0} } };
	
	//I
	private int [][][] piece3 = { { {1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0} } , 
			{ {0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0} } ,
			{ {1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0} } , 
			{ {0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0} } };
	
	//s
	private int [][][] piece4 = { { {0,1,1,0},{1,1,0,0},{0,0,0,0},{0,0,0,0} } , 
			{ {0,1,0,0},{0,1,1,0},{0,0,1,0},{0,0,0,0} } ,
			{ {0,1,1,0},{1,1,0,0},{0,0,0,0},{0,0,0,0} } , 
			{ {0,1,0,0},{0,1,1,0},{0,0,1,0},{0,0,0,0} } };
	//z
	private int [][][] piece5 = { { {0,1,1,0},{0,0,1,1},{0,0,0,0},{0,0,0,0} } , 
			{ {0,0,1,0},{0,1,1,0},{0,0,1,0},{0,0,0,0} } ,
			{ {0,1,1,0},{0,0,1,1},{0,0,0,0},{0,0,0,0} } , 
			{ {0,0,1,0},{0,1,1,0},{0,0,1,0},{0,0,0,0} } };
	
	//J
	private int [][][] piece6 = { { {0,0,1,0},{0,0,1,0},{0,0,1,0},{0,1,1,0} } , 
			{ {0,1,0,0},{0,1,1,1},{0,0,0,0},{0,0,0,0} } ,
			{ {0,1,1,0},{0,1,0,0},{0,1,0,0},{0,0,0,0} } , 
			{ {0,0,0,0},{1,1,1,0},{0,0,1,0},{0,0,0,0} } };
	
	//T
	private int [][][] piece7 = { { {0,1,0,0},{1,1,1,0},{0,0,0,0},{0,0,0,0} } , 
			{ {0,1,0,0},{0,1,1,0},{0,1,0,0},{0,0,0,0} } ,
			{ {1,1,1,0},{0,1,0,0},{0,0,0,0},{0,0,0,0} } , 
			{ {0,1,0,0},{1,1,0,0},{0,1,0,0},{0,0,0,0} } };
	
	private int posY;
	private int posX;
	private int orientation;
	private int[][][] arrayOrientations;
	private int[][] tetriminoArray;
	
	public Tetrimino() {
		random = new Random();
		
	}

	void create() {
		piece = random.nextInt() % NUMBER_PIECES;
		setPosX(0);
		setPosY(3);
		orientation = 0;
		switch(piece) {
		case 0:
			this.arrayOrientations = piece1;
			break;
		case 1:
			this.arrayOrientations = piece2;
			break;
		case 2:
			this.arrayOrientations = piece3;
			break;
		case 3:
			this.arrayOrientations = piece4;
			break;
		case 4:
			this.arrayOrientations = piece5;
			break;
		case 5:
			this.arrayOrientations = piece6;
			break;
		case 6:
			this.arrayOrientations = piece7;
			break;
		}
		this.tetriminoArray = arrayOrientations[orientation];
	}
	
	public void turn() {
		this.orientation = (orientation+1)%4;
		this.tetriminoArray = arrayOrientations[orientation];
	}
	
	public void goLeft() {
		this.setPosY(this.getPosY() - 1);
	}
	
	public void goRight() {
		this.setPosY(this.getPosY() + 1);
	}
	
	public void goDown() {
		this.setPosX(this.getPosX() + 1);
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}
}
