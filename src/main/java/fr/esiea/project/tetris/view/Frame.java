package fr.esiea.project.tetris.view;

import javax.swing.JFrame;

import fr.esiea.project.tetris.controller.Keyboard;

public class Frame {

	public Frame() {
		JFrame frame = new JFrame();
		

		frame.setTitle("Tetris by BEMAT, GULL & WAN");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.addKeyListener(new Keyboard());
		
		frame.setSize(800, 600);
		frame.setFocusable(true);
		frame.setVisible(true);
		
	}

}
