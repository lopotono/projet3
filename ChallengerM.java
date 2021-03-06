
package fr.projet3.jeux;

import java.util.ArrayList;

public class ChallengerM {

	public void run() {

		User gamer1 = new User();
		IA gamer2 = new IA();

		// générer une combinaison aléatoire
		ArrayList<Integer> code = gamer2.generateCode();

		// déterminer le nombre d'essais
		int nombreEssais = 10;

		while (nombreEssais > 0) {
			
			System.out.println("\nSaisir une combinaison à 4 chiffres : ");
			ArrayList<Integer> proposition = gamer1.getCode();

			int bienPlace = 0;
			int present = 0;

			// vérification de la proposition");
			System.out.print("Proposition : ");
			for (int j = 0; j < 4; j++) {
				System.out.print(proposition.get(j));
			}
			System.out.print(" -> réponse : ");

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
			}
			System.out.print(bienPlace + " bien placé(s) " + present + " présent(s) ");

			if (bienPlace == 4) {
				System.out.println("\nc'est gagné !");
				nombreEssais = 0;
			}
			nombreEssais--;
		}
	}
}
