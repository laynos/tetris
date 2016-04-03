package fr.esiea.project.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.esiea.project.tetris.model.Board;
import fr.esiea.project.tetris.model.Tetrimino;
import fr.esiea.project.tetris.view.BoardPanel;
import fr.esiea.project.tetris.view.View;

public class ViewTest {


	@Test
	public void shouldDisplayBoard() {
		View view = new View();
		BoardPanel boardPanel = view.getBoard();
		Board board = new Board();
		int[][] gridArray = board.boardArray;
		Tetrimino tetrimino = Tetrimino.getInstance();
		tetrimino.create();
		view.displayBoard(gridArray, tetrimino.tetriminoArray, tetrimino.posX, tetrimino.posY);
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<4; j++) {
				if (tetrimino.tetriminoArray[i][j] != 0) {
					assertEquals((boardPanel.getGrid())[tetrimino.posX+i][tetrimino.posY+j].getBackground(),
							boardPanel.getColor(tetrimino.tetriminoArray[i][j]));
				}
			}
		}
	}
}
