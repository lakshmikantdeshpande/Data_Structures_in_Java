package hr_Solution;

// Kangaroo program HackerRank
import java.util.Scanner;

public class Kangaroo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int v1 = in.nextInt();
		int x2 = in.nextInt();
		int v2 = in.nextInt();

		if (v1 < v2 && x1 < x2)
			System.out.println("NO");
		else if (v1 != v2 && check(x1, v1, x2, v2))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	private static boolean check(int x1, int v1, int x2, int v2) {
		return ((x2 - x1) % (v1 - v2)) == 0;
	}
}