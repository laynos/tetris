package fr.esiea.project.tetris.model;


public class Board {
	public int[][] boardArray;
	public final static int NB_LINES = 16;
	public final static int NB_COL = 10;

	public Board() {
		boardArray = new int[NB_LINES][NB_COL];
	}

	public void init() {
		for (int i = 0; i < NB_LINES; i++){
			for (int j = 0; j < NB_COL; j++) {
				boardArray[i][j] = 0;
			}
		}
	}

	public int checkLine() {
		int lines = 0;
		boolean isLineComplete;
		for (int i = NB_LINES; i > 0; i--){
			isLineComplete = true;
			for (int j = 0; j < NB_COL; j++) {
				if (boardArray[i][j] == 0) {
					isLineComplete = false;
					break;
				}
			}
			if (isLineComplete) {
				System.out.println("line "+Integer.toString(i)+" complete");
				lines++;
				cleanLine(i);
				isLineComplete = false;
				//la ligne est descendue, il faut la revérifier
				i++;
			}
		}
		return lines;
	}

	public void cleanLine(int lineToClean){
		System.out.println("Clean line "+Integer.toString(lineToClean));
		for (int i = lineToClean; i >= 0; i--){
			for (int j = 0; j < NB_COL; j++) {
				//on vide la ligne
				boardArray[i][j] = 0;
				//décallage ligne vers le bas
				if (i>0)
					boardArray[i][j] = boardArray[i-1][j];
			}
		}
		for (int j = 0; j < NB_COL; j++) {
			//ligne du haut remise à 0
			boardArray[0][j] = 0;
		}
	}
}
