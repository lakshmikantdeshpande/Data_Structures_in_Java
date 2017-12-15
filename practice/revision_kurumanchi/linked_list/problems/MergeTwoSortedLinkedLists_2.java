// M + N time 1 space

package linked_list.problems;

public class MergeTwoSortedLinkedLists_2 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private static void display(Node temp) {
        if (temp == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (temp != null) {
            stringBuilder.append(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(stringBuilder.toString());
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

        Node temp = new Node(0);
        Node head = temp;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        if (head1 == null) {
            temp.next = head2;
        } else {
            temp.next = head2;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head1 = null;
        Node head2 = null;

        MergeTwoSortedLinkedLists_2 one = new MergeTwoSortedLinkedLists_2();
        head1 = one.insertBeginning(head1, 6);
        head1 = one.insertBeginning(head1, 5);
        head1 = one.insertBeginning(head1, 2);

        MergeTwoSortedLinkedLists_2 two = new MergeTwoSortedLinkedLists_2();
        head2 = two.insertBeginning(head2, 3);
        head2 = two.insertBeginning(head2, 2);
        head2 = two.insertBeginning(head2, 1);

        Node temp = mergeTwoLinkedLists(head1, head2);
        display(temp);
    }

}
