package amz.tree;

import java.util.ArrayList;
import java.util.List;

public class PrintPaths {

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

        printPaths(root);
    }

    private static void printPaths(Node root) {
        List<Integer> path = new ArrayList<>();
        printAllPaths(root, path);
    }

    private static void printAllPaths(Node root, List<Integer> path) {
        if (root == null || path == null) {
            return;
        }

        path.add(root.data);

        if (root.left == null && root.right == null) {
            print(path);
        } else {
            printAllPaths(root.left, path);
            printAllPaths(root.right, path);
        }
        // Remove last element (Current element)
        if (!path.isEmpty()) {
            path.remove(path.size() - 1);
        }
    }

    private static void print(List<Integer> path) {
        System.out.println(path);
    }

}
