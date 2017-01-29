// 11. Solve problem 10 using stack.
// n time n space

package tree_problems;

import java.util.Stack;

import tree.TreeNode;

public class HeightDepthTree_2 {

	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(findDepth(root));
	}

	/*-
	 *     __          _______   ____  _   _  _____       _____ ____  _____  ______ 
	 *     \ \        / /  __ \ / __ \| \ | |/ ____|     / ____/ __ \|  __ \|  ____|
	 *      \ \  /\  / /| |__) | |  | |  \| | |  __     | |   | |  | | |  | | |__   
	 *       \ \/  \/ / |  _  /| |  | | . ` | | |_ |    | |   | |  | | |  | |  __|  
	 *        \  /\  /  | | \ \| |__| | |\  | |__| |    | |___| |__| | |__| | |____ 
	 *         \/  \/   |_|  \_\\____/|_| \_|\_____|     \_____\____/|_____/|______|
	 *                                                                              
	 *                                                                              
	 */

	// non recursive
	private static int findDepth(TreeNode root) {
		if (root == null)
			return 0;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		int max = 0;
		TreeNode prev = null;

		while (!stack.isEmpty()) {
			TreeNode curr = stack.peek();

			if (prev == null || prev.left == null || prev.right == null) {
				if (curr.left != null)
					stack.push(curr.left);
				else if (curr.right != null)
					stack.push(curr.right);
			} else if (curr.left == prev) {
				if (curr.right != null)
					stack.push(curr.right);
			} else
				stack.pop();
			prev = curr;
			if (stack.size() > max)
				max = stack.size();
		}
		return max;
	}
}
