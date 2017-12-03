package linked_list.problems;

import java.util.HashMap;
import java.util.Map;

public class FindCycleLinkedList_1 {

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

    private boolean isCyclePresent() {
        if (head == null) {
            return false;
        }

        Map<Node, Integer> map = new HashMap<>();
        Node temp = head;

        while (temp.next != null) {
            if (map.containsKey(temp)) {
                return true;
            } else {
                map.put(temp, 0);
            }
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        FindCycleLinkedList_1 linkedList = new FindCycleLinkedList_1();
        linkedList.insertBeginning(1);
        linkedList.insertBeginning(2);
        linkedList.insertBeginning(3);
        linkedList.insertBeginning(4);
        linkedList.insertBeginning(5);
        linkedList.insertBeginning(6);
        linkedList.insertBeginning(7);
        linkedList.insertBeginning(8);

        linkedList.head.next.next.next.next.next.next.next = linkedList.head.next.next;
        System.out.println(linkedList.isCyclePresent());
    }

}
