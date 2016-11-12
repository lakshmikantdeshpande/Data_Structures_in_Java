package week_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class prepare {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("prepare.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"prepare.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] array = new int[n][n];

		int max = 0, a = 0, b = 0, amaxindex = -1, bmaxindex = -1;

		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < n; j++) {
			array[0][j] = Integer.parseInt(st.nextToken());
			if (array[0][j] > amaxindex)
				amaxindex = j;
		}

		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < n; j++) {
			array[1][j] = Integer.parseInt(st.nextToken());
			if (array[1][j] > bmaxindex)
				bmaxindex = j;
		}

		for (int j = 0; j < n; j++) {
			if (array[0][j] >= array[1][j]) {
				max += array[0][j];
				a++;
			} else {
				max += array[1][j];
				b++;
			}
		}

		if (a == 0) {
			max -= array[1][amaxindex];
			max += array[0][amaxindex];
		} else if (b == 0) {
			max -= array[0][bmaxindex];
			max += array[1][bmaxindex];
		}

		pw.println(max);
		pw.close();
		br.close();
	}
}
