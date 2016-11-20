package practice;

public class ShellSort {

	public static void shellSort(int[] array) {
		int length = array.length;
		int h = 1;
		// use increments of 3x+1 to find partitions
		while (h < length / 3)
			h = 3 * h + 1;

		while (h >= 1) {
			for (int i = h; i < length; i++) {
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
		int[] array = { 3, 5, 67, 3, 2, 65, 57, 2, 34, 5, 57, 3, 3, 45, 856, 76 };
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		shellSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
