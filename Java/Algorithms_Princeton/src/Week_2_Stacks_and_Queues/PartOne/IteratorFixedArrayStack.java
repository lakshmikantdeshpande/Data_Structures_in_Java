package Week_2_Stacks_and_Queues.PartOne;

import java.util.Iterator;

public class IteratorFixedArrayStack<Item> implements Iterable<Item> {
    Item[] stack;
    int top = 0;

    public IteratorFixedArrayStack(int capacity) {
        // Not a good coding practice
        stack = (Item[]) new Object[capacity];
    }

    public static void main(String args[]) {
        IteratorFixedArrayStack ills = new IteratorFixedArrayStack(5);
        ills.push(1);
        ills.push("Two");
        ills.push('3');
        Iterator iterator = ills.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void push(Item item) {
        stack[++top] = item;
    }

    public Item pop() {
        Item item = stack[top];
        stack[top--] = null;
        return item;
    }

    public StackIterator iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private int i = top;

        public boolean hasNext() {
            return i != 0;
        }

        public Item next() {
            return stack[i--];
        }

        public void remove() {
            // Not implemented
        }
    }
}
