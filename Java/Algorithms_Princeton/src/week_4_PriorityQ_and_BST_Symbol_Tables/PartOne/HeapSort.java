package week_4_PriorityQ_and_BST_Symbol_Tables.PartOne;

import java.awt.print.Printable;

import edu.princeton.cs.algs4.Heap;

public class HeapSort {
	private static int[] pq;
		
	public static void sort()
	{
		int N = pq.length;
		for (int k = N/2; k >= 1; k--)
			sink(k, N);
		while (N > 1)
		{
			swap(1, N--);
			sink(1, N);
		}		
	}
	
	private static void sink(int k, int size) {
		while (2*k <= size)
		{
			int j = 2*k;
			if (j < size && less(j, j+1))
				j++;
			if (!less(k, j))
				break;
			swap(k, j);
			k = j;
		}
	}

	private static void swap(int i, int j) {
		int temp = pq[i-1];
		pq[i-1] = pq[j-1];
		pq[j-1] = temp;
	}

	private static boolean less(int i, int j) {
		return pq[i-1] < pq[j-1]; 
	}
	
	public static void printheap()
	{
		int N = pq.length;
		int k = 1;
		for (int i = 1; i <= N; i++)
		{
			for (int j = 0; j < k && i <= N; j++)
			{
				System.out.print(pq[i++] + " ");
			}
			k = (int)Math.pow(2, k++);
			i--;
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] t = {5, 7, 8, 9, 1, 3, 2, 4, 15, 974, 45, 0};
		int N = t.length;
		pq = new int[N];
		for (int i = 0; i < N; i++) {
			pq[i] = t[i];
		}
		sort();

		for (int i = 0; i < N; i++)
			System.out.print(pq[i] + " ");
		System.out.println();
	}

}
