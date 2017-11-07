

package fr.projet3.jeux;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

public class DefenserM {

	public void run() {

		User gamer1 = new User();
		IADefM gamer2 = new IADefM();

		// Saisir une combinaison
		System.out.println("\nSaisir une combinaison à 4 chiffres : ");

		ArrayList<Integer> code = gamer1.getCode();

		// nombre d'essais
		int nombreEssais = 10;

		ArrayList<Integer> proposition = null;
		int result = 0;
		// Lancement du jeu

		while (nombreEssais > 0) {

			int bienPlace = 0;
			int present = 0;
						
			proposition = gamer2.generateCode(proposition, result);
			// Vérification de la proposition
			ArrayList<Integer> temp = new ArrayList<Integer>();
			// Etape 1 : parcourir la proposition
			for (int i = 0; i < 4; i++) {
				int value = proposition.get(i);
				// Etape 2 : si la proposition est bien placé, incrémenté bien
				// placé et ajouter la valeur dans temp
				if (code.get(i) == value) {
					bienPlace++;
					temp.add(value);
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
				result = 0;
				System.out.print("\nProposition : ");
				for (int j = 0; j < 4; j++) {
					System.out.print(value);
				}
				System.out.print(" -> réponse : " + bienPlace + " bien placé(s) " + present + " présent(s) ");
				System.out.println();

				if (bienPlace == 4) {
					System.out.println("\nBRAVO c'est gagné !");
					nombreEssais = 0;
				}
				nombreEssais--;
			}
		}
	}
}
