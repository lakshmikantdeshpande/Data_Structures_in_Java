// 32. Given two sorted linked lists, we need to merge them into the third list in sorted order.
// O(n) time, O(n) space stack
// recursion
package linked_list_Problems;

public class Merge_Sorted_Linked_List_1 {
    private Node head1;
    private Node head2;

    public static void display(Node head) {
        Node temp = head;
        if (temp == null)
            return;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Merge_Sorted_Linked_List_1 msll = new Merge_Sorted_Linked_List_1();
        msll.head1 = new Node(0);
        msll.head2 = new Node(1);

        Node one1 = new Node(2);
        Node one2 = new Node(4);
        Node one3 = new Node(5);
        Node one4 = new Node(7);
        Node one5 = new Node(9);
        msll.head1.next = one1;
        one1.next = one2;
        one2.next = one3;
        one3.next = one4;
        one4.next = one5;

        Node two1 = new Node(3);
        Node two2 = new Node(5);
        Node two3 = new Node(6);
        Node two4 = new Node(8);
        Node two5 = new Node(10);
        msll.head2.next = two1;
        two1.next = two2;
        two2.next = two3;
        two3.next = two4;
        two4.next = two5;

        display(msll.head1);
        display(msll.head2);
        display(merge(msll.head1, msll.head2));
    }

    private static Node merge(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        Node head;
        if (head1.data <= head2.data) {
            head = head1;
            head.next = merge(head1.next, head2);
        } else {
            head = head2;
            head.next = merge(head2.next, head1);
        }
        return head;
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

}
