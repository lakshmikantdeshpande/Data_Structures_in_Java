package linkedlist;

import java.util.Stack;

public class Palindrome {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SLL.insertBeginning(i);
        }
        for (int i = 9; i >= 0; i--) {
            SLL.insertBeginning(i);
        }
//        SLL.insertEnd(5);
        SLL.display();

        System.out.println(isPalindrome1(SLL.head));
        System.out.println(isPalindrome2(SLL.head));
    }

    // N + N / 2 + N / 2 + N / 2 time 1 space
    private static boolean isPalindrome2(SLL.Node head) {
        if (head == null) {
            return false;
        } else if (head.next == null) {
            return true;
        }

        SLL.Node fast = head, slow = head;
        SLL.Node prev_slow = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev_slow = slow;
            slow = slow.next;
        }

        SLL.Node middle = null;
        if (fast != null) {
            middle = slow;
            slow = slow.next;
        }

        SLL.Node secondHead = slow;
        prev_slow.next = null;
        secondHead = reverse(secondHead);

        SLL.Node temp = head;
        boolean flag = true;
        while (secondHead != null && temp != null) {
            if (secondHead.data != temp.data) {
                flag = false;
                break;
            }
            secondHead = secondHead.next;
            temp = temp.next;
        }

        secondHead = reverse(secondHead);
        if (middle != null) {
            prev_slow.next = middle;
            middle.next = secondHead;
        } else {
            prev_slow.next = secondHead;
        }
        return flag;
    }

    private static SLL.Node reverse(SLL.Node head) {
        if (head == null) {
            return null;
        }

        SLL.Node curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    // N + N time N space
    private static boolean isPalindrome1(SLL.Node head) {
        if (head == null) {
            return false;
        }

        Stack<SLL.Node> stack = new Stack<>();
        SLL.Node temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        temp = head;

        while (!stack.isEmpty()) {
            if (stack.pop().data != temp.data) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

}
