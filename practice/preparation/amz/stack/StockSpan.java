package amz.stack;

import java.util.Arrays;

public class StockSpan {

    public static void main(String[] args) {
        int[] stockPrices = new int[]{1, 2, 3, 3, 2, 1, 4};
        findStockSpanBruteForce(stockPrices);
    }

    private static void findStockSpanBruteForce(int[] stockPrices) {
        if (stockPrices == null || stockPrices.length == 0) {
            throw new IllegalArgumentException();
        }
        final int n = stockPrices.length;
        int[] spans = new int[n];
        spans[0] = 1;

        for (int i = 1; i < n; i++) {
            spans[i] = 1;
            int j = i - 1;

            while (j >= 0 && stockPrices[j] <= stockPrices[j + 1]) {
                j--;
                spans[i]++;
            }
        }
        System.out.println(Arrays.toString(spans));
    }

}
