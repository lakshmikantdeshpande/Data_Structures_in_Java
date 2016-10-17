package Week_2_Stacks_and_Queues.PartOne;

/**
 * Implementation of stack using linked list
 * Reverse given string using stack
 */
public class StackOfStringsLinkedList {
    Node head = null;
    int size = 0;

    public static void main(String args[]) throws Exception {
        StackOfStringsLinkedList sos = new StackOfStringsLinkedList();
        sos.push("one");
        sos.push("two");
        sos.push("three");
        sos.push("four");
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }

    public void push(String item) {
        Node oldhead = head;
        head = new Node();
        head.item = item;
        this.size++;
        head.next = oldhead;
    }

    public String pop() {
        if (head == null) {
            throw new NullPointerException("Stack is empty");
        }
        String item = head.item;
        head = head.next;
        this.size--;
        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private int size() {
        return this.size;
    }

    private class Node {
        String item;
        Node next;
    }
}
