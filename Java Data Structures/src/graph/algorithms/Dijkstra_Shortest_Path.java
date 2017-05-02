package graph.algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Vertex {
    int destination;
    int weight;

    public Vertex(int destination) {
        this.destination = destination;
    }

    public Vertex(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return destination == vertex.destination;
    }

    @Override
    public int hashCode() {
        return destination;
    }
}

public class Dijkstra_Shortest_Path {
    private static final int MAX = 100;
    private static final int WHITE = 0, GRAY = 1, BLACK = 2; // colors for storing visits
    private static final int INFINITY = Integer.MAX_VALUE;
    // for faster lookups, we can use Map<Integer, Set<Integer>>
    private static Map<Integer, List<Vertex>> map;
    private static int[] colors;    // store colors to indicate progress of graph traversal
    private static int[] parent;    // Union find array
    private static int[] discoveryTime;  // discovery time array
    private static int[] finished;  // for DFS, to store the final topologicallySortedLL of vertices
    private static int time;

    public Dijkstra_Shortest_Path() {
        map = new HashMap<>();

        colors = new int[MAX];
        parent = new int[MAX];
        discoveryTime = new int[MAX];
        finished = new int[MAX];

        time = 0;
    }

    public static void main(String[] args) {

    }

    public void addEdge(int source, int destination) {
        // if source / destination don't exist, create those
        if (!map.containsKey(destination)) {
            map.put(destination, new LinkedList<>());
        }
        if (!map.containsKey(source)) {
            map.put(source, new LinkedList<>());
        }

        List<Vertex> adjacencyList = map.get(source);
        adjacencyList.add(new Vertex(destination));

        // optional if it is an undirected graph
        /*
        List<Integer> adjacencyList = map.get(destination);
        adjacencyList.add(source);
         */
    }

    public boolean removeEdge(int source, int destination) {
        if (!map.containsKey(source))
            return false;
        if (!map.containsKey(new Vertex(destination)))
            return false;
        if (!map.get(source).contains(new Vertex(destination)))
            return false;
        else {
            map.get(source).remove(new Vertex(destination));
            return true;
        }
    }

    ///////////////////////////////////////////////////////////////////

    public void initialize_Single_Source(int source) {
        for (Vertex v : map.get(source)) {
            int vertex = v.destination;
            discoveryTime[vertex] = INFINITY;
            parent[vertex] = -1;
        }
        discoveryTime[source] = 0;
    }

    public void relax(int source, int destination, int weight) {
        if ()
    }

}
