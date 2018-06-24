package amz.algos;

import java.util.Arrays;

public class PythagoreanTriplet {

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 6, 5};
        System.out.println(isPythagoreanTripletPresent(array));
    }

    private static boolean isPythagoreanTripletPresent(int[] array) {
        if (array == null || array.length < 3) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i];
        }

        Arrays.sort(array);

        for (int i = array.length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;

            while (left < right) {
                if (array[i] == array[left] + array[right]) {
                    return true;
                } else if (array[i] > array[left] + array[right]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }

}
