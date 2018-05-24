// find number of numbers after which all numbers are smaller

package practice;

public class CountSmallerElements {

    public static void main(String[] args) {
        int[] array = new int[]{10, 40, 23, 50, 40, 7};
        System.out.println(findBiggerElements(array));
        System.out.println(findBiggerElementsOptimal(array));
    }

    private static int findBiggerElements(int[] array) {
        int biggerNumberCount = 0;
        for (int i = 0; i < array.length; i++) {
            boolean flag = true; // all numbers are smaller
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] >= array[i]) {
                    flag = false;
                    i = j;
                    break;
                }
            }
            if (flag) {
                biggerNumberCount++;
            }
        }
        return biggerNumberCount;
    }

    private static int findBiggerElementsOptimal(int[] array) {
        if (array.length < 2) {
            return array.length;
        }

        int count = 0;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                ++count;
            } else {
                return count;
            }
        }
        return array.length;
    }

}
