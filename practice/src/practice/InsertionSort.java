package practice;

public class InsertionSort {

    public static void insertionSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
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
        int[] array = {3, 5, 67, 3, 2, 65, 57, 2, 34, 5, 57, 3, 3, 45, 856, 76};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

}
