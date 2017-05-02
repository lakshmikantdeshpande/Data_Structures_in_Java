package graph.algorithms;

import java.util.*;

class Edge {
    int dest, weight;

    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public Edge(int dest) {

        this.dest = dest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        return dest == edge.dest;
    }

    @Override
    public int hashCode() {
        return dest;
    }
}

public class Dijkstra_Shortest_Path {
    private static final int MAX = 100;
    private static final int WHITE = 0, GRAY = 1, BLACK = 2; // colors for storing visits
    private static final int INFINITY = Integer.MAX_VALUE;
    // for faster lookups, we can use Map<Integer, Set<Integer>>
    private static Map<Integer, List<Edge>> map;
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

        List<Edge> adjacencyList = map.get(source);
        adjacencyList.add(new Edge(destination));

        // optional if it is an undirected graph
        /*
        List<Integer> adjacencyList = map.get(destination);
        adjacencyList.add(source);
         */
    }

    public boolean removeEdge(int source, int destination) {
        if (!map.containsKey(new Edge(source)))
            return false;
        if (!map.containsKey(new Edge(destination)))
            return false;
        if (!map.get(source).contains(new Edge(destination)))
            return false;
        else {
            map.get(source).remove(new Edge(destination));
            return true;
        }
    }

    ///////////////////////////////////////////////////////////////////

    public void dijkstra(int src) {
        for (int vertex : map.keySet()) {
            discoveryTime[vertex] = INFINITY;
            parent[vertex] = -1;
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(src, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int dest = edge.dest;
            int weight = edge.weight;

            if (discoveryTime[dest] != weight)
                continue;

            for (Edge e : map.get(dest)) {
                if (discoveryTime[e.dest] < discoveryTime[dest] + e.weight)
                    queue.add(new Edge(edge.dest, discoveryTime[e.dest] = discoveryTime[dest] + e.weight));
            }

        }

    }

}
