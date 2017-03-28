// heap index starting from 1 (following Princeton Algorithms course style)
// insertion logn deletion logn getMax 1 time
// n space

package heap_priority_queue;

public class MaxHeap {
	private int capacity;
	private int size;
	private int[] array;

	public MaxHeap() {
		this(10);
	}

	public MaxHeap(int capacity) {
		this.size = 0;
		if (capacity <= 0)
			this.capacity = 10;
		else
			this.capacity = capacity;

		array = new int[this.capacity];
	}

	public void insert(int data) {
		if (size == capacity) {
			System.out.println("Max heap size reached");
			return;
		}

		array[++size] = data;
		swim(size);
	}

	public int getMax() {
		if (size == 0)
			return Integer.MIN_VALUE;
		int max = array[1];
		swap(1, size--);
		sink(1);
		return max;
	}

	private void sink(int k) {
		while (2 * k <= size) {
			int j = 2 * k;
			if (j < size && array[j] < array[j + 1])
				j++;
			if (array[j] <= array[k])
				break;
			swap(j, k);
			k = j;
		}
	}

	private void swim(int k) {
		while (k > 1 && array[k] > array[k / 2]) {
			swap(k, k / 2);
			k /= 2;
		}
	}

	private void swap(int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public void heapSort() {
		for (int k = size / 2; k >= 1; k--)
			sink(k);
		while (size > 1) {
			System.out.println(array[1]);
			swap(1, size--);
			sink(1);
		}
	}

	public static void main(String[] args) {
		MaxHeap maxheap = new MaxHeap(30);
		maxheap.insert(5);
		maxheap.insert(10);
		maxheap.insert(0);
		maxheap.insert(84);
		maxheap.insert(1);
		maxheap.insert(2);
		maxheap.insert(15);

		// for (int i = 0; i < 7; i++)
		// System.out.println(maxheap.getMax());

		maxheap.heapSort();

	}

}
