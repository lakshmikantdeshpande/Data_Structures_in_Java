package amz.algos;

public class LargestContiguousSum {

    public static void main(String[] args) {
        int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxConsecutiveSum(array));
    }

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

}
