/*
 zero- indexed array A consisting of N different integers is given. The array contains all integers in the range [0…N-1]. Sets S [K] for 0 ≤ K ≤ N are defines a s follows:
S[k] = {A[K], A[A[K]], A[A[A[K]]],….}.

Sets S[k] are finite for each k.

Write a function
Class Solution {public int solution (int [] a);}

That given an array A consisting of N integers, returns the size of the largest set S[K] for this array. The function should return O if the array is empty

For example A[0]=5, A[1]=4, A[2]=0, A[3]=3, A[4]=1, A[5]=6, A[6]=2,
The function should return 4, because set S [2] = {0, 5, 6, 2} has for elements. No other set S[k] has more than four elements
 */

import java.util.Arrays;

public class Nested_Arrays {

    public static int solution(int[] A) {
        if (A.length == 0)
            return 0;

        int max = Integer.MIN_VALUE;
        int size = 0, temp = 0;
        int counter = 0;
        boolean flag = false;

        int[] numbers = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            counter = 0;
            Arrays.fill(numbers, -1);
            temp = i;

            while (counter < A.length) {
                temp = A[temp];
                flag = (temp >= 0 && temp < A.length);
                if (!flag)
                    break;
                if (!connected(numbers, temp))
                    numbers[A[temp]]++;
                counter++;
            }

            size = getCount(numbers);
            max = Math.max(size, max);
        }
        return max;
    }


    private static boolean connected(int[] A, int check) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == check)
                return true;

        }
        return false;
    }

    private static int getCount(int[] A) {
        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != -1) {
                counter += A[i];
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 0, 3, 1, 6, 2};
        System.out.println(new Nested_Arrays().solution(array));
    }
}
