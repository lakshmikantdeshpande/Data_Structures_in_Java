package linkedlist;

public class MakeLastNodeTheFirstNode {

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            SLL.insertBeginning(i);
        }
        SLL.display();

        SLL.head = makeLastNodeTheFirstNode(SLL.head);
        SLL.display();
    }

    // N time 1 space
    private static SLL.Node makeLastNodeTheFirstNode(SLL.Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        SLL.Node temp = head;
        SLL.Node old = null;
        while (temp.next != null) {
            old = temp;
            temp = temp.next;
        }
        old.next = null;
        temp.next = head;
        head = temp;
        return head;
    }

}
