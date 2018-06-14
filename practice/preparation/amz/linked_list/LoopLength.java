package amz.linked_list;

public class LoopLength {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // N + N time 1 space
    private static int findLoopLength(Node head) {
        if (head == null) {
            return 0;
        }

        Node fast = getIntersectionPoint(head);
        if (fast == null) {
            return 0;
        } else {
            Node slow = fast.next;
            int counter = 1;
            while (fast != slow) {
                slow = slow.next;
                ++counter;
            }
            return counter;
        }

    }

    private static Node getIntersectionPoint(Node head) {
        if (head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return fast;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next;

        System.out.println(findLoopLength(head));
    }

}
