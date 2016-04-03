package fr.esiea.project.tetris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.esiea.project.tetris.model.Board;
import fr.esiea.project.tetris.model.Model;

public class GameStepTest {

	@Test
	public void shouldAnchorTetrimino() {
		Model model = new Model();
		int tetPosX = model.getTetrimino().posX;
		int tetPosY = model.getTetrimino().posY;
		model.anchorTetrimino();
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<4; j++) {
				if (model.getTetrimino().tetriminoArray[i][j] != 0) {
					assertEquals(model.getBoard().boardArray[tetPosX+i][tetPosY+j],model.getTetrimino().tetriminoArray[i][j]);
				}
			}
		}
	}
	
	@Test
	public void shouldCheckEndOfGame() {
		Model model = new Model();
		//fill virtually the top lines of the board
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<10; j++) {
				model.getBoard().boardArray[i][j]=1;
			}
		}
		assertTrue(model.checkEndOfGame());	
	}
	
	@Test
	public void shouldCheckLine() {
		Model model = new Model();
		//fill virtually the bottom line of the board
		for (int j = 0; j<10; j++) {
			model.getBoard().boardArray[Board.NB_LINES-1][j]=1;
		}
		assertEquals(model.getBoard().checkLine(),1);
	}
	
	@Test
	public void shouldCleanLine() {
		Model model = new Model();
		//fill virtually the bottom line of the board
		for (int j = 0; j<10; j++) {
			model.getBoard().boardArray[15][j]=1;
		}
		model.getBoard().cleanLine(15);
		for (int j = 0; j<10; j++) {
			assertEquals(model.getBoard().boardArray[15][j],0);
		}
	}
}
