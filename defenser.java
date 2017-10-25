package fr.projet3.jeux;

import java.util.ArrayList;

public class Defenseur {
	
	public Defenseur(){
					
		User gamer1 = new User();
		IA gamer2 = new IA();
		
		//Etape 1 : saisir la combinaison
		System.out.println("\nSaisir une combinaison à 4 chiffres : ");
		
		ArrayList<Integer> code = gamer1.getCode();
		
		//Etape 2 : Déterminer le nombre limité d'essai
		
		int nombreEssaisRestant = 10; // TODO : Récupérer cette valeur dans un fichier de configuration.
		
		//Etape 3 : Lancer le jeu		
		ArrayList<Integer> proposition = null;
		String result = null;
		
		while(nombreEssaisRestant > 0) {
		
			//Etape 4 : Faire proposition			
			proposition = gamer2.generateCode(proposition, result);
			
			//Etape 5 : Vérifier la proposition
			result = "";
			System.out.print("Proposition : ");
			for (int j = 0; j < 4; j++){
				System.out.print(proposition.get(j));					
				}
			System.out.print(" -> réponse : ");
			
			for (int i = 0; i < 4; i++) {
				if (code.get(i) == proposition.get(i)) {
					result += "=";
				} else if (code.get(i) < proposition.get(i)) {
					result += "-";
				} else
					result += "+";
			}
			System.out.println(result);
			//Etape 6 : Afficher le retour (combinaison trouvé ou non")
			
			//System.out.println(result);			
			if(result.equals("====")){
				System.out.println("BRAVO c'est gagné !");
				nombreEssaisRestant = 0;		
			}			
			//Etape 7 : Si combinaison trouvé fin, sinon relance 4 jusqu'à fin du nombre d'essai possible			
			nombreEssaisRestant--;			
		}
	}
}


