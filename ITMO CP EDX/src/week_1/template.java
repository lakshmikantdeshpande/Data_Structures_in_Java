package week_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class template {
	private static char[][] array;
	private static int w, h;
	private static int lastx, lasty, x, y;

	private static boolean getCoordinates(char c, boolean isOld) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (c == array[i][j]) {
					if (isOld) {
						lastx = i;
						lasty = j;
					} else {
						x = i;
						y = j;
					}
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("template.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"template.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		array = new char[w][h];

		for (int i = 0; i < h; i++) {
			array[i] = br.readLine().toCharArray();
		}

		String line = null;
		List<String> list = new ArrayList<String>();
		List<String> names = new ArrayList<String>();
		List<Integer> cost = new ArrayList<Integer>();

		// continue until EOF is not found
		while ((line = br.readLine()) != null) {
			if (line.length() == 0)
				continue;
			else {
				StringBuilder language = new StringBuilder();
				names.add(line);
				while ((line = br.readLine()) != null) {
					if (line.length() == 0)
						break;
					else
						language.append(line);
				}

				if (language.length() > 0) {
					list.add(language.toString());
				}
			}
		}

		int lsize = list.size();
		for (int p = 0; p < lsize; p++) {
			String str = list.get(p);
			int sum = 0;
			int slen = str.length();
			int i = 1;
			boolean isValid = true;

			isValid = getCoordinates(str.charAt(0), true);
			if (!isValid) {
				list.remove(p);
				names.remove(p);
				p--;
				continue;
			}
			while (i < slen) {
				isValid = getCoordinates(str.charAt(i), false);
				if (!isValid) {
					System.out.println();
					list.remove(p);
					names.remove(p);
					p--;
					break;
				}
				sum += Math.max(Math.abs(x - lastx), Math.abs(y - lasty));
				lastx = x;
				lasty = y;
				i++;
			}
			if (isValid)
				cost.add(sum);
			else
				continue;
		}

		int costlen = cost.size();
		int min = cost.get(0), minindex = 0;
		for (int i = 1; i < costlen; i++) {
			int t = cost.get(i);
			if (t < min) {
				min = t;
				minindex = i;
			}
		}

		pw.println(names.get(minindex) + "\n" + cost.get(minindex));
		
		pw.close();
		br.close();
	}

}
