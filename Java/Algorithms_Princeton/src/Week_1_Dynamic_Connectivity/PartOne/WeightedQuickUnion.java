package Week_1_Dynamic_Connectivity.PartOne;

class WeightedQuickUnion {
	private int[] id;
	private int[] size; // to store component size

	private WeightedQuickUnion(int N) {
		id = new int[N];
		size = new int[N];
		// initialize id elements with itself (individual components)
		// initialize component sizes to 1
		for (int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}

	private int root(int n) {
		while (id[n] != n)
			n = id[n];
		return n;
	}

	private boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	private void union(int p, int q) {
		int pid = root(p);
		int qid = root(q);
		if (pid == qid)
			return;
		else {
			// make larger component parent of smaller component
			if (size[p] >= size[q]) {
				size[q] += size[p];
				id[pid] = qid;
			} else {
				size[p] += size[q];
				id[qid] = pid;

			}
		}
	}

	public static void main(String[] args) {
		WeightedQuickUnion wqu = new WeightedQuickUnion(4);
		wqu.union(0, 3);
		wqu.union(1, 2);
		System.out.println(wqu.connected(1, 2));
		System.out.println(wqu.connected(1, 3));
		System.out.println(wqu.connected(2, 3));
		wqu.union(2, 3);
		System.out.println(wqu.connected(2, 3));
		System.out.println(wqu.connected(0, 3));
		System.out.println(wqu.connected(1, 0));
		wqu.union(1, 3);
		wqu.union(1, 0);
		System.out.println(wqu.connected(1, 0));
	}
}