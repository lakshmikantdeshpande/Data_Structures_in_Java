// 41. Find the sum of all the elements in a generic tree.
// n time n space (recursion)

package tree_problems;

import tree.GenericTreeNode;

public class FindSumGenericTree {

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

		System.out.println(findSum(root));
	}

	private static int findSum(GenericTreeNode root) {
		if (root == null)
			return 0;
		return root.data + findSum(root.firstChild) + findSum(root.nextSibling);
	}

}
