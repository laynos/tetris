package fr.esiea.project.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.esiea.project.tetris.model.Score;

public class ScoreTest {

	@Test
	public void shouldCreateScore() {
		Score score = new Score();
		assertEquals(score.getScore(),0);
	}
	
	@Test
	public void shouldIncrementScore() {
		Score score = new Score();
		score.incrementScore(1);
		assertEquals(score.getScore(),10);
	}
}
