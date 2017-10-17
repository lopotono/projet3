package testFred;

import java.util.ArrayList;

public class Duel {

	public static void main(String[] args) {

		System.out.println("Recherche +/-");
		System.out.println("Mode duel");

		UserDuel gamer1 = new UserDuel();
		IADuel gamer2 = new IADuel();

		// ArrayList<Integer> codeUser = gamer1.getCode();
		ArrayList<Integer> codeIA = gamer2.generateCode();

		int nombreEssaisRestant = 10;

		ArrayList<Integer> proposition = null;
		String result = null;

		// Lancement du jeu
		while (nombreEssaisRestant > 0) {

			System.out.println("\nEtape 1 : saisir la combinaison");
			// générer la combinaison
			ArrayList<Integer> propositionUser = gamer1.getCode();
			ArrayList<Integer> propositionIA = gamer2.generateCode();
			// Vérification de la proposition User
			result = "";
			for (int i = 0; i < 4; i++) {
				if (propositionIA.get(i) == propositionUser.get(i)) {
					result += "=";
				} else if (propositionIA.get(i) < propositionUser.get(i)) {
					result += "-";
				} else
					result += "+";
			}
			System.out.print("\nProposition : ");
			for (int j = 0; j < 4; j++) {
				System.out.print(propositionUser.get(j));
			}
			System.out.print(" -> réponse : " + result);

			// Vérification de la proposition IA
			result = "";
			for (int i = 0; i < 4; i++) {
				if (propositionUser.get(i) == propositionIA.get(i)) {
					result += "=";
				} else if (propositionUser.get(i) < propositionIA.get(i)) {
					result += "-";
				} else
					result += "+";
			}
			// Affichage de la combinaison IA pour le test
			System.out.println("\nProposition IA : ");
			for (int j = 0; j < 4; j++) {
				System.out.print(propositionIA.get(j));
			}
			System.out.print(" -> réponse : " + result);

			if (result.equals("====")) {
				System.out.println("c'est gagné");
				nombreEssaisRestant = 0;
			}

			// Si combinaison trouvé fin, sinon relance 4 jusqu'à fin du nombre
			// d'essai possible
			nombreEssaisRestant--;

		}

	}

}

