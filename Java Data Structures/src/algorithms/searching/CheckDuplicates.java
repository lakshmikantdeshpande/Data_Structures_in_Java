package algorithms.searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckDuplicates {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4};

        System.out.println(hasDuplicatesBruteForce(array));
        System.out.println(hasDuplicatesSort(array));
        System.out.println(hasDuplicatesSet(array));
        System.out.println(hasDuplicatesNegativeInRange(array));
    }

    // n * n time 1 space
    private static boolean hasDuplicatesBruteForce(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("The given array is null / empty");
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // nlogn time 1 space
    private static boolean hasDuplicatesSort(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("The given array is null / empty");
        }

        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // n time n space
    private static boolean hasDuplicatesSet(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("The given array is null / empty");
        }

        Set<Integer> set = new HashSet<>();
        for (int element : array) {
            if (!set.add(element)) {
                return true;
            }
        }
        return false;
    }

    // n time 1 space
    // assuming that all elements are positive, and in range of array length
    private static boolean hasDuplicatesNegativeInRange(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("The given array is null / empty");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[Math.abs(array[i])] < 0) {
                return true;
            }
            array[Math.abs(array[i])] *= -1;
        }
        return false;
    }

}
