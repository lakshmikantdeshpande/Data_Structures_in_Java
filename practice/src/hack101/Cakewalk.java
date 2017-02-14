package hack101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Cakewalk {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] calories = new Integer[T];

		for (int i = 0; i < T; i++) {
			calories[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(calories, Collections.reverseOrder());

		long sum = 0;
		for (int i = 0; i < T; i++) {
			sum += Math.pow(2, i) * calories[i].longValue();
		}
		System.out.println(sum);
		br = null;
		calories = null;
		System.gc();
	}
}
