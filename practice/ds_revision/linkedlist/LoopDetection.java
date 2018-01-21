package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LoopDetection {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            SLL.insertBeginning(i);
        }
        SLL.insertEnd(7);
        SLL.insertEnd(8);
        SLL.Node temp = SLL.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = SLL.head.next.next;

        System.out.println(isLoopPresent1(SLL.head));
        System.out.println(isLoopPresent2(SLL.head));

    }

    // Floyd's algorithm
    // N time 1 space
    private static boolean isLoopPresent2(SLL.Node head) {
        if (head == null) {
            return false;
        }

        SLL.Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;

            }
        }
        return false;
    }

    // N time N space
    private static boolean isLoopPresent1(SLL.Node head) {
        if (head == null) {
            return false;
        }

        SLL.Node temp = head;
        Set<SLL.Node> set = new HashSet<>();

        while (temp != null) {
            if (!set.add(temp)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

}
