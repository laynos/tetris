package fr.esiea.project.tetris.controller;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.esiea.project.tetris.model.Model;
import fr.esiea.project.tetris.view.View;

public class Controller {
	private Model model;
	private View view;
	private KeyListener keyListener;
	private int keyCode;
	private boolean endOfGame; 
	private long currentTime;
	private long nextStepTime;
	
	public Controller() {
		this.model = new Model();
		this.view = new View();
		this.endOfGame = false;
		this.keyCode = 0;
		this.currentTime = 0;
		this.nextStepTime = 0;
		
		this.keyListener = new KeyListener() {

			public void keyPressed(KeyEvent e){

				keyCode = e.getKeyCode();

				if(keyCode == KeyEvent.VK_LEFT){
					if (model.moveLeft()) {
						view.displayBoard(model.getBoard().boardArray,
										  model.getTetrimino().tetriminoArray,
										  model.getTetrimino().posX,
										  model.getTetrimino().posY);
					}
				}

				if(keyCode == KeyEvent.VK_RIGHT){
					if (model.moveRight()) {
						view.displayBoard(model.getBoard().boardArray,
										  model.getTetrimino().tetriminoArray,
										  model.getTetrimino().posX,
										  model.getTetrimino().posY);
					}
				}

				if(keyCode == KeyEvent.VK_DOWN){
					if (model.moveDown()) {
						view.displayBoard(model.getBoard().boardArray,
										  model.getTetrimino().tetriminoArray,
										  model.getTetrimino().posX,
										  model.getTetrimino().posY);
					}
				}

				if(keyCode == KeyEvent.VK_UP){
					if (model.turnTetrimino()) {
						view.displayBoard(model.getBoard().boardArray,
										  model.getTetrimino().tetriminoArray,
										  model.getTetrimino().posX,
										  model.getTetrimino().posY);
					}
				}
				e.consume();
			}
			
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {}
		};

		view.addKeyListener(keyListener);	
	}
	
	public void play()
	{
		this.gameLoop();
		this.notifyEnd();
	}
	
	private void gameLoop() {
		while (! endOfGame) {
			//wait for step
			currentTime = System.currentTimeMillis();
			nextStepTime = currentTime + 500;
			while(nextStepTime - currentTime > 0)
				currentTime = System.currentTimeMillis();
			
			if (model.moveDown()) {
				view.displayBoard(model.getBoard().boardArray,
								  model.getTetrimino().tetriminoArray,
								  model.getTetrimino().posX,
								  model.getTetrimino().posY);
			}
			else {
				this.step();
			}
		}
	}
	
	private void step() {
		//on ajoute la pièce à la grille
		model.anchorTetrimino();
		//si des lignes sont complètes, on clean et on incrémente le score
		model.getScore().incrementScore(model.getBoard().checkLine());
		view.updateScore(model.getScore().getScore());
		model.newTetrimino();
		view.displayBoard(model.getBoard().boardArray,
						  model.getTetrimino().tetriminoArray,
						  model.getTetrimino().posX,
						  model.getTetrimino().posY);
		endOfGame = model.checkEndOfGame();
	}
	
	private void notifyEnd(){
		view.end(model.getScore().getScore());
	}
}
