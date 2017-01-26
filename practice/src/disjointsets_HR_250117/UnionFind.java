package disjointsets_HR_250117;

public class UnionFind {
	int[] array;
	int[] size;

	public UnionFind() {
		this(10);
	}

	public UnionFind(int esize) {
		size = new int[esize];
		array = new int[esize];

		for (int i = 0; i < esize; i++)
			array[i] = i;
	}

	// find
	public boolean connected(int a, int b) {
		return root(a) == root(b);
	}

	// connect the two points
	public void union(int a, int b) {
		int x = root(a);
		array[b] = x;
	}

	// return root of the given array
	public int root(int x) {
		while (x != array[x]) {
			x = array[array[x]];
			x = array[x];
		}
		return x;
	}

	public static void main(String[] args) {

	}

}
