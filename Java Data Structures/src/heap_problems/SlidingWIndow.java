// Find maximum in sliding window of size w.
// n time 1 space

package heap_problems;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWIndow {
    public static void main(String[] args) {

        int[] array = new int[]{1, -2, 5, 6, 0, 9, 8, -1, 2, 0};
        int windowSize = 3;

        System.out.println(Arrays.toString(maxInSlidingWindow(array, windowSize)));
    }

    private static int[] maxInSlidingWindow(int[] array, int windowSize) {
        if (windowSize < 1 || windowSize > array.length)
            return new int[]{};

        int windows = array.length - windowSize + 1;

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] maximum = new int[windows];

        for (int i = 0; i < array.length; i++) {
            // maximum is always the first element in the deque
            if (i >= windowSize)
                maximum[i - windowSize] = array[deque.getFirst()];

            // remove all elements from the back which are greater than current array element
            while (!deque.isEmpty() && array[i] >= array[deque.getLast()])
                deque.pollLast();

            // remove all elements until first element index is less than or equal to start of the window.
            while (!deque.isEmpty() && deque.getFirst() <= (i - windowSize))
                deque.pollFirst();

            deque.addLast(i);
        }
        maximum[windows - 1] = array[deque.getFirst()];
        return maximum;
    }
}
