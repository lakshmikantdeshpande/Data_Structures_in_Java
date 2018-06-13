import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth {

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

        System.out.println(findMinimumDepthRec(root));
        System.out.println(findMinimumDepthNonRec(root));
    }

    private static int findMinimumDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return 1 + findMinimumDepthRec(root.right);
        }

        if (root.right == null) {
            return 1 + findMinimumDepthRec(root.left);
        }

        return 1 + Math.min(findMinimumDepthRec(root.left), findMinimumDepthRec(root.right));
    }

    private static int findMinimumDepthNonRec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    count++;
                    queue.offer(null);
                }
            } else {
                if (node.left == null && node.right == null) {
                    return count;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return count;
    }

}
