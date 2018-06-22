package amz.algos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstRepeatingNumber {

    public static void main(String[] args) {
        int[] array = {1, 0, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        System.out.println(firstRepeatingNumberBruteForce(array));
        System.out.println(firstRepeatingNumber(array));
        System.out.println(firstRepeatingNumberSet(array));
    }

    private static int firstRepeatingNumberBruteForce(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Invalid input array");
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return array[i];
                }
            }
        }
        throw new RuntimeException("No repeating number is present");
    }

    // N time N space
    private static int firstRepeatingNumber(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Invalid input array");
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                return num;
            }
            map.put(num, count + 1);
        }
        throw new RuntimeException("No repeating number is present");
    }

    // N time N space
    private static int firstRepeatingNumberSet(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Invalid input array");
        }

        Set<Integer> set = new HashSet<>();

        for (int num : array) {
            if (!set.add(num)) {
                return num;
            }
        }
        throw new RuntimeException("No repeating number is present");
    }

}
