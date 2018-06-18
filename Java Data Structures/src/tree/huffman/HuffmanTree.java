package tree.huffman;

import java.util.*;

class HuffmanNode {
    int frequency;
    char character;

    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {

    @Override
    public int compare(HuffmanNode one, HuffmanNode two) {
        return one.frequency - two.frequency;
    }

}

public class HuffmanTree {

    private static void printHuffmanCode(HuffmanNode node, String prefix) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.println(node.character + ": " + prefix);
        }
        printHuffmanCode(node.right, prefix + "1");
        printHuffmanCode(node.left, prefix + "0");
    }

    public static void main(String[] args) {
        String inputString = "ebfdecffedefdecfbdeefbacdcffcefedfadbfedcbedbffacfffbcedafabfcdffefffffffbfffffcffefffefdffefffcfcfd";
        Map<Character, Integer> frequencyMap = generateFrequencyMap(inputString);

        HuffmanNode root = buildHuffmanTree(frequencyMap);
        printHuffmanCode(root, "");
    }

    private static HuffmanNode buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        Queue<HuffmanNode> heap = new PriorityQueue<>(frequencyMap.size(), new MyComparator());

        // build heap
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            HuffmanNode node = new HuffmanNode();
            node.character = entry.getKey();
            node.frequency = entry.getValue();

            heap.offer(node);
        }

        while (heap.size() > 1) {
            HuffmanNode left = heap.poll();
            HuffmanNode right = heap.poll();

            HuffmanNode parent = new HuffmanNode();
            parent.frequency = left.frequency + right.frequency; // added frequency
            parent.character = '-'; // no useful character needs to be here
            parent.left = left;
            parent.right = right;

            heap.offer(parent);
        }
        return heap.poll();
    }

    private static Map<Character, Integer> generateFrequencyMap(String inputString) {
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
        for (char c : inputString.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

}
