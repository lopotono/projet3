package testFred;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;



public class IA {
	
	public ArrayList<Integer> generateCode() {
		
		Random r = new Random();
		
		ArrayList<Integer> code = new ArrayList<Integer>();
		for(int i=0; i<4; i++) {
			code.add(r.nextInt(10));
		}
		
		Iterator<Integer> iterator = code.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next());
		}

		return code;
		
	}
	
	public ArrayList<Integer> generateCode(ArrayList<Integer> previousCode, String result) {
		
		if(previousCode == null && result == null) {
			return generateCode();
		}
		
		ArrayList<Integer> code = new ArrayList<Integer>();
		
		char[] tabResult = result.toCharArray();
		
		for(int i=0; i<4; i++) {
			Random rand = new Random();
			if(tabResult[i] == '=') {
				code.add(previousCode.get(i));
			} else if(tabResult[i] == '-') {				
				//Entre 0 et previousCode.get(i) - 1
				int value = 0 + rand.nextInt(previousCode.get(i)-1);
				code.add(previousCode.get(i));																
			} else if(tabResult[i] == '+') {				
				//Entre previousCode.get(i) + 1 et 0
				int value = previousCode.get(i) + rand.nextInt(previousCode.get(i)+1);
				code.add(previousCode.get(i));				
			}			
			
		}
		
		return code;
			
	 
	}
	
	
	
}

