package linked_list.problems;

public class PrintReverse {
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
            return;
        }

        Node oldHead = head;
        head = new Node(data);
        head.next = oldHead;
        return;
    }

    private String printReverse(Node node) {
        if (node.next == null) {
            return String.valueOf(node.data);
        }

        return printReverse(node.next) + " -> " + node.data;
    }

    public static void main(String[] args) {
        PrintReverse linkedList = new PrintReverse();
        linkedList.insertBeginning(1);
        linkedList.insertBeginning(0);
        linkedList.insertBeginning(-1);
        linkedList.insertBeginning(-2);
        linkedList.insertBeginning(-3);

        System.out.println(linkedList.printReverse(linkedList.head));
    }
}
