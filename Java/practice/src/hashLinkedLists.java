import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

public class hashLinkedLists {
	private static LinkedList<Integer> ContentA;
	private static LinkedList<String> ContentB;

	// Inserts values in ContentA, and hashed values in ContentB
	public static void insert(int a) throws NoSuchAlgorithmException {
		ContentA.add(a);
		ContentB.add(hash(a));
	}

	// uses MD5 hashing algorithm
	private static String hash(int a) throws NoSuchAlgorithmException {
		String input = String.valueOf(a);
		String md5 = null;
		// get MD5 class instance
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");

		// put input in the md5 hashing function
		messageDigest.update(input.getBytes(), 0, input.length());

		// Converts MD value in hexadecimal
		md5 = new BigInteger(1, messageDigest.digest()).toString(16);
		return md5;
	}

	// selection sort
	public static void sort(LinkedList<Integer> ContentA, LinkedList<String> ContentB) {
		int min = 0, N = ContentA.size();
		for (int i = 0; i < N; i++) {
			min = i;
			for (int j = i + 1; j < N; j++) {
				if (ContentA.get(j) < ContentA.get(min))
					min = j;
			}
			swapInteger(i, min, ContentA);
			swapString(i, min, ContentB);
		}
	}

	// swaps values in ContentA
	private static void swapInteger(int i, int j, LinkedList<Integer> list) {
		int temp1 = list.get(i);
		int temp2 = list.get(j);
		list.set(j, temp1);
		list.set(i, temp2);
	}

	// swaps values in ContentB
	private static void swapString(int i, int j, LinkedList<String> list) {
		String temp1 = list.get(i);
		String temp2 = list.get(j);
		list.set(j, temp1);
		list.set(i, temp2);
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		ContentA = new LinkedList<Integer>();
		ContentB = new LinkedList<String>();

		// for loop for adding values in the linked list
		for (int i = 10; i >= 1; i--)
			insert(i);

		// sorts ContentA and ContentB
		sort(ContentA, ContentB);

		System.out.println(ContentA);
		System.out.println(ContentB);
	}
}
