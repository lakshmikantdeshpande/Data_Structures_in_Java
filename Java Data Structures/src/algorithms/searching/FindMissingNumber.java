package algorithms.searching;

import java.util.Arrays;

public class FindMissingNumber {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10};

        System.out.println(findMissingNumberBruteForce(array));
        System.out.println(findMissingNumberCounter(array));
        System.out.println(findMissingNumberSummation(array));
    }

    // N + N time N space
    private static int findMissingNumberBruteForce(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Null / empty array");
        }
        int[] auxArray = new int[array.length + 2];
        for (int i = 0; i < auxArray.length; i++) {
            auxArray[i] = i;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != auxArray[i + 1]) {
                return auxArray[i + 1];
            }
        }
        return -1;
    }

    // N time 1 space
    private static int findMissingNumberCounter(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Null / empty array");
        }

        int counter = 1;
        for (int i = 0; i < array.length; i++, counter++) {
            if (array[i] != counter) {
                return counter;
            }
        }
        return -1;
    }

    private static int findMissingNumberSummation(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Null / empty array");
        }

        return ((array[array.length - 1] * (array[array.length - 1] + 1)) / 2) - sum(array);
    }

    private static int sum(int[] array) {
        return Arrays.stream(array).sum();
    }

}
