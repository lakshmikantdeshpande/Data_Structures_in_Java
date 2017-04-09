// 15. Find kth smallest element in the minimum heap.
// klogn time (One deletion takes logn time, so k deletions will result into klogn time complexity)

package heap_problems;

import heap.MinHeap;

public class KthMinimumElementHeap {

	public static void main(String[] args) {
		MinHeap mheap = new MinHeap();

		mheap.insert(1);
		mheap.insert(0);
		mheap.insert(5);
		mheap.insert(9);
		mheap.insert(4);
		mheap.insert(7);
		mheap.insert(10);
		mheap.insert(2);

		System.out.println(findKthMinimum(mheap, 3));

	}

	public static int findKthMinimum(MinHeap mheap, int k) {
		for (int i = 0; i < k - 1; i++)
			mheap.getMin();

		return mheap.getMin();
	}
}
