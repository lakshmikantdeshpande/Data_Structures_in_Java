import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<Integer, Integer> map = new HashMap<>();

    public int[] solution(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        int cIndex = findCIndex(array);
        int[] arrayToBeReturned = new int[array.length - 1];
        map.put(cIndex, 0);
        arrayToBeReturned[0]++;
        for (int i = 0; i < array.length; i++) {
            if (i != array[i]) {
                int index = getDesiredDistance(i, cIndex, array);
                arrayToBeReturned[index]++;
                map.put(i, index);
            }
            System.out.println(Arrays.toString(arrayToBeReturned));
        }
        return arrayToBeReturned;
    }

    private int getDesiredDistance(int i, int j, int[] array) {
        return getDistance(i, j, array, 0);
    }

    private int getDistance(int i, int j, int[] array, int current) {
        if (i == j) {
            return current + 1;
        } else if (map.containsKey(array[i])) {
            return current + map.get(array[i]);
        } else {
            return getDistance(array[i], j, array, current + 1);
        }
    }

    private int findCIndex(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Invalid array");
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == i) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{9, 1, 4, 9, 0, 4, 8, 9, 0, 1})));
    }

}