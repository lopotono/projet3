package fr.projet3.jeux;

import java.util.ArrayList;
import java.util.Iterator;

public class Helper {
	public static Integer getNbValueInArray(int value, ArrayList<Integer> list) {
		
		int count = 0;

		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equals(value)) {
				count++;
			}
		}
		return count;	
	}			
}
