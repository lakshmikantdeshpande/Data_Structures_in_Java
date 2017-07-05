// 22. Finding spans in the given array
// (Stock market problem)
// How many times a[j] <= a[j+1]  in the given array? (How many peaks are there in the given array)
// n*n time, 1 space

package stack_problems;

public class SpanProblem_1 {

    public static void main(String[] args) {
        int spans[] = findSpans(new int[]{6, 3, 4, 5, 2});
        for (int x : spans) {
            System.out.println(x);
        }
    }

    private static int[] findSpans(int[] array) {
        int[] spans = new int[array.length];

        spans[0] = 1;
        for (int i = 1; i < array.length; i++) {
            spans[i] = 1;
            int j = i - 1;
            // check the number of consecutive previous stock rates in the
            // increasing order
            while (j >= 0 && array[j] <= array[j + 1]) {
                spans[i]++;
                j--;
            }
        }
        return spans;
    }

}
