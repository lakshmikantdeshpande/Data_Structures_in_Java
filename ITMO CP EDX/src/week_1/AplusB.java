package week_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AplusB {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("aplusb.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"aplusb.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		pw.print(a + b);
		pw.close();
		br.close();
	}

}
