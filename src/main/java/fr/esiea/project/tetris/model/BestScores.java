package fr.esiea.project.tetris.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BestScores {

	static final String path ="src/main/Scores.txt";

	static File file = new File(path);
	static FileWriter fw;
	static FileReader fr;
	// Indique le nombre de score présent dans le fichier
	public final static int NOMBRE_SCORE_STOCKE = 5;
	static int[] valeursrecuperees;

	public static int[] lectureFichierScore() throws IOException {
		//Lecture des scores
		fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr); 
		// On crée un scanner qui va récupérer les int
		Scanner scanner = new Scanner(file);
		int scorerecupere;
		int nombreligne=0;
		int[] valeursrecuperees= new int [NOMBRE_SCORE_STOCKE ];
		//Lecture des données
		// On lit les lignes une part une tant qu'il y en a encore
		while((br.readLine()) != null) {
			// NextInt permet de recupérer le prochain integer
			scorerecupere=scanner.nextInt();
			// On stocke la valeur recupérée dans un tableau
			valeursrecuperees[nombreligne]=scorerecupere;
			nombreligne++;


		}
		scanner.close();
		br.close();
		fr.close();


		// Retourne un talbeau contenaent l'ensemble des scores récupérés
		return valeursrecuperees;
	}

	public static void ecritureFichierScore(int score, int positionscore) throws IOException {
		// Ecriture dans le fichier
		fw = new FileWriter(file);
		for (int compteur = 0; compteur < positionscore ; compteur++) {
			//On écrit la chaîne
			fw.write(new Integer(score).toString());
			fw.write("\n");
		}

		//On ferme le flux
		fw.close();



	}
}
