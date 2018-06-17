package amz.array;

public class SearchNumberInSortedMatrix {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(searchNumberInMatrix(array, 1));
        System.out.println(searchNumberInMatrix(array, 2));
        System.out.println(searchNumberInMatrix(array, 3));
        System.out.println(searchNumberInMatrix(array, 4));
        System.out.println(searchNumberInMatrix(array, 5));
        System.out.println(searchNumberInMatrix(array, 6));
        System.out.println(searchNumberInMatrix(array, 7));
        System.out.println(searchNumberInMatrix(array, 8));
        System.out.println(searchNumberInMatrix(array, 9));
        System.out.println(searchNumberInMatrix(array, 10));
    }

    private static String searchNumberInMatrix(int[][] array, int number) {
        if (array == null || array.length == 0) {
            return "Not found";
        }

        int i = 0;
        int j = array[0].length - 1;

        while (i < array.length && j >= 0) {
            System.out.println("Looking at " + array[i][j]);
            if (array[i][j] == number) {
                return i + " " + j;
            } else if (array[i][j] < number) {
                i++;
            } else {
                j--;
            }
        }
        return "Not found";
    }

}
