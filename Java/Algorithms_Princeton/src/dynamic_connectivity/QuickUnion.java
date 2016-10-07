package dynamic_connectivity;

public class QuickUnion {
	private int []id;
	public QuickUnion(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	// find root of the tree
	private int root(int i)
	{
		while (id[i] != i)
			i = id[i];
		return i;
			
	}
	
	public void union(int p, int q)
	{
		int proot = root(p);
		int qroot = root(q);
		id[proot] = qroot;
	}
	
	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}
	
	
	public static void main(String[] args) {

		QuickUnion qu = new QuickUnion(4);
		qu.union(0,3);
		qu.union(1, 2);
		System.out.println(qu.connected(1,2));
		System.out.println(qu.connected(1,3));
		System.out.println(qu.connected(2,3));
		qu.union(2, 3);
		System.out.println(qu.connected(2,3));
		System.out.println(qu.connected(0,3));
	}

}
