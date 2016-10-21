import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private Node head, tail;
	private int size;

	public Deque() {
		head = tail = null;
		size = 0;
	}

	private class Node {
		private Item item;
		private Node next;
		private Node prev;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void addFirst(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}

		if (isEmpty()) {
			head = new Node();
			head.item = item;
			head.next = null;
			head.prev = null;
			tail = head;
		} else {
			Node oldhead = head;
			head = new Node();
			head.item = item;
			head.next = oldhead;
			oldhead.prev = head;
			head.prev = null;
		}
		size++;
	}

	public void addLast(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}

		if (isEmpty()) {
			tail = new Node();
			tail.item = item;
			tail.next = null;
			tail.prev = null;
			head = tail;
		} else {
			Node oldtail = tail;
			tail = new Node();
			tail.item = item;
			tail.next = null;
			tail.prev = oldtail;
			oldtail.next = tail;
		}
		size++;
	}

	public Item removeFirst() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		size--;
		Item item = head.item;
		head = head.next;
		if (isEmpty())
			tail = null;
		else
			head.prev = null;
		return item;
	}

	public Item removeLast() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		size--;
		Item item = tail.item;
		tail = tail.prev;
		if (isEmpty())
			head = null;
		else
			tail.next = null;

		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new DequeComparator();
	}

	private class DequeComparator implements Iterator<Item> {
		private Node current = head;

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public void remove() {
			// Not Implemented
			throw new UnsupportedOperationException();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String args[]) {
		Deque deq = new Deque();
		deq.addFirst("hi");
		deq.addLast(0);
		deq.addLast(2);
		deq.addFirst(1);
		deq.addFirst("zuzu");

		// deq.removeFirst();
		// deq.removeFirst();
		// deq.removeFirst();
		// deq.removeLast();
		// deq.removeFirst ();
		//
		Iterator iterator = deq.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}
}
