// heap index starting from 1 (following Princeton Algorithms course style)
// insertion logn deletion logn getMin 1 time
// n space

package heap_priority_queue;

public class MinHeap {
	private int size;
	private int capacity;
	private int[] array;

	public MinHeap(int capacity) {
		this.size = 0;
		if (capacity <= 0)
			this.capacity = 11;
		else
			this.capacity = capacity;
		array = new int[this.capacity];
	}

	public MinHeap() {
		this(10);
	}

	public void insert(int data) {
		if (size == capacity) {
			System.out.println("Array is full, can't continue");
			return;
		}
		array[++size] = data;
		swim(size);
	}

	public int getMin() {
		if (size < 1)
			return Integer.MIN_VALUE;
		int min = array[1];
		swap(1, size--);
		sink(1);
		return min;
	}

	public int min() {
		if (size < 1)
			return Integer.MIN_VALUE;
		return array[1];
	}

	private void swim(int k) {
		// swim up until heap is restored
		while (k > 1 && array[k] < array[k / 2]) {
			swap(k, k / 2);
			k /= 2;
		}
	}

	private void sink(int k) {
		// sink down until heap is restored
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

	private void swap(int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) {
		MinHeap minheap = new MinHeap(30);
		minheap.insert(5);
		minheap.insert(10);
		minheap.insert(0);
		minheap.insert(84);
		minheap.insert(1);
		minheap.insert(2);
		minheap.insert(15);

		for (int i = 0; i < 7; i++)
			System.out.println(minheap.getMin());

	}

}
