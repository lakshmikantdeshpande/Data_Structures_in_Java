package graph;

import java.util.Map;
import java.util.Set;

public class GraphNode {
    private Map<Integer, Set<Node>> map;

    public void addEdge(int source, int destination) {
        if (!map.containsKey(source) || !map.containsKey(destination))
            return;

        Node temp = new Node(destination);
        Set<Node> set = map.get(source);
        set.add(temp);

        temp = new Node(source);
        Set<Node> set1 = map.get(destination);
        set1.add(temp);
    }

    private static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public Node(int vertex) {
            this.vertex = vertex;
            this.weight = 0;
        }
    }
}
