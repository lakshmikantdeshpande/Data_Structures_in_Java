package algorithms.searching;

import java.util.Arrays;

public class FindTheNumberOccuringOddNumberOfTimes {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 1, 2, 4, 5, 6};

        System.out.println(getOddNumber(array));
    }

    private static int getOddNumber(int[] array) {
        int[] result = new int[]{0};
        Arrays.stream(array).forEach(x -> result[0] = result[0] ^ x);
        return result[0];
    }

}
