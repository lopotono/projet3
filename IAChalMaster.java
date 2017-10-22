package mastermind;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class IAChalMaster {
	public ArrayList<Integer> generateCode() {

		Random r = new Random();

		ArrayList<Integer> codeIAChalMaster = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			codeIAChalMaster.add(r.nextInt(10));
		}

		Iterator<Integer> iterator = codeIAChalMaster.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next());
		}
		return codeIAChalMaster;

	}
}
