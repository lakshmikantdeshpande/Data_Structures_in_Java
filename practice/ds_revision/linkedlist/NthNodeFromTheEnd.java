package linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static linkedlist.SLL.head;

public class NthNodeFromTheEnd {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            SLL.insertBeginning(i);
        }
        SLL.display();

        // starting with 1 index
        System.out.println(findNthNodeFromTheEnd1(head, 5));
        System.out.println(findNthNodeFromTheEnd2(head, 5));
        System.out.println(findNthNodeFromTheEnd3(head, 5));
        findNthNodeFromTheEnd4(head, 5); // Won't print anything if the value is invalid
        System.out.println(findNthNodeFromTheEnd5(head, 5));
    }

    // Length + N time 1 space
    // Sliding window approach
    private static int findNthNodeFromTheEnd5(SLL.Node head, int N) {
        if (head == null || N <= 0) {
            return -1;
        }

        SLL.Node temp = head;
        int i;
        for (i = 0; i < N && temp != null; i++) {
            temp = temp.next;
        }

        if (N < i) {
            return -1;
        } else {
            while (temp != null) {
                temp = temp.next;
                head = head.next;
            }
            return head.data;
        }

    }

    // N time N space for recursion
    private static int counter = 0;

    private static void findNthNodeFromTheEnd4(SLL.Node head, int N) {
        if (head == null) {
            return;
        }
        findNthNodeFromTheEnd4(head.next, N);
        counter++;
        if (counter == N) {
            System.out.println(head.data);
        }
    }

    // N time N space stack
    private static int findNthNodeFromTheEnd3(SLL.Node head, int N) {
        if (head == null || N <= 0) {
            return -1;
        }

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.data);
            head = head.next;
        }

        int counter = 0, temp = -1;
        while (!stack.isEmpty() && counter != N) {
            temp = stack.pop();
            ++counter;
        }
        if (counter == N) {
            return temp;
        } else {
            return -1;
        }
    }

    // N time N space hashmap
    private static int findNthNodeFromTheEnd2(SLL.Node head, int N) {
        if (head == null || N <= 0) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (head != null) {
            map.put(++i, head.data);
            head = head.next;
        }

        if (N > map.size()) {
            return -1;
        } else {
            return map.get(map.size() - N + 1);
        }
    }

    // N * N time 1 space
    private static int findNthNodeFromTheEnd1(SLL.Node head, int N) {
        if (head == null || N <= 0) {
            return -1;
        }

        SLL.Node temp = head;
        while (temp != null) {
            SLL.Node t = temp;
            int count = 0;
            while (t != null) {
                t = t.next;
                count++;
            }
            if (count == N) {
                return temp.data;
            }
            temp = temp.next;
        }
        return -1;
    }

}
