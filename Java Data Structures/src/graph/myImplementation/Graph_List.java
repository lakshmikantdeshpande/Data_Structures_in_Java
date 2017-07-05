package graph.myImplementation;

import java.util.*;

public class Graph_List {
    private static final int MAX = 100;
    private static final int WHITE = 0, GRAY = 1, BLACK = 2; // colors for storing visits
    // for faster lookups, we can use Map<Integer, Set<Integer>>
    private static Map<Integer, List<Integer>> map;
    private static int[] colors;    // store colors to indicate progress of graph traversal
    private static int[] parent;    // Union find array
    private static int[] discoveryTime;  // discovery time array
    private static int[] finished;  // for DFS, to store the final list of vertices
    private static int time;

    public Graph_List() {
        map = new HashMap<>();

        colors = new int[MAX];
        parent = new int[MAX];
        discoveryTime = new int[MAX];
        finished = new int[MAX];

        time = 0;
    }

    public static void main(String[] args) {
        Graph_List g = new Graph_List();

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("\nBFS: ");
        g.BFS(2);

        System.out.println("\nDFS: ");
        g.DFS();
    }

    public void addEdge(int source, int destination) {
        // if source / destination don't exist, create those
        if (!map.containsKey(destination)) {
            map.put(destination, new LinkedList<>());
        }
        if (!map.containsKey(source)) {
            map.put(source, new LinkedList<>());
        }

        List<Integer> adjacencyList = map.get(source);
        adjacencyList.add(destination);

        // optional if it is an undirected graph
        /*
        List<Integer> adjacencyList = map.get(destination);
        adjacencyList.add(source);
         */
    }

    public boolean removeEdge(int source, int destination) {
        if (!map.containsKey(source))
            return false;
        if (!map.containsKey(destination))
            return false;
        if (!map.get(source).contains(destination))
            return false;
        else {
            map.get(source).remove(destination);
            return true;
        }
    }

    //    CLRS style BFS
    public void BFS(int source) {
        // Initialize the arrays
        Arrays.fill(colors, WHITE);
        Arrays.fill(discoveryTime, 0);
        Arrays.fill(parent, -1);

        // Mark first node as visited, set parent to null, discoveryTime to 0
        colors[source] = GRAY;
        discoveryTime[source] = 0;
        parent[source] = -1;

        Queue<Integer> queue = new LinkedList<>();
        // Put the first vertex in queue
        queue.offer(source);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");

            for (int vertex : map.get(temp)) {
                if (colors[vertex] == WHITE) {
                    colors[vertex] = GRAY;
                    discoveryTime[vertex] = discoveryTime[source] + 1;
                    parent[vertex] = temp;
                    queue.offer(vertex);
                }
            }
            colors[source] = BLACK;
        }

    }

    //    CLRS style DFS
    public void DFS() {
        Arrays.fill(colors, WHITE);
        Arrays.fill(parent, -1);
        Arrays.fill(discoveryTime, 0);
        Arrays.fill(finished, 0);

        time = 0;

        for (int vertex : map.keySet()) {
            if (colors[vertex] == WHITE) {
                DFS_VISIT(vertex);
            }
        }

    }

    private void DFS_VISIT(int source) {
        time++;
        discoveryTime[source] = time;
        colors[source] = GRAY;

        System.out.print(source + " ");

        for (int vertex : map.get(source)) {
            if (colors[vertex] == WHITE) {
                parent[vertex] = source;
                DFS_VISIT(vertex);
            }
        }

        colors[source] = BLACK;
        time++;
        finished[source] = time;
    }
}
