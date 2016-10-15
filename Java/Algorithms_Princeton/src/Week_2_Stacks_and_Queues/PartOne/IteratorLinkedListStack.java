package Week_2_Stacks_and_Queues.PartOne;

import java.util.Iterator;

public class IteratorLinkedListStack<Item> implements Iterable<Item> {
    Node head = null;

    public static void main(String args[]) {
        IteratorLinkedListStack ills = new IteratorLinkedListStack();
        ills.push(1);
        ills.push("Two");
        ills.push('3');
        Iterator iterator = ills.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void push(Item item) {
        Node oldhead = head;
        head = new Node();
        head.item = item;
        head.next = oldhead;
    }

    public Item pop() {
        Item item = head.item;
        head = head.next;
        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public StackIterator iterator() {
        return new StackIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class StackIterator implements Iterator<Item> {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            // Not Implemented
        }
    }

}
