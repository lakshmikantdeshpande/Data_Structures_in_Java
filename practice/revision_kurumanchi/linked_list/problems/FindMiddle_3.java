// N time N space

package linked_list.problems;

import java.util.HashMap;
import java.util.Map;

public class FindMiddle_3 {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    private void insertBeginning(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node oldHead = head;
        head = new Node(data);
        head.next = oldHead;
    }

    private int middle() {
        if (head == null) {
            throw new RuntimeException("Linked list is empty");
        }

        Map<Integer, Node> map = new HashMap<>();
        Node temp = head;
        int i = 0;
        while (temp != null) {
            map.put(i++, temp);
            temp = temp.next;
        }

        return map.get(i / 2).data;
    }

    public static void main(String[] args) {
        FindMiddle_3 fm = new FindMiddle_3();

        fm.insertBeginning(5);
        fm.insertBeginning(4);
        fm.insertBeginning(3);
        fm.insertBeginning(2);
        fm.insertBeginning(1);

        System.out.println(fm.middle());
    }
}
