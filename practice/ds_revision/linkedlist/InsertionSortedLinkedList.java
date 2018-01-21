package linkedlist;

public class InsertionSortedLinkedList {

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            if (i == 10) {
                continue;
            }
            SLL.insertEnd(i);
        }
        SLL.display();

        SLL.head = insertIntoSortedLinkedList(SLL.head, 10);
        SLL.display();
    }

    private static SLL.Node insertIntoSortedLinkedList(SLL.Node head, int data) {
        SLL.Node node = new SLL.Node(data);

        if (head == null) {
            head = node;
            return head;
        } else if (head.data >= data) {
            SLL.Node oldHead = head;
            head = node;
            head.next = oldHead;
            return head;
        }

        SLL.Node q = null, p = head;

        while (p.next != null && p.data < node.data) {
            q = p;
            p = p.next;
        }

        if (p.next == null) {
            p.next = node;
        } else {
            node.next = q.next;
            q.next = node;
        }
        return head;
    }
}
