
package fr.projet3.jeux;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
	
	private static Logger logger = Logger.getLogger(Log4j.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DOMConfigurator.configure("log4j.xml");
		Logger logRoot = Logger.getRootLogger();
		ConsoleAppender co = new ConsoleAppender();
		co.setName("console");
		co.setLayout(new SimpleLayout());
		co.activateOptions();
		logRoot.addAppender(co);
						
		Properties properties = new Properties();		
		try {
			FileInputStream in = new FileInputStream("D://workspace/fr.projet3.jeux/src/fr/projet3/jeux/config.properties");
			properties.load(in);
			in.close();
		} catch (IOException e) {
			logger.error("Erreur de chargement du fichier de configuration !");
			//System.out.println("Chargement impossible du fichier config.");
		}
		
		System.out.println("JEU RECHERCHE+/-");
		System.out.print("Nombre de cases de la combinaison secrète : ");
		System.out.println(properties.getProperty("nombreCases", "defaultnombreCases"));
		System.out.print("Nombre d'essais : ");
		System.out.println(properties.getProperty("nombreEssais", "defaultnombreEssais"));
		System.out.println();
		System.out.println("JEU MASTERMIND");
		System.out.print("Nombre d'essais : ");
		System.out.println(properties.getProperty("nombreEssaisM", "defaultnombreEssais"));
		System.out.print("Nombre de chiffres utilisables : ");
		System.out.println(properties.getProperty("nombreChiffres", "defaultnombreChiffres"));
		
		System.out.println();

		String jeu1 = "Recherche+/-";
		String jeu2 = "Mastermind";
		String modeC = "Mode challenger";
		String modeD = "Mode défenseur";
		String modeDu = "Mode duel";
		String modeDev = "Mode développeur";
		char reponse = ' ', choix = ' ', mode = ' ';
		
		logger.info("Lancement des jeux");
		System.out.println();

		do {
			do {
				choix = ' ';
				System.out.println("------------CHOISIR LE JEU------------");
				System.out.println("---->Taper 1 pour jouer à Recherche+/-");
				System.out.println("---->Taper 2 pour jouer à Mastermind");
				System.out.println("---->Taper 3 pour quitter\n");
				Scanner sc = new Scanner(System.in);
				choix = sc.next().charAt(0);

				if (choix != '1' && choix != '2' && choix != '3')
					logger.error("Vous devez taper 1, 2 ou 3");
					//System.out.println("Taper 1, 2 ou 3.");
					
				if (choix == '1')
					logger.info("Vous avez choisi le jeu " + jeu1 + "\n");
					//System.out.println("Vous avez choisi le jeu " + jeu1 + "\n");
				else if (choix == '2')
					logger.info("Vous avez choisi le jeu " + jeu2 + "\n");
					//System.out.println("Vous avez choisi le jeu " + jeu2 + "\n");
				else if (choix == '3')
					logger.warn("Fin du jeu.");
					//System.out.println("Fin du jeu.");

			} while (choix != '1' && choix != '2' && choix != '3');

			if (choix == '1' || choix == '2') {
				do {
					mode = ' ';
					System.out.println("CHOISIR LE MODE DE JEU:---------");
					System.out.println("---> 1 : Mode challenger -------");
					System.out.println("---> 2 : Mode défenseur --------");
					System.out.println("---> 3 : Mode duel--------------");
					System.out.println("---> 4 : Mode développeur-------");
					Scanner sc = new Scanner(System.in);
					mode = sc.next().charAt(0);

					if (mode != '1' && mode != '2' && mode != '3' && mode != '4')
						logger.error("Vous devez taper 1, 2, 3 ou 4");
						//System.out.println("Taper 1, 2 ou 3.");
						
					if (mode == '1' && choix == '1') {
						logger.info("Vous avez choisi " + modeC);
						logger.info("Vous devez trouver la combinaison secrète de l'ordinateur.");
						Challenger challenger = new Challenger();
						challenger.run();
						
					} else if (mode == '4' && choix == '1') {
						logger.info("Vous avez choisi " + modeDev);
						logger.info("Vous devez trouver la combinaison secrète de l'ordinateur.");						
						Challenger challenger = new Challenger();
						challenger.run();
						
					} else if (mode == '2' && choix == '1') {
						logger.info("Vous avez choisi " + modeD);
						logger.info("Vous devez trouver la combinaison secrète de l'ordinateur.");
						//System.out.println("Vous avez choisi " + modeD);
						//System.out.println("C'est à l'ordinateur de trouver votre combinaison secrète.");
						Defenseur defenseur = new Defenseur();
						defenseur.run();
						
					} else if (mode == '3' && choix == '1') {
						logger.info("Vous avez choisi " + modeDu);
						logger.info("Vous devez trouver la combinaison secrète de l'ordinateur.");
						//System.out.println("Vous avez choisi " + modeDu);
						//System.out.println("L'ordinateur et vous jouez tour à tour, le premier à trouver la combinaison secrète de l'autre a gagné.");
						Duel duel = new Duel();
						duel.run();
						
					} else if (mode == '1' && choix == '2') {
						logger.info("Vous avez choisi " + modeC);
						logger.info("Vous devez trouver la combinaison secrète de l'ordinateur.");
						//System.out.println("Vous avez choisi " + modeC);
						//System.out.println("Vous devez trouver la combinaison secrète de l'ordinateur.");
						ChallengerM challengerM = new ChallengerM();
						challengerM.run();
					} else if (mode == '2' && choix == '2') {
						logger.info("Vous avez choisi " + modeD);
						logger.info("Vous devez trouver la combinaison secrète de l'ordinateur.");
						//System.out.println("Vous avez choisi " + modeD);
						//System.out.println("C'est à l'ordinateur de trouver votre combinaison secrète.");
						DefenserM defenserM = new DefenserM();
						defenserM.run();
						
					} else if (mode == '3' && choix == '2') {
						logger.info("Vous avez choisi " + modeDu);
						logger.info("Vous devez trouver la combinaison secrète de l'ordinateur.");
						//System.out.println("Vous avez choisi " + modeDu);
						//System.out.println("L'ordinateur et vous jouez tour à tour, le premier à trouver la combinaison secrète de l'autre a gagné.");
						DuelM duelM = new DuelM();
						duelM.run();
					}

					do {
						logger.info("Voulez-vous rejouer au même mode ? (o/n)");
						//System.out.println("\nVoulez-vous rejouer au même mode ? (o/n)");
						Scanner ret = new Scanner(System.in);
						reponse = ret.nextLine().charAt(0);

					} while (reponse != 'o' && reponse != 'n');

				} while (reponse == 'o');
			}
		} while (choix != '3');

		System.out.println("A bientôt !");
	}	
}
