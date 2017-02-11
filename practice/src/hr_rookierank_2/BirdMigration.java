package hr_rookierank_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BirdMigration {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] types = new int[5];

		StringTokenizer strt = new StringTokenizer(br.readLine());
		while (strt.hasMoreTokens()) {
			types[Integer.parseInt(strt.nextToken()) - 1]++;
		}

		int max = 0;
		for (int i = 0; i < 5; i++) {
			if (types[max] < types[i])
				max = i;
		}
		System.out.println(max + 1);
	}
}
