import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node head, tail;
    private int size;

    public Deque() {
    	head = tail = null;
    	size = 0;
    }

    private class Node{
        Item item;
        Node next;
        Node prev;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size()
    {
        return this.size;
    }

    public void addFirst(Item item){
    	if (item == null)
    		throw new NullPointerException();
    	
    	if (this.isEmpty())
    	{
    		head = new Node();
    		head.item = item;
    		head.next = null;
    		head.prev = null;
    		tail = head;
    	}
    	else
    	{
    		Node oldhead = head;
    		head = new Node();
    		head.item = item;
    		head.next = oldhead;
    		oldhead.prev = head;
    		head.prev = null;
    	}
    	size++;
    }

    public void addLast(Item item){
    	if (item == null)
    		throw new NullPointerException();
    	
    	if (this.isEmpty())
    	{
    		tail = new Node();
    		tail.item = item;
    		tail.next = null;
    		tail.prev = null;
    		head = tail;
    	}
    	else
    	{
    		Node oldtail = tail;
    		tail= new Node();
    		tail.item = item;
    		tail.next = null;
    		tail.prev = oldtail;
    		oldtail.next = tail;
    	}
    	size++;
    }
    
    public Item removeFirst()
    {
    	if (this.size == 0)
    		throw new NoSuchElementException();
    	this.size--;
    	Item item = head.item;
    	head = head.next;
    	if (isEmpty())
    		tail = null;
    	else
    		head.prev = null;
    	return item;
    }
    
    public Item removeLast()
    {
    	if (this.size == 0)
    		throw new NoSuchElementException();
    	this.size--;
    	Item item = tail.item;
    	tail = tail.prev;
    	if (isEmpty())
    		head = null;
    	else
    		tail.next = null;
    	
    	return item;
    }
    
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
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String args[]){
		Deque deq = new Deque();
    	deq.addFirst("hi");
    	deq.addLast(0);
    	deq.addLast(2);
    	deq.addFirst(1);
    	deq.addFirst("zuzu");
    	
//    	deq.removeFirst();
//    	deq.removeFirst();
//    	deq.removeFirst();
//    	deq.removeLast();
//    	deq.removeFirst ();
//    	
    	Iterator iterator = deq.iterator();
    	while (iterator.hasNext())
    	{
    		System.out.println(iterator.next());
    	}
    	
    }
}
