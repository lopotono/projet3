package testFred;

import java.util.ArrayList;
import java.util.Scanner;

public class UserDuel {
	
public ArrayList<Integer> getCode() {
		
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		char[] tab = str.toCharArray();
		ArrayList<Integer> codeUser = new ArrayList<Integer>();
		codeUser.add(Integer.parseInt(Character.toString(tab[0])));
		codeUser.add(Integer.parseInt(Character.toString(tab[1])));
		codeUser.add(Integer.parseInt(Character.toString(tab[2])));
		codeUser.add(Integer.parseInt(Character.toString(tab[3])));
		
		return codeUser;

	}

}

