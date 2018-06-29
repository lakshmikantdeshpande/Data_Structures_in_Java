package practice;

public class LCA {

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
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " +
                lca(root, root.left.left, root.left.right).data);
        System.out.println("LCA(4, 6) = " +
                lca(root, root.left.left, root.right.left).data);
        System.out.println("LCA(3, 4) = " +
                lca(root, root.right, root.left.left).data);
        System.out.println("LCA(2, 4) = " +
                lca(root, root.left, root.left.left).data);
    }

    private static Node lca(Node root, Node a, Node b) {
        if (root == null || (a == null && b == null)) {
            return null;
        }

        if (a == root) {
            return a;
        } else if (b == root) {
            return b;
        }

        Node aLca = lca(root.left, a, b);
        Node bLca = lca(root.right, a, b);
        if (aLca != null && bLca != null) {
            return root;
        }

        if (aLca == null) {
            return bLca;
        } else {
            return aLca;
        }
    }

}
