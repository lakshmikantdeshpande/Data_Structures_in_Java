package algorithms;

import java.util.Arrays;

public class SortArrayWith0sAnd1s {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray1(new int[]{0, 1, 0, 1, 1, 1})));
        System.out.println(Arrays.toString(sortArray2(new int[]{0, 1, 0, 1, 1, 1})));
    }

    private static int[] sortArray1(int[] array) {
        if (array.length == 0) {
            return array;
        }

        int zeroCount = 0;
        for (int number : array) {
            if (number == 0) {
                zeroCount++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (zeroCount > 0) {
                zeroCount--;
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        return array;
    }

    private static int[] sortArray2(int[] array) {
        if (array.length == 0) {
            return array;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            while (left < right && array[left] == 0) {
                left++;
            }

            while (left < right && array[right] == 1) {
                right--;
            }

            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return array;
    }

}
