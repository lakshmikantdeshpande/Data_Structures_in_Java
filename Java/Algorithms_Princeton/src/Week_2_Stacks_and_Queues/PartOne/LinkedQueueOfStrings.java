package Week_2_Stacks_and_Queues;

public class LinkedQueueOfStrings {
    Node head, tail;

    public static void main(String args[]) throws Exception {
        LinkedQueueOfStrings sos = new LinkedQueueOfStrings();
        sos.enqueue("one");
        sos.enqueue("two");
        sos.enqueue("three");
        sos.enqueue("four");
        System.out.println(sos.dequeue());
        System.out.println(sos.dequeue());
        System.out.println(sos.dequeue());
        System.out.println(sos.dequeue());
        System.out.println(sos.dequeue());
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(String item) {
        Node oldtail = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if (isEmpty())
            head = tail;
        else
            oldtail.next = tail;
    }

    public String dequeue() {
        String item = head.item;
        head = head.next;
        if (isEmpty())
            tail = null;
        return item;
    }

    private class Node {
        String item;
        Node next;
    }
}
