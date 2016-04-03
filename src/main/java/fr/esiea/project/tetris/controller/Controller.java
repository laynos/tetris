package fr.esiea.project.tetris.controller;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.esiea.project.tetris.model.Model;
import fr.esiea.project.tetris.model.Score;
import fr.esiea.project.tetris.view.View;

public class Controller {
	private Model model;
	private View view;

	private int keyCode;
	private Score score;
	private boolean endOfGame;
	private KeyListener keyListener;

	public Controller() {
		this.model = new Model();
		this.view = new View();
		this.score = new Score();
		this.endOfGame = false;
  		view = new View();
		this.keyListener = new KeyListener() {

			public void keyPressed(KeyEvent e){

				keyCode = e.getKeyCode();

				if(keyCode == KeyEvent.VK_LEFT){
					if (model.moveLeft()) {
						view.displayBoard();
					}
				}

				if(keyCode == KeyEvent.VK_RIGHT){
					if (model.moveRight()) {
						view.displayBoard();
					}
				}

				if(keyCode == KeyEvent.VK_DOWN){
					if (model.moveDown()) {
						view.displayBoard();
					}
				}

				if(keyCode == KeyEvent.VK_SPACE){
					if (model.turnTetrimino()) {
						view.displayBoard();
					}
				}
				e.consume();
			}
			
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {}
		};

		view.addKeyListener(keyListener);
		
		while (! endOfGame) {
			if (model.moveDown()) {
				view.displayBoard();
			}
			else {
				this.step();
			}
		}
		this.end();
	}

	private void end() {
		// TODO Auto-generated method stub
		
	}

	private void step() {
		score.scoreUp(model.board.checkLines());
		model.anchorTetrimino();
		model.newTetrimino();
		view.displayBoard();
		endOfGame = model.checkEndOfGame();
		
	}		  	
}
