package hr_rookierank_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinAbsoluteDiff {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];

		StringTokenizer strt = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(strt.nextToken());
		}

		Arrays.sort(array);
		int min = Math.abs((array[0] - array[1]));

		for (int i = 0; i < n - 1; i++) {
			int temp = Math.abs((array[i] - array[i + 1]));
			if (temp < min)
				min = temp;
		}
		System.out.println(min);
		strt = null;
		br = null;
		array = null;
		System.gc();
	}
}
