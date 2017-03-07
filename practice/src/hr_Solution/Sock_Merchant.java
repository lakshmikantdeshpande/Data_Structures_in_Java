import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sock_Merchant {
	private static Scanner scanner;
	private static PrintStream ps;

	public static void main(String args[]) throws Exception {
		scanner = new Scanner(System.in);
		ps = new PrintStream(System.out);

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int N = scanner.nextInt();
		while (N-- > 0) {
			int temp = scanner.nextInt();

			if (map.containsKey(temp))
				map.put(temp, map.get(temp) + 1);
			else
				map.put(temp, 1);
		}
		int counter = 0;

		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			if (entry.getValue() % 2 > 0)
				++counter;
		ps.println(counter);
		ps.flush();

		ps = null;
		scanner = null;
		map = null;
		System.gc();
	}
}