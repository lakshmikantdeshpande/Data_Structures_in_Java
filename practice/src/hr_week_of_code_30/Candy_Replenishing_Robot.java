package hr_week_of_code_30;

import java.util.Scanner;

public class Candy_Replenishing_Robot {

	public static void main(String args[]) throws Exception {

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int T = scanner.nextInt();
		int temp = 0;
		int sum = 0;
		int backup = N;

		for (int i = 0; i < T - 1; i++) {
			temp = scanner.nextInt();
			N -= temp;
			if (N < 5) {
				sum += backup - N;
				N = backup;
			}
		}

		temp = scanner.nextInt();

		System.out.println(sum);
		scanner.close();
		scanner = null;
		System.gc();
	}
}