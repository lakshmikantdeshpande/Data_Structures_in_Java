package linkedlist;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesSortedLL {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SLL.insertBeginning(i);
            SLL.insertBeginning(i);
        }
        SLL.display();

        SLL.head = removeDuplicates1(SLL.head);
        removeDuplicates2(SLL.head);
    }

    // N time 1 space
    private static void removeDuplicates2(SLL.Node head) {
        if (head == null) {
            return;
        }

        SLL.Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == curr.data) {
                SLL.Node nextnext = curr.next.next;
                curr.next = null;
                curr.next = nextnext;
            } else {
                curr = curr.next;
            }
        }
    }

    // N time N space
    private static SLL.Node removeDuplicates1(SLL.Node head) {
        if (head == null) {
            return null;
        }

        SLL.Node curr = head;
        Set<Integer> set = new LinkedHashSet<>();

        while (curr != null) {
            set.add(curr.data);
            curr = curr.next;
        }

        curr = null;
        SLL.Node temp = null;
        for (int i : set) {
            if (curr == null) {
                curr = new SLL.Node(i);
                temp = curr;
            } else {
                curr.next = new SLL.Node(i);
                curr = curr.next;
            }
        }
        return temp;
    }

}
