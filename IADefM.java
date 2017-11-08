
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

	public ArrayList<Integer> generateCode(ArrayList<Integer> previousCode, int result) {

		if (previousCode == null) {
			return generateCode();
		}
		ArrayList<Integer> code = new ArrayList<Integer>();
		
		int[] tabResult = new int[result];
		 
		for (int i = 0; i < 4; i++) {
			Random rand = new Random();
			if (tabResult[i] == 1) {
				code.add(previousCode.get(i));
			}else if (tabResult[i] < 1) {
				// Entre 0 et previousCode.get(i) - 1
				int low = 0;
				int high = previousCode.get(i);
				int value = rand.nextInt(high - low) + low;
				code.add(value);
			} else if (tabResult[i] > 1) {				
				// Entre previousCode.get(i) + 1 et 0
				int low = previousCode.get(i) + 1;
				int high = 10;
				int value = rand.nextInt(high - low) + low;
				code.add(value);
			} 
		}
		return code;
	}
}
	
