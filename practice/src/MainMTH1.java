/* Save this in a file called Main.java to compile and test it */

import java.util.ArrayList;
import java.util.Scanner;

public class MainMTH1 {
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
		if (size == 1)
			return 1;
		int num1 = 0, num = 0;
		for (int i = 1; i < size; i++) {
			num1 = array.get(i);
			num = array.get(i - 1);

			if (num1 % 2 == 0) {
				continue;
			} else {
				if (i == 0) {
					continue;
				} else if (num1 % 2 != 0 && num % 2 != 0) {
					array.set(i, Math.max(num1, num));
					array.remove(i - 1);
					size--;
					i--;
				}
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
