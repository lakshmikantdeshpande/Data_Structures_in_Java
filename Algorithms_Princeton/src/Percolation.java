
class Percolation {

	private int size;
	private int[] states;
	private WeightedQuickUnionUF tree;

	public Percolation(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("Please pass valid arguments");

		size = n;
		tree = new WeightedQuickUnionUF(n * n + 2); // n*n for matrix,
		// additional 2 for virtual
		// top and bottom roots
		states = new int[n * n + 2];
		for (int i = 0; i < n * n; i++)
			states[i] = 0; // 0 closed, 1 Open

		states[n * n] = states[n * n + 1] = 1; // virtual top and virtual bottom
		// set to 1
	}

	public void open(int i, int j) {
		validateIndices(i, j);
		if (isOpen(i, j))
			return;
		int cell = mapIndices(i, j);
		states[cell] = 1; // state opened
		// Now open all the adjacent cells

		if (i != 1 && isOpen(i - 1, j)) // if the row is not the first one, call
			// union method
			connect(mapIndices(i - 1, j), cell);
		else if (i == 1)
			connect(cell, size * size); // If it's a top row, connect the cell
		// to the virtual top root

		if (i != size && isOpen(i + 1, j))
			connect(mapIndices(i + 1, j), cell);
		else if (i == size)
			connect(cell, size * size + 1); // If it's a bottom row, connect the
		// cell to the virtual bottom root

		if (j != 1 && isOpen(i, j - 1))
			connect(mapIndices(i, j - 1), cell); // if the cell is not in the
		// leftmost column

		if (j != size && isOpen(i, j + 1))
			connect(mapIndices(i, j + 1), cell); // if the cell is not in the
		// rightmost column
	}

	private void connect(int p, int q) {
		if (!tree.connected(p, q)) {
			tree.union(p, q);
		}
	}

	public boolean isOpen(int i, int j) {
		validateIndices(i, j);
		int t = mapIndices(i, j);
		return states[t] == 1;
	}

	public boolean isFull(int i, int j) {
		validateIndices(i, j);
		return tree.connected(size * size, mapIndices(i, j));
	}

	public boolean percolates() {
		return tree.connected(size * size, size * size + 1);
	}

	private int mapIndices(int i, int j) {
		// map 2D indices to 1D
		return (size * (i - 1)) + j - 1;
	}

	private boolean validateIndices(int i, int j) {
		int n = size;
		if (i <= 0 || i > n || j <= 0 || j > n)
			throw new IndexOutOfBoundsException("Index out of bounds !");
		return true;
	}
}