// Recursive
// M + N time M + N space for recursion

package linked_list.problems;

public class MergeTwoSortedLinkedLists_1 {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node insertBeginning(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }

        Node oldHead = head;
        head = new Node(data);
        head.next = oldHead;
        return head;
    }

    private static Node mergeTwoLinkedLists(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        Node head = new Node(0);
        if (head1.data <= head2.data) {
            head = head1;
            head.next = mergeTwoLinkedLists(head1.next, head2);
        } else {
            head = head2;
            head.next = mergeTwoLinkedLists(head2.next, head1);
        }

        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(111);
        Node head2 = new Node(222);

        MergeTwoSortedLinkedLists_1 one = new MergeTwoSortedLinkedLists_1();
        head1 = one.insertBeginning(head1, 6);
        head1 = one.insertBeginning(head1, 5);
        head1 = one.insertBeginning(head1, 2);

        MergeTwoSortedLinkedLists_1 two = new MergeTwoSortedLinkedLists_1();
        head2 = two.insertBeginning(head2, 3);
        head2 = two.insertBeginning(head2, 2);
        head2 = two.insertBeginning(head2, 1);

        Node temp = mergeTwoLinkedLists(head1, head2);
        display(temp);
    }

    private static void display(Node temp) {
        if (temp == null) {
            System.out.println("");
        }
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
    }

}
