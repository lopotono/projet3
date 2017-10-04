package jeux;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.BooleanControl;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(new File("configuration"));

		} catch (FileNotFoundException e) {

		}
		Scanner scanner = new Scanner(System.in);

		System.out.println("Recherche +/-");
		System.out.println("Mode challenger");

		// System.out.println("Etape 1 : générer la combinaison");

		Random r = new Random();
		ArrayList<Integer> combinaison = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			combinaison.add(r.nextInt(10));
		}

		/*Iterator<Integer> iterator = combinaison.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next());
		}*/

		// System.out.println("\nEtape 2 : déterminer le nombre limité
		// d'essai");

		int nombreEssaisRestant = 10; // TODO : récupérer cette valeur dans un
										// fichier de configuration.

		// System.out.println("Etape 3 : lancer le jeu");

		// System.out.println("Etape 4 : faire une proposition");

		while (nombreEssaisRestant > 0) {

			// System.out.println("Etape 4 : faire une proposition");
			System.out.println("\nSaisir une combinaison à 4 chiffres : ");
			String str = scanner.nextLine();

			// System.out.println("Etape 5 : vérifier la proposition");

			char[] tab = str.toCharArray();
			
			try {
				ArrayList<Integer> proposition = new ArrayList<Integer>();
				proposition.add(Integer.parseInt(Character.toString(tab[0])));
				proposition.add(Integer.parseInt(Character.toString(tab[1])));
				proposition.add(Integer.parseInt(Character.toString(tab[2])));
				proposition.add(Integer.parseInt(Character.toString(tab[3])));

				System.out.print("Proposition : " + str + " -> réponse : ");
				String result = "";

				for (int i = 0; i < 4; i++) {
					if (combinaison.get(i) == proposition.get(i)) {
						result += "=";
					} else if (combinaison.get(i) < proposition.get(i)) {
						result += "-";
					} else
						result += "+";
				}
				
				System.out.println(result);

				// Etape 6 : retour si combinaison trouvée
					if(result.equals("====")){
							System.out.println("c'est gagné");
							nombreEssaisRestant = 0;		
					}
				// Etape 7 : si combinaison trouvé fin, sinon relance 4 jusqu'à
				// la fin du nombre d'essai possible");

			} catch (NumberFormatException exception) {

				System.out.println("Mauvaise combinaison, merci de saisir des chiffres.");
			}

			nombreEssaisRestant--;
			
		}
			
		System.out.println("jeu terminé");
	}

}

