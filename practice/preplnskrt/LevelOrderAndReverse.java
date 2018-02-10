import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderAndReverse {

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

        levelOrder(root);
        reverseLevelOrder(root);
        levelOrderFromBottom(root);
    }

    private static void levelOrderFromBottom(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            stack.push(node);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop().data).append(" -> ");
        }
        System.out.println(stringBuilder.toString());
    }

    private static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            stringBuilder.append(node.data).append(" -> ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println(stringBuilder.toString());
    }

    private static void reverseLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            stringBuilder.append(node.data).append(" -> ");
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
        }
        System.out.println(stringBuilder.toString());
    }

}
