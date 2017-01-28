// 2. Find the max element in a binary tree (without recursion)
// n time n space

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

public class MaxElement_2 {

	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(maxElement(root));
	}

	private static int maxElement(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;

		int max = Integer.MIN_VALUE;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();

			if (temp.data > max)
				max = temp.data;

			if (temp.left != null)
				queue.offer(temp.left);
			if (temp.right != null)
				queue.offer(temp.right);
		}

		return max;
	}

}
