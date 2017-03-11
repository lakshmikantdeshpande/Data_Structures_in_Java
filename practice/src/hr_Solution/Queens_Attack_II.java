package hr_Solution;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Queens_Attack_II {

	private static Set<String> set;

	public static void main(String args[]) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		int qx = scanner.nextInt();
		int qy = scanner.nextInt();

		// It may throw an exception, as the nextline character may/may not be
		// present in the input
		// just mask the exception
		try {
			scanner.nextLine().trim(); // eat the nextline character
		} catch (Exception e) {

		}
		set = new HashSet<String>();
		// o(1) for adding and retrieving
		for (int i = 0; i < k; i++) {
			set.add(scanner.nextLine().trim());
		}

		int count = 0;
		for (int i = 1; i <= 8; i++)
			count += getBoxes(i, qx, qy, n);
		System.out.println(count);

		scanner.close();
		set = null;
		scanner = null;
		System.gc();
	}

	private static int getBoxes(int direction, int qx, int qy, int n) {
		int count = 0;
		int dirx = 0, diry = 0;
		/*-
		 *     -1-1 (1)       -1 0 (2)       -1+1 (3)
		 *      0-1 (4)					  	  0+1 (5)
		 *     +1-1 (6)       +1 0 (7)       +1+1 (8)
		 *     
		 */
		switch (direction) {
		case 1:
			dirx = diry = -1;
			break;
		case 2:
			dirx = -1;
			break;
		case 3:
			dirx = -1;
			diry = 1;
			break;
		case 4:
			diry = -1;
			break;
		case 5:
			diry = 1;
			break;
		case 6:
			dirx = 1;
			diry = -1;
			break;
		case 7:
			dirx = 1;
			break;
		case 8:
			dirx = diry = 1;
			break;
		}

		int tempx = qx, tempy = qy;
		while (true) {
			tempx += dirx;
			tempy += diry;
			if (tempx < 1 || tempy < 1 || tempx > n || tempy > n
					|| set.contains(tempx + " " + tempy)) {
				break;
			} else {
				count++;
			}
		}

		return count;
	}

}