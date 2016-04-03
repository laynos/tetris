package fr.esiea.project.tetris.model;


public class Board {

	int [][] boardArray;
	private final int NB_LINES = 20;
	private final int NB_COL = 10;
	
	public Board(){
		boardArray = new int[NB_LINES][NB_COL];
		init();
	}

	public void init() {
		for (int i = 0; i < NB_LINES; i++){
			for (int j = 0; j < NB_COL; j++) {
				boardArray[i][j] = 0;
			}
		}
	}
	
	public int checkLines() {
		int lines = 0;
		boolean isComplete;
		for (int i = 0; i < NB_LINES; i++){
			isComplete = true;
			for (int j = 0; j < NB_COL; j++) {
				if (boardArray[i][j] == 0){
					isComplete = false;
					break;
				}
			}
			if (isComplete) {
				lines++;
				cleanLine(i);
				isComplete = false;
			}
		}
		return lines;
	}
	
	public void cleanLine(int lineToClean) {
		for (int i = NB_LINES; i <= 0; i--){
			for (int j = 0; j < NB_COL; j++) {
				//décallage ligne vers le bas
				boardArray[i][j] = boardArray[i-1][j];
			}
		}
		for (int j = 0; j < NB_COL; j++) {
			//ligne du haut remise à 0
			boardArray[0][j] = 0;
		}
	}

}
