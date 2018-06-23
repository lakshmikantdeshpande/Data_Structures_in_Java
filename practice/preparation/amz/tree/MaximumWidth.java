package amz.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {

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
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);

        System.out.println("Maximum width is " + getMaximumWidth(root));
    }

    private static int getMaximumWidth(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                if (!queue.isEmpty()) {
                    max = Math.max(queue.size(), max);
                    queue.offer(null);
                }
            }
        }
        return max;
    }

}
