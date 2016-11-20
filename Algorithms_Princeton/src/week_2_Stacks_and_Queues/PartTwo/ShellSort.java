package week_2_Stacks_and_Queues.PartTwo;

public class ShellSort {

	public static void sort(int[] array) {
		int N = array.length;
		int h = 1;

		while (h < N / 3)
			// Knuth's 3x+1 sequence
			h = 3 * h + 1;

		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h; j = j - h) {
					if (array[j] < array[j - h])
						swap(array, j, j - h);
					else
						break;
				}
			}

			h = h / 3;
		}

	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 5, 1, 3, 8, 9, 4, 7, 2, 0 };
		sort(array);
		for (int x : array)
			System.out.print(x + " ");

	}

}
