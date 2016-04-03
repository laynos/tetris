package fr.esiea.project.tetris.model;

import java.util.Random;

public class Tetrimino {
	public static final int SIZEX = 4;
	public static final int SIZEY = 4;
	public final static int NUMBER_PIECES = 7;
	public int[][] tetriminoArray;
	public int posX;
	public int posY;
	public int[][][] arrayOrientations;
	private Random random;
	public int orientation;
	private int piece;
	//0
	private int [][][] piece1 = { { {0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0} } , 
			{ {0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0} } ,
			{ {0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0} } , 
			{ {0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0} } };

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
			{ {0,0,1,0},{0,1,1,0},{0,1,0,0},{0,0,0,0} } ,
			{ {0,1,1,0},{0,0,1,1},{0,0,0,0},{0,0,0,0} } , 
			{ {0,0,1,0},{0,1,1,0},{0,1,0,0},{0,0,0,0} } };

	//J
	private int [][][] piece6 = { { {0,0,1,0},{0,0,1,0},{0,1,1,0},{0,0,0,0} } , 
			{ {0,1,0,0},{0,1,1,1},{0,0,0,0},{0,0,0,0} } ,
			{ {0,1,1,0},{0,1,0,0},{0,1,0,0},{0,0,0,0} } , 
			{ {0,0,0,0},{1,1,1,0},{0,0,1,0},{0,0,0,0} } };

	//T
	private int [][][] piece7 = { { {0,1,0,0},{1,1,1,0},{0,0,0,0},{0,0,0,0} } , 
			{ {0,1,0,0},{0,1,1,0},{0,1,0,0},{0,0,0,0} } ,
			{ {1,1,1,0},{0,1,0,0},{0,0,0,0},{0,0,0,0} } , 
			{ {0,1,0,0},{1,1,0,0},{0,1,0,0},{0,0,0,0} } };


	private static Tetrimino INSTANCE = new Tetrimino();
	
	private Tetrimino() {
		random = new Random();
	}
	
	public static Tetrimino getInstance() {
		return INSTANCE;
	}

	void create() {
		piece = random.nextInt() % NUMBER_PIECES;
		posX = 0;
		posY = 3;
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
	
	public void left() {
		this.posY -=1;
	}
	
	public void right() {
		this.posY +=1;
	}
	
	public void down() {
		this.posX +=1;
	}
}
