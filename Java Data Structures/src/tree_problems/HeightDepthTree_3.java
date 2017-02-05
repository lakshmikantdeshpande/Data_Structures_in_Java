// 12. Solve problem 11 without recursion.
// n time n space

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;

public class HeightDepthTree_3 {

	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		// root.left.left.right = new TreeNode(9);

		System.out.println(findDepth(root));

	}

	// offering null indicates end of the level
	public static int findDepth(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		int max = 1;

		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp != null) {
				if (temp.left == null && temp.right == null)
					return max;

				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			} else {
				if (!queue.isEmpty()) {
					max++;
					queue.offer(null);
				}
			}
		}
		return max;
	}

}
