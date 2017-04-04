public class Quicksort {

	static void sort(int[] array, int low, int high) {
		if (low < high) {
			int pi = partition(array, low, high);
			sort(array, low, pi - 1);
			sort(array, pi + 1, high);
		}
	}

	static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {

			if (array[j] <= pivot) {
				i++;

				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}

		// swap array[i+1] and array[pivot]
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;

		return i + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 9, 5, 87, 854, 5, 65, 65465, 46, 4654, 8, 854, 64, 54, 6565, 4 };
		sort(array, 0, array.length - 1);
		for (int x : array) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

}
