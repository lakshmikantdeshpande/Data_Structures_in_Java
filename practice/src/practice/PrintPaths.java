package practice;

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
        root.left.left = new Node(-12);
        root.left.right = new Node(12);
        printPaths(root, new ArrayList<>());
    }

    private static void printPaths(Node root, List<Integer> paths) {
        if (root == null || paths == null) {
            return;
        }

        paths.add(root.data);
        printPaths(root.left, paths);
        printPaths(root.right, paths);
        // print only if it is a leaf node
        if (root.left == null && root.right == null) {
            print(paths);
        }

        // remove the current node, so that it can go back to callee and choose right path
        if (!paths.isEmpty()) {
            paths.remove(paths.size() - 1);
        }
    }

    private static void print(List<Integer> paths) {
        for (Integer i : paths) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

}
