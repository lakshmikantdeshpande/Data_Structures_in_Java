package linked_list_Problems;

public class InsertIntoSortedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    private void insertIntoSortedList(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        } else if (head.data >= data) {
            insertBeginning(data);
            return;
        }

        Node temp = new Node(data);

        Node p = head;
        while (p.next != null && p.data < data) {
            p = p.next;
        }
        temp.next = p.next;
        p.next = temp;
    }

    private void insertBeginning(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return;
        }

        Node oldHead = head;
        head = new Node(data);
        head.next = oldHead;
    }

    private void display() {
        if (head == null) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            stringBuilder.append(temp.data);
            temp = temp.next;
        }

        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        InsertIntoSortedList linkedList = new InsertIntoSortedList();

        linkedList.insertBeginning(8);
        linkedList.insertBeginning(7);
        linkedList.insertBeginning(6);
        linkedList.insertBeginning(5);
        linkedList.insertBeginning(4);
        linkedList.insertBeginning(3);
        linkedList.insertBeginning(2);
        linkedList.insertBeginning(1);

        linkedList.display();
        linkedList.insertIntoSortedList(0);
        linkedList.display();

    }
}
