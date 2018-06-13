import java.util.LinkedList;
import java.util.Queue;

public class FindHalfNodes {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(98);
        root.left.left = new TreeNode(8456);
        root.right.right = new TreeNode(455);
        root.right.right.right = new TreeNode(455);
        root.right.right.right.right = new TreeNode(455);
        root.right.right.right.left = new TreeNode(455);

        System.out.printf("There are %d half nodes in the tree\n", findHalfNodes(root));
        System.out.printf("There are %d half nodes in the tree\n", findHalfNodesRecursive(root, 0));
    }

    private static int findHalfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
                count++;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return count;
    }

    private static int findHalfNodesRecursive(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            return 1 + findHalfNodes(root.right == null ? root.left : root.right);
        } else {
            return findHalfNodesRecursive(root.left, i) + findHalfNodesRecursive(root.right, i);
        }
    }

}
