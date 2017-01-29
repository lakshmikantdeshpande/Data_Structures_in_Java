// 14. Find the deepest node in the binary tree
// n time n space

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;

public class Deepest_Node {

	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		// null check necessary
		System.out.println(deepestNode(root).data);

	}

	// simple level order traversal
	// last processed item is deepest
	private static TreeNode deepestNode(TreeNode root) {
		if (root == null)
			return null;

		TreeNode temp = null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			temp = queue.poll();

			if (temp.left != null)
				queue.offer(temp.left);
			if (temp.right != null)
				queue.offer(temp.right);

		}

		return temp;
	}

}
