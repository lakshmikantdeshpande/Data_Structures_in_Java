package week_2_Stacks_and_Queues.PartTwo;

import edu.princeton.cs.algs4.StdRandom;

public class GenericSelectionSort {

    public static void sort(Item array[]) {
        int N = array.length;
        int min = 0;

        for (int i = 0; i < N; i++) {
            min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(array[j], array[min]))
                    min = j;
            }
            swap(array, i, min);
        }
    }

    private static void swap(Item[] item, int i, int min) {
        Item it = item[i];
        item[i] = item[min];
        item[min] = it;
    }

    private static boolean less(Item i, Item j) {
        if (i.compareTo(j) == -1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Item array[] = new Item[10];
        for (int i = 0; i < 10; i++) {
            array[i] = new Item(StdRandom.uniform(10));
        }
        System.out.println(("BEFORE"));

        for (Item c : array)
            System.out.print(c.toString());

        System.out.println();
        sort(array);
        System.out.println(("AFTER"));

        for (Item item : array) {
            System.out.print(item.toString());
        }

    }
}
