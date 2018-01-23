package linkedlist;

public class PrintReverse {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            SLL.insertBeginning(i);
        }
        SLL.display();

        displayReverse(SLL.head);
    }

    // N time N space (for recursion)
    private static void displayReverse(SLL.Node head) {
        if (head == null) {
            return;
        }
        displayReverse(head.next);
        System.out.print(head.data + "~");
    }

}
