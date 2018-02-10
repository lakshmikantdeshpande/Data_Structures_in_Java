import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {

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

        System.out.println(heightOfTree(root));
        System.out.println(heightOfTreeLevelOrder(root));
        System.out.println(minHeightOfTree(root));
    }

    private static int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        return 1 + Math.max(left, right);
    }

    private static int minHeightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return 1 + minHeightOfTree(root.right);
        }

        if (root.right == null) {
            return 1 + minHeightOfTree(root.left);
        }

        return 1 + Math.min(minHeightOfTree(root.left), minHeightOfTree(root.right));
    }

    private static int heightOfTreeLevelOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int counter = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                ++counter;
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
            }
        }
        return counter;
    }

}
