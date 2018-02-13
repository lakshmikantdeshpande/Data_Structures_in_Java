import java.util.LinkedList;
import java.util.Queue;

public class Mirror {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        root.right.right.right.right = new TreeNode(7);
        root.right.right.right.left = new TreeNode(8);

        printLevelOrder(root);
        root = mirror(root);
        System.out.println();
        printLevelOrder(root);
    }

    private static TreeNode mirror(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) {
            return root;
        }

        TreeNode left = mirror(root.right);
        TreeNode right = mirror(root.left);

        root.left = left;
        root.right = right;
        return root;
    }

    private static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                stringBuilder.append('\n');
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
                stringBuilder.append(node.data).append(' ');
            }
        }
        System.out.println(stringBuilder.toString());
    }

}
