package amz.linked_list;

public class Length {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private static int findLengthIterative(Node head) {
        if (head == null) {
            return 0;
        }
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            counter++;
        }
        return counter;
    }

    private static int findLengthRecursive(Node head) {
        if (head == null) {
            return 0;
        }
        return findLengthRecursive(head, 0);
    }

    private static int findLengthRecursive(Node head, int counter) {
        if (head == null) {
            return counter;
        }
        return findLengthRecursive(head.next, counter + 1);
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println(findLengthIterative(head));
        System.out.println(findLengthRecursive(head));
    }

}
