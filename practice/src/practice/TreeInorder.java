package practice;

import java.util.Stack;

public class TreeInorder {
    private static class TreeNode {
        TreeNode left, right;
        int data;

        TreeNode(int data) {
            this.data = data;
        }
    }

    private static void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    private static void inorderNonRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        // push all the left nodes in the stack
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.println(node.data);
            if (node.right != null) {
                // push all left side elements of right node in the stack
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(1);

        inorderRecursive(root);
        System.out.println();
        inorderNonRecursive(root);
    }
}
