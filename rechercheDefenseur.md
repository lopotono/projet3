package jeux;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Recherche +/-");
		System.out.println("Mode défenseur");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Etape 1 : déterminer le nombre limité d'essai");
		int nombreEssaisRestantDe = 10;

		// combinaison utilisateur dans un arraylist
		ArrayList<Integer> secret = new ArrayList<Integer>();
		secret.add(5);
		secret.add(3);
		secret.add(2);
		secret.add(9);

		while (nombreEssaisRestantDe > 0) {
			// générer une combinaison aléatoire ordinateur
			Random r = new Random();
			ArrayList<Integer> combinaison = new ArrayList<Integer>();
			for (int i = 0; i < 4; i++) {
				combinaison.add(r.nextInt(10));
			}			

			System.out.println("Proposition : "+combinaison.get(0)+combinaison.get(1)+combinaison.get(2)+combinaison.get(3)+" -> réponse : ");

			String resultat = "";

			for (int i = 0; i < 4; i++) {
				if (combinaison.get(i) == secret.get(i)) {
					resultat += "=";
				} else if (combinaison.get(i) > secret.get(i)) {
					resultat += "-";
				} else
					resultat += "+";
			}			
			System.out.print(resultat);
			

			if (resultat.equals("====")) {
				System.out.println("c'est gagné");
				nombreEssaisRestantDe = 0;
			}

			nombreEssaisRestantDe--;
		}
		System.out.println("jeu terminé");
	}
}

