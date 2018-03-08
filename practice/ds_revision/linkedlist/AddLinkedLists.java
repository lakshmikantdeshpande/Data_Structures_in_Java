package linkedlist;

public class AddLinkedLists {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(2);
        head1.next = new Node(7);

        Node head2 = new Node(9);
        head2.next = new Node(9);
        head2.next.next = new Node(2);

        display(head1);
        display(head2);
        display(additionOfTwoLinkedLists(head1, head2));
    }

    private static Node additionOfTwoLinkedLists(Node head1, Node head2) {
        Node head = null;
        Node prev = null;
        Node temp = null;
        int carry = 0;
        int sum;

        while (head1 != null || head2 != null) {
            sum = carry + (head1 != null ? head1.data : 0) + (head2 != null ? head2.data : 0);
            carry = sum > 10 ? 1 : 0;
            sum %= 10;

            temp = new Node(sum);

            if (head == null) {
                head = temp;
            } else {
                prev.next = temp;
            }

            prev = temp;

            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }

        if (carry > 0) {
            temp.next = new Node(carry);
        }
        return head;
    }

    private static void display(Node temp) {
        StringBuilder stringBuilder = new StringBuilder();
        while (temp != null) {
            stringBuilder.append(temp.data).append("--");
            temp = temp.next;
        }
        System.out.println(stringBuilder.toString());
    }

}
