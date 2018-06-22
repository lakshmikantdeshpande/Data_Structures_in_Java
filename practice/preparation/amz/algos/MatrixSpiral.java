package amz.algos;

public class MatrixSpiral {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        spiralPrint(array);
    }

    private static void spiralPrint(int[][] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Invalid input");
        }

        int top = 0;
        int left = 0;
        int bottom = array.length - 1;
        int right = array[0].length - 1;
        StringBuilder stringBuilder = new StringBuilder();

        // top right bottom left 0 1 2 3
        int direction = 0;
        while (top <= bottom && left <= right) {
            switch (direction) {
                case 0:
                    for (int i = left; i <= right; i++) {
                        stringBuilder.append(array[top][i]).append(' ');
                    }
                    top++;
                    break;
                case 1:
                    for (int i = top; i <= bottom; i++) {
                        stringBuilder.append(array[i][right]).append(' ');
                    }
                    right--;
                    break;
                case 2:
                    for (int i = right; i >= left; i--) {
                        stringBuilder.append(array[bottom][i]).append(' ');
                    }
                    bottom--;
                    break;
                case 3:
                    for (int i = bottom; i >= top; i--) {
                        stringBuilder.append(array[i][left]).append(' ');
                    }
                    left++;
                    break;
            }
            direction = (direction + 1) % 4;
        }
        System.out.println(stringBuilder.toString());
    }

}
