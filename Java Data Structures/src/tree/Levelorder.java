package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Levelorder {

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;

		// Initialize
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);

		ArrayList<Integer> curr = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp != null) {
				curr.add(temp.data);
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			} else {
				ArrayList<Integer> ccurr = new ArrayList<Integer>(curr);
				res.add(ccurr);
				curr.clear();

				if (!queue.isEmpty())
					queue.offer(null);
			}
		}
		return res;
	}
	
	public static void levelOrderPrint(TreeNode root) {
		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();

			if (temp != null) {
				System.out.print(temp.data + " ");
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			} else {
				System.out.println();
				if (!queue.isEmpty())
					queue.offer(null);
			}
		}
		System.out.println("************************");
	}
}
