package Week_2_Stacks_and_Queues.PartOne;

public class GenericsLinkedListStack<Item> {
    Node head = null;

    private class Node {
        Item item;
        Node next;
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

    public static void main(String args[])
    {
        GenericsLinkedListStack gs = new GenericsLinkedListStack();
        System.out.println(gs.isEmpty());
        // pushing three different datatypes
        gs.push(1);
        gs.push("Two");
        gs.push('3');
        System.out.println(gs.pop());
        System.out.println(gs.pop());
        System.out.println(gs.pop());
    }
}
