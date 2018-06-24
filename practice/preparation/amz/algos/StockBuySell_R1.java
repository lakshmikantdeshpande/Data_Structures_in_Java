package amz.algos;

import java.util.ArrayList;
import java.util.List;

public class StockBuySell_R1 {

    public static void main(String[] args) {
        int[] stock = new int[]{1, 2, 3, 4, 1, 5, 4};
        stockSpan(stock);
    }

    private static class Interval {
        int buy;
        int sell;

        @Override
        public String toString() {
            return "Interval{" +
                    "buy=" + buy +
                    ", sell=" + sell +
                    '}';
        }
    }

    // N time N space
    private static void stockSpan(int[] stock) {
        if (stock == null || stock.length == 0) {
            throw new IllegalArgumentException();
        }

        List<Interval> intervals = new ArrayList<>();
        int i = 0;
        final int n = stock.length;

        while (i < n - 1) {
            while (i < n - 1 && stock[i] >= stock[i + 1]) {
                i++;
            }

            if (i == n - 1) {
                break;
            }

            Interval interval = new Interval();
            interval.buy = i++;

            while (i < n && stock[i] >= stock[i - 1]) {
                i++;
            }
            interval.sell = i - 1;
            intervals.add(interval);
        }
        for (Interval interval : intervals) {
            System.out.println(interval);
        }
    }

}
