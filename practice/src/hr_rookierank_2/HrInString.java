package hr_rookierank_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HrInString {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder strb = new StringBuilder();
		char[] array = new char[] { 'h', 'a', 'c', 'k', 'e', 'r', 'r', 'a',
				'n', 'k' };
		for (int i = 0; i < n; i++) {
			String string = br.readLine();
			int p = 0;
			for (int j = 0; j < string.length(); j++) {
				if (string.charAt(j) == array[p])
					p++;
				if (p == 10)
					break;
			}

			switch (p) {
			case 10:
				strb.append("YES\n");
				break;
			default:
				strb.append("NO\n");
				break;
			}
		}

		System.out.print(strb.toString());
		strb = null;
		br = null;
		array = null;
		System.gc();
	}
}
