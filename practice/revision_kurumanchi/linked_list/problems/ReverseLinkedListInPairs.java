// N time 1 space

package linked_list.problems;

public class ReverseLinkedListInPairs {
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
    }

    private void display() {
        if (head == null) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            stringBuilder.append("->").append(temp.data);
            temp = temp.next;
        }
        System.out.println(stringBuilder.toString());
    }

    private Node reverseInPairs(Node head) {
        Node temp;
        if (head == null || head.next == null) {
            return head;
        }

        temp = head.next;
        head.next = temp.next;
        temp.next = head;
        head = temp;

        head.next.next = reverseInPairs(head.next.next);
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedListInPairs linkedList = new ReverseLinkedListInPairs();

        linkedList.insertBeginning(8);
        linkedList.insertBeginning(7);
        linkedList.insertBeginning(6);
        linkedList.insertBeginning(5);
        linkedList.insertBeginning(4);
        linkedList.insertBeginning(3);
        linkedList.insertBeginning(2);
        linkedList.insertBeginning(1);

        linkedList.display();
        linkedList.head = linkedList.reverseInPairs(linkedList.head);
        linkedList.display();
    }
}
