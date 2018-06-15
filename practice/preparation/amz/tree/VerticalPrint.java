package amz.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalPrint {

    private static class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
        }
    }

    private static void printVertically(Node head, int key, TreeMap<Integer, List<Integer>> map) {
        if (head == null) {
            return;
        }

        List<Integer> list = map.getOrDefault(key, new ArrayList<>());
        list.add(head.data);
        map.put(key, list);
        printVertically(head.left, key - 1, map);
        printVertically(head.right, key + 1, map);
    }

    private static void printTreeVertically(TreeMap<Integer, List<Integer>> map) {
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
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

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        printVertically(root, 0, map);
        printTreeVertically(map);
    }

}
