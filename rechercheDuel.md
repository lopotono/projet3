package duel;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Recherche +/-");
		System.out.println("Mode duel");

		int nombreEssais = 10;

		while (nombreEssais > 0) {
			// création de la combinaison de l'ordinateur
			ArrayList<Integer> ordiComb = new ArrayList<Integer>();
			ordiComb.add(2);
			ordiComb.add(5);
			ordiComb.add(8);
			ordiComb.add(4);

			// générer ma combinaison
			System.out.println("\nSaisir votre combinaison secrète : ");
			Scanner sc = new Scanner(System.in);
			String combUtil = sc.nextLine();

			char[] tab = combUtil.toCharArray();

			try {
				ArrayList<Integer> proposition = new ArrayList<Integer>();
				proposition.add(Integer.parseInt(Character.toString(tab[0])));
				proposition.add(Integer.parseInt(Character.toString(tab[1])));
				proposition.add(Integer.parseInt(Character.toString(tab[2])));
				proposition.add(Integer.parseInt(Character.toString(tab[3])));

				System.out.print("Proposition : " + proposition.get(0) + proposition.get(1) + proposition.get(2)
						+ proposition.get(3) + " -> réponse : ");
				String result = "";
				for (int i = 0; i < 4; i++) {
					if (ordiComb.get(i) == proposition.get(i)) {
						result += "=";
					} else if (ordiComb.get(i) < proposition.get(i)) {
						result += "-";
					} else {
						result += "+";
					}
				}
				System.out.println(result);

				// comparer les éléments
				for (int i = 0; i < 4; i++)
					if (ordiComb.get(i) == proposition.get(i)) {
						ordiComb.set(i, proposition.get(i));
						System.out.print(proposition.get(i));
					} else if (ordiComb.get(i) < proposition.get(i)) {
						proposition.set(i, ordiComb.get(i) - 1);
						System.out.print(ordiComb.get(i) - 1);
					} else {
						proposition.set(i, ordiComb.get(i) + 1);
						System.out.print(ordiComb.get(i) + 1);
					}

				String retour = "";
				for (int i = 0; i < 4; i++) {
					if (ordiComb.get(i) == proposition.get(i)) {
						retour += "=";
					} else if (ordiComb.get(i) < proposition.get(i)) {
						retour += "-";
					} else {
						retour += "+";
					}
				}
				System.out.println(retour);

				// comparaison de la bonne combinaison de l'utilisateur avec
				// celle de l'ordinateur
				if (result.equals("====")) {
					System.out.println("c'est gagné");
					nombreEssais = 0;
				}

			} catch (NumberFormatException exception) {

				System.out.println("Mauvaise combinaison, merci de saisir des chiffres.");
			}
			nombreEssais--;
		}
	}

}

