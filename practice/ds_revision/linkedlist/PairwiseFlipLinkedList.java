package linkedlist;

public class PairwiseFlipLinkedList {

    private static Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        head = new Node(0);
        Node temp1 = new Node(1);
        Node temp2 = new Node(2);
        Node temp3 = new Node(3);
        Node temp4 = new Node(4);
        Node temp5 = new Node(5);
        Node temp6 = new Node(7);
        Node temp7 = new Node(8);
        Node temp8 = new Node(9);
        Node temp9 = new Node(10);
        Node temp10 = new Node(11);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = temp6;
        temp6.next = temp7;
        temp7.next = temp8;
        temp8.next = temp9;
        temp9.next = temp10;
        temp10.next = null;

        display(head);
        head = pairwiseFlip(head);
        display(head);
        head = pairwiseFlipRecursive(head);
        display(head);
    }

    private static void display(Node head) {
        if (head == null) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            stringBuilder.append(temp.data).append("->");
            temp = temp.next;
        }
        System.out.println(stringBuilder.toString());
    }

    private static Node pairwiseFlip(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = head;
        Node curr = head.next;
        Node oldHead = curr;

        while (true) {
            Node next = curr.next;
            curr.next = prev;

            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }

            prev.next = next.next;

            prev = next;
            curr = prev.next;
        }
        return oldHead;
    }

    private static Node pairwiseFlipRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node nxt = head.next.next;
        Node newhead = head.next;
        head.next.next = head;
        head.next = pairwiseFlipRecursive(nxt);
        return newhead;
    }

}
