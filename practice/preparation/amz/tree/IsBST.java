package amz.tree;

public class IsBST {

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        System.out.println(isBST(root));
    }

    // WRONG
    private static boolean isBST(Node root) {
        if (root == null) {
            return false;
        }

        if (root.left != null && root.left.data >= root.data) {
            return false;
        }
        if (root.right != null && root.right.data <= root.data) {
            return false;
        }

        return isBST(root.left) && isBST(root.right);
    }

    // CORRECT
    private static boolean isBSTCorrect(Node root) {
        if (root == null) {
            return false;
        }

        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBST(Node root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        if (root.data < minValue || root.data > maxValue)
            return false;

        return (checkBST(root.left, minValue, root.data - 1) &&
                checkBST(root.right, root.data + 1, maxValue));
    }

}
