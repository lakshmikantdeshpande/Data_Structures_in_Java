package linkedlist;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesUnsortedLL {

    public static void main(String[] args) {
        getLinkedList();
        SLL.display();

        SLL.head = removeDuplicates1(SLL.head);
        SLL.display();

        getLinkedList();
        SLL.head = removeDuplicates2(SLL.head);
        SLL.display();
    }

    // N time N space
    private static SLL.Node removeDuplicates2(SLL.Node head) {
        if (head == null) {
            return null;
        }

        Set<Integer> set = new LinkedHashSet<>();
        SLL.Node temp = head;
        while (temp != null) {
            SLL.Node nxt = temp.next;
            temp.next = null;
            set.add(temp.data);
            temp = nxt;
        }

        SLL.Node newHead = null;
        for (int k : set) {
            if (temp == null) {
                temp = new SLL.Node(k);
                newHead = temp;
            } else {
                temp.next = new SLL.Node(k);
                temp = temp.next;
            }
        }
        return newHead;
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

    private static SLL.Node getLinkedList() {
        SLL.head = null;
        for (int i = 0; i < 10; i++) {
            SLL.insertBeginning(i);
            SLL.insertBeginning(i);
        }
        return SLL.head;
    }

}
