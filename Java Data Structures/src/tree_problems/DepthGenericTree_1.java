// 44.  Find height/depth of a tree (given an array where array[i] == parent of i)
// eg. array = { 0, 0, 1, 6, 6, 0, 0, 2, 7 };
// n * n time 1  space

package tree_problems;

public class DepthGenericTree_1 {

	public static void main(String[] args) {
		int[] array = new int[] { 0, 0, 1, 6, 6, 0, 0, 2, 7 };

		System.out.println(findDepth(array));
	}

	private static int findDepth(int[] array) {
		if (array == null)
			return 0;
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			int t = i;
			int curr = 0;
			while (t != array[t]) {
				curr++;
				t = array[t];
			}
			if (curr > max)
				max = curr;
		}
		return max;
	}
}
