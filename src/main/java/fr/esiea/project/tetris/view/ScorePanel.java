package fr.esiea.project.tetris.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScorePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2785344968364921368L;
	private JLabel scoreValue;
	private JLabel scoreTitle;

	public ScorePanel() {
		GridLayout layout = new GridLayout(3,1);	
		setLayout(layout);
		this.scoreTitle = new JLabel("SCORE", SwingConstants.CENTER);
		this.scoreValue = new JLabel("0", SwingConstants.CENTER);
		scoreTitle.setPreferredSize(new Dimension(150,30));
		scoreValue.setPreferredSize(new Dimension(150,30));
		add(scoreTitle);
		add(scoreValue);
	}
	
	public void updateScore(int score) {
		scoreValue.setText(Integer.toString(score));
		//refresh
		scoreValue.setVisible(false);
		scoreValue.setVisible(true);
	}
	
	public String getScoreValue() {
		return scoreValue.getText();
	}
	
	public String getScoreTitle() {
		return scoreTitle.getText();
	}
	
	public void endScore(int score) {
		scoreTitle.setText("GAME OVER");
		scoreValue.setText("SCORE = "+Integer.toString(score));
		//refresh
		scoreTitle.setVisible(false);
		scoreValue.setVisible(false);
		scoreTitle.setVisible(true);
		scoreValue.setVisible(true);
	}
}