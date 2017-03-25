// 45. Find number of siblings for a node
// n time 1 space

package tree_problems;

import tree.GenericTreeNode;

public class NoOfSiblingsGenericTrees {

	public static void main(String[] args) {
		GenericTreeNode root = new GenericTreeNode(1);
		root.firstChild = new GenericTreeNode(2);
		root.firstChild.nextSibling = new GenericTreeNode(3);
		root.firstChild.nextSibling.firstChild = new GenericTreeNode(4);
		root.firstChild.nextSibling.nextSibling = new GenericTreeNode(5);
		root.firstChild.nextSibling.nextSibling.firstChild = new GenericTreeNode(6);
		root.firstChild.nextSibling.nextSibling.firstChild.firstChild = new GenericTreeNode(7);

		System.out.println(siblingCount(root.firstChild));
		System.out.println(siblingCount(root.firstChild));
	}

	private static int siblingCount(GenericTreeNode root) {
		if (root == null)
			return 0;
		int count = 0;
		while (root.nextSibling != null) {
			++count;
			root = root.nextSibling;
		}
		return count;
	}

}
