package amz.linked_list;

public class Middle {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // N time 1 space
    private static Node getMiddleNodeOptimal(Node head) {
        if (head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // N + N/2 time 1 space
    private static Node getMiddleNodeBruteForce(Node head) {
        if (head == null) {
            return null;
        }

        int length = findLength(head);
        Node temp = head;
        for (int i = 0; i < length / 2; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private static int findLength(Node head) {
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            ++counter;
            temp = temp.next;
        }
        return counter;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println(getMiddleNodeBruteForce(head).data);
        System.out.println(getMiddleNodeOptimal(head).data);
    }

}
