package amz.algos;

public class LargestContiguousSum {

    public static void main(String[] args) {
        int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxConsecutiveSum(array));
        System.out.println(maxConsecutiveSumPrefixSum(array));
    }

    // n time 1 space (dynamic programming)
    private static int maxConsecutiveSum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }

        int maxSum = array[0];
        int currentSum = array[0];
        for (int i = 1; i < array.length; i++) {
            currentSum = Math.max(array[i], currentSum + array[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // N time N space (prefix array)
    private static int maxConsecutiveSumPrefixSum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] prefixSum = new int[array.length];
        prefixSum[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            prefixSum[i] = array[i] + prefixSum[i - 1];
        }

        int maxSum = Integer.MIN_VALUE;
        int minPrefix = 0;

        for (int i = 0; i < array.length; i++) {
            maxSum = Math.max(maxSum, prefixSum[i] - minPrefix);
            minPrefix = Math.min(minPrefix, prefixSum[i]);
        }
        return maxSum;
    }

}
