package fr.esiea.project.tetris.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2465995542035980113L;

	private JPanel board;
	
	public View() {
		
		setTitle("Tetris by BEMAT, GULL & WAN");
		setResizable(false);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		
		setLayout(new BorderLayout());
		
		board = new JPanel();
		add(board, BorderLayout.CENTER);
		
		setFocusable(true);
		setVisible(true);
		
	}
	
	public JPanel getBoard() {
		return this.board;
	}

	public void displayBoard() {
		// TODO Auto-generated method stub
		
	}
}
