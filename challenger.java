package testFred;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Challenger {

	public static void main(String[] args) {
		
		System.out.println("Recherche +/-");
		System.out.println("Mode challenger");
		
		User gamer1 = new User();
		IA gamer2 = new IA();
		
		//générer la combinaison
		
		ArrayList<Integer> code = gamer2.generateCode();
		
		//Déterminer le nombre limité d'essai		
		int nombreEssaisRestant = 10; // TODO : Récupérer cette valeur dans un fichier de configuration.
		
		//Lancer le jeu
		
		while(nombreEssaisRestant > 0) {
		
			System.out.println("\nSaisir une combinaison à 4 chiffres : ");
			
			ArrayList<Integer> proposition = gamer1.getCode();

			System.out.print("Proposition : ");
			for (int j = 0; j < 4; j++){
				System.out.print(proposition.get(j));					
				}
			System.out.print(" -> réponse : ");
			
			//Vérifier la proposition
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
			//System.out.println("Proposition : "++" -> Réponse : "+result);
			//Afficher le retour (combinaison trouvé ou non)		
			
			if(result.equals("====")){
				System.out.println("c'est gagné");
				nombreEssaisRestant = 0;		
			}
			
			//Si combinaison trouvé fin, sinon relance 4 jusqu'à fin du nombre d'essai possible			
			nombreEssaisRestant--;
			
		}			

		
	}

}

