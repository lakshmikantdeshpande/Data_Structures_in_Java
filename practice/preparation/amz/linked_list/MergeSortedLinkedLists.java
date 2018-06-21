package amz.linked_list;

public class MergeSortedLinkedLists {

    public static void main(String[] args) {
        display(createLinkedList(1));
        display(createLinkedList(2));
        Node merged = merge(createLinkedList(1), createLinkedList(2));
        display(merged);
        merged = mergeRecursive(createLinkedList(1), createLinkedList(2));
        display(merged);
    }

    // M + N time M + N space
    private static Node merge(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        } else if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node temp = new Node(0);
        Node tempPrev = temp;
        while (!(head1 == null && head2 == null)) {
            if (head1 == null) {
                temp.next = head2;
                head2 = head2.next;
            } else if (head2 == null) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                if (head1.data <= head2.data) {
                    temp.next = head1;
                    head1 = head1.next;
                } else {
                    temp.next = head2;
                    head2 = head2.next;
                }
            }
            temp = temp.next;
        }
        return tempPrev.next;
    }

    // N + M time N + M space recursion
    private static Node mergeRecursive(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        Node head;
        if (head1.data <= head2.data) {
            head = head1;
            head.next = mergeRecursive(head1.next, head2);
        } else {
            head = head2;
            head.next = mergeRecursive(head1, head2.next);
        }
        return head;
    }

    private static void display(Node head) {
        if (head == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            stringBuilder.append(temp.data).append("--->");
            temp = temp.next;
        }
        System.out.println(stringBuilder.toString());
    }

    private static Node createLinkedList(int start) {
        Node head = new Node(start);
        Node temp = head;
        for (int i = 0, j = start; i < 5; i++, j += 2) {
            temp.next = new Node(j);
            temp = temp.next;
        }
        return head.next;
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

}
