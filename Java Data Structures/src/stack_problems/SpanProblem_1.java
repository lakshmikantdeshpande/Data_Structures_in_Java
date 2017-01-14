// 22. Finding spans in the given array
// (Stock market problem)
// How many times a[j] <= a[j+1]  in the given array? (How many peaks are there in the given array)
// n*n time, 1 space

package stack_problems;

public class SpanProblem_1 {

	public static void main(String[] args) {
		int spans[] = findSpans(new int[] { 6, 3, 4, 5, 2 });
		for (int x : spans) {
			System.out.println(x);
		}
	}

	private static int[] findSpans(int[] array) {
		int[] spans = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			int span = 1;
			int j = i - 1;
			// check how many ups have been there till nw in the array
			while (j >= 0 && array[j] <= array[j + 1]) {
				span++;
				j--;
			}
			spans[i] = span;
		}
		return spans;
	}

}
