package practice;

public class SelectionSort {

	public static void selectionSort(int[] array) {
		int length = array.length;
		for (int i = 0; i < length; i++) {
			int min = i;
			for (int j = i + 1; j < length; j++) {
				if (array[min] > array[j])
					min = j;
			}
			swap(array, i, min);
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 3, 5, 67, 3, 2, 65, 57, 2, 34, 5, 57, 3, 3, 45, 856, 76 };
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		selectionSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
