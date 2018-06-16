package amz.array;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] array = new int[100];

        for (int i = 0; i < 100; i++) {
            array[i] = i >= 77 ? i + 1 : i;
        }

        System.out.println("Missing number is " + findMissingNumberBruteForce(array));
        System.out.println("Missing number is " + findMissingNumberOptimal(array));
        System.out.println("Missing number is " + findMissingNumberXorOptimal(array));
    }

    // N time 1 space
    private static int findMissingNumberBruteForce(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i) {
                return i;
            }
        }
        return -1;
    }

    // N time 1 space
    private static int findMissingNumberOptimal(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int sum = Arrays.stream(array).sum();
        int requiredSum = (array.length * (array.length + 1)) / 2;
        return requiredSum - sum;
    }

    // N time 1 space
    private static int findMissingNumberXorOptimal(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int actualXor = 0;
        for (int i = 0; i < 100; i++) {
            actualXor ^= array[i];
        }
        int requiredXor = 0;
        for (int i = 0; i < 101; i++) {
            requiredXor ^= i;
        }
        return requiredXor ^ actualXor;
    }

}
