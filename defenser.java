package testFred;

import java.util.ArrayList;

public class Defenser {

	public static void main(String[] args) {
		System.out.println("Recherche +/-");
		System.out.println("Mode defenser");
		
		User gamer1 = new User();
		IA gamer2 = new IA();
		
		System.out.println("Etape 1 : saisir la combinaison");
		
		ArrayList<Integer> code = gamer1.getCode();
		
		System.out.println("Etape 2 : Déterminer le nombre limité d'essai");
		
		int nombreEssaisRestant = 10; // TODO : Récupérer cette valeur dans un fichier de configuration.
		
		System.out.println("Etape 3 : Lancer le jeu");
		
		
		ArrayList<Integer> proposition = null;
		String result = null;
		
		while(nombreEssaisRestant > 0) {
		
			System.out.println("Etape 4 : Faire proposition");
			
			proposition = gamer2.generateCode(proposition, result);

			System.out.print("Proposition : ");
			for (int j = 0; j < 4; j++){
				System.out.print(proposition.get(j));					
				}
			System.out.print(" -> réponse : ");
			
			System.out.println("Etape 5 : Vérifier la proposition");
		
			for (int i = 0; i < 4; i++) {
				if (code.get(i) == proposition.get(i)) {
					result += "=";
				} else if (code.get(i) < proposition.get(i)) {
					result += "-";
				} else
					result += "+";
			}
			
			System.out.println("Etape 6 : Afficher le retour (combinaison trouvé ou non");
			System.out.println(result);
			System.out.println(result);
			
			if(result.equals("====")){
				System.out.println("c'est gagné");
				nombreEssaisRestant = 0;		
			}
			
			System.out.println("Etape 7 : Si combinaison trouvé fin, sinon relance 4 jusqu'à fin "
				+ "du nombre d'essai possible");
			
			nombreEssaisRestant--;
			
		}

	}

}


