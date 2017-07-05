// 27. Convert a tree to its mirror tree
// n time n space

package tree_problems;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        printLevelOrder(root);
        root = mirror(root);
        System.out.println();
        printLevelOrder(root);
    }

    private static TreeNode mirror(TreeNode root) {
        if (root == null)
            return null;
        mirror(root.left);
        mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    // helper function for printing tree in level order
    private static void printLevelOrder(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
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
    }
}
