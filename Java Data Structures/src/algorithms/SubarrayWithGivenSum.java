package algorithms;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithGivenSum {

    public static void main(String[] args) {
        findSubArrayWithGivenSum(new int[]{10, 2, -2, -20, 10}, 5, -10);
    }

    private static void findSubArrayWithGivenSum(int[] array, int N, int sum) {
        if (array.length == 0) {
            return;
        }

        Map<Integer, Integer> hashmap = new HashMap<>();
        int curr = 0;
        for (int i = 0; i < N; i++) {
            curr += array[i];

            if (curr == sum) {
                System.out.println("Start " + 0 + " End " + i);
                return;
            }
            if (hashmap.containsKey(curr - sum)) {
                System.out.println("Start " + (hashmap.get(sum - curr) + 1) + " End " + i);
                return;
            }

            hashmap.put(sum - curr, i);
        }
        System.out.println("No subarray with given sum exists in the array");
    }

}
