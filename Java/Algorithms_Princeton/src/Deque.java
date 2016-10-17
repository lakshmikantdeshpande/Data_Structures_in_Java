import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node head = null, tail = null;
    private int size = 0;

    public Deque() {
        head = new Node();
        tail = head;
    }

    private class Node{
        Item item;
        Node next;
        Node prev;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size()
    {
        return this.size;
    }

    public void addFirst(Item item){
        Node oldtail = tail;
        tail = new Node();
        tail.item = item;

        if (isEmpty())
            head = tail;
        else // tail exists
        {
            tail.next = oldtail;
            if(oldtail.prev
        }

        size++;
    }

    public void addLast(Item item){}

    public DequeComparator iterator()
    {
        return new DequeComparator();
    }

    class DequeComparator implements Iterator<Item> {
        Node current = head;

        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
        public boolean hasNext(){
            return current != null;
        }
        public void remove(){
            // Not Implemented
        }
    }

    public static void main(String args[]){

    }
}
