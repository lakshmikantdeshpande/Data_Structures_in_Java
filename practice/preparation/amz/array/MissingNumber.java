package amz.array;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] array = new int[99];

        for (int i = 0; i < 99; i++) {
            array[i] = i >= 77 ? i + 1 : i;
        }

        System.out.println("Missing number is " + findMissingNumberBruteForce(array));
        System.out.println("Missing number is " + findMissingNumberOptimal(array));
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

}
