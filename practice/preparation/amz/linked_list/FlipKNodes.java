package amz.linked_list;

public class FlipKNodes {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private static Node reverseKNodes(Node head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null) {
            head.next = reverseKNodes(next, k);
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        head = reverseKNodes(head, -5);

        display(head);
    }

    private static void display(Node head) {
        if (head == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            stringBuilder.append(temp.data).append("-->");
            temp = temp.next;
        }
        System.out.println(stringBuilder.toString());
    }

}
