package graph.trial;

import java.io.IOException;
import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> map;

    public Graph(int vertices) {
        map = new HashMap<>();
        for (int i = 1; i <= vertices; i++)
            map.put(i, new LinkedList<>());
    }

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph(4);
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < 5; i++) {
            graph.setEdge(scanner.nextInt(), scanner.nextInt());
        }

        System.out.println("PRINTING THE GRAPH\n");
        for (int i = 1; i < 5; i++) {
            System.out.print(i + " ");
            for (int p : graph.getEdge(i))
                System.out.print(p + "->");
            System.out.println();
        }
    }

    public void setEdge(int source, int destination) {
        if (!map.containsKey(source) || !map.containsKey(destination)) {
            System.out.println("Invalid source / destination");
            return;
        }

        map.get(source).add(destination);
        map.get(destination).add(source);
    }

    public List<Integer> getEdge(int source) {
        if (!map.containsKey(source)) {
            System.out.println("Invalid source");
            return null;
        }

        return map.get(source);
    }

}
