package practice;

public class LeastCommonAncestor {

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.right = new Node(4);
        root.right.right = new Node(5);
        root.right.right.right = new Node(6);
        root.right.right.right.right = new Node(7);
        root.right.right.right.left = new Node(8);

        System.out.println(lca(root, 7, 8));
    }

    private static Node lca(Node root, int left, int right) {
        if (root == null) {
            return null;
        }

        if (root.data == left || root.data == right) {
            return root;
        }

        Node leftChild = lca(root.left, left, right);
        Node rightChild = lca(root.right, left, right);

        if (leftChild != null && rightChild != null) {
            return root;
        }

        return leftChild != null ? leftChild : rightChild;
    }
}