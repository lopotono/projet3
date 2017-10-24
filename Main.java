package fr.projet3.jeux;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jeu1 = "Recherche+/-";
		String jeu2 = "Mastermind";
		String modeC = "Mode challenger";
		String modeD = "Mode défenseur";
		String modeDu = "Mode duel";
		char reponse = ' ', choix = ' ', mode = ' ', reponse2 = ' ';
		
		do {
			do {
				choix = ' ';
				System.out.println("------------CHOISIR LE JEU------------");
				System.out.println("---->Taper 1 pour jouer à Recherche+/-");
				System.out.println("---->Taper 2 pour jouer à Mastermind\n");
				Scanner sc = new Scanner(System.in);
				choix = sc.next().charAt(0);

				if (choix != '1' && choix != '2')
					System.out.println("Taper 1 ou 2.");

				if (choix == '1')
					System.out.println("Vous avez choisi le jeu " + jeu1 + "\n");
				else if (choix == '2')
					System.out.println("Vous avez choisi le jeu " + jeu2 + "\n");

			} while (choix != '1' && choix != '2');
			
		do{
			do {
				mode = ' ';
				System.out.println("CHOISIR LE MODE DE JEU :--------");
				System.out.println("---> 1 : Mode challenger -------");
				System.out.println("---> 2 : Mode défenseur --------");
				System.out.println("---> 3 : Mode duel--------------");
				Scanner sc = new Scanner(System.in);
				mode = sc.next().charAt(0);

				if (mode != '1' && mode != '2' && mode != '3')
					System.out.println("Taper 1, 2 ou 3.");

				if (mode == '1') {
					System.out.println("Vous avez choisi " + modeC);
					System.out.println("Vous devez trouver la combinaison secrète de l'ordinateur.");
					Challenger challenger = new Challenger();
				} else if (mode == '2') {
					System.out.println("Vous avez choisi " + modeD);
					System.out.println("C'est à l'ordinateur de trouver votre combinaison secrète.");
					Defenseur defenseur = new Defenseur();
				} else {
					System.out.println("Vous avez choisi " + modeDu);
					System.out.println("L'ordinateur et vous jouez tour à tour, le premier à trouver la combinaison secrète de l'autre a gagné.");
					Duel duel = new Duel();
				}
								
				do {
					System.out.println("\nVoulez-vous rejouer au même jeu ? (o/n)");
					Scanner ret = new Scanner(System.in);
					reponse2 = ret.nextLine().charAt(0);
									
				}while (reponse2 != 'o' && reponse2 != 'n');
				
				} while (reponse2 == 'o');

			} while (mode != '1' && mode != '2' && mode != '3');
									
			do {
				System.out.println("\nVoulez-vous rejouer à un autre jeu ? (o/n)");
				Scanner sc = new Scanner(System.in);
				reponse = sc.nextLine().charAt(0);

			} while (reponse != 'o' && reponse != 'n');
			
		} while (reponse == 'o');
				
		System.out.println("A bientôt !");
	}
}

