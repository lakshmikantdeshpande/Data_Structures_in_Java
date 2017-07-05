// 26. Solve problem 25 without recursion.
// n time n space

package tree_problems;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSum_2 {

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(sum(root));
    }

    private static int sum(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            sum += temp.data;
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        return sum;
    }

}
