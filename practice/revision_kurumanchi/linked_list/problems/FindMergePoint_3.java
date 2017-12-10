package linked_list.problems;

import java.util.HashSet;
import java.util.Set;

public class FindMergePoint_3 {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }


    private Node insertBeginning(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }

        Node oldHead = head;
        head = new Node(data);
        head.next = oldHead;
        return head;
    }

    private int findMergePoint(Node headA, Node headB) {
        if (headA == null || headB == null) {
            throw new IllegalArgumentException();
        }

        Set<Node> set = new HashSet<>();

        for (Node temp = headA; temp != null; temp = temp.next) {
            set.add(temp);
        }

        for (Node temp = headB; temp != null; temp = temp.next) {
            if (!set.add(temp)) {
                return temp.data;
            }
        }
        return Integer.MIN_VALUE;
    }

    private void display(Node head) {
        if (head == null) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            stringBuilder.append(temp.data + "-");
            temp = temp.next;
        }

        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        Node headA = null, headB = null;
        FindMergePoint_3 fmp = new FindMergePoint_3();

        headA = fmp.insertBeginning(headA, 4);
        headA = fmp.insertBeginning(headA, 3);
        headA = fmp.insertBeginning(headA, 2);
        headA = fmp.insertBeginning(headA, 1);

        headB = fmp.insertBeginning(headB, 9);
        headB = fmp.insertBeginning(headB, 7);
        headB.next.next = headA.next.next;

        fmp.display(headA);
        fmp.display(headB);

        System.out.println(fmp.findMergePoint(headA, headB));
    }
}
