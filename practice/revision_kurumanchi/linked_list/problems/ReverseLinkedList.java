package linked_list.problems;

public class ReverseLinkedList {

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

    private void reverseLinkedList() {
        if (head == null) {
            System.out.println("NULL LINKED LIST");
            return;
        }

        Node p = head, q = null;

        while (p != null) {
            Node next = p.next;
            p.next = q;
            q = p;
            p = next;
        }

        head = q;
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
        ReverseLinkedList linkedList = new ReverseLinkedList();

        linkedList.insertBeginning(8);
        linkedList.insertBeginning(7);
        linkedList.insertBeginning(6);
        linkedList.insertBeginning(5);
        linkedList.insertBeginning(4);
        linkedList.insertBeginning(3);
        linkedList.insertBeginning(2);
        linkedList.insertBeginning(1);

        linkedList.display();
        linkedList.reverseLinkedList();
        linkedList.display();
    }

}
