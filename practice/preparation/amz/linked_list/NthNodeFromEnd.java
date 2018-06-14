package amz.linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NthNodeFromEnd {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // N * N time 1 space
    private static int findNthNodeFromTheEndBruteForce(Node head, int n) {
        if (head == null || n <= 0) {
            return -1;
        }

        Node temp = head;
        while (temp != null) {
            Node t = temp;
            int count = 0;
            while (t != null) {
                t = t.next;
                count++;
            }
            if (count == n) {
                return temp.data;
            }
            temp = temp.next;
        }
        return -1;
    }

    // N + N time 1 space
    private static int findNthNodeFromTheEndTwoIterations(Node head, int n) {
        if (head == null || n <= 0) {
            return -1;
        }

        Node temp = head;
        int counter = 0;
        while (temp != null) {
            temp = temp.next;
            counter++;
        }

        if (counter < n) {
            return -1;
        }

        temp = head;
        for (int i = 0; i < counter - n; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // N time N space
    private static int findNthNodeFromTheEndList(Node head, int n) {
        if (head == null || n <= 0) {
            return -1;
        }

        List<Integer> list = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }
        if (n > list.size()) {
            return -1;
        }
        return list.get(list.size() - n);
    }

    // N time 1 space
    private static int findNthNodeFromTheEndTwoPointers(Node head, int n) {
        if (head == null || n <= 0) {
            return -1;
        }

        Node fast = head;
        Node slow = head;
        for (int i = 1; i < n && fast != null; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return -1;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }

    private static int counter = 0;

    private static void findNthNodeFromTheEndRecursive(Node head, int n) {
        if (head == null) {
            return;
        }
        findNthNodeFromTheEndRecursive(head.next, n);
        counter++;
        if (counter == n) {
            System.out.println(head.data);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Arrays.asList(0, 1, 5, 6).forEach(x -> System.out.println(findNthNodeFromTheEndBruteForce(head, x)));
        System.out.println();
        Arrays.asList(0, 1, 5, 6).forEach(x -> System.out.println(findNthNodeFromTheEndTwoIterations(head, x)));
        System.out.println();
        Arrays.asList(0, 1, 5, 6).forEach(x -> System.out.println(findNthNodeFromTheEndList(head, x)));
        System.out.println();
        Arrays.asList(0, 1, 5, 6).forEach(x -> System.out.println(findNthNodeFromTheEndTwoPointers(head, x)));
        System.out.println();
        Arrays.asList(0, 1, 5, 6).forEach(x -> {
            findNthNodeFromTheEndRecursive(head, x);
            counter = 0;
        });
    }

}
