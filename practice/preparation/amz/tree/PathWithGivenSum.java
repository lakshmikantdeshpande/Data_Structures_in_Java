package amz.tree;

public class PathWithGivenSum {

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);

        System.out.println(hasPathWithSum(root, 21));
        System.out.println(hasPathWithSum(root, 22));
    }

    private static boolean hasPathWithSum(Node root, int sum) {
        if (root == null) {
            return false;
        }

        int temp = sum - root.data;
        if (temp == 0) {
            return true;
        } else {
            return hasPathWithSum(root.left, temp) || hasPathWithSum(root.right, temp);
        }
    }

}
