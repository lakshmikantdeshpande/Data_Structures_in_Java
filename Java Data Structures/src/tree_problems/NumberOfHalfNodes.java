// 18. Find number of nodes in a binary tree with one child only (half nodes)
// n time n space

package tree_problems;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfHalfNodes {

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(6);

        System.out.println(getHalfNodes(root));
    }

    // classic level order traversal
    private static int getHalfNodes(TreeNode root) {
        if (root == null)
            return 0;

        int halfNodes = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if ((temp.left == null && temp.right != null) || (temp.left != null && temp.right == null))
                halfNodes++;
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }

        return halfNodes;
    }
}
