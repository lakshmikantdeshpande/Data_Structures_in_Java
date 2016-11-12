package week_2_Stacks_and_Queues.PartTwo;

public class SelectionSort {

    public static void sort(int[] array) {
        int min = 0, N = array.length;
        for (int i = 0; i < N; i++) {
            min = i;
            for (int j = i + 1; j < N; j++) {
                if (array[j] < array[min])
                    min = j;
            }
            swap(array, i, min);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = { 5, 1, 3, 8, 9, 4, 7, 2, 0 };
        sort(array);
        for (int x : array)
            System.out.print(x + " ");

    }

}
