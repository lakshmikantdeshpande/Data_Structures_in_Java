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

}
