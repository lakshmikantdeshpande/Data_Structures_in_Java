package october_lunchtime_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int[][] array = new int[3][3];

		while (t-- > 0) {
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] max = new int[6];
			max[0] = array[0][0] + array[1][0] + array[2][0]; // columns
			max[1] = array[0][1] + array[1][1] + array[2][1]; // columns
			max[2] = array[0][2] + array[1][2] + array[2][2]; // columns
			max[3] = array[0][0] + array[0][1] + array[0][2]; // rows
			max[4] = array[1][0] + array[1][1] + array[1][2]; // rows
			max[5] = array[2][0] + array[2][1] + array[2][2]; // rows

			int max1 = -1;
			for (int i = 0; i < 6; i++) {
				if (max1 < max[i])
					max1 = max[i];
			}
			int max2 = -1;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (array[i][j] > max2)
						max2 = array[i][j];
				}
			}

			if (max2 < max1)
				max2 = max1;

			if (max2 == 0 || max2 == 1 || max2 == 2)
				System.out.println(0);
			else if (max2 % 2 == 0) {
				System.out.println(--max2);
			} else
				System.out.println(max2);
		}
	}
}
