package amz.tree;

import java.util.TreeMap;

public class VerticalSum {

    private static class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
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

        TreeMap<Integer, Integer> map = new TreeMap<>();
        verticalSum(root, map);
    }

    private static void verticalSum(Node root, TreeMap<Integer, Integer> map) {
        if (root == null) {
            throw new RuntimeException("Invalid input");
        }

        sum(root, 0, map);
        for (int value : map.values()) {
            System.out.println(value);
        }
    }

    private static void sum(Node root, int key, TreeMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(key, map.getOrDefault(key, 0) + root.data);
        sum(root.left, key - 1, map);
        sum(root.right, key + 1, map);
    }

}
