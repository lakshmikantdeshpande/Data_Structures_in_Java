// 48. Find number of children for a node in a generic tree.
// n time 1 space;

package tree_problems;

import tree.GenericTreeNode;

public class FindChildrenGenericTree {

	public static void main(String[] args) {
		GenericTreeNode root = new GenericTreeNode(1);
		root.firstChild = new GenericTreeNode(2);
		root.firstChild.nextSibling = new GenericTreeNode(3);
		root.firstChild.nextSibling.firstChild = new GenericTreeNode(4);
		root.firstChild.nextSibling.nextSibling = new GenericTreeNode(5);
		root.firstChild.nextSibling.nextSibling.firstChild = new GenericTreeNode(
				6);
		root.firstChild.nextSibling.nextSibling.firstChild.firstChild = new GenericTreeNode(
				7);

		System.out.println(findChildrenCount(root));
	}

	private static int findChildrenCount(GenericTreeNode root) {
		if (root == null)
			return 0;
		GenericTreeNode temp = root.firstChild;
		int count = 0;
		while (temp != null) {
			temp = temp.nextSibling;
			count++;
		}
		return count;
	}

}
