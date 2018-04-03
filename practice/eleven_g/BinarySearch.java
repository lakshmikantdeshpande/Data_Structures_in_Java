public class BinarySearch {

    int binarySearchNonRecursive(final int[] array, final int number) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == number) {
                return middle;
            } else if (array[middle] < number) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }
        return -1;
    }

    int binarySearchRecursive(int[] array, int left, int right, int number) {
        if (left <= right) {
            int middle = (left + right) / 2;

            if (array[middle] == number) {
                return middle;
            } else if (array[middle] < number) {
                return binarySearchRecursive(array, middle + 1, right, number);
            } else {
                return binarySearchRecursive(array, left, middle - 1, number);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10, 14, 16, 19, 22, 23, 25, 26, 27, 29, 31, 34, 35, 36, 38, 39, 40, 45, 46, 48, 50, 51, 52, 57, 59, 60, 61, 63, 67, 68, 69, 71, 75, 76, 77, 79, 81, 82, 83, 86, 87, 88, 90, 92, 93, 94, 95, 96, 98, 99, 100};

        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearchNonRecursive(array, 59));
        System.out.println(binarySearch.binarySearchRecursive(array, 0, array.length - 1, 59));
        System.out.println(binarySearch.binarySearchNonRecursive(array, -6));
        System.out.println(binarySearch.binarySearchRecursive(array, 0, array.length - 1, -6));
        System.out.println(binarySearch.binarySearchNonRecursive(array, 456));
        System.out.println(binarySearch.binarySearchRecursive(array, 0, array.length - 1, 456));

    }

}
