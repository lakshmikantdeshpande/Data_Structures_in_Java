package linkedlist;

public class SortedMerge {

    private Node head;

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private void insertBeginning(final int data) {
        Node oldHead = head;
        head = new Node(data);
        head.next = oldHead;
    }

    private void insertEnd(final int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(data);
    }

    private static void display(Node head) {
        Node temp = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (temp != null) {
            stringBuilder.append(temp.data).append('~');
            temp = temp.next;
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        display(sortedMerge1(getList(0).head, getList(1).head));
        System.out.println();
        display(sortedMerge2(getList(0).head, getList(1).head));
    }

    // N + M time N + M space (for recursion)
    private static Node sortedMerge2(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        Node head;
        if (head1.data <= head2.data) {
            head = head1;
            head.next = sortedMerge2(head1.next, head2);
        } else {
            head = head2;
            head.next = sortedMerge2(head1, head2.next);
        }
        return head;
    }

    // N + M time 1 space
    private static Node sortedMerge1(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        Node head = new Node(0);
        Node temp = head;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 == null) {
            temp.next = head2;
        } else if (head2 == null) {
            temp.next = head1;
        }
        return head.next;
    }

    private static SortedMerge getList(int k) {
        SortedMerge list = new SortedMerge();

        for (int i = k; i < 10 + k; i += 2) {
            list.insertEnd(i);
        }
        System.out.printf("List %d  =>  ", k);
        display(list.head);
        return list;
    }

}
