package mastermind;

import java.util.ArrayList;
import java.util.Scanner;

public class UserChalMaster {
	public ArrayList<Integer> getCode() {

		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();

		char[] tab = str.toCharArray();
		ArrayList<Integer> codeUserChalMaster = new ArrayList<Integer>();
		codeUserChalMaster.add(Integer.parseInt(Character.toString(tab[0])));
		codeUserChalMaster.add(Integer.parseInt(Character.toString(tab[1])));
		codeUserChalMaster.add(Integer.parseInt(Character.toString(tab[2])));
		codeUserChalMaster.add(Integer.parseInt(Character.toString(tab[3])));
			
		return codeUserChalMaster;
	}

}
