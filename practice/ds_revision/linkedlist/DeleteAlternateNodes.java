package linkedlist;

public class DeleteAlternateNodes {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            SLL.insertBeginning(i);
        }
        SLL.display();

        SLL.head = deleteAlternateNodes1(SLL.head);
        SLL.display();
        SLL.head = deleteAlternateNodes2(SLL.head);
        SLL.display();
    }

    // N time N space (recursion)
    private static SLL.Node deleteAlternateNodes2(SLL.Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteAlternateNodes2(head.next.next);
        return head;
    }

    // N time 1 space
    private static SLL.Node deleteAlternateNodes1(SLL.Node head) {
        if (head == null) {
            return null;
        }

        SLL.Node temp = head;
        while (temp != null && temp.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return head;
    }

}
