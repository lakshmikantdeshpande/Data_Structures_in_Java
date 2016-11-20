package week_4_PriorityQ_and_BST_Symbol_Tables.PartOne;

public class UnorderedMaxPQ {
	private int[] pq;
	private int size;

	public UnorderedMaxPQ(int capacity) {
		pq = new int[capacity];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void insert(int t) {
		pq[size++] = t;
	}

	public int delMax() {
		int max = 0;
		for (int i = 0; i < size; i++)
			if (pq[i] > pq[max])
				max = i;

		swap(max, size - 1);
		return pq[--size];
	}

	private void swap(int max, int i) {
		int temp = pq[max];
		pq[max] = pq[i];
		pq[i] = temp;
	}

	public static void main(String[] args) {
		UnorderedMaxPQ upq = new UnorderedMaxPQ(5);
		upq.insert(1);
		upq.insert(3);
		upq.insert(2);
		upq.insert(9);
		upq.insert(5);
		System.out.println(upq.delMax());
	}

}
