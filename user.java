package fr.projet3.jeux;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

	public ArrayList<Integer> getCode() {

		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();

		char[] tab = str.toCharArray();
		ArrayList<Integer> code = new ArrayList<Integer>();
		code.add(Integer.parseInt(Character.toString(tab[0])));
		code.add(Integer.parseInt(Character.toString(tab[1])));
		code.add(Integer.parseInt(Character.toString(tab[2])));
		code.add(Integer.parseInt(Character.toString(tab[3])));

		return code;
	}

}

