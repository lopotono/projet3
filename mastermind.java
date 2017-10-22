package mastermind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

import javax.naming.spi.DirStateFactory.Result;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Mastermind");
		System.out.println("Mode challenger");

		UserChalMaster gamer1 = new UserChalMaster();
		IAChalMaster gamer2 = new IAChalMaster();

		System.out.println("Etape 1 : générer une combinaison aléatoire");
		ArrayList<Integer> codeIAChalMaster = gamer2.generateCode();

		System.out.println("\nEtape 2 : déterminer le nombre d'essais");
		int nombreEssais = 10;

		String result = null;

		while (nombreEssais > 0) {
			// Etape 3 : faire une proposition

			System.out.println("\nSaisir une combinaison à 4 chiffres : ");
			ArrayList<Integer> proposition = gamer1.getCode();

			System.out.println("Etape 4 : vérification de la proposition");
			System.out.print("Proposition : ");
			for (int j = 0; j < 4; j++) {
				System.out.print(proposition.get(j));
			}
			System.out.print(" -> réponse : ");

			int bienPlace = 0;
			int presents = 0;

			for (int i = 0; i < 4; i++) {
				if ((codeIAChalMaster.get(i) == proposition.get(i))) {
					bienPlace++;
				} else if (codeIAChalMaster.contains(proposition.get(i))) {
					presents++;
				}
			}
			System.out.print(bienPlace + " bien placé(s) ");
			System.out.print(presents + " présent(s)");

			if (bienPlace == 4) {
				System.out.println("\nc'est gagné !");
				nombreEssais = 0;
			}
			nombreEssais--;
		}
	}
}

