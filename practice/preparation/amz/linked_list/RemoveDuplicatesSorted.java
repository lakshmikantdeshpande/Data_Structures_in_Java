package amz.linked_list;

public class RemoveDuplicatesSorted {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
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

    // N time 1 space
    private static void removeDuplicatesBruteForce(Node head) {
        if (head == null) {
            return;
        }

        Node temp = head;
        while (temp != null && temp.next != null) {
            Node next = temp.next;
            while (next != null && next.data == temp.data) {
                next = next.next;
            }
            temp.next = next;
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        display(head);
        removeDuplicatesBruteForce(head);
        display(head);
    }

}
