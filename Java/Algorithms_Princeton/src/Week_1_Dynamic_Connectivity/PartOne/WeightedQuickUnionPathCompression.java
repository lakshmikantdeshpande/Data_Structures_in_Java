package Week_1_Dynamic_Connectivity.PartOne;

class WeightedQuickUnionPathCompression {
    private int[] size; // to store component size
    private int[] id;

    private WeightedQuickUnionPathCompression(int N) {
        id = new int[N];
        size = new int[N];
        // initialize id elements with itself (individual components)
        // initialize component sizes to 1
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public static void main(String[] args) {
        WeightedQuickUnionPathCompression wqupc = new WeightedQuickUnionPathCompression(4);
        wqupc.union(0, 3);
        wqupc.union(1, 2);
        System.out.println(wqupc.connected(1, 2));
        System.out.println(wqupc.connected(1, 3));
        System.out.println(wqupc.connected(2, 3));
        wqupc.union(2, 3);
        System.out.println(wqupc.connected(2, 3));
        System.out.println(wqupc.connected(0, 3));
        System.out.println(wqupc.connected(1, 0));
        wqupc.union(1, 3);
        wqupc.union(1, 0);
        System.out.println(wqupc.connected(1, 0));

    }

    private int root(int i) {
        while (i != id[i]) {
            // reduce path by jumping up by 2 for each loop
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
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
            if (size[pid] >= size[qid]) {
                size[pid] += size[qid];
                id[qid] = pid;
            } else {
                size[qid] += size[pid];
                id[pid] = qid;
            }
        }
    }

}