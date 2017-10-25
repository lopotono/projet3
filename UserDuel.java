package fr.projet3.jeux;

import java.util.ArrayList;
import java.util.Scanner;

public class UserDuel {
	public ArrayList<Integer> getCode() {

		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();

		char[] tab = str.toCharArray();
		ArrayList<Integer> codeUserDuel = new ArrayList<Integer>();
		codeUserDuel.add(Integer.parseInt(Character.toString(tab[0])));
		codeUserDuel.add(Integer.parseInt(Character.toString(tab[1])));
		codeUserDuel.add(Integer.parseInt(Character.toString(tab[2])));
		codeUserDuel.add(Integer.parseInt(Character.toString(tab[3])));

		return codeUserDuel;
	}

	public ArrayList<Integer> getCode(ArrayList<Integer> previousCode, String resultUser) {
		if (previousCode == null && resultUser == null) {
			return getCode();
		}

		ArrayList<Integer> codeUserDuel = new ArrayList<Integer>();

		char[] tabResultUser = resultUser.toCharArray();

		for (int i = 0; i < 4; i++) {
			if (tabResultUser[i] == '=') {
				codeUserDuel.add(previousCode.get(i));
			} else if (tabResultUser[i] == '-') {
				int value = previousCode.get(i) - 1;
				codeUserDuel.add(value);
			} else if (tabResultUser[i] == '+') {
				int value = previousCode.get(i) + 1;
				codeUserDuel.add(value);
			}
		}
		return codeUserDuel;
	}

}

