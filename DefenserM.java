


package fr.projet3.jeux;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;

public class DefenserM {

	public void run() {

		User gamer1 = new User();
		IADefM gamer2 = new IADefM();

		// Saisir une combinaison
		System.out.println("\nSaisir une combinaison à 4 chiffres : ");

		ArrayList<Integer> code = gamer1.getCode();
		
		Properties properties = new Properties();

		try {
			FileInputStream in = new FileInputStream("D://workspace/fr.projet3.jeux/src/fr/projet3/jeux/config.properties");
			properties.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println("Erreur");
		}
		
		int nombreEssaisM = Integer.parseInt(properties.getProperty("nombreEssaisM"));
		// TODO : Récupérer cette valeur dans un fichier de configuration.
		ArrayList<Integer> proposition = null;
		
		// Lancement du jeu
		while (nombreEssaisM > 0) {

			int bienPlace = 0;
			int present = 0;
						
			proposition = gamer2.generateCode();
			// Vérification de la proposition
			ArrayList<Integer> temp = new ArrayList<Integer>();
			// Parcourir la proposition
			for (int i = 0; i < 4; i++) {
				int value = proposition.get(i);
				// Si la proposition est bien placé, incrémenté bien
				// placé et ajouter la valeur dans temp
				if (code.get(i) == value) {
					bienPlace++;
				} else if (code.contains(value)) {
					int res = Helper.getNbValueInArray(value, code);
					// Cas n°1 : il n'est pas bien placé
					if (temp.contains(value) && res > 1) {
						present++;
						// Cas n°2 : il est bien placé
					} else if (!temp.contains(value)) {
						present++;
					}
				}
				System.out.print("\nProposition : ");
				for (int j = 0; j < 4; j++) {
					System.out.print(value);
				}
				System.out.print(" -> réponse : " + bienPlace + " bien placé(s) " + present + " présent(s) ");
				System.out.println();

				if (bienPlace == 4) {
					System.out.println("\nBRAVO c'est gagné !");
					nombreEssaisM = 0;
				}
				nombreEssaisM--;
			}
		}
	}
}
