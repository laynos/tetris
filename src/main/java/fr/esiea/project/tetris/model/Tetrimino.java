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
	
	public Tetrimino() {
		random = new Random();
		
	}

	@SuppressWarnings("unused")
	private int[][][] create() {
		piece = random.nextInt() % NUMBER_PIECES;
		switch(piece) {
		case 0:
			return piece1;
		case 1:
			return piece2;
		case 2:
			return piece3;
		case 3:
			return piece4;
		case 4:
			return piece5;
		case 5:
			return piece6;
		case 6:
			return piece7;
		default:return null;
		}
	}
}
