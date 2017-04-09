package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class CakeFlips {
	static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	static PrintWriter pw = new PrintWriter(System.out);
	static StringBuilder strb = new StringBuilder();

	public static void main(String[] args) {
		int T = scanner.nextInt();

		for (int i = 1; i <= T; i++) {
			String cake = scanner.next();
			int flipSize = scanner.nextInt();
			pw.println("Case #" + i + ": " + flipCakes(cake, flipSize));
		}

		strb = null;
		scanner.close();
		scanner = null;
		pw.close();
		pw = null;
		System.gc();

	}

	public static String flipCakes(String cake, int flipsize) {
		String temp = cake;
		int counter = 0;

		while (!temp.isEmpty() && temp.length() >= flipsize) {
			temp = remaining(temp);
			if (temp.length() >= flipsize) {
				counter++;
				temp = flip(temp, flipsize);
			}
		}
		return temp.equals("") ? counter + "" : "IMPOSSIBLE";
	}

	private static String flip(String cake, int flipsize) {
		strb = new StringBuilder();
		for (int i = 0; i < flipsize; i++)
			strb.append(cake.charAt(i) == '+' ? '-' : '+');
		strb.append(cake.substring(flipsize));
		return strb.toString();
	}

	private static String remaining(String cake) {
		int i = 0;
		while (i < cake.length() && cake.charAt(i) == '+') {
			i++;
		}
		return cake.substring(i);
	}

}