import java.util.LinkedList;
import java.util.Queue;

public class NumberOfLeaves {

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

        System.out.printf("There are %d leaves in the tree.\n", findNumberOfLeaves(root));
    }

    private static int findNumberOfLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int counter = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right == null && node.left == null) {
                counter++;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return counter;
    }

}
