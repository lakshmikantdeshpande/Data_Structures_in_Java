package hr_rookierank_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChessMoves {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = n / 2;

		int[][] array = new int[n][n];

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (array[i][j] == 0) {
					if (i > k && j > k) {
						if (i == n - 1 && j == n - 1)
							array[i][j] = 1;
						else
							array[i][j] = -1;
					} else
						array[j][i] = array[i][j] = check(i, j, n);
				}
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (j != n - 1)
					System.out.print(array[i][j] + " ");
				else
					System.out.print(array[i][j]);
			}
			System.out.println();
		}

	}

	public static int check(int i, int j, int n) {
		int counter = 0;
		n--;
		int[][] list = new int[][] { { +1, +1 }, { +1, -1 }, { -1, +1 },
				{ -1, -1 } };

		List<String> alist = new ArrayList<String>();
		StringBuilder strb1 = new StringBuilder();
		int a = n, b = n;
		int p, q;
		while (true) {

			for (int l = 0; l < 8; l++) {
				if (l < 4) {
					p = a - i * list[l][0];
					q = b - j * list[l][1];
				} else {
					p = a - j * list[l - 4][0];
					q = b - i * list[l - 4][1];
				}

				strb1 = new StringBuilder();
				strb1.append(p).append(q);

				if (p == 0 && q == 0) {
					alist.add(strb1.toString());
					return ++counter;
				} else if (p < 0 || q < 0 || p > n || q > n
						|| alist.contains(strb1.toString())) {
					continue;
				} else {
					int tempa, tempb;
					if (!(p == 0 && q == 0))
						for (int m = l + 1; m < 8; m++) {
							if (m < 4) {
								tempa = a - i * list[m][0];
								tempb = b - j * list[m][1];
							} else {
								tempa = a - j * list[m - 4][0];
								tempb = b - i * list[m - 4][1];
							}
							if (tempa == 0 && tempb == 0)
								return ++counter;
						}

					a = p;
					b = q;
					alist.add(strb1.toString());
					break;
				}
			}

			if (a == 0 && b == 0)
				break;
			counter++;
		}
		return counter;
	}
}