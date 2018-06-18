package amz.array;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix(array);
    }

    private static void rotateMatrix(int[][] array) {
        if (!validateArray(array)) {
            throw new RuntimeException("Invalid input");
        }

        int n = array.length;

        for (int x = 0; x < n / 2; x++) {
            for (int y = x; y < n - x - 1; y++) {
                int temp = array[x][y];
                array[x][y] = array[y][n - 1 - x];
                array[y][n - 1 - x] = array[n - 1 - x][n - 1 - y];
                array[n - 1 - x][n - 1 - y] = array[n - 1 - y][x];
                array[n - 1 - y][x] = temp;
            }
        }
        display(array);
    }

    private static boolean validateArray(int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        int height = array.length;
        for (int[] anArray : array) {
            if (anArray.length != height) {
                return false;
            }
        }
        return true;
    }

    private static void display(int[][] array) {
        if (array == null) {
            throw new RuntimeException("Invalid input");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}
