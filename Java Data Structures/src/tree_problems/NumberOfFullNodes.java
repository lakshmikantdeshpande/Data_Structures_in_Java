// 17. Find number of full nodes in a binary tree
// n time n space

package tree_problems;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfFullNodes {

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(getFullNodes(root));
    }

    // classic level order traversal
    private static int getFullNodes(TreeNode root) {
        if (root == null)
            return 0;

        int fullNodes = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null && temp.right != null)
                fullNodes++;
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }

        return fullNodes;
    }
}
