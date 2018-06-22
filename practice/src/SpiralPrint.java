public class SpiralPrint {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        spiralPrint(array);
    }

    private static void spiralPrint(int[][] array) {
        if (array == null || array.length == 0) {
            return;
        }

        StringBuilder builder = new StringBuilder();
        int top = 0;
        int left = 0;
        int bottom = array.length - 1;
        int right = array[0].length - 1;

        // top 0 right 1 bottom 2 left 3
        int direction = 0;
        while (top <= bottom && left <= right) {
            switch (direction) {
                case 0:
                    for (int i = left; i <= right; i++) {
                        builder.append(array[top][i]).append(' ');
                    }
                    top++;
                    break;
                case 1:
                    for (int i = top; i <= bottom; i++) {
                        builder.append(array[i][right]).append(' ');
                    }
                    right--;
                    break;
                case 2:
                    for (int i = right; i >= left; i--) {
                        builder.append(array[bottom][i]).append(' ');
                    }
                    bottom--;
                    break;
                case 3:
                    for (int i = bottom; i >= top; i--) {
                        builder.append(array[left][i]).append(' ');
                    }
                    left++;
                    break;
            }
            direction = (direction + 1) % 4;
        }
        System.out.println(builder.toString());

    }

}
