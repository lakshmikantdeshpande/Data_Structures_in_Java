package week_2_Stacks_and_Queues.PartTwo;

public class Item implements Comparable<Item> {
    int smarks;

    public Item(int smarks) {
        super();
        this.smarks = smarks;
    }

    @Override
    public String toString() {
        return "sms=" + smarks;
    }

    @Override
    public int compareTo(Item item) {
        if (this.smarks == item.smarks)
            return 0;
        else if (this.smarks < item.smarks)
            return -1;
        else
            return 1;
    }

}
