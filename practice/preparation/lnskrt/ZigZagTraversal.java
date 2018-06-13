import java.util.Deque;
import java.util.LinkedList;

public class ZigZagTraversal {

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

        printTreeInZigZagFashion(root);
    }

    private static void printTreeInZigZagFashion(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> reverseStack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty() || !reverseStack.isEmpty()) {

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.println(node.data);

                if (node.right != null) {
                    reverseStack.push(node.right);
                }

                if (node.left != null) {
                    reverseStack.push(node.left);
                }
            }

            while (!reverseStack.isEmpty()) {
                TreeNode node = reverseStack.pop();
                System.out.println(node.data);

                if (node.left != null) {
                    stack.push(node.left);
                }

                if (node.right != null) {
                    stack.push(node.right);
                }

            }
        }
    }

}
