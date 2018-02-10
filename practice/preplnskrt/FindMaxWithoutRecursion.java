import java.util.LinkedList;
import java.util.Queue;

public class FindMaxWithoutRecursion {

    private static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(98);
        root.left.left = new TreeNode(8456);
        root.left.right = new TreeNode(45);
        root.right.left = new TreeNode(54564);
        root.right.right = new TreeNode(455);

        findMaxWithoutRecursion(root);
    }

    // using level order
    private static void findMaxWithoutRecursion(TreeNode root) {
        if (root == null) {
            return;
        }

        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            max = Math.max(max, node.data);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println(max);
    }

}
