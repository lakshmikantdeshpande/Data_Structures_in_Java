package week_4_PriorityQ_and_BST_Symbol_Tables.PartOne;

public class BinaryHeapMaxPQ {
	private int[] pq; // priority queue starts with 1 in our case
	int N; // size of the priority queue;

	public BinaryHeapMaxPQ(int capacity) {
		pq = new int[capacity];
		N = 0;
	}

	public void insert(int p) {
		pq[++N] = p; // add to the end of the heap, and let it float up
		swim(N);
	}

	private void swim(int k) // to float, we've to divide index by 2 (i.e. k/2)
	{
		while (k > 1 && (pq[k] > pq[k / 2])) // while child is greater than
												// parent
		{
			swap(k, k / 2);
			k = k / 2;
		}
	}

	public int delMax() {
		int max = pq[1]; // root is the maximum element
		swap(1, N--);
		sink(1);
		// pq[N+1] = null; // if this was an array of objects, to avoid
		// loitering
		return max;
	}

	private void sink(int k) {
		while (k * 2 <= N) {
			int j = k * 2;
			if (j < N && pq[j] < pq[j + 1])
				j++;
			if (pq[k] >= pq[j])
				break;
			swap(k, j);
			k = j;
		}
	}

	private void swap(int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	// My own function to print the heap :D
	public void printheap() {
		int k = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < k && i <= N; j++) {
				System.out.print(pq[i++] + " ");
			}
			k = (int) Math.pow(2, k++);
			i--;
			System.out.println();
		}
	}

	public static void main(String[] args) {
		BinaryHeapMaxPQ bpq = new BinaryHeapMaxPQ(10);
		bpq.insert(3);
		bpq.insert(4);
		bpq.insert(5);
		bpq.insert(6);
		bpq.insert(7);
		bpq.insert(9);
		bpq.delMax();
		bpq.delMax();
		bpq.printheap();
		// for (int i = 0; i <= bpq.N; i++) {
		// System.out.println(bpq.pq[i]);
		// }
	}

}
