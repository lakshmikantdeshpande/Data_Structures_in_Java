package amz.algos;

public class NearestPalindrome {

    public static void main(String[] args) {
        System.out.println(getNearestPalindrome(5421));
        System.out.println(getNearestPalindrome(32));
        System.out.println(getNearestPalindrome(4886));
        System.out.println(getNearestPalindrome(213));
        System.out.println(getNearestPalindrome(121));
        System.out.println(getNearestPalindrome(1));
    }

    private static int getNearestPalindrome(int number) {
        if (isPalindrome(number)) {
            return number;
        }

        int i = number - 1;
        int j = number + 1;
        while (true) {
            if (isPalindrome(i--)) {
                return i + 1;
            }
            if (isPalindrome(j++)) {
                return j - 1;
            }
        }
    }

    private static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        } else if (number < 10) {
            return true;
        }

        int temp = number;
        int sum = 0;
        while (temp > 0) {
            sum = sum * 10 + temp % 10;
            temp /= 10;
        }
        return sum == number;
    }

}
