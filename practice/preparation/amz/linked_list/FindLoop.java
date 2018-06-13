package amz.linked_list;

import java.util.HashSet;
import java.util.Set;

public class FindLoop {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // N time complexity, N space complexity
    private boolean isLoopPresentBruteForce(Node head) {
        if (head == null) {
            return false;
        }

        Set<Node> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // N time complexity, N space complexity
    private boolean isLoopPresentMostOptimal(Node head) {
        if (head == null) {
            return false;
        }

        Node fastPointer = head;
        Node slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next; // created a loop

        FindLoop findLoop = new FindLoop();
        System.out.println(findLoop.isLoopPresentBruteForce(head));
        System.out.println(findLoop.isLoopPresentMostOptimal(head));
    }

}
