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
        SLL.display();

        System.out.println(isPalindrome1(SLL.head));
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
