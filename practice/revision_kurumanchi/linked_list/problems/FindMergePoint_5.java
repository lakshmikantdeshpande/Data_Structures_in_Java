// M + N + min(M + N) time 1 space

package linked_list.problems;

public class FindMergePoint_5 {
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

        int lengthA = 0, lengthB = 0;
        for (Node temp = headA; temp != null; temp = temp.next, ++lengthA) ;
        for (Node temp = headB; temp != null; temp = temp.next, ++lengthB) ;
        int diff = lengthA - lengthB;

        Node tempA = headA, tempB = headB;
        if (diff < 0) {
            tempA = run(tempA, Math.abs(diff));
        } else if (diff > 0) {
            tempB = run(tempB, Math.abs(diff));
        }

        while (tempA != null && tempB != null) {
            if (tempA == tempB) {
                return tempA.data;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return Integer.MIN_VALUE;
    }

    private Node run(Node temp, int diff) {
        for (int i = 0; i < diff; i++) {
            temp = temp.next;
        }
        return temp;
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
        FindMergePoint_5 fmp = new FindMergePoint_5();

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
