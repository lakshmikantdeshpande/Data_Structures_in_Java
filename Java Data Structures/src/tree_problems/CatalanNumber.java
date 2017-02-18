// 36. Find possible binary trees from n nodes.
// n*n time n space 

package tree_problems;

public class CatalanNumber {

	public static void main(String[] args) {
		System.out.println(possibleBinaryTrees(4));
	}

	/*-  Catalan Number is given by
	 *			 (2 * n) !
	 *          ------------
	 *        (n + 1) ! * n ! 	    
	 *
	 */
	private static int possibleBinaryTrees(int n) {
		int[] count = new int[n + 1];
		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++)
				count[i] += count[j] * count[i - j - 1];
		}

		return count[n];
	}

}
