package fr.esiea.project.tetris.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import fr.esiea.project.tetris.model.Board;

public class BoardPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2573176150569157208L;

	private JPanel[][] grid;
	private Color[] colors;
	
	public BoardPanel() {
		GridLayout gridLayout = new GridLayout(Board.NB_LINES,Board.NB_COL);
		setLayout(gridLayout);
		grid = new JPanel[Board.NB_LINES][Board.NB_COL];
		colors = new Color[8];
		
		this.initGrid();
		this.initColors();		
	}

	private void initGrid() {
		Dimension blockSize = new Dimension(30,30);
		for (int i = 0; i < Board.NB_LINES; i++)
		{
			for (int j = 0; j < Board.NB_COL; j++)
			{
				//nouvelle case de la grille en tant que jpanel
				grid[i][j] = new JPanel();
				grid[i][j].setPreferredSize(blockSize);
				grid[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
				add(grid[i][j]);
			}
		}
	}
	
	private void initColors() {
	      colors[0] = Color.WHITE;;
	      colors[1] = Color.CYAN;
	      colors[2] = Color.YELLOW;
	      colors[3] = Color.PINK;
	      colors[4] = Color.GREEN;
	      colors[5] = Color.RED;
	      colors[6] = Color.BLUE;
	      colors[7] = Color.ORANGE;
	}

	public void colorizeBoard(int[][] gridArray) {
		int id = 0;
		for (int i = 0; i<Board.NB_LINES; i++) {
			for (int j = 0; j<Board.NB_COL; j++) {
				id = gridArray[i][j];
				this.grid[i][j].setBackground(colors[id]);
			}
		}
	}
	
	public void colorizeTetrimino(int[][] gridArray, int[][] tetriminoArray, int tetX, int tetY) {
		int id = 0;
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<4; j++) {
				id = tetriminoArray[i][j];
				if (id != 0)
					this.grid[tetX+i][tetY+j].setBackground(colors[id]);
			}
		}
	}
	
	public JPanel[][] getGrid() {
		return this.grid;
	}
	
	public Color getColor(int id) {
		return colors[id];
	}
}
