// 49. Build a k-ary tree from given preorder traversal 
// where each tree has 0 or k nodes. (full k-ary tree)
// n time n space

// SKIPPED FOR NOW  (WRONG CODE)

package tree_problems;

public class KaryTreeFromPreorder {

	static class KaryTreeNode {
		public int data;
		public KaryTreeNode[] child;

		// assuming that least k should be 0
		public KaryTreeNode(int k) {
			if (k < 0)
				k = 0;
			child = new KaryTreeNode[k];
		}

		public void setChild(int i, KaryTreeNode ktn) {
			child[i] = ktn;
		}

		public KaryTreeNode getChild(int i) {
			return child[i];
		}
	}

	public static void main(String[] args) {
		build(new int[] { 1, 2, 5, 6, 7, 3, 9, 10, 11, 4 }, 10, 2);
	}

	static int index = 0;

	public static KaryTreeNode build(int[] array, int n, int k) {
		if (n <= 0)
			return null;

		KaryTreeNode node = new KaryTreeNode(k);

		node.data = array[index];
		for (int i = 0; i < k; i++) {
			if (k * index + i < n) {
				index++;
				node.setChild(index, build(array, n, k));
			}
		}
		return node;
	}

}
