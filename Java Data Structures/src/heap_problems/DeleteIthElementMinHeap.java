// 9. Delete ith element from the given min-heap.
// logn time 1 space

package heap_problems;

import java.util.Arrays;

public class DeleteIthElementMinHeap {

	public static void main(String[] args) throws Exception {
		MinimumHeap mheap = new MinimumHeap();

		mheap.insert(1);
		mheap.insert(0);
		mheap.insert(5);
		mheap.insert(9);
		mheap.insert(4);
		mheap.insert(7);
		mheap.insert(10);
		mheap.insert(2);
		mheap.insert(3);
		System.out.println(Arrays.toString(mheap.array));
		System.out.println(DeleteIthElement(mheap, 3));
	}

	private static int DeleteIthElement(MinimumHeap mheap, int k) {
		if (mheap == null || k > mheap.size || k < 0)
			return -1;

		int key = mheap.array[k];
		// swap kth element with last element
		mheap.array[k] = mheap.array[mheap.size--];
		// now sink down
		mheap.sink(k);
		return key;
	}

}
