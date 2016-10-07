package dynamic_connectivity;

public class QuickFind {
	private int []id;
	
	public QuickFind(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	public boolean find(int p, int q)
	{
		return id[p] == id[q];
	}
	
	public void union(int p, int q)
	{
		int pid = id[p];
		int qid = id[q];
		int len = id.length;
		
		for (int i = 0; i < len; i++)
			if (id[i] == pid)
				id[i] = qid;
	}
	
	public static void main(String[] args) {
		QuickFind qfi =  new QuickFind(4);
		qfi.union(0, 3);
		qfi.union(1, 2);
		System.out.println(qfi.find(1, 2));
		System.out.println(qfi.find(1, 3));
		System.out.println(qfi.find(2,3));
		qfi.union(2, 3);
		System.out.println(qfi.find(2,3));
		System.out.println(qfi.find(1, 1));
	}

}
