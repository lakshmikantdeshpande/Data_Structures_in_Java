import java.util.LinkedList;
import java.util.Queue;

public class FindFullNodes {

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

        System.out.printf("There are %d full nodes in the tree\n", findFullNodes(root));
        System.out.printf("There are %d full nodes in the tree\n", findFullNodesRecursive(root, 0));
    }

    private static int findFullNodes(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null && node.right != null) {
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

    private static int findFullNodesRecursive(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        } else {
            return findFullNodesRecursive(root.left, i) + findFullNodesRecursive(root.right, i);
        }
    }

}
