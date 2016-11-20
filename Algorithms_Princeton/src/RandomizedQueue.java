import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private List<Item> queue;

	public RandomizedQueue() {
		// construct an empty randomized queue
		queue = new ArrayList<Item>();
	}

	public boolean isEmpty() {
		// is the queue empty?
		return queue.size() == 0;
	}

	public int size() {
		// return the number of items on the queue
		return queue.size();
	}

	public void enqueue(Item item) {
		// add the item
		if (item == null) {
			throw new NullPointerException();
		}

		queue.add(item);
	}

	public Item dequeue() {
		// remove and return a random item
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		int random = StdRandom.uniform(size());
		return queue.remove(random);
	}

	public Item sample() {
		// return (but do not remove) a random item
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return queue.get(StdRandom.uniform(size()));
	}

	@Override
	public Iterator<Item> iterator() {
		// return an independent iterator over items in random order
		return new RandomIterator();
	}

	private class RandomIterator implements Iterator<Item> {
		public RandomIterator() {
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return dequeue();
		}

		@Override
		public boolean hasNext() {
			return size() > 0;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public static void main(String[] args) {
	}
}