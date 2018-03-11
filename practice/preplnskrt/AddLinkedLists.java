public class AddLinkedLists {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private static void display(Node head) {
        Node temp = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (temp != null) {
            stringBuilder.append(temp.data).append("->");
            temp = temp.next;
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        Node head1 = new Node(9);
        head1.next = new Node(9);
        head1.next.next = new Node(9);

        Node head2 = new Node(9);
        head2.next = new Node(9);

        display(addTwoLinkedLists(head1, head2));
    }

    private static Node addTwoLinkedLists(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }

        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        Node temp = new Node(0);
        Node prev = temp;
        int carry = 0;

        while (head1 != null || head2 != null) {
            int sum = carry;
            sum += (head1 != null ? head1.data : 0) + (head2 != null ? head2.data : 0);

            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }

            int value = sum % 10;
            carry = sum / 10;
            prev.next = new Node(value);
            prev = prev.next;
        }

        if (carry > 0) {
            prev.next = new Node(carry);
        }

        return temp.next;
    }

}
