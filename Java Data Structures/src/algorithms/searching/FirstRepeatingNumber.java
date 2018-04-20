package algorithms.searching;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingNumber {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 3};

        System.out.println(firstRepeatingNumberBruteForce(array));
        System.out.println(firstRepeatingNumberSet(array));
    }

    // N * N time 1 space
    private static int firstRepeatingNumberBruteForce(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Null / empty array");
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return array[i];
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    // N time N space
    private static int firstRepeatingNumberSet(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Null / empty array");
        }

        Set<Integer> set = new HashSet<>();
        for (int element : array) {
            if (!set.add(element)) {
                return element;
            }
        }
        return Integer.MIN_VALUE;
    }

}
