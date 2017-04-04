package heap_problems;

public class MinimumHeap {
	int size;
	int capacity;
	int[] array;

	public MinimumHeap(int capacity) {
		if (capacity <= 0) {
			capacity = 10;
			System.out.println("Capacity adjusted to 10, as invalid value was provided.");
		}
		this.size = 0;
		this.capacity = capacity;
		array = new int[capacity + 1];
	}

	public MinimumHeap() {
		this(10);
	}

	public void insert(int element) throws Exception {
		if (isFull())
			throw new Exception("Heap is full");

		array[++size] = element;
		swim(size);
	}

	public int getMin() throws Exception {
		if (isEmpty())
			throw new Exception("Heap is empty");

		int min = array[1];
		swap(1, size--);
		sink(1);
		return min;
	}

	public void sink(int k) {

		while (2 * k <= size) {
			int j = 2 * k;
			if (j < size && array[j] > array[j + 1])
				j++;
			if (array[j] >= array[k])
				break;
			swap(j, k);
			k = j;
		}

	}

	private boolean isEmpty() {
		return size == 0;
	}

	private void swim(int k) {
		while (k > 1 && array[k] < array[k / 2]) {
			swap(k, k / 2);
			k /= 2;
		}
	}

	private void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private boolean isFull() {
		return size == capacity;
	}

}
