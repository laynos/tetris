package fr.esiea.project.tetris.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	public void keyPressed(KeyEvent arg0) {

		if (arg0.getKeyCode()== KeyEvent.VK_UP){
			
		}
		
		if (arg0.getKeyCode()== KeyEvent.VK_DOWN){
			
		}
		
		if (arg0.getKeyCode()== KeyEvent.VK_LEFT){
	
		}
		
		if (arg0.getKeyCode()== KeyEvent.VK_RIGHT){
	
		}
		
		if (arg0.getKeyCode()== KeyEvent.VK_P){
			Game.pause();
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
