
/* Save this in a file called Main.java to compile and test it */

import java.util.ArrayList;
import java.util.Scanner;

public class MainMTH2 {
	public static int processArray(ArrayList<Integer> array) {
		/*
		 * Do not make any changes outside this method.
		 * 
		 * Modify this method to process `array` as indicated in the question.
		 * At the end, return the size of the array.
		 * 
		 * Do not print anything in this method
		 * 
		 * Submit this entire program (not just this function) as your answer
		 */
		int size = array.size();
		for (int i = 0; i < size; i++) {
			int num = array.get(i); // for avoiding unnecessary calls to get
									// method
			int mod = num % 10; // % operator is expensive, so saving that
								// overhead

			if (mod == 6) {
				if (num < 100)
					array.set(i, -3);
				else
					array.set(i, -1);
			} else if (num < 100) {
				array.set(i, -2);
			}
		}
		return array.size();
	}

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int num = in.nextInt();
			if (num < 0)
				break;
			arrayList.add(new Integer(num));
		}
		int new_length = processArray(arrayList);
		for (int i = 0; i < new_length; i++)
			System.out.println(arrayList.get(i));
	}
}
