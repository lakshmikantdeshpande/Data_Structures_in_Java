package week_3_MergeSort_and_QuickSort.PartOne;

public class MergeSort_Recursive_TopDown {

    public static void sort(int[] array) {
        int[] auxiliary = new int[array.length];
        sort(array, auxiliary, 0, array.length - 1);
    }

    private static void sort(int[] array, int[] auxiliary, int low, int high) {
        if (high <= low)
            return;

        int mid = low + (high - low) / 2;
        sort(array, auxiliary, low, mid);
        sort(array, auxiliary, mid + 1, high);
        merge(array, auxiliary, low, mid, high);
    }

    private static void merge(int[] array, int[] auxiliary, int low, int mid,
                              int high) {

        for (int i = low; i <= high; i++) {
            auxiliary[i] = array[i];
        }

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid)
                array[k] = auxiliary[j++];
            else if (j > high)
                array[k] = auxiliary[i++];
            else if (auxiliary[i] < auxiliary[j])
                array[k] = auxiliary[i++];
            else
                array[k] = auxiliary[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 5, 67, 3, 2, 65, 57, 2, 34, 5, 57, 3, 3, 45, 856, 76};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
