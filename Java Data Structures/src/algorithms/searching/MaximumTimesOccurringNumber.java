package algorithms.searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumTimesOccurringNumber {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 2};

        System.out.println(maxOccurBruteForce(array));
        System.out.println(maxOccurSort(array));
        System.out.println(maxOccurHashMap(array));
    }

    // n * n time 1 space
    private static int maxOccurBruteForce(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("The given array is null / empty");
        }

        int maxOccurringNumber = Integer.MIN_VALUE;
        int maxFrequency = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int frequency = 0;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    ++frequency;
                }
            }
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                maxOccurringNumber = array[i];
            }
        }

        return maxOccurringNumber;
    }

    // nlogn time 1 space
    private static int maxOccurSort(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("The given array is null / empty");
        }

        Arrays.sort(array);
        int maxOccurring = Integer.MIN_VALUE;
        int maxFrequency = Integer.MIN_VALUE;

        int last = maxOccurring;
        int frequency = 0;

        for (int element : array) {
            if (last != element) {
                if (frequency > maxFrequency) {
                    maxFrequency = frequency;
                    maxOccurring = last;
                }
                frequency = 1;
            } else {
                ++frequency;
            }
            last = element;
        }

        if (frequency > maxFrequency) {
            maxOccurring = last;
        }
        return maxOccurring;
    }

    // n time n space
    private static int maxOccurHashMap(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("The given array is null / empty");
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxOccurring = Integer.MIN_VALUE;
        int maxFrequency = Integer.MIN_VALUE;

        for (int element : array) {
            int frequency = map.getOrDefault(element, 0) + 1;
            map.put(element, frequency);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                maxOccurring = element;
            }
        }
        return maxOccurring;
    }

}
