package week_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AplusB2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("aplusbb.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"aplusbb.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		pw.println(a + b * b);
		pw.close();
		br.close();
	}

}
