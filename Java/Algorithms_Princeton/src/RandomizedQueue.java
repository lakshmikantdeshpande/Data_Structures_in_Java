import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] array;
	private int size;

	public RandomizedQueue() {
		// construct an empty randomized queue
		array = (Item[]) new Object[1];
		size = 0;
	}

	public boolean isEmpty() {
		// is the queue empty?
		return size == 0;
	}

	public int size() {
		// return the number of items on the queue
		return size;
	}

	public void enqueue(Item item) {
		// add the item
		if (item == null) {
			throw new NullPointerException();
		} else if (size == array.length) {
			resize(array.length * 2);
		}

		array[size] = item;
		size++;
	}

	private void resize(int newsize) {
		Item[] newarray = (Item[]) new Object[newsize];
		for (int i = 0; i < newsize; i++) {
			newarray[i] = array[i];
		}
		array = newarray;
	}

	public Item dequeue() {
		// remove and return a random item
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		int random = StdRandom.uniform(size);
		Item item = array[random];

		if (size - 1 == random) {
			array[random] = null;
		} else {
			array[random] = array[size - 1];
			array[size - 1] = null;
		}

		if (size == array.length / 4) {
			resize(array.length / 2);
		}
		size--;
		return item;
	}

	public Item sample() {
		// return (but do not remove) a random item
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		int random = StdRandom.uniform(size);
		Item item = array[random];
		// array[random] = null;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		// return an independent iterator over items in random order
		return new RandomIterator();
	}

	private class RandomIterator implements Iterator<Item> {
		private int i = 0;
		private int[] visited;

		public RandomIterator() {
			visited = new int[size];
			for (int j = 0; j < visited.length; j++)
				visited[j] = j;
			StdRandom.shuffle(visited);
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return array[visited[i++]];
		}

		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public static void main(String[] args) {
	}
}