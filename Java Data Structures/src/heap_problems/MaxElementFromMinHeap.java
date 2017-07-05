// 7. Given a min heap, find the maximum element.
// n/2 time 1 space

package heap_problems;

import heap.MinHeap;

public class MaxElementFromMinHeap {

    public static void main(String[] args) throws Exception {
        MinHeap mheap = new MinHeap();

        mheap.insert(1);
        mheap.insert(0);
        mheap.insert(5);
        mheap.insert(9);
        mheap.insert(4);
        mheap.insert(7);
        mheap.insert(10);
        mheap.insert(2);
        mheap.insert(3);

        System.out.println(MaxElement(mheap.array, mheap.size));
    }

    private static int MaxElement(int[] array, int size) {
        int max = Integer.MIN_VALUE;

        int i = (size + 1) / 2;
        for (; i <= size; i++)
            if (array[i] > max)
                max = array[i];

        return max;
    }

}
