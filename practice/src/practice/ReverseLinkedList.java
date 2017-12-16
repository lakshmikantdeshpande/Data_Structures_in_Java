package practice;

public class ReverseLinkedList {
    static class Node {
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
        }

        Node oldHead = head;
        head = new Node(data);
        head.next = oldHead;
    }

    private void reverse() {
        if (head == null) {
            return;
        }

        Node curr = head, prev = null;
        while (curr != null) {
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    private Node reverseLinkedList(Node curr, Node prev) {
        if (curr.next == null) {
            head = curr;
            curr.next = prev;
            return null;
        }

        Node temp = curr.next;
        curr.next = prev;
        reverseLinkedList(temp, curr);
        return head;
    }


    private void display() {
        if (head == null) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            stringBuilder.append(" -> ").append(temp.data);
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
        linkedList.reverse();
        linkedList.display();
        linkedList.reverseLinkedList(linkedList.head, null);
        linkedList.display();
    }
}
