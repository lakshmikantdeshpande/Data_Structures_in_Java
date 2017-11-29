package disjoint_set;

public class QuickFind_NetworkConnectivity {
    private int[] ids;

    private QuickFind_NetworkConnectivity(int N) {
        ids = new int[N];
        for (int i = 0; i < N; i++)
            ids[i] = i;
    }

    private boolean connected(int a, int b) {
        return ids[a] == ids[b];
    }

    private void union(int a, int b) {
        if (ids[a] != ids[b]) {
            int length = ids.length;
            int a_id = ids[a];
            int b_id = ids[b];
            for (int i = 0; i < length; i++)
                if (ids[i] == a_id) {
                    ids[i] = b_id;
                }
        }
    }

    public static void main(String args[]) throws Exception {
        QuickFind_NetworkConnectivity qfn = new QuickFind_NetworkConnectivity(4);
        qfn.union(0, 3);
        qfn.union(1, 2);
        System.out.println(qfn.connected(1, 2));
        System.out.println(qfn.connected(1, 3));
        System.out.println(qfn.connected(2, 3));
        qfn.union(2, 3);
        System.out.println(qfn.connected(2, 3));
        System.out.println(qfn.connected(0, 3));
        System.out.println(qfn.connected(1, 0));
        qfn.union(1, 3);
        qfn.union(1, 0);
        System.out.println(qfn.connected(1, 0));

    }

}
