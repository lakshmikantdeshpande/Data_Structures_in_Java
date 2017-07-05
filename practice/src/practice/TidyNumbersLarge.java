package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class TidyNumbersLarge {
    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter pw = new PrintWriter(System.out);
    static StringBuilder strb = new StringBuilder();

    public static void main(String[] args) {
        int T = scanner.nextInt();

        for (int i = 1; i < T + 1; i++) {

        }
    }

    private static String nine(int number) {
        strb = new StringBuilder(number);
        for (int i = 0; i < number; i++)
            strb.append("9");

        return strb.toString();
    }

    private static int previousNumber(String number, int index) {
        int i = index;
        while (i > 0 && number.charAt(i) == number.charAt(i - 1))
            i--;
        return i;
    }


    public static String isTiny(String number) {
        int p = prevIndex(number);
        if (p == -1)
            return number;

        strb = new StringBuilder();
        p = previousNumber(number, p);

        strb.append(number.substring(0, p));
        char smallNumber = (char) ((number.charAt(p)) - 1);
        if (smallNumber != '0' || strb.length() != 0)
            strb.append(smallNumber);

        strb.append(nine(number.length() - 1 - p));
        return strb.toString();
    }


    private static int prevIndex(String number) {
        int i = 0;
        while ((i < number.length() - 1) && ((int) number.charAt(i + 1) >= (int) number.charAt(i)))
            i++;

        if (i >= number.length() - 1)
            return -1;

        return ((int) number.charAt(i + 1) <= (int) number.charAt(i) ? i : -1);
    }
}