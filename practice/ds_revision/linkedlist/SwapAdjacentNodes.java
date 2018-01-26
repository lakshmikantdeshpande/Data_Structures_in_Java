package linkedlist;

public class SwapAdjacentNodes {

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            SLL.insertBeginning(i);
        }
        SLL.display();

        swapAdjacentNodes(SLL.head);
        SLL.display();
    }

    // N time 1 space
    private static void swapAdjacentNodes(SLL.Node head) {
        if (head == null) {
            return;
        }
        SLL.Node temp = head;
        while (temp != null && temp.next != null) {
            int data = temp.data;
            temp.data = temp.next.data;
            temp.next.data = data;
            temp = temp.next.next;
        }
    }

}
