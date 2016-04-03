package fr.esiea.project.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.esiea.project.tetris.view.ScorePanel;

public class ScoreViewTest {

	@Test
	public void shouldUpdateScore() {
		ScorePanel scorePanel = new ScorePanel();
		scorePanel.updateScore(10);
		assertEquals(scorePanel.getScoreValue(),"10");
	}
	
	@Test
	public void shouldUpdateScoreEnd() {
		ScorePanel scorePanel = new ScorePanel();
		scorePanel.endScore(10);
		assertEquals(scorePanel.getScoreValue(),"SCORE = 10");
		assertEquals(scorePanel.getScoreTitle(),"GAME OVER");
	}
}
