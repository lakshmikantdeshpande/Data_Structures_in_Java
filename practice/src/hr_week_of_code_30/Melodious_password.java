package hr_week_of_code_30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Melodious_password {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String args[]) throws Exception {
		int N = Integer.parseInt(br.readLine());
		char[] conso = new char[] { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v',
				'w', 'x', 'z' };
		char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u' };

		StringBuilder strb = new StringBuilder();

		int k = 0;
		for (int i = 0; i < conso.length; i++) {
			for (int j = 0; j < N; j++) {
				if (j % 2 == 0)
					strb.append(conso[i]);
				else
					strb.append(vowels[k]);
			}
			strb.append('\n');
			k++;
		}
		k = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < N; j++) {
				if (j % 2 == 0)
					strb.append(vowels[i]);
				else
					strb.append(conso[k]);
			}
			strb.append('\n');
			k++;
		}

		out.print(strb.toString());
		conso = null;
		vowels = null;
		strb = null;
		out.close();
		br.close();
		br = null;
		out = null;
		System.gc();
	}
}