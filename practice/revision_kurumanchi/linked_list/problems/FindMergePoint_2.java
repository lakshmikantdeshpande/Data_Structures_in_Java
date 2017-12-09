package linked_list.problems;

import java.util.Stack;

public class FindMergePoint_2 {
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

        Stack<Node> stackA = new Stack<>();
        Stack<Node> stackB = new Stack<>();
        Node tempA = headA;
        while (tempA != null) {
            stackA.push(tempA);
            tempA = tempA.next;
        }

        Node tempB = headB;
        while (tempB != null) {
            stackB.push(tempB);
            tempB = tempB.next;
        }

        int last = Integer.MIN_VALUE;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() == stackB.peek()) {
                last = stackA.peek().data;
            } else {
                stackA.clear();
                stackB.clear();
                return last;
            }
            stackA.pop();
            stackB.pop();
        }
        return last;
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
        FindMergePoint_2 fmp = new FindMergePoint_2();

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
