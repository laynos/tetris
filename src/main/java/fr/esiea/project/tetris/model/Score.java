package fr.esiea.project.tetris.model;

public class Score {
	private int score;
	
	public Score() {
		this.score = 0;
	}
	
	public  void scoreUp(int nbLines) {
		score += nbLines;
	}
	
	public int getScore() {
		return score;
	}

}
