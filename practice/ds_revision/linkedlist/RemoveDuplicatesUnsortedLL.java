package linkedlist;


public class RemoveDuplicatesUnsortedLL {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SLL.insertBeginning(i);
            SLL.insertBeginning(i);
        }
        SLL.display();

        SLL.head = removeDuplicates1(SLL.head);
        SLL.display();
    }

    // N * N time 1 space
    private static SLL.Node removeDuplicates1(SLL.Node head) {
        if (head == null) {
            return null;
        }

        SLL.Node temp1 = head, temp2;
        while (temp1 != null && temp1.next != null) {
            temp2 = temp1;
            while (temp2.next != null) {
                if (temp1.data == temp2.next.data) {
                    SLL.Node nextnext = temp2.next.next;
                    temp2.next = null;
                    temp2.next = nextnext;
                } else {
                    temp2 = temp2.next;
                }
            }
            temp1 = temp1.next;
        }
        return head;
    }

}
