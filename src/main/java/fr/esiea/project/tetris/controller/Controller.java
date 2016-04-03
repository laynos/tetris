package fr.esiea.project.tetris.controller;



import fr.esiea.project.tetris.model.Model;
import fr.esiea.project.tetris.view.View;

public class Controller {
	private Model model;
	private View view;

	private int keyCode;

	public Controller() {
		model = new Model();
  		view = new View();
	}		  	
}
