package testFred;

import java.util.ArrayList;

public class Duel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Recherche +/-");
		System.out.println("Mode duel");

		UserDuel gamer1 = new UserDuel();
		IADuel gamer2 = new IADuel();

		ArrayList<Integer> codeIA = gamer2.generateCode();
		ArrayList<Integer> codeUserDuel = gamer1.getCode();
		// nombre total d'essais
		int nombreEssaisRestant = 10;
				
		// lancement du jeu
		while (nombreEssaisRestant > 0) {
			System.out.println("saisir la combinaison");
			ArrayList<Integer> propositionUserDuel = gamer1.getCode();

			System.out.print("Proposition : ");
			for (int j = 0; j < 4; j++) {
				System.out.print(propositionUserDuel.get(j));
			}
			System.out.print(" -> réponse : ");

			// vérification de la proposition user par IA
			String resultIA = "";
			for (int i = 0; i < 4; i++) {
				if (codeIA.get(i) == propositionUserDuel.get(i)) {
					resultIA += "=";
				} else if (codeIA.get(i) < propositionUserDuel.get(i)) {
					resultIA += "-";
				} else
					resultIA += "+";
			}
			System.out.println(resultIA);
			
			ArrayList<Integer> propositionIA = gamer2.generateCode();
			propositionIA = gamer2.generateCode(propositionIA, resultIA);
			// vérification de la proposition IA
			String resultUser = "";
			System.out.print("Proposition : ");
			for (int j = 0; j < 4; j++){
				System.out.print(propositionIA.get(j));					
				}
			System.out.print(" -> réponse : ");
			
			for (int i = 0; i < 4; i++) {
				if (codeUserDuel.get(i) == propositionIA.get(i)) {
					resultUser += "=";
				} else if (codeUserDuel.get(i) < propositionIA.get(i)) {
					resultUser += "-";
				} else
					resultUser += "+";
			}
			System.out.println(resultUser);

			if (resultIA.equals("====")) 
				System.out.println("c'est gagné");
			else if (resultUser.equals("===="));
				System.out.println("c'est gagné");
			
				nombreEssaisRestant = 0;
			}

			// Si combinaison trouvé fin, sinon relance 4 jusqu'à fin du nombre
			// d'essai possible
			nombreEssaisRestant--;

		}
}


