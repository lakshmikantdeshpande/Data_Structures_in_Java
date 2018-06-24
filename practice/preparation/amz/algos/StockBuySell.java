package amz.algos;

import java.util.ArrayList;
import java.util.List;

public class StockBuySell {

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

    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(buySell(prices));
        prices = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(buySell(prices));
    }

    private static List<Interval> buySell(int[] prices) {
        List<Interval> intervals = new ArrayList<>();
        if (prices == null || prices.length == 1) {
            return intervals;
        }

        int i = 0;
        final int n = prices.length;
        while (i < n - 1) {
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            // No suitable day for selling the stock
            if (i == n - 1) {
                break;
            }


            Interval interval = new Interval();
            interval.buy = i++;

            while (i < n && prices[i] >= prices[i - 1]) {
                i++;
            }

            interval.sell = i - 1;
            intervals.add(interval);
        }

        return intervals;
    }

}
