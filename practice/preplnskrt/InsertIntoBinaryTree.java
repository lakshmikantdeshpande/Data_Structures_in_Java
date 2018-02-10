import java.util.LinkedList;
import java.util.Queue;

public class InsertIntoBinaryTree {

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

        inorder(root);
        System.out.println();
        root = insertIntoBinaryTree(root, 1);
        inorder(root);
    }

    private static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    private static TreeNode insertIntoBinaryTree(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            } else {
                node.left = new TreeNode(data);
                return root;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else {
                node.right = new TreeNode(data);
                return root;
            }
        }
        return root;
    }

}
