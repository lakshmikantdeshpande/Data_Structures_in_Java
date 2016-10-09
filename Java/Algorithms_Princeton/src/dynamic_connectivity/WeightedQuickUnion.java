package dynamic_connectivity;

public class WeightedQuickUnion {
	int []id;
	int []size;
	
	public WeightedQuickUnion(int N) 
	{
		id = new int[N];
		size = new int[N];
		for (int i = 0; i < N; i++)
		{
			id[i] = i;
			size[i] = 1;
		}
	}
	
	int root(int n)
	{
		while (id[n] != n)
			n = id[n];
		return n;
	}
	
	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}
	
	public void union(int p, int q)
	{
		int pid = root(p);
		int qid = root(q);
		if (pid == qid)
			return;
		else 
		{
			if (size[p] >= size[q])
			{
				size[q] += size[p];
				id[pid] = qid;
			}
			else
			{
				size[p] += size[q];
				id[qid] = pid;
							
			}
		}
	}
	
	public static void main(String[] args) 
	{
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