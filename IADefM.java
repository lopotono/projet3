
	
package fr.projet3.jeux;

import java.util.ArrayList;
import java.util.Random;

public class IADefM {
	public ArrayList<Integer> generateCode() {

		Random r = new Random();

		ArrayList<Integer> code = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			code.add(r.nextInt(10));
		}
		return code;
	}

	public ArrayList<Integer> generateCode(int value) {

		Random r = new Random();
		ArrayList<Integer> code = new ArrayList<Integer>();

		do {
			value = r.nextInt(10);
		} while (!code.contains(value));
		code.add(value);
		return code;
	}
}
