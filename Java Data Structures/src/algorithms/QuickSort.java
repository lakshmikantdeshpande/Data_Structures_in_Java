package algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 123, 34, 45, 65, 7, 4, 8, 0, 4, 22, 9999, 5, 1};
        quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quicksort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(array, start, end);
            quicksort(array, 0, pivot - 1);
            quicksort(array, pivot + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pindex = start;

        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                swap(array, i, pindex);
                pindex++;
            }
        }
        swap(array, pindex, end);
        return pindex;
    }

    private static void swap(int[] array, int i, int pindex) {
        int temp = array[i];
        array[i] = array[pindex];
        array[pindex] = temp;
    }

}
