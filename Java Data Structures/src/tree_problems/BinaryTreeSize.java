// 6, 7.  Find the size of the binary tree (Recursive and non recursive)
// n time n space

package tree_problems;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSize {

    // elegant code using inorder
    private static int size = 0;

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(treeSize(root));
        System.out.println(size(root));
        System.out.println(findSize(root));
    }

    private static int findSize(TreeNode root) {
        size = 0;
        inorderSize(root);
        return size;
    }

    private static void inorderSize(TreeNode root) {
        if (root == null)
            return;
        inorderSize(root.left);
        size++;
        inorderSize(root.right);
    }

    // recursive
    private static int treeSize(TreeNode root) {
        if (root == null)
            return 0;
        int left = root.left == null ? 0 : treeSize(root.left);
        int right = root.right == null ? 0 : treeSize(root.right);
        return 1 + left + right; // size of root = 1
    }

    // non recursive
    private static int size(TreeNode root) {
        if (root == null)
            return 0;
        int size = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            size++;
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        return size;
    }

}
