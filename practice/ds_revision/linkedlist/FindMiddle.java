package linkedlist;

import java.util.HashMap;

public class FindMiddle {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            SLL.insertBeginning(i);
        }
        SLL.display();

        System.out.println(findMiddle1(SLL.head));
        System.out.println(findMiddle2(SLL.head));
        System.out.println(findMiddle3(SLL.head));
    }

    // N + N time 1 space
    private static int findMiddle3(SLL.Node head) {
        if (head == null) {
            return -1;
        }

        int length = 0;
        SLL.Node node = head;
        while (node != null) {
            node = node.next;
            ++length;
        }
        node = head;
        int i = 0;
        length /= 2;
        while (i++ < length) {
            node = node.next;
        }
        return node.data;
    }

    // N time N space
    private static int findMiddle2(SLL.Node head) {
        if (head == null) {
            return -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (head != null) {
            map.put(i++, head.data);
            head = head.next;
        }
        return map.get(map.size() / 2);
    }

    // N * N time 1 space
    private static int findMiddle1(SLL.Node head) {
        if (head == null) {
            return -1;
        }

        SLL.Node temp = head;
        int counter = 0;

        while (temp != null) {
            SLL.Node t = temp.next;
            int count = counter;
            while (t != null) {
                t = t.next;
                count++;
            }
            if (count / 2 == counter) {
                return temp.data;
            }

            counter++;
            temp = temp.next;
        }
        return -1;
    }

}
