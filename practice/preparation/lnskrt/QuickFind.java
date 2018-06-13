class QuickFind {
    private int[] id;

    QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        if (id[p] != id[q]) {
            int one = id[p];
            int two = id[q];
            for (int i = 0; i < id.length; i++) {
                if (id[i] == one)
                    id[i] = two;
            }
        }
    }
}