package hr_week_of_code_30;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Find_the_Minimum_Number {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder strb = new StringBuilder();
		if (n == 2)
			strb.append("min(int, int)");
		else {
			int c = n - 2;
			while (n-- > 2)
				strb.append("min(int, ");
			strb.append("min(int, int)");
			while (c-- > 0)
				strb.append(")");
		}

		System.out.println(strb.toString());

		br.close();
		strb = null;
		br = null;
		System.gc();
	}
}