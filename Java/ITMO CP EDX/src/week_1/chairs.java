package week_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class chairs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("chairs.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("chairs.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double i = Double.parseDouble(st.nextToken())/2;
		double j = Double.parseDouble(st.nextToken())/2;
		double k = Double.parseDouble(st.nextToken())/2;		
		pw.println(  (i+j+k) / 3);
		pw.close();
		br.close();
	}
}
