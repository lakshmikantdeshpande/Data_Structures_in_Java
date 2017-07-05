package week_2_Stacks_and_Queues.PartTwo;

public class InsertionSort {

    public static void sort(int[] array) {
        int N = array.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1])
                    swap(array, j, j - 1);
                else
                    break;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {5, 1, 3, 8, 9, 4, 7, 2, 0};
        sort(array);
        for (int x : array)
            System.out.print(x + " ");

    }
}
