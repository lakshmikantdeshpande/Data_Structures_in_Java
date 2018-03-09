package stack;

import java.util.ArrayList;
import java.util.List;

public class StockBuySell {

    private static class Interval {
        int buy, sell;
    }

    public static void main(String[] args) {
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        whenToBuyAndSell(price, price.length);
    }

    private static void whenToBuyAndSell(int[] price, int length) {
        if (length == 1) {
            return;
        }

        int i = 0;
        List<Interval> intervals = new ArrayList<>();
        while (i < length - 1) {
            while (i < length - 1 && (price[i] >= price[i + 1])) {
                i++;
            }

            if (i == length - 1) {
                break;
            }

            Interval interval = new Interval();
            interval.buy = i++;

            while (i < length && (price[i] >= price[i - 1])) {
                i++;
            }

            interval.sell = i - 1;
            intervals.add(interval);
        }

        if (intervals.isEmpty()) {
            System.out.println("Lossy market");
        } else {
            for (Interval interval : intervals) {
                System.out.printf("Buy: %d   Sell: %d", interval.buy, interval.sell);
                System.out.println();
            }
        }
    }

}
