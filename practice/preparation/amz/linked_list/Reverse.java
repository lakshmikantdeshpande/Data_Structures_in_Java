package amz.linked_list;

import java.util.ArrayDeque;
import java.util.Deque;

public class Reverse {

    private static Node head;

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private static Node reverseBruteForce(Node head) {
        if (head == null) {
            return null;
        }

        Deque<Node> stack = new ArrayDeque<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        Node newHead = stack.pop();
        temp = newHead;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return newHead;
    }

    private static Node reverseOptimal(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void display(Node head) {
        Node temp = head;
        StringBuilder output = new StringBuilder();
        while (temp != null) {
            output.append(temp.data).append('-');
            temp = temp.next;
        }
        System.out.println(output.toString());
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);

        display(head);
        head = reverseBruteForce(head);
        display(head);
        head = reverseOptimal(head);
        display(head);
    }

}
