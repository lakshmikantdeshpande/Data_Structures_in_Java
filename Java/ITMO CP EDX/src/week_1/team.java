package week_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class team {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("team.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"team.out")));

		double[][] array = new double[3][3];
		StringTokenizer st;

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				array[i][j] = Double.parseDouble(st.nextToken());
		}

		double max = 0;
		double[] marray = new double[6];

		marray[0] = Math.sqrt(array[0][0] * array[0][0] + array[1][1]
				* array[1][1] + array[2][2] * array[2][2]);
		marray[1] = Math.sqrt(array[0][0] * array[0][0] + array[1][2]
				* array[1][2] + array[2][1] * array[2][1]);
		marray[2] = Math.sqrt(array[0][1] * array[0][1] + array[1][2]
				* array[1][2] + array[2][0] * array[2][0]);
		marray[3] = Math.sqrt(array[0][1] * array[0][1] + array[1][0]
				* array[1][0] + array[2][2] * array[2][2]);
		marray[4] = Math.sqrt(array[0][2] * array[0][2] + array[1][0]
				* array[1][0] + array[2][1] * array[2][1]);
		marray[5] = Math.sqrt(array[0][2] * array[0][2] + array[1][1]
				* array[1][1] + array[2][0] * array[2][0]);

		for (int i = 0; i < 6; i++) {
			if (max < marray[i])
				max = marray[i];
		}

		pw.println(max);
		pw.close();
		br.close();
	}
}