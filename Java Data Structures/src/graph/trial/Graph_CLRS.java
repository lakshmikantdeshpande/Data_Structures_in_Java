package graph.trial;

import java.util.*;

// Edges can have destination and weight of an edge
class Edge {
    int destination;

    public Edge(int destination) {
        this.destination = destination;
    }
}

public class Graph_CLRS {
    // colors to indicate progress of graph traversal
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;
    private static final int MAX = 100;
    Map<Integer, ArrayList<Edge>> map;
    private int vertices = 0;
    private int time = 0;
    // to track colors, distance travelled, disjoint sets and final answer
    private int[] colors = new int[MAX];
    private int[] distance = new int[MAX];
    private int[] parent = new int[MAX];
    private int[] finish = new int[MAX];


    public Graph_CLRS(int vertices) {
        this.vertices = vertices;
        this.time = 0;

        map = new HashMap<>();
    }

    public static void main(String[] args) {
        Graph_CLRS g1 = new Graph_CLRS(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(2, 3);
        g1.addEdge(3, 3);

        System.out.print("BFS Traversal:");
        g1.BFS(2);
        System.out.print("DFS Traversal:");
        g1.DFS();


    }

    public void addEdge(int source, int destination) throws IllegalArgumentException {
        if (source < 0 || source > vertices || destination < 0 || destination > vertices)
            throw new IllegalArgumentException("Invalid vertices");

        if (map.containsKey(source))
            map.get(source).add(new Edge(destination));
        else {
            ArrayList<Edge> list = new ArrayList<>();
            list.add(new Edge(destination));
            map.put(source, list);
        }

        if (map.containsKey(destination))
            map.get(destination).add(new Edge(source));
        else {
            ArrayList<Edge> list = new ArrayList<>();
            list.add(new Edge(source));
            map.put(destination, list);
        }
    }

    public void BFS(int src) {
        Arrays.fill(colors, WHITE);
        Arrays.fill(distance, 0);
        Arrays.fill(parent, -1);

        // mark source as gray (visited but neighbours unexplored)
        colors[src] = GRAY;
        distance[src] = 0;
        parent[src] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            // visit current vertex
            int source = queue.poll();
            System.out.print(source + " ");

            // get adjacent, and visit all of the adjacent vertices
            ArrayList<Edge> adjacent = map.get(source);
            for (Edge edge : adjacent) {
                int dest = edge.destination;
                if (colors[dest] == WHITE) {
                    colors[dest] = GRAY;
                    distance[dest] += 1;
                    parent[dest] = source;
                    queue.add(dest);
                }
            }
            colors[source] = BLACK;
        }
    }

    private void DFS() {
        Arrays.fill(colors, WHITE);
        Arrays.fill(distance, 0);
        Arrays.fill(parent, -1);
        Arrays.fill(finish, -1);

        time = 0;
        for (int vertex : map.keySet())
            if (colors[vertex] == WHITE)
                DFSTraversal(vertex);
    }

    public void DFSTraversal(int source) {
        colors[source] = GRAY;
        // record discovery time;
        time++;
        distance[source] = time;

        System.out.print(source + " ");
        for (Edge edge : map.get(source)) {
            int dest = edge.destination;
            if (colors[dest] == WHITE) {
                parent[dest] = source;
                DFSTraversal(dest);
            }
        }

        colors[source] = BLACK;
        time++;
        finish[source] = time;
    }


}
