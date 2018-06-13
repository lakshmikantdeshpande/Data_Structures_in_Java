import java.util.LinkedList;
import java.util.Queue;

public class SumOfBinaryTree {

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

        System.out.printf("The sum of the tree elements is %d.\n", binaryTreeSum(root, 0));
        System.out.printf("The sum of the tree elements is %d.\n", binaryTreeSum(root));
    }

    private static int binaryTreeSum(TreeNode root, int current) {
        if (root == null) {
            return 0;
        }

        return root.data + binaryTreeSum(root.left, current) + binaryTreeSum(root.right, current);
    }

    private static int binaryTreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sum += node.data;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return sum;
    }

}
