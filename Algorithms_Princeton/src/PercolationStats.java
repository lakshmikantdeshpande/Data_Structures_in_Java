
class PercolationStats {
	private double[] trials;

	private PercolationStats(int n, int tests) {

		if (n <= 0 || tests <= 0)
			throw new IllegalArgumentException();

		trials = new double[tests];

		for (int i = 0; i < tests; i++) {

			Percolation perc = new Percolation(n);
			int steps = 0;
			while (!perc.percolates()) {
				int row = StdRandom.uniform(n) + 1;
				int column = StdRandom.uniform(n) + 1;
				if (!perc.isOpen(row, column)) {
					perc.open(row, column);
					steps++;
				}
			}

			trials[i] = (double) steps / (n * n);
		}
	}

	public static void main(String[] args) {
		PercolationStats ps = new PercolationStats(300, 1000);
		StdOut.print("Mean = " + ps.mean() + "\n");
		StdOut.print("Standard Deviation = " + ps.stddev() + "\n");
		StdOut.print("95% Confidence Interval = " + ps.confidenceLo() + ", "
				+ ps.confidenceHi());
	}

	private double mean() {
		return StdStats.mean(trials);
	}

	private double stddev() {
		return StdStats.stddev(trials);
	}

	private double confidenceLo() {
		return mean() - ((1.96 * stddev()) / Math.sqrt(trials.length));
	}

	private double confidenceHi() {
		return mean() + ((1.96 * stddev()) / Math.sqrt(trials.length));
	}
}