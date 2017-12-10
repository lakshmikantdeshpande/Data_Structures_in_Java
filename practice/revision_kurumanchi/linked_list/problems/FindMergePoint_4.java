// N + N + N log N + M log N time  N space

package linked_list.problems;

import java.util.Arrays;

public class FindMergePoint_4 {
    private static class Node implements Comparable<Node> {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        @Override
        public int compareTo(Node o) {
            if (o == null)
                return -1;
            return this.data - o.data;
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

        int len = 0;
        Node temp = headA;
        while (temp != null) {
            ++len;
            temp = temp.next;
        }
        Node[] array = new Node[len];
        Node t = headA;
        for (int i = 0; t != null; t = t.next, i++) {
            array[i] = t;
        }
        Arrays.sort(array);

        for (temp = headB; temp != null; temp = temp.next) {
            int index = Arrays.binarySearch(array, temp);
            if (index > -1) {
                return array[index].data;
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
        FindMergePoint_4 fmp = new FindMergePoint_4();

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
