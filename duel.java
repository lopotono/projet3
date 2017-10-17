package testFred;

import java.util.ArrayList;

public class Duel {

	public static void main(String[] args) {

		System.out.println("Recherche +/-");
		System.out.println("Mode duel");

		User gamer1 = new User();
		IA gamer2 = new IA();

		ArrayList<Integer> code = gamer2.generateCode();

		int nombreEssaisRestant = 10;

		ArrayList<Integer> combinaison = null;
		String result = null;

		// Lancement du jeu
		while (nombreEssaisRestant > 0) {

			System.out.println("\nEtape 1 : saisir la combinaison");
			// générer la combinaison
			ArrayList<Integer> proposition = gamer1.getCode();
			
			//Vérification de la proposition User
			result = "";
			for (int i = 0; i < 4; i++) {
				if (code.get(i) == proposition.get(i)) {
					result += "=";
				} else if (code.get(i) < proposition.get(i)) {
					result += "-";
				} else
					result += "+";
			}			
			System.out.print("Proposition : ");
			for (int j = 0; j < 4; j++){
				System.out.print(proposition.get(j));					
				}
			System.out.print(" -> réponse : " + result);
			
			//Vérification de la proposition IA
			combinaison = gamer2.generateCode(code, result);
			result = "";
			for (int i = 0; i < 4; i++) {
				if (code.get(i) == combinaison.get(i)) {
					result += "=";
				} else if (code.get(i) < combinaison.get(i)) {
					result += "-";
				} else
					result += "+";				
			}
			//Affichage de la combinaison IA pour le test
			System.out.println("\nProposition IA : ");
			for (int j = 0; j < 4; j++){
				System.out.print(combinaison.get(j));					
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

