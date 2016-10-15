package Week_1_Dynamic_Connectivity.PartOne;

class QuickFind {
	private int[] id;

	private QuickFind(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}

	private boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	private void union(int p, int q) {
		if (id[p] == id[q])
			return;
		else {
			int len = id.length;
			int pid = id[p];
			int qid = id[q];
			for (int i = 0; i < len; i++)
				if (id[i] == pid)
					id[i] = qid;
		}
	}

	public static void main(String args[]) throws Exception {

		QuickFind qf = new QuickFind(4);
		qf.union(0, 3);
		qf.union(1, 2);
		System.out.println(qf.connected(1, 2));
		System.out.println(qf.connected(1, 3));
		System.out.println(qf.connected(2, 3));
		qf.union(2, 3);
		System.out.println(qf.connected(2, 3));
		System.out.println(qf.connected(0, 3));
		System.out.println(qf.connected(1, 0));
		qf.union(1, 3);
		qf.union(1, 0);
		System.out.println(qf.connected(1, 0));

	}
}
