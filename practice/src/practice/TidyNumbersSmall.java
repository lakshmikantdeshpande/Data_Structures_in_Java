package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class TidyNumbersSmall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(System.out);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            long number = scanner.nextLong();
            long ans = checkIncreasing(number);
            if (ans == number)
                pw.println("Case #" + i + ": " + number);
            else {
                long temp = (number % 10);
                if (checkIncreasing(number - temp - 1) == (number - temp - 1))
                    pw.println("Case #" + i + ": " + (number - temp - 1));
                else {
                    number--;
                    while (checkIncreasing(number) != number) {
                        number--;
                    }
                    pw.println("Case #" + i + ": " + (number));
                }

            }
        }
        pw.close();
        scanner.close();
        scanner = null;
        pw = null;
        System.gc();
    }

    static long checkIncreasing(long number) {
        String tmp = Long.toString(number);
        boolean flag = true;
        int t = 0;

        int last = Character.getNumericValue(tmp.charAt(0));
        for (int i = 1; i < tmp.length(); i++) {
            if (Character.getNumericValue(tmp.charAt(i)) < last) {
                t = i;
                flag = false;
                break;
            }
            last = Character.getNumericValue(tmp.charAt(i));
        }

        if (flag)
            return number;
        else
            return t;
    }
}