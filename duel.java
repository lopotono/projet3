package testFred;

import java.util.ArrayList;

public class Duel {

	public static void main(String[] args) {

		System.out.println("Recherche +/-");
		System.out.println("Mode duel");

		UserDuel gamer1 = new UserDuel();
		IADuel gamer2 = new IADuel();

		ArrayList<Integer> codeIA = gamer2.generateCode();

		int nombreEssaisRestant = 10;

		// ArrayList<Integer> proposition = null;
		String resultIA = null;
		String resultUser = null;

		// Lancement du jeu
		while (nombreEssaisRestant > 0) {
			
			System.out.println("\nEtape 1 : saisir la combinaison");
			ArrayList<Integer> codeUserDuel = gamer1.getCode();			
			// générer la combinaison
			ArrayList<Integer> propositionUserDuel = gamer1.getCode();
			ArrayList<Integer> propositionIA = gamer2.generateCode();

			// Vérification de la proposition User
			resultIA = "";
			for (int i = 0; i < 4; i++) {
				if (propositionIA.get(i) == codeUserDuel.get(i)) {
					resultIA += "=";
				} else if (propositionIA.get(i) < codeUserDuel.get(i)) {
					resultIA += "-";
				} else
					resultIA += "+";
			}
			System.out.print("\nProposition : ");
			for (int j = 0; j < 4; j++) {
				System.out.print(propositionUserDuel.get(j));
			}
			System.out.print(" -> réponse : " + resultIA);

			propositionIA = gamer2.generateCode(propositionIA, resultIA);
			// Vérification de la proposition IA
			resultUser = "";
			for (int i = 0; i < 4; i++) {
				if (propositionUserDuel.get(i) == codeIA.get(i)) {
					resultUser += "=";
				} else if (propositionUserDuel.get(i) < codeIA.get(i)) {
					resultUser += "-";
				} else
					resultUser += "+";
			}
			// Affichage de la combinaison IA pour le test
			System.out.println("\nProposition IA : ");
			for (int j = 0; j < 4; j++) {
				System.out.print(propositionIA.get(j));
			}
			System.out.print(" -> réponse : " + resultUser);

			if (resultIA.equals("====")) {
				System.out.println("c'est gagné");
			} else if (resultUser.equals("====")) {
				System.out.println("c'est gagné");
				nombreEssaisRestant = 0;
			}
			// Si combinaison trouvé fin, sinon relance 4 jusqu'à fin du nombre
			// d'essai possible
			nombreEssaisRestant--;
		}

	}

}

