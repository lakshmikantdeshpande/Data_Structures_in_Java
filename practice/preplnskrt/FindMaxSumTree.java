import java.util.LinkedList;
import java.util.Queue;

public class FindMaxSumTree {

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

        System.out.println(findMaxSumLevel(root));
    }

    private static int findMaxSumLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int current = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                max = Math.max(current, max);
                current = 0;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                current += node.data;
            }
        }
        return max;
    }

}
