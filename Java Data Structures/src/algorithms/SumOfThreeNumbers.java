package algorithms;

import java.util.Arrays;

public class SumOfThreeNumbers {

    public static void main(String[] args) {
        SumOfThreeNumbers sumOfThreeNumbers = new SumOfThreeNumbers();
        int[] array = new int[]{1, 4, 5, -6, 1, 7};
        int requiredSum = 6;
        sumOfThreeNumbers.printNumbersWithGivenSum(array, requiredSum);
    }

    private void printNumbersWithGivenSum(int[] array, int requiredSum) {
        if (array == null || array.length < 3) {
            throw new IllegalArgumentException("Invalid input");
        }

        boolean flag = false;

        // Sort the array first
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int start = i + 1;
            int end = array.length - 1;

            while (start < end) {
                int sum = array[start] + array[end] + array[i];
                if (sum == requiredSum) {
                    System.out.printf("Required numbers at %d (index: %d)     %d (index: %d)     %d (index: %d)%n",
                            array[start], start, array[i], i, array[end], end);
                    flag = true;
                    break;
                } else if (sum < requiredSum) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        if (!flag) {
            System.out.println("Numbers with given sum were not found in the array");
        }
    }

}
