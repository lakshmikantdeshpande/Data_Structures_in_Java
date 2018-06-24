package amz.tree;

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
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(lca(root, root.left, root.right).data);
    }

    private static Node lca(Node root, Node a, Node b) {
        if (root == null) {
            return null;
        }

        if (root == a || root == b) {
            return root;
        }

        Node left = lca(root.left, a, b);
        Node right = lca(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

}
