package mastermind;

import java.util.ArrayList;

public class Helper {
	public static Integer getNbValueInArray(int value, ArrayList<Integer> list) {
		// Ecrire le code qui compte combien le nombre de fois la value est dans
		// le tableau list.
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.equals(value)) 
				count++;
			else if (list.contains(value))
					count = 1;			
		}
		return count;
			
	}

	
}
