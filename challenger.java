package fr.projet3.jeux;

import java.util.ArrayList;

public class Challenger {

	public void run() {

		User gamer1 = new User();
		IA gamer2 = new IA();

		// générer la combinaison
		ArrayList<Integer> code = gamer2.generateCode();

		// Déterminer le nombre limité d'essai
		int nombreEssaisRestant = 10; // TODO : Récupérer cette valeur dans un
										// fichier
										// de configuration.
		// Lancer le jeu
		while (nombreEssaisRestant > 0) {
			
			System.out.println("\nSaisir une combinaison à 4 chiffres : ");
			ArrayList<Integer> proposition = gamer1.getCode();

			System.out.print("Proposition : ");
			for (int j = 0; j < 4; j++) {
				System.out.print(proposition.get(j));
			}
			System.out.print(" -> réponse : ");

			// Vérifier la proposition
			String result = "";

			for (int i = 0; i < 4; i++) {
				if (code.get(i) == proposition.get(i)) {
					result += "=";
				} else if (code.get(i) < proposition.get(i)) {
					result += "-";
				} else
					result += "+";
			}
			System.out.println(result);
			// Afficher le retour (combinaison trouvé ou non)
			if (result.equals("====")) {
				System.out.println("BRAVO c'est gagné !");
				nombreEssaisRestant = 0;
			}						
			nombreEssaisRestant--;
			
			
		}
	}
}

