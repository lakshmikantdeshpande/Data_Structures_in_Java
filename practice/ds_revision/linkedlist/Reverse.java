package linkedlist;

import java.util.Stack;

public class Reverse {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            SLL.insertBeginning(i);
        }
        SLL.display();

        SLL.head = reverse1(SLL.head);
        SLL.display();
        SLL.head = reverse2(SLL.head);
        SLL.display();
        SLL.head = reverse3(SLL.head);
        SLL.display();
    }

    private static SLL.Node reverse3(SLL.Node head) {
        if (head == null) {
            return null;
        }

        SLL.Node curr = head, prev = null;
        while (curr != null) {
            SLL.Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static SLL.Node reverse2(SLL.Node head) {
        if (head == null) {
            return null;
        }
        return reverse(head, null);
    }

    private static SLL.Node reverse(SLL.Node curr, SLL.Node prev) {
        if (curr.next == null) {
            SLL.head = curr;
            curr.next = prev;
            return null;
        }

        SLL.Node next = curr.next;
        curr.next = prev;
        reverse(next, curr);
        return SLL.head;
    }

    // N + N time N space
    private static SLL.Node reverse1(SLL.Node head) {
        if (head == null) {
            return null;
        }

        Stack<SLL.Node> stack = new Stack<>();

        while (head != null) {
            SLL.Node temp = head;
            head = head.next;
            temp.next = null;

            stack.push(temp);
        }

        SLL.Node temp = null;
        while (!stack.isEmpty()) {
            if (head == null) {
                head = stack.pop();
                temp = head;
            } else {
                temp.next = stack.pop();
                temp = temp.next;
            }
        }
        return head;
    }

}
