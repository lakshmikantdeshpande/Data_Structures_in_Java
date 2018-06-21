package amz.algos;

public class LuckyNumber {

    public static void main(String[] args) {
        System.out.println(841993 + "====>" + luckyNumber(841993));
        System.out.println(2101971 + "====>" + luckyNumber(2101971));
    }

    private static int luckyNumber(int number) {
        if (number < 10) {
            return number;
        }

        return luckyNumber(digitSum(number));
    }

    private static int digitSum(int number) {
        int sum = 0;
        int temp = number;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum;
    }

}
