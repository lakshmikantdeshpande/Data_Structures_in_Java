package amz.linked_list;

public class Palindrome {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(5);
        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(Node head) {
        if (head == null) {
            return false;
        }

        Node fast = head;
        Node slow = head;
        Node slowPrev = head;
        Node middle = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slowPrev = slow;
            slow = slow.next;
        }

        if (fast != null) {
            middle = slow;
            slow = slow.next;
        }

        Node secondHead = slow;
        slowPrev.next = null;
        secondHead = reverse(secondHead);
        boolean result = compare(head, secondHead);
        secondHead = reverse(secondHead);

        if (middle != null) {
            slowPrev.next = middle;
            middle.next = secondHead;
        } else {
            slowPrev.next = secondHead;
        }
        return result;
    }

    private static boolean compare(Node head, Node secondHead) {
        if (head == null && secondHead == null) {
            return true;
        }
        if (head == null || secondHead == null) {
            return false;
        }

        Node temp1 = head;
        Node temp2 = secondHead;
        while (temp1 != null && temp2 != null) {
            if (temp1.data != temp2.data) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1 == null && temp2 == null;
    }

    private static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
